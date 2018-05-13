package com.lgd.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

/**
 * 操作数据库的基本类
 * @author saber
 * @param <T>
 *
 */
@Repository("dao") 
public class BaseDao<T> implements IBaseDao<T>{

	private String mapperPath="com.lgd.model.";
	
	@Resource(name="sqlSession")
	private SqlSession session;
	
	public BaseDao() {
		// TODO Auto-generated constructor stub
	}
	
	private String getClassName(Class<T> cls) {
		return cls.getSimpleName();
	}
	
	private String getClassName(T t){
		return t.getClass().getSimpleName();
	}
	
	private String  getMapperPath(Class<T> cls) {
		return mapperPath+getClassName(cls)+"Mapper.";
	}
	
	private String getMapperPath(T t){
		return mapperPath+getClassName(t)+"Mapper.";
	}

	@Override
	public int insert(String sql, T t) {
		String path=getMapperPath(t);
		int  r=session.insert(path+sql, t);
		return r;
	}

	@Override
	public int insert(String sql, Class<T> cls, List<T> list) {
		String path=getMapperPath(cls);
		int  r=session.insert(path+sql, list);
		return r;
	}

	@Override
	public int insert(String sql, Class<T> cls, Map<String, String> map) {
		String path=getMapperPath(cls);
		int r=session.insert(path+sql, map);
		return r;
	}

	@Override
	public int update(String sql, T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String sql, Class<T> cls, List<T> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(String sql, Class<T> cls, Map<String, T> map) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String sql, T t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(String sql, String sqlid, String id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public T selectOne(String sql, Class<T> cls) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T selectOne(String sql, T t) {
		// TODO Auto-generated method stub
		String path=getMapperPath(t);
		return session.selectOne(path+sql, t);
	}
	
	@Override
	public T selectOne(String sql, T t, Class<T> cls) {
		// TODO Auto-generated method stub
		String path=getMapperPath(cls);
		return session.selectOne(path+sql, t);
	}

	@Override
	public T selectOne(String sql, Class<T> cls, String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> selectAll(String sql, Class<T> cls) {
		
		return null;
	}

	@Override
	public  Map<String, Map<String, String>> findAll(String sql, T t, Class<T> cls, String field) {
		String path=getMapperPath(cls);
		return session.selectMap(path+sql, t, field);
	}
	
	

	@Override
	public void commit() {
		session.commit();
	}

	@Override
	public List<Map<String, String>> selectAll(String sql, T t) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
