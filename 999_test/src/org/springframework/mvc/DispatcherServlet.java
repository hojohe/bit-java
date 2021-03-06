package org.springframework.mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DispatcherServlet extends HttpServlet {

	private URLHandlerMapping mappings;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		mappings = new URLHandlerMapping();
	
	}

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String requestUri = request.getRequestURI();
		String contextPath = request.getContextPath();
		
		requestUri = requestUri.substring(contextPath.length());
		
		try {
			Controller controller = mappings.getController(requestUri);
			
			if(controller == null) {
				throw new ServletException("요청하신  url은 존재 하지 않습니다.");
			}
			
			ModelAndView mav = controller.service(request, response);
			
			String view = mav.getView();
			
			if(view.startsWith("redirect:")) {
				
				response.sendRedirect(view.substring("redirect:".length()));
			}
			else if(view.startsWith("ajax:")) {
				
				response.setContentType("text/json; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println(view.substring("ajax:".length()));
				
			}
			else {
				
				Map<String, Object> model = mav.getModel();
				
				Set<String> keys = model.keySet();
				
				for(String key:keys) {
					request.setAttribute(key, model.get(key));
				}
				
				RequestDispatcher rd = request.getRequestDispatcher(view);
				rd.forward(request, response);
				
				
			}
			
		}
		catch (Exception e) {
			
			throw new ServletException(e);
		}
	
	}

	
	
	
}
