package com.lgd.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
/**
 * �����ȡ�����ļ�
 * 1.��������������ļ�ֻ��Ҫ��ȡһ��    ���õ���ģʽ 
 * 2.MyProperties extends Properties��ȡ�����ļ�    load(InputStream )
 * InputStream   Ҫָ��db.properties ��λ��      ���ܰѵ�ַд��        �����ֽ��뷴���ȡ��ַ
 *
 */
public class MyProperties extends Properties{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MyProperties instance=new MyProperties();
	
	private MyProperties() {
		//���췽�����ٻ�ִ��һ��
		//InputStream iis=new FileInputStream("...");
		InputStream iis=MyProperties.class.getClassLoader().getResourceAsStream("db.properties");
		try {
			load(iis);
		} catch (IOException e) {
			Log.error(e);
		}finally{
			if(iis!=null){
				try {
					iis.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static MyProperties getInstance(){
		return instance;
	}
	
}
