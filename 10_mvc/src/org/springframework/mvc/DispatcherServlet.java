package org.springframework.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class DispatcherServlet extends HttpServlet {
	
	private URLHandlerMapping mapping;
	private String prefix, suffix;
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		// web.xml 에 설정된 init-param 태그의 값 접근하기
		String ctrlNames = config.getInitParameter("controller");
		prefix  = config.getInitParameter("prefix");
		suffix  = config.getInitParameter("suffix");
		
//		System.out.println(ctrlNames);
		try {
			mapping = new URLHandlerMapping(ctrlNames);
		} catch (Exception e) {
			// 만약 throw 잡지 않으면 다음 라인 쭉 쭉 실행됨 서블릿한테 에러났따고 강제 exception 발생시켜줌
			throw new ServletException(e);
			
		}
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getMethod().equals("POST")) {
			request.setCharacterEncoding("utf-8");
		}
		
		// 사용자의 요청 URI 얻기
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		requestUri = requestUri.substring(contextPath.length());
		
		
		try {
			// http://localhost: 9090/10_mvc/board/write.do
			
			CtrlAndMethod cam = mapping.getCtrlAndMethod(requestUri);
			
			if(cam == null) {
				throw new ServletException("요청하신 URL이 존재하지 않습니다.");
			}
			Object target = cam.getTarget();
			Method method = cam.getMethod();
			
			// 파라미터 처리하기
			PreParameterProcess ppp = new PreParameterProcess();
			Object[] param = ppp.process(method, request);
			
			
			Class<?> rType = method.getReturnType();
			String rName = rType.getSimpleName();
			
			ModelAndView mav = null;
			String view = null;
			
			switch (rName){
				case "ModelAndView":
					mav = (ModelAndView)method.invoke(target, param);
					view = mav.getView();
					break;
				case "String" :
					view = (String)method.invoke(target, param);
					break;
				case "void" :
					method.invoke(target, param);
					// requestUri -> /board/list.do
					view = requestUri.substring(1).replace(".do", "");
					break;
			}
			
			

			if (view.startsWith("redirect:")) {
				response.sendRedirect(view.substring("redirect:".length()));
			} 
			else if(view.startsWith("ajax:")) {
				response.setContentType("text/json; charset=utf-8"); 
				PrintWriter out = response.getWriter();
				out.println(view.substring("ajax:".length()));
			}
			else {
				if(mav != null) {
					Map<String,Object> model = mav.getModel();
					// map의 key 가져오기
					Set<String> keys = model.keySet();
					for(String key : keys) {
						request.setAttribute(key, model.get(key));
					}
				}
				
				if(!view.endsWith(".do")) {
					view = prefix + view + suffix;
				}
				
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
				
			}
			
		} catch (Exception e) {
			
			// 에러를 서블릿exception으로 형변환해서 던진다!! 만약 여기서 처리하게 되면 사용자가 오류가 난지 모른다!
			throw new ServletException(e);
			
		}
	}

	
	
}
