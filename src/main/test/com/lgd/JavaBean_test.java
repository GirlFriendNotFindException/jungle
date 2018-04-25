package com.lgd;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.lgd.bean.Cmpt_dtalJudges;
import com.lgd.biz.Context;


@ContextConfiguration("classpath:springConfig.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class JavaBean_test {

	/**
	 * @Resource注入方式  调用原有的set方法注入
	 */
	@Resource(name="cmpt_dtal")
	private Cmpt_dtalJudges cmpt_dtal;
	
	
	@Test
	public void test(){
		System.out.println("======================="+cmpt_dtal);
	}
	
	@Test
	public void test2(){
		System.out.println(Context.getApplicationContext().getBean("cmpt_dtal"));
	}
	
}
