package com.enation.framework.web.launcher;

import java.io.Reader;
import java.util.Properties;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.context.ContextLoaderListener;


public class FrameworkListener extends ContextLoaderListener {
	static {
		try {
					//对数据库的用户名和密码进行解密。
					Reader reader=Resources.getResourceAsReader("/mapper/mybatis-config.xml");
					Properties ppt=Resources.getResourceAsProperties("/config/jdbc.properties");
					String username=ppt.getProperty("jdbc.username");
					String password=ppt.getProperty("jdbc.password");
//					System.out.println("原密文="+username+"/"+password);
//					System.out.println("解密后="+DESUtils.getDecryptString(username)+"/"+DESUtils.getDecryptString(password));
//					ppt.setProperty("jdbc.username", DESUtils.getDecryptString(username));
//					ppt.setProperty("jdbc.password", DESUtils.getDecryptString(password));
					SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(reader,ppt);
			} catch (Exception e) {
					e.printStackTrace();
			}
	}
}
