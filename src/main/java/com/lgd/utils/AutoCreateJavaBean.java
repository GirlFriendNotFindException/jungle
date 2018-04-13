package com.lgd.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;


import java.util.Set;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;

public class AutoCreateJavaBean {

	private String classText="";
	
	private String database="judges";
	private String className="Judges";
	private String type="";
	private String getMethod="get";
	private String setMethod="set";
	private String CstrMethod="public "+className;
	private String classPrifix="public class  "+className+" { ";
	private String newline="\r\n";
	private String space="  ";
	private String semicolon=";";
	private String tab="\t";
	private String kh_less_left="(";
	private String kh_less_right=")";
	private String kh_middle_left="{";
	private String kh_middle_right="}";
	
	private String sql ="select * from  "+className;
	
	/**
	 * 原子操作  防止对象未初始化就被另一个线程取走
	 * 实例化一个对象其实可以分为三个步骤：　　
	 * （1）分配内存空间。　　（2）初始化对象。　　（3）将内存空间的地址赋值给对应的引用。
	 * 但是由于操作系统可以对指令进行重排序，所以上面的过程也可能会变成如下过程：　　
	 * 1）分配内存空间。　　（2）将内存空间的地址赋值给对应的引用。　　（3）初始化对象
	 */
	private static volatile AutoCreateJavaBean  instance=null;
	
	private  AutoCreateJavaBean(String className) {
		super();
		this.className = className;
	}
	
	/**
	 * 单例模式   double check
	 * @param classname
	 * @return
	 */
	public static AutoCreateJavaBean getClassCode(String classname){
		if(instance==null){
			synchronized (AutoCreateJavaBean.class) {
				if(instance==null){
					instance =new AutoCreateJavaBean(classname);
				}
			}
		}
		return instance;
	}


	/**
	 * 获得表所有字段名及其数据类型
	 * @throws SQLException
	 */
	private Map<String, String> getAttrFromDB() throws SQLException{
		DBHelper db=new DBHelper();
		Map<String, String > map=new HashMap<>();
		Connection con=db.getCon();
		try {
			PreparedStatement ps = db.doPrepareStatement(sql, null, con);
			ResultSet rs=ps.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData(); 
			int  colNum=rsmd.getColumnCount();
			for(int i=1; i<=colNum; i++){
				String coltype=rsmd.getColumnTypeName(i);
				String colname=rsmd.getColumnName(i);
				map.put(colname, coltype);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		}
		return toJavaDataType(map);
	}
	
	
	/***
	 * 
	 * 得到java所有的基本数据类型
	 * @param map
	 * @return
	 */
	private  Set<String> getJavaAllDataType(){
		Set<String> set=new HashSet<>(); 
		String arr[]={"int","double","float","String","Date","byte","char"};
		for(String tmp:arr){
			set.add(tmp);
		}
		return set;
	}
	
	/**
	 * 将数据库数据类型转换为java数据类型
	 * Map<colName, type>
	 */
	private Map<String, String> toJavaDataType(Map<String, String> map){
		Map<String, String> tmp_map=new HashMap<>();
		Set<String> set=getJavaAllDataType();
		Iterator<Entry<String, String>> iter=map.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, String> entry=iter.next();
			String DBDataType=entry.getValue();
			boolean flag=false;
			for(String tmp:set){
				if(DBDataType.equalsIgnoreCase(tmp)){
					tmp_map.put(entry.getKey(), tmp);
					flag=true;
					break;
				}
			}
			if(!flag){
				tmp_map.put(entry.getKey(), "String");   
			}
		}
		return tmp_map;
	}
	
	/**
	 * 属性的拼接
	 * @param args
	 * @throws SQLException
	 */
	private String  createAttrStr() throws SQLException{
		Map<String, String> attr=getAttrFromDB();
		StringBuffer sb=new StringBuffer();  //线程安全的类
		sb.append(classPrifix);
		sb.append(newline);
		sb.append(newline);
		Iterator<Entry<String, String>> iter=attr.entrySet().iterator();
		while(iter.hasNext()){
			Entry<String, String> entry=iter.next();
			sb.append(tab);
			sb.append(modifier.PRIVATE.value);
			sb.append(space);
			sb.append(entry.getValue());  //得到数据类型
			sb.append(space);
			sb.append(entry.getKey());     //得到字段名
			sb.append(semicolon);
			sb.append(newline);
		}
		return sb.toString();
	}
	
	
	private String toFirstCharUpper(String str){
		return str.substring(0, 1).toUpperCase()+str.substring(1);
	}
	
	/**
	 * 拼接构造方法   无参数构造 和  有参数构造
	 * @return
	 */
	private String createConstractorMethod(Object ...objects){
		StringBuffer sb=new StringBuffer();
		sb.append(newline);
		sb.append(tab);
		sb.append(modifier.PUBLIC.value);
		sb.append(space);
		sb.append(toFirstCharUpper(className));
		sb.append(kh_less_left);
		if(objects!=null  &&  objects.length>0){
			if(objects[0] instanceof Map){
				Map<String, String> attr=(Map<String, String>) objects[0];
				for(Map.Entry<String, String> entry : attr.entrySet()){
					sb.append(entry.getValue());
					sb.append(space);
					sb.append(entry.getKey());
					sb.append(",");
				}
				sb.replace(sb.lastIndexOf(","), sb.lastIndexOf(",")+1, space);
			}
		}
		sb.append(kh_less_right);
		sb.append(kh_middle_left);
		if(objects!=null  &&  objects.length>0){
			if(objects[0] instanceof Map){
				Map<String, String> attr=(Map<String, String>) objects[0];
				for(Map.Entry<String, String> entry : attr.entrySet()){
					sb.append(newline);
					sb.append(tab);
					sb.append(tab);
					sb.append("this."+entry.getKey()+"="+entry.getKey());
					sb.append(";");
					sb.append(semicolon);
				}
				sb.replace(sb.lastIndexOf(sb.toString()), sb.lastIndexOf(sb.toString()), space);
			}
		}
		sb.append(newline);
		sb.append(tab);
		sb.append(kh_middle_right);
		return sb.toString();
	}
	
	
	/**
	 * 生成get方法
	 * 
	 */
	private String createGetMethod(Map<String, String> attr){
		StringBuffer sb=new StringBuffer();
		for(Map.Entry<String, String> entry: attr.entrySet()){
			sb.append(newline);
			sb.append(modifier.PUBLIC.value);
			sb.append(space);
			sb.append(entry.getValue());
			sb.append(space);
			sb.append(getMethod);
			String firstChar=entry.getKey().substring(0, 1).toUpperCase();
			String afterfirstChar=entry.getKey().substring(1);
			sb.append(firstChar+afterfirstChar);
			sb.append(kh_less_left);
			sb.append(kh_less_right);
			sb.append(kh_middle_left);
			sb.append(newline);
			sb.append("return this."+entry.getKey());
			sb.append(";");
			sb.append(newline);
			sb.append(kh_middle_right);
		}
		return sb.toString();
	}
	
	/**
	 * 生成Set方法
	 * @param attr
	 * @return
	 */
	private String createSetMethod(Map<String, String> attr){
		StringBuffer sb=new StringBuffer();
		for(Map.Entry<String, String> entry: attr.entrySet()){
			sb.append(newline);
			sb.append(modifier.PUBLIC.value);
			sb.append(space);
			sb.append("void");
			sb.append(space);
			sb.append(setMethod);
			String firstChar=entry.getKey().substring(0, 1).toUpperCase();
			String afterfirstChar=entry.getKey().substring(1);
			sb.append(firstChar+afterfirstChar);
			sb.append(kh_less_left);
			sb.append(entry.getValue());
			sb.append(space);
			sb.append(entry.getKey());
			sb.append(kh_less_right);
			sb.append(kh_middle_left);
			sb.append(newline);
			sb.append("this."+entry.getKey()+"="+entry.getKey());
			sb.append(";");
			sb.append(newline);
			sb.append(kh_middle_right);
		}
		return sb.toString();
	}
	
	/**
	 * 创建对象的toString方法
	 */
	private String createToStringMethod(Map<String, String> attr){
		StringBuffer sb=new StringBuffer();
		sb.append(newline);
		sb.append("public String toString() {");
		sb.append(newline);
		sb.append("return");
		sb.append(space);
		sb.append("\" "+ className+" [  ");
		for(Map.Entry<String, String> entry:attr.entrySet()){
			sb.append(entry.getKey());
			sb.append("=\"+ this."+ entry.getKey() +"+ \",");
		}
		int index=sb.lastIndexOf("\",");
		sb.replace(index, index+3, "");
		sb.append("\"]\";");
		sb.append(newline);
		sb.append(kh_middle_right);
		return sb.toString();
	}
	
	/**
	 * 创建javabean对应的数据库的实体类
	 * @return
	 * @throws SQLException
	 */
	
	public String createJavaBena() throws SQLException{
		StringBuffer sb=new StringBuffer();
		Map<String, String> attr=getAttrFromDB();
		sb.append(createAttrStr());
		sb.append(createConstractorMethod());
		sb.append(createConstractorMethod(attr));
		sb.append(createGetMethod(attr));
		sb.append(createSetMethod(attr));
		sb.append(createToStringMethod(attr));
		sb.append(newline);
		sb.append(kh_middle_right);
		return sb.toString();
	}
	
	
	private void writeJavaBean(){
		
	}
	
	

	public static void main(String[] args) throws SQLException, UnsupportedEncodingException, ClassNotFoundException, FileNotFoundException {
		
		System.out.println(AutoCreateJavaBean.getClassCode("Judges").createJavaBena());
		
		String path=Thread.currentThread().getContextClassLoader().getResource("").getPath();
		
		path=URLDecoder.decode(path, "utf-8");

		/*FileInputStream in=new FileInputStream("D:/test.java");
		FileOutputStream out=new FileOutputStream(new File("D:/test_1.class"));
				System.out.println(System.getProperty("java.home"));
		
		 JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
	        int run = compiler.run(in, out, null, "-version");
	        System.out.println("===" + run);*/
	}
	
	
	/**
	 * 定义修饰词的枚举类
	 * @author saber
	 *
	 */
	enum modifier{
		PUBLIC("public"), PRIVATE("private"), PROTECTED("protected");
		
		private String value;
		
		private modifier(String str){
			this.value=str;
		}
	}
	
	
	
}
