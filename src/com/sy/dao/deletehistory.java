
package com.sy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * 在数据库里删除历史记录
 * @author sunset
 *
 */
public class deletehistory {
	/**
	 * 测试
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		todelete("1111");
	}
	/**
	 * 连接数据库并删除历史记录
	 * @param str
	 */
	public static void todelete(String str) {
		Connection conn = null;
		PreparedStatement presta = null;
		ResultSet res = null;
		conn = ConnectionDemo01.getconnection();
		String sql = "delete from  rtable where result = ?";
		try {
		presta = conn.prepareStatement(sql);
		presta.setString(1, str);
		presta.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
