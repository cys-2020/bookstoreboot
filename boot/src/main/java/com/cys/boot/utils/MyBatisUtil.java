package com.cys.boot.utils;
import java.io.IOException;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.ibatis.session.*;
import org.apache.ibatis.io.*;
public class MyBatisUtil {
	private static SqlSessionFactory sqlSessionFactory= null;
	//����ģʽ
	private static final Class<MyBatisUtil> CLASS_LOCK=MyBatisUtil.class;
	//����ģʽ
	private MyBatisUtil() {
		
	}
	public static SqlSessionFactory initFactory() {
		String config="mybatis/mybatis_config.xml";
		InputStream in=null;
		//���jdbc.properties��username��password��������
		InputStreamReader proReader=null,cfgReader=null;
		Properties properties=null;
		try {
			/*cfgReader=new InputStreamReader(Resources.getResourceAsStream(
							"mybatis/mybatis_config.xml"));
			proReader=new InputStreamReader(Resources.getResourceAsStream(
					"properties/jdbc.properties"));
			properties=new Properties();
			�޸�����Ϊ����(�����е�decode)
			properties.setProperty("username",
					decode(properties.getProperty("uesrname")));
			properties.setProperty("password",
					decode(properties.getProperty("password")));*/
			in=Resources.getResourceAsStream(config);
		} catch (IOException e) {
			Logger.getLogger(MyBatisUtil.class.getName())
				.log(Level.SEVERE,null,e);
		}
		//����ģʽ
		synchronized (CLASS_LOCK) {
			if(sqlSessionFactory==null) {
				sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
			}
		}
		
		return sqlSessionFactory;
	}
	public static SqlSession openSqlSession() {
		if(sqlSessionFactory==null) {
			initFactory();
		}
		return sqlSessionFactory.openSession();
	}
}
