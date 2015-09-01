package com.enation.cms.core.action;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.enation.cms.core.service.IDataManager;
import com.enation.framework.action.WWAction;

/**
 * cms信息首页项
 * @author kingapex
 * 2010-10-14上午09:39:35
 */
@RequestMapping("/cms/admin")
public class CmsIndexItemAction extends WWAction {
	@Autowired
	private IDataManager dataManager;
	private Map datass;
	
	public String article(){
		datass= dataManager.census();
		this.model.put("datass", datass);
		return "/cms/admin/index/article";
	}
	public IDataManager getDataManager() {
		return dataManager;
	}
	public void setDataManager(IDataManager dataManager) {
		this.dataManager = dataManager;
	}
	public Map getDatass() {
		return datass;
	}
	public void setDatass(Map datass) {
		this.datass = datass;
	}
	

}
