package com.lgd;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lgd.bean.Cmpt_dtalJudges;
import com.lgd.biz.Context;
import com.lgd.dao.IBaseDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfig.xml")
public class BaseDao_test {

	
	/**
	 * @Autowired  默认根据类型自动装配 
	 * 用在属性上，使用反射来自动装配
	 * 用在Set方法上， 使用Set 方法装配
	 */
	@Autowired
	private IBaseDao<Cmpt_dtalJudges> baseDao; 
	
	
	@Test
	public void test(){
		Cmpt_dtalJudges c=new Cmpt_dtalJudges();
		c.setFid(1001);
		Object obj= baseDao.selectOne("findCmpt_datlByfid", c);
		if(obj instanceof Cmpt_dtalJudges){
			c=(Cmpt_dtalJudges) obj;
		}
		System.out.println("==========================="+c);
	}
	
	@Test
	public void test1(){
		IBaseDao<Cmpt_dtalJudges> dao=null;
		Object o= Context.getContext().getDao();
		if(o instanceof IBaseDao){
			dao=(IBaseDao<Cmpt_dtalJudges>) o;
		}
		Cmpt_dtalJudges c=new Cmpt_dtalJudges();
		c.setFid(1001);
		Object obj= dao.selectOne("findCmpt_datlByfid", c);
		if(obj instanceof Cmpt_dtalJudges){
			c=(Cmpt_dtalJudges) obj;
		}
		System.out.println("==========================="+c);
	}
	
}
