package com.lgd;

import javax.annotation.Resource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:springConfig.xml")
public class Mysql_Con_test {

	@Resource(name="dataSource")
	private BasicDataSource dataSource;
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	
	
	@Test
	public void getDataSource(){
		System.out.println(dataSource);
	}
	
	@Test 
	public void getSqlSession(){
		System.out.println(session);
	}
	
	
}
