
package com.sy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * �����ݿ��������¼������һ�μ�¼һ�Σ�
 * @param str
 */
public class preserve {
	/**
	 * ����һ����¼���в���
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		toinsert("1*2=3");
	}
/**
 * �������ݿⲢ��������
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
