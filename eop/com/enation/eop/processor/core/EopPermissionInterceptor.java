package com.enation.eop.processor.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.enation.eop.sdk.context.EopContext;

/**
 * eop权限拦截器
 * @author kingapex
 * 2010-10-23下午11:55:03
 */
public class EopPermissionInterceptor implements HandlerInterceptor {

	public void destroy() {
	}

	public void init() {
	}

//	public String intercept(ActionInvocation inv) throws Exception {
//		
//		Integer userid  = EopContext.getContext().getCurrentSite().getUserid();
//		if(userid.intValue() !=1){
//			return "error";
//		}
//		
//		String result = inv.invoke();
//		return result;
//	}

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2) throws Exception {
		// TODO Auto-generated method stub
		Integer userid  = EopContext.getContext().getCurrentSite().getUserid();
		if(userid.intValue() !=1){
			new Exception("error");
			return false;
		}
		return true;
	}

}
