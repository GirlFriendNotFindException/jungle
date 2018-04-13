package com.lgd.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lgd.bean.Cmpt_dtal;
import com.lgd.bean.Competition;
import com.lgd.bean.Course;
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
	 */
	@RequestMapping(value="/admin/addCompetition.action", consumes="application/json;charset=UTF-8")
	protected  void  addCompetition(@RequestBody final List<Competition>  competitions, final HttpServletResponse response ){
		add(competitions, response);
	}
	
	/**
	 * 添加评委
	 * @param competitions
	 * @param response
	 */
	@RequestMapping(value="/admin/addCmpt_dtal.action", consumes="application/json;charset=UTF-8")
	public  void  addJudges(@RequestBody final List<Cmpt_dtal>  cmpt_dtal, final HttpServletResponse response){
		add(cmpt_dtal, response);
	}
	
	/**
	 * 
	 * @param Course
	 * @param response
	 */
	@RequestMapping(value="/admin/addCourse.action", consumes="application/json;charset=UTF-8")
	public  void  addCourse(@RequestBody final List<Course>  Course, final HttpServletResponse response){
		add(Course, response);
	}
	
}
