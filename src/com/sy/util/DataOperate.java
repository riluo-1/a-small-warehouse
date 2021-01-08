
package com.sy.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

import com.sy.dao.ConnectionDemo01;
/**
 * ������ط���ָ����Χ�������
 * @param start
 * @param end
 * @return
 */
public class DataOperate {
	/**
	 * ������ط���ָ����Χ�������
	 * @param start
	 * @param end
	 * @return
	 */
	 public static int getNum(int start,int end) {//������ط���ָ����Χ�������
	        //Math.random()�������0.0��1.0֮�����
	        return (int)(Math.random()*(end-start+1)+start);
}
	 /**
	  * ��������������ɼ�����
	  * @param args
	  */
	 public static void main(String[] args) {
		 for(int i=1;i<=10000;i++) {
			 double data1=getNum(1,10000);
			 double data2=getNum(1,10000);
			 double result;
			 DecimalFormat df = new DecimalFormat("0.00");
			 int k=getNum(1,4);
			 if(k==1)
			 {
				 result=data1+data2;
				toinsert( data1+"+"+data2+"="+df.format(result));
			 }
			 if(k==2)
			 {
				 result=data1-data2;
				 toinsert( data1+"-"+data2+"="+df.format(result));
			 }
			 if(k==3)
			 {
				 result=data1*data2;
				 toinsert( data1+"*"+data2+"="+df.format(result));
			 } 
			 if(k==4)
			 {
				 result=data1/data2;
				 toinsert( data1+"��"+data2+"="+df.format(result));
			 }
		 }
		}
	 /**
	  * ���Ӳ������ݿ���������
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