
package com.sy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 往数据库插入计算记录（运算一次记录一次）
 * @param str
 */
public class preserve {
	/**
	 * 插入一条记录进行测试
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toinsert("1*2=3");
	}
/**
 * 连接数据库并插入数据
 * @param str
 */
	public static void toinsert(String str) {
		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;

		conn = ConnectionDemo01.getconnection();
		String sql = "insert into  rtable values(?)";
		try {
			presta = conn.prepareStatement(sql);
			presta.setString(1, str);
			presta.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
