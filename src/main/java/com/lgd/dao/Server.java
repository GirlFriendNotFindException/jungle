package com.lgd.dao;

import java.util.List;

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
		int r=dao.insert(getSqlID(cls, "addList"), cls, list);
		return r;
	}
	
	

	
	private <T> String getSqlID(T t, String prefix){
		return getSqlID(t.getClass(), prefix);
	}
	
	private <T> String getSqlID(Class cls, String prefix){
		return prefix+cls.getSimpleName();
	}

	
}
