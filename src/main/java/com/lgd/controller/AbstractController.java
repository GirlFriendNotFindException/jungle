package com.lgd.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.lgd.biz.CallBack;
import com.lgd.biz.Task;
import com.lgd.dao.Server;

public abstract class AbstractController {

	@Resource(name="server")
	protected Server server=null;
	
	/**
	 * 异步线程调度
	 * @param task
	 * @param callback
	 */
	public  Thread asyncCall(final Task task, final CallBack callback){
		return new Thread(new Runnable() {
			@Override
			public void run() {
				Object obj=task.task();
				try {
					callback.callback(obj);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	protected  <T> void  add(final List<T>  list, final HttpServletResponse response){
		Thread t=asyncCall(new Task(){
			@Override
			public Object task() {
				if(list==null |  list.size()<=0  |   list.get(0)==null)   return null;
				if(list.size()==1   )    return server.add(list.get(0));
				if(list.size()>1   )    return server.addList(list, list.get(0).getClass()); 
				return null;
				
			}} ,   new CallBack(){

				@Override
				public void callback(Object result) throws IOException {
					out(response, toJson(result));
				}} );
		
		t.start();
	}
	
	
	
	/**
	 * 将对象转化为json字符串
	 *
	 */
	protected String  toJson(Object obj) throws IOException{
		Gson gson=new Gson();
		return gson.toJson(obj);
	}
	
	
	
	/**
	 * 
	 * 通过响应对象将json字符串发送到客户端
	 * 
	 */
	protected void  out(HttpServletResponse response, String jsonData) throws IOException{
		PrintWriter out=response.getWriter(); 
		out.println(jsonData);
	} 
	
	
	
	
}
