package com.enation.framework.web.mvc;

import java.util.Locale;
import java.util.Map;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class MultiViewResover implements ViewResolver {

	private Map<String, ViewResolver> resolvers;  
	  
    @Override  
    public View resolveViewName(String viewName, Locale locale) throws Exception {  
	        int n = viewName.lastIndexOf("."); 
	        // viewName(modelAndView中的名字)看其有没有下划线  
	        String suffix = "";  
	  
	        if (n == (-1)) {  
	            	suffix = "jsp";  
	        } else {  
	            	suffix = viewName.substring(n + 1);  
	            	viewName = viewName.substring(0, n);  
	        }  
	  
	        ViewResolver resolver = resolvers.get(suffix);  
	  
	        if (resolver != null) {  
	            	return resolver.resolveViewName(viewName, locale);  
	        }  
	        else {  
	            	return null;  
	        }  
    }  
  
    public Map<String, ViewResolver> getResolvers() {  
        return resolvers;  
    }  
  
    public void setResolvers(Map<String, ViewResolver> resolvers) {  
        this.resolvers = resolvers;  
    }  

}
