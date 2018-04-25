package com.lgd.dao;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;



/**
 * 后台操作数据库的业务逻辑类
 * @author saber
 *
 */

@Service(value="server")
public class Server {
	
	@Resource(name="dao")
	private IBaseDao dao=null;

	public <T> int add(T t){
		return dao.insert(getSqlID(t, "add"), t);
	}
	
	public <T> int addList(List list, Class cls){
		String path=getSqlID(cls, "addList");
		int r=dao.insert(path, cls, list);
		return r;
	}
	
	public <T> int addList(Map<String, String> map, Class cls){
		String path=getSqlID(cls, "addList");
		int r=dao.insert(path, cls, map);
		return r;
	}
	
	public  <T> Object findAll(String sql, Map<String, String> map, Class<T> cls){
		Object obj=dao.findAll(sql, map, cls);
		return obj;  
	}
	
	public  <T> Object findOne(  T   t){
		String path=getSqlID(t, "find");
		Object obj=dao.selectOne( path,   t);
		return obj;  
	}

	
	private <T> String getSqlID(T t, String prefix){
		return getSqlID(t.getClass(), prefix);
	}
	
	private <T> String getSqlID(Class cls, String prefix){
		return prefix+cls.getSimpleName();
	}


	
	
}
