
package com.sy.dao;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * �������ݿ�����
 * @return
 */
public class ConnectionDemo01 {
/**
 * �������ݿ�
 * @return
 */
	public static Connection getconnection() {
		Connection conn = null;
		try {
			//��������
			Class.forName("com.mysql.cj.jdbc.Driver");
			//���������ݿ������
			conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jisuanqi?serverTimezone=GMT", "root", "root");
			//conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
