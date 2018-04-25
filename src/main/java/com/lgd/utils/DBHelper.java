package com.lgd.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class DBHelper<T> {

	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			Log.error(e);
			System.exit(0);
		}
	}
	
	public Connection getCon(){
		Connection con=null;
//		String url=MyProperties.getInstance().getProperty("url");
//		String userName=MyProperties.getInstance().getProperty("userName");
//		String passwd=MyProperties.getInstance().getProperty("passwd");
		String url="jdbc:mysql://localhost:3306/judges";
		String userName="root";
		String passwd="1234";
		try {
			con=DriverManager.getConnection(url,userName,passwd);
		} catch (SQLException e) {
			Log.error(e);
		}
		return con;
	}
	
	public int update(String sql,List<Object> params){
		Connection con=getCon();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int r=-1;
		try {
			ps = doPrepareStatement(sql, params, con);
			r=ps.executeUpdate();
			if(r>0){
			}
		} catch (SQLException e) {
			Log.error(e);
		}
		closeAll(con,ps,rs);
		return r;
	}

	public PreparedStatement doPrepareStatement(String sql,List<Object> params, Connection con) throws SQLException {
		PreparedStatement ps;
		ps=con.prepareStatement(sql);
		if(params!=null&&params.size()>0){
			for(int i=0;i<params.size();i++){
				ps.setObject(i+1, params.get(i));
			}
		}
		return ps;
	}
	
	private void closeAll( Connection con,PreparedStatement ps,ResultSet rs){
		try {
			if(rs!=null){
				rs.close();
			}
			if(ps!=null){
				ps.close();
			}
			if(con!=null){
				con.close();
			}
		} catch (SQLException e) {
			Log.error(e);
		}
	}
	
	public List<Map<String,String>> queryAll(String sql,List<Object> params){
		List<Map<String,String>> list=new ArrayList<Map<String,String>>();
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try { 
			con=getCon();
			ps = doPrepareStatement(sql, params, con);
			rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData(); 
			int cc=rsmd.getColumnCount();
			List<String> columnNames=new ArrayList<String>();
			for(int i=0;i<cc;i++){
				String columnName=rsmd.getColumnLabel(i+1);
				columnNames.add(columnName);
			}
			while(rs.next()){
				Map<String,String> rowMap=new HashMap<String, String>();
				for(String cn:columnNames){
					String value=rs.getString(cn);
					rowMap.put(cn, value);
				}
				list.add(rowMap);
			}
		} catch (SQLException e) {
			Log.error(e);
		}finally{
			closeAll(con,ps,rs);
		}
		return  list;
	}
	
	private T parseMapToT(Map<String, String> map, Class<T> cls) throws Exception{
		T t=cls.newInstance();    //
		List<Method> listMed=findAllSetMethod(cls);
		for(String key:map.keySet()){
			String value=map.get(key);
			for(Method m:listMed){
				String T_MethodName="set"+key;
				if(T_MethodName.equalsIgnoreCase(m.getName())){
					Class c=m.getParameterTypes()[0];
					String ParameterTypeNmae=c.getName();   
					if("int".equals(ParameterTypeNmae) ||"java.lang.Integer".equals(ParameterTypeNmae)){
						Integer v=Integer.parseInt(value);
						m.invoke(t, v);   
					}else if("float".equals(ParameterTypeNmae) || "java.lang.Float".equals(ParameterTypeNmae)){
						float v=Float.parseFloat(value);
						m.invoke(t, v);
					}else if("double".equals(ParameterTypeNmae) || "java.lang.Double".equals(ParameterTypeNmae)){
						double v=Double.parseDouble(value);
						m.invoke(t, v);
					}else if("Date".equals(ParameterTypeNmae) || "java.util.Date".equals(ParameterTypeNmae)){
						Date v=DateUtil.parseStringToDate(value, "yyyy-MM-dd HH:mm:ss");
						m.invoke(t, v);
					}else if("long".equals(ParameterTypeNmae) || "java.lang.Long".equals(ParameterTypeNmae)){
						long v=Long.parseLong(value);
						m.invoke(t, v);
					}
					else{
						m.invoke(t, value);
					}
					
				}
			}
		}
		return t;
	}
	
	
	public List<Method> findAllSetMethod(Class<T> cls) {
		List<Method> listMed=new ArrayList<>();
		Method[] ms=cls.getMethods();
		for(Method m:ms){
			if(m.getName().startsWith("set")){
				listMed.add(m);
			}
		}
		return listMed;
	}
	
	public List<T> select(String sql, List<Object> params, Class<T> cls) throws Exception{
		List<Map<String, String>> listMap=queryAll(sql, params);
		List<T> listT=new ArrayList<>();
		if(listMap!=null && listMap.size()>0){
			for(Map<String, String> map:listMap){
				T t=parseMapToT(map, cls);
				listT.add(t);
			}
		}
		return listT;
	}
}
