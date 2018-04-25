package com.lgd.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lgd.bean.Cmpt_dtalCompetitor;
import com.lgd.bean.Cmpt_dtalJudges;
import com.lgd.bean.Competition;
import com.lgd.bean.Competitor;
import com.lgd.bean.Course;
import com.lgd.bean.Judges;
import com.lgd.bean.User;
/**
 * 多个线程调用同一个对象的同一个方法： 
	如果方法里无成员变量，那么不受任何影响；
	如果方法里有成员变量，只有读操作，不受影响；存在写操作，考虑多线程影响值；
 * @author saber
 *
 */

@org.springframework.stereotype.Controller
public class Controller extends AbstractController{
	
	/**
	 * test
	 * @return
	 */
	@RequestMapping("/hello")
	public  ModelAndView hello(){
		ModelAndView mav=new ModelAndView();
		mav.addObject("data", "xxx");
		mav.setViewName("hello");
		return mav;
	}
	
	
	/**
	 * 添加比赛信息
	 * 异步调用    传入两个参数   要执行的任务   以及执行任务完成后的回调函数  
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/admin/addCompetition.action", consumes="application/json;charset=UTF-8")
	protected  void  addCompetition(@RequestBody final List<Competition>  competitions, final HttpServletResponse response ) throws IOException{
		Object obj=task(competitions);
		out(response, toJson(obj));
	}
	
	
	
	
	/**
	 * 添加评委
	 * @param competitions
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/admin/addJudges.action", consumes="application/json;charset=UTF-8")
	public  void  addJudges(@RequestBody final List<Judges>  judges, final HttpServletResponse response) throws IOException{
		Object obj=task(judges);
		out(response, toJson(obj));
	}
	
	
	@RequestMapping(value="/admin/addListCmpt_dtalJudges.action", consumes="application/json;charset=UTF-8")
	public  void  addListCmpt_dtalJudges(@RequestBody final List<Cmpt_dtalJudges> list, final HttpServletResponse response) throws IOException{
		int  r=server.addList(list, Cmpt_dtalJudges.class);
		out(response, toJson(r));
	}
	

	
	/**
	 * 
	 * @param Course
	 * @param response
	 * @throws IOException 
	 */
	@RequestMapping(value="/admin/addCourse.action", consumes="application/json;charset=UTF-8")
	public  void  addCourse(@RequestBody final List<Course>  Course, final HttpServletResponse response) throws IOException{
		Object obj=task(Course);
		out(response, toJson(obj));
	}
	
	
	
	
	@RequestMapping(value="/admin/addCompetitor.action", consumes="application/json;charset=UTF-8")
	public  void  addCompetitor(@RequestBody final List<Competitor>  Competitor, final HttpServletResponse response) throws IOException{
		Object obj=task(Competitor);
		out(response, toJson(obj));
	}
	
	@RequestMapping(value="/admin/addListCmpt_dtalCompetitor.action", consumes="application/json;charset=UTF-8")
	public  void  addListCmpt_dtalCompetitor(@RequestBody final List<Cmpt_dtalCompetitor>  Cmpt_dtalCompetitor, final HttpServletResponse response) throws IOException{
		int  r=server.addList(Cmpt_dtalCompetitor, Cmpt_dtalCompetitor.class);
		out(response, toJson(r));
	}
	
	
	
	
	@RequestMapping(value="/admin/findCompetitionByCreator.action", consumes="application/json;charset=UTF-8")
	public  void  findCompetitionByCreator(@RequestBody final Map<String, String> map, final HttpServletResponse response) throws IOException{
		//find(map, response, Competition.class, "findCompetitionByCreator");
		Object obj=server.findAll("findCompetitionByCreator", map, Competition.class);
		out(response, toJson(obj));
	}
	
	
	@RequestMapping(value="/admin/findCourseByCreator.action", consumes="application/json;charset=UTF-8")
	public  void  findCourseByCreator(@RequestBody final Map<String, String> map, final HttpServletResponse response) throws IOException{
		Object obj=server.findAll("findCourseByCreator", map, Course.class);
		out(response, toJson(obj));
	}
	
	
	
	/**
	 * 登录 注册
	 */
	@RequestMapping(value="/login/login.action", consumes="application/json;charset=UTF-8")
	public  void  login(@RequestBody final List<User> user, final HttpServletResponse response) throws IOException{
		if(user==null | user.size()<=0 ) return;
		Object obj=server.findOne( user.get(0));
		out(response, toJson(obj));
	}
	
	
	@RequestMapping(value="/regist/regist.action", consumes="application/json;charset=UTF-8")
	public  void  regist(@RequestBody final List<User> user, final HttpServletResponse response) throws IOException{
		Object obj=task(user);
		out(response, toJson(obj));
	}
	
	
	
	public  <T> Object task( List<T> list) {
		if(list==null |  list.size()<=0  |   list.get(0)==null)   return null;
		if(list.size()==1   )    return server.add(list.get(0));
		if(list.size()>1   )    return server.addList(list, list.get(0).getClass()); 
		return null;
	}
	
}
