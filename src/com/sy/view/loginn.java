
package com.sy.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.sy.bean.loginservice;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
/**
 * 用户登录界面
 * @author sunset
 *
 */
public class loginn extends JFrame {
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * 启动应用程序
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginn frame = new loginn();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 建立框架
	 */
	public loginn() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setToolTipText("\u8BA1\u7B97\u5668");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");
		lblNewLabel.setBounds(14, 58, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");
		lblNewLabel_1.setBounds(14, 89, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(114, 55, 86, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(100, 86, 136, 24);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String userName =textField.getText();
				String password = passwordField.getText();
				if (userName.equals("")) {
					JOptionPane.showMessageDialog(null, "用户名不能为空");
					return;
				}
				if (password.equals("")) {
					JOptionPane.showMessageDialog(null, "密码不能为空");
					return;
				}

				int ans = 0;
				try {
					ans = loginservice.verid(userName, password);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (ans == 0) {
					JOptionPane.showMessageDialog(null, "密码错误", "ERROR_MESSAGE", JOptionPane.ERROR_MESSAGE);
				} else if (ans == -1) {
					JOptionPane.showMessageDialog(null, "用户不存在", "WARNING_MESSAGE", JOptionPane.WARNING_MESSAGE);
				} else {
					cl();
					JS win=new JS();

				}
			}
		});
		btnNewButton.setBounds(114, 200, 113, 27);
		contentPane.add(btnNewButton);
		
		
	}
	
	public void cl() {
		this.dispose();
	}
}
