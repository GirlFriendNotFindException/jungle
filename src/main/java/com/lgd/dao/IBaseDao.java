package com.lgd.dao;

import java.util.List;
import java.util.Map;

public interface IBaseDao<T> {

	
	public int insert(String sql, T t);
	public int insert(String sql, Class<T> cls, List<T> list);
	public int insert(String sql, Class<T> cls, Map<String, T> map) ;
	
	public int update(String sql, T t);
	public int update(String sql, Class<T> cls, List<T> list);
	public int update(String sql, Class<T> cls, Map<String, T> map);
	
	public int delete(String sql, T t);
	public int delete(String sql, String sqlid, String id);
	
	public T selectOne(String sql, Class<T> cls);
	public T selectOne(String sql, T t);
	public T selectOne(String sql, Class<T> cls, String id); 
	public List<T> selectAll(String sql, Class<T> cls);
	public List<T> selectAll(String sql, T t);
	
	
	public  void commit();
}
