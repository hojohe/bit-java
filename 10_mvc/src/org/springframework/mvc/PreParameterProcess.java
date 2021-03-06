package org.springframework.mvc;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

import javax.servlet.http.HttpServletRequest;

public class PreParameterProcess {
	public Object[] process(Method method, HttpServletRequest request) 
			throws Exception  {
		// 메서드에서 파라미터 정보를 추출하자
		// update(int no, String title)
		Parameter[] pArr = method.getParameters();
		
		int index = 0;
		Object[] rArr = new Object[pArr.length];
		
		for(Parameter p: pArr) {
			// Parameter p -> int no
			
			// Class<?> pType -> int
			Class<?> pType = p.getType();
			String tName = pType.getSimpleName();

			// @RequestParam(value="no") int no
			// 파라미터 이름 : no
			String name = p.getName();
			
			RequestParam rp = p.getAnnotation(RequestParam.class);
			if(rp != null) name = rp.value();
			
			
			
			
			switch (tName) {
				case "int" :
					rArr[index++] = Integer.parseInt(request.getParameter(name));
					break;
				case "HttpServletRequest" :
					rArr[index++] = request;
					break;
				default : 
					rArr[index++] = WebUtil.getParamToVO(request, pType);
				
			}
			
			
		}
		
		
		
		return rArr;
	}
}
