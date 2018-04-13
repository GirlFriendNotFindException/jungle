package com.lgd.biz;

import org.codehaus.plexus.component.annotations.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.lgd.bean.Cmpt_dtal;
import com.lgd.dao.IBaseDao;


/**
 * 上下文
 * @author saber
 * @param <T>
 * @param <T>
 *
 */

public class Context {
	

	
	private static ApplicationContext appcxt;
	
	private static Context cxt;
	
	private static String configClasspath="classpath:springConfig.xml";
	
	private Context(){}
	
	public static ApplicationContext getApplicationContext(){
		if(appcxt==null){
			synchronized (ApplicationContext.class) {
				if(appcxt==null){
					appcxt=new ClassPathXmlApplicationContext(configClasspath);
				}
			}
		}
		return appcxt;
	}
	

	public static String getConfigClasspath() {
		return configClasspath;
	}

	public static void setConfigClasspath(String configClasspath) {
		Context.configClasspath = configClasspath;
	}

	
	/**
	 * 自定义路径
	 * @param path
	 * @return
	 */
	public static ApplicationContext getApplicationContext(String path){
		configClasspath=path;
		return  getApplicationContext();
	}
	
	public static Context getContext(){
		if(cxt==null){
			synchronized (Context.class) {
				if(cxt==null){
					cxt=new Context();
				}
			}
		}
		return cxt;
	}
	
	public IBaseDao<?> getDao(){
		IBaseDao<?> dao=null; 
		Object obj=Context.getApplicationContext().getBean("dao");
		if(obj instanceof IBaseDao){
			dao=(IBaseDao<?>) obj;
		}
		return dao;
	}
	
}
