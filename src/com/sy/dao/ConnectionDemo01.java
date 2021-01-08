
package com.sy.dao;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * 建立数据库连接
 * @return
 */
public class ConnectionDemo01 {
/**
 * 连接数据库
 * @return
 */
	public static Connection getconnection() {
		Connection conn = null;
		try {
			//加载驱动
			Class.forName("com.mysql.cj.jdbc.Driver");
			//建立和数据库的连接
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jisuanqi?serverTimezone=GMT", "root", "root");
			//conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
