package com.atguigu.mvcapp.db;

import java.sql.Connection;
import java.sql.SQLException;





import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;



/**
 * 
 * JDBC�����Ĺ�����
 *
 */
public class JdbcUtils {

	/**
	 * �ͷ�Connection����
	 * @param connection
	 */
	public static void releaseConnection(Connection connection){
		
	}
	
	private static DataSource dataSource = null;
	static{
		dataSource = new ComboPooledDataSource("mvcapp");
	}
	
	/**
	 * ��������Դ��һ��Connection����
	 * @return
	 * @throws SQLException 
	 */
	public static  Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
	
}