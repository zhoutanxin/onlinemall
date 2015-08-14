package com.enation.app.base.core.action;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enation.framework.action.WWAction;
@Controller
public class TestAction extends WWAction {
	protected final Logger logger = Logger.getLogger(getClass());
	@RequestMapping("test")
	public String  list() {
		System.out.println("test");
		return "/install/step1";
	}

}
