
package com.sy.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import com.sy.dao.ConnectionDemo01;
import com.sy.dao.deletehistory;
/**
 * 计算记录
 * @author sunset
 *
 */
public class history extends JFrame {

	private JPanel contentPane;

	/**
	 * 启动应用程序
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					history frame = new history();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 *创建框架。
	 */
	 JPanel panel = null;
	 JScrollPane scrollPane =null;
	public history() {
		setTitle("\u5386\u53F2\u8BB0\u5F55");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 363);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 群聊面板
		 scrollPane = new JScrollPane();

		scrollPane.setBounds(0, 146, 353, 542);
		contentPane.add(scrollPane);

		 panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		scrollPane.setViewportView(panel);
		panel.setLayout(new GridLayout(50, 1, 4, 4));
		addhis();
	}

	public  void addhis() {
		String username = "";
		String userid = "";
		String myid = "";
		Connection conn = null;
		PreparedStatement presta = null;// 要执行SQL语句首先要Statement对象
		ResultSet res = null;
		panel.removeAll();
		try {
			// 获取连接
			conn = ConnectionDemo01.getconnection();
			String sql4 = "SELECT * FROM rtable ";
			presta = conn.prepareStatement(sql4);
			res = presta.executeQuery();
			while (res.next()) {
				String sender = res.getString("result");
				addmessage(sender);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
		}
		panel.setVisible(false);
		scrollPane.setVisible(false);
		
		
		panel.repaint();
		
		
		
		panel.setVisible(true);
		scrollPane.setVisible(true);
	}

	// 把消息添加到面板上面
	public  void addmessage(String sender) {
		
		JLabel jlabel11 = new JLabel(sender , JLabel.LEFT);
		jlabel11.setFont(new Font("宋体", Font.PLAIN, 24));
		// 菜单
		JPopupMenu popuMenu = new JPopupMenu();

		// 给菜单添加按钮组件 私聊 /群聊
		JMenuItem ac = new JMenuItem("删除");
		ac.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				deletehistory.todelete(sender);
				addhis();
			}
		});
		popuMenu.add(ac);


		// 添加监听器
		jlabel11.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				popuMenu.show(jlabel11, e.getX(), e.getY());

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override // 鼠标碰到变蓝
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				JLabel jl = (JLabel) e.getSource();
				jl.setForeground(Color.blue);
			}

			@Override // 鼠标离开变黑
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				JLabel jl = (JLabel) e.getSource();
				jl.setForeground(Color.black);
			}

		});
		panel.add(jlabel11);
		panel.repaint();

	}

}
