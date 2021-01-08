
package com.sy.view;
import javax.swing.*;

import com.sy.dao.preserve;
import com.sy.util.Music;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.EventObject;

/**
 * 创建计算器主界面
 * @author sunset
 *
 */
public class CaculatorDemo {
	/**
	 * 实例化计算器对象
	 * @param args
	 */
	public static void main(String[] args) {
		JS win=new JS();
	}
}
/**
 * 计算器主界面
 *
 */
class JS extends JFrame implements ActionListener{
	/**
	 * 利用StringBuilder类来显示，以及区分两个操作数
	 */
	private StringBuilder sBuilder = new StringBuilder();  //利用StringBuilder类来显示，以及区分两个操作数

	JTextArea text=new JTextArea();
	/*
	 * 操作数
	 */
	double a,b;
	/**
	 * 计算结果
	 */
	Double sum;
	Music music;
	int i;
	int x = 0;
	@SuppressWarnings("null")
	public JS()
	{
		setBounds(100,100,400,400);//设置窗体大小
		setTitle("计算器");
		JMenuBar menubar=new JMenuBar();//创建菜单条
		JMenu menu1=new JMenu("查看(V)");//创建和设置菜单名
		JMenuItem jmenuitem=new JMenuItem("历史记录");
		jmenuitem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				//System.out.println("查看历史记录");
				
					history his = new history();
					his.setVisible(true);
				
			}
		});
		
		menu1.add(jmenuitem);
		JMenu menu2=new JMenu("编辑(E)");//创建和设置菜单名
		JMenu menu3=new JMenu("帮助(H)");//创建和设置菜单名
		menubar.add(menu1);//将菜单加入到菜单条中
		menubar.add(menu2);
		menubar.add(menu3);
		this.setJMenuBar(menubar);//将设置好的菜单条放在窗口中
		this.setLayout(new BorderLayout());//添加文本框
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		text.setPreferredSize(new Dimension (370,60));//设置组件大小
		p2.setLayout(new FlowLayout());
		p1.add(text);
		this.add(p1,BorderLayout.NORTH);
		p2.setLayout(new GridLayout(6,4));	//添加按钮
		JButton button[]=new JButton[24];
		button[0]=new JButton("AC");		//清空
		button[1]=new JButton("←");	//清除之前输入的一个数据
		button[2]=new JButton("NM");		//暂停音乐
		button[3]=new JButton("1/x");   //求倒数
		button[4]=new JButton("+/-");   //求相反数
		button[5]=new JButton("sin");  //求正弦
		button[6]=new JButton("sqrt"); //开平方
		button[7]=new JButton("÷");
		button[8]=new JButton("7");
		button[9]=new JButton("8");
		button[10]=new JButton("9");
		button[11]=new JButton("x");  //乘号
		button[12]=new JButton("4");
		button[13]=new JButton("5");
		button[14]=new JButton("6");
		button[15]=new JButton("—");  //减号
		button[16]=new JButton("1");
		button[17]=new JButton("2");
		button[18]=new JButton("3");
		button[19]=new JButton("+");  //加号
		button[20]=new JButton("M");//播放（暂停）音乐
		button[21]=new JButton("0");
		button[22]=new JButton(".");  //小数点
		button[23]=new JButton("="); //等于
		for(int i=0;i<button.length;i++ )	//将组件加入容器
			p2.add(button[i]);
		button[23].setBackground(Color.ORANGE);//设置按钮的背景颜色为橙色
		p2.add(button[23]);
		add(p2,BorderLayout.CENTER);
		for(int i=0;i<button.length;i++)	//为每一个事件(按钮)添加监视器
			button[i].addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //点击X号可以关闭程序
	}
	/**
	 * 将输入的字符串保存以便于后面进行记录
	 */
	String ans="";
	/**
	 * 处理相应按钮事件
	 */
	public void actionPerformed(ActionEvent e) //事件处理
	{
		// TODO Auto-generated method stub
		String lab=e.getActionCommand();			//得到当前的按钮字符，后面进行匹配
		if(lab.equals("0"))								//处理按钮 0~9
		{
			/**
			 * 利用StringBuilder类的对象调用方法，将数据存起来
			 */
			sBuilder.append("0");		//利用StringBuilder类的对象调用方法，将数据存起来
			/**
			 * 显示之前所有输入的数据
			 */
			text.setText(sBuilder.toString());	//显示之前所有输入的数据
			/**
			 * 保存相应数据
			 */
			ans=ans+"0";
		}
		else if(lab.equals("1"))
		{
			sBuilder.append("1");		//利用StringBuilder类的对象调用方法，将数据存起来			
			text.setText(sBuilder.toString());	//显示之前所有输入的数据	
			ans=ans+"1";
		}
		else if(lab.equals("2"))
		{
			sBuilder.append("2");		//利用StringBuilder类的对象调用方法，将数据存起来
			ans=ans+"2";
			text.setText(sBuilder.toString());	 //显示之前所有输入的数据
		}
		else if(lab.equals("3"))
		{
			sBuilder.append("3");		//利用StringBuilder类的对象调用方法，将数据存起来
			ans=ans+"3";
			text.setText(sBuilder.toString());	//显示之前所有输入的数据
		}
		else if(lab.equals("4"))
		{
			sBuilder.append("4");			
			ans=ans+"4";
			text.setText(sBuilder.toString());	
		}
		else if(lab.equals("5"))
		{
			sBuilder.append("5");		
			ans=ans+"5";
			text.setText(sBuilder.toString());	
		}
		else if(lab.equals("6"))
		{
			sBuilder.append("6");
			ans=ans+"6";
			text.setText(sBuilder.toString());	
		}
		else if(lab.equals("7"))
		{
			sBuilder.append("7");	
			ans=ans+"7";
			text.setText(sBuilder.toString());	
		}
		
		else if(lab.equals("8"))
		{
			sBuilder.append("8");
			ans=ans+"8";
			text.setText(sBuilder.toString());	
		}
		else if(lab.equals("9"))
		{
			sBuilder.append("9");		//利用StringBuilder类的对象调用方法，将数据存起来	
			ans=ans+"9";
			text.setText(sBuilder.toString());	//显示之前所有输入的数据
		}
		
		else if(lab.equals("←"))    				//处理"←"按钮事件   即清除当前的输入的数据
		{
			sBuilder.deleteCharAt(sBuilder.length() - 1);	//StringBuilder的实例化对象调用方法下标减1即可
			text.setText(sBuilder.toString());
		}
		else if(lab.equals("AC"))                   //处理"AC"按钮事件   即清除之前的输入所有的数据
		{
			sBuilder = new StringBuilder();						//重新创建即可清除之前的输入所有的数据
			text.setText(sBuilder.toString());
		}
		else if(lab.equals("."))						// 处理按钮 "." 事件
		{
			sBuilder.append(".");						//利用StringBuilder类的对象调用方法，将数据存起来
			text.setText(sBuilder.toString());			//显示之前输入的数据
		}
		else if(lab.equals("+"))	//处理+"按钮
		{
			/**
			 * 将 运算符 之前的数据 作为第一个操作数 a
			 */
			a = Double.parseDouble(sBuilder.toString());	//将 运算符 之前的数据 作为第一个操作数 a
			i=0;                                            //标记运算类型  即"+"之前的数据即将作为加数
			sBuilder = new StringBuilder();					//将数组清空来存储第二个操作数 b
			text.setText("+");
			ans = ans +"+";
		}
		else if(lab.equals("—"))		//处理"—"按钮
		{
			a = Double.parseDouble(sBuilder.toString());	//将前面的输入的数 作为第一个操作数a
			i=1;											//标记运算类型  即"-"之前的数据即将作为被减数
			sBuilder = new StringBuilder();					//将数组清空来存储第二个操作数 b	
			text.setText("—");
			ans = ans +"-";
		}
		else if(lab.equals("x"))    	//处理"x"按钮
		{										
			a = Double.parseDouble(sBuilder.toString());	//将前面的输入的数 作为第一个操作数a
			i=2;											//标记运算类型  即"*"之前的数据即将作为因数
			sBuilder = new StringBuilder();					//将数组清空来存储第二个操作数 b
			text.setText("x");
			ans = ans +"x";
		}
		else if(lab.equals("÷"))		//处理"÷"按钮
		{
			a = Double.parseDouble(sBuilder.toString());	//将除法的输入的数 作为第一个操作数a
			i=3;											//标记运算类型  即"÷"之前的数据即将作为被除数
			sBuilder = new StringBuilder();					//将数组清空来存储第二个操作数 b
			text.setText("÷");
			ans = ans +"÷";
		}
		/**else if(lab.equals("%"))	//处理取余运算
		{
			a = Double.parseDouble(sBuilder.toString());	//将前面的输入的数 作为第一个操作数a
			i=4;											//标记取余运算
			sBuilder = new StringBuilder();					//将数组清空来存储第二个操作数 b
			text.setText("%");
		}*/
		else if(lab.equals("1/x")) //处理求倒数
		{
			a = Double.parseDouble(sBuilder.toString());  //将前面的输入的数 作为第一个操作数a
			sum=1/a;
			text.setText("1/x");
			sBuilder = new StringBuilder();
			text.setText(sum.toString());
			sBuilder.append(sum);
			ans = "1/"+a+"="+sum;
			preserve.toinsert(ans);
		}
		else if(lab.equals("+/-"))//处理求相反数
		{
			a = Double.parseDouble(sBuilder.toString());  //将前面的输入的数 作为第一个操作数a
			if(a!=0)
			{
			sum=-a;
			text.setText("+/-");
			sBuilder = new StringBuilder();
			text.setText(sum.toString());
			sBuilder.append(sum);
			ans = "+/-"+a+"="+sum;
			preserve.toinsert(ans);
			}
			else
			text.setText("0");
		}
		else if(lab.equals("sin"))//处理求正弦
		{
			a = Double.parseDouble(sBuilder.toString());  //将前面的输入的数 作为第一个操作数a
			/**
			 * 将数字a转换为弧度
			 */
			sum=Math.toRadians(a);   //将数字a转换为"sum"度数
			text.setText(sum.toString());
			sBuilder.append(Math.sin(sum));
			ans = "sin"+a+"="+sum;
			preserve.toinsert(ans);
		}
		else if(lab.equals("sqrt"))//处理求平方
		{
			a=Double.parseDouble(sBuilder.toString());
			if(a>=0)
{
			sum=Math.sqrt(a); //使用java.lang.Math类的sqrt(double)方法
			text.setText(sum.toString());
			sBuilder.append(sum);
			ans = "sqrt"+a+"="+sum;
			preserve.toinsert(ans);
}
			else
			text.setText("该数无法求平方");
			preserve.toinsert(ans);
		}
		else if(lab.equals("M"))//播放音乐
		{
			music=new Music();
			
		}
		else if(lab.equals("NM"))//暂停音乐
		{
			music.stopMusic();
		}
		/**else if(lab.equals("历史记录")) {
		public void actionPerformed(ActionEvent e1) {
	      //  if( e.getSource().equals("历史记录"))
	            this.dispose();
	            // System.exit( 0); 
	            
	       }}
		else if(lab.equals("历史记录")) {
			jmenuitem.addActionListener(e->{
				jieguojilu j=new jieguojilu();
				j.setVisible(true);
			});
			this.dispose();
			jieguojilu bb=new jieguojilu();
			bb.E();
		}*/
		//jmenuitem
		else if(lab.equals("="))
		{
			b = Double.parseDouble(sBuilder.toString());	//一遇到"=",我们就能得到第二个操作数b
			if (i == 0)			//加法 a+b
				{
					sum=a+b;
					text.setText(sum.toString());		//输出第二个操作数已经输入的数据
					sBuilder = new StringBuilder();		//清空数据，为后面的操作数留空间
					sBuilder.append(sum);
					ans = ans+"="+sum;
					preserve.toinsert(ans);
				} 
			else if (i == 1) 	//加法  a-b
				{
					sum = a - b;
					text.setText(sum.toString());
					sBuilder = new StringBuilder();		//清空数据，为后面的操作数留空间
					sBuilder.append(sum);
					ans = ans+"="+sum;
					preserve.toinsert(ans);
				}
			else if (i == 2) 	//乘法a*b
				{
					sum = a * b;
					text.setText(sum.toString());
					sBuilder = new StringBuilder();
					sBuilder.append(sum);
					ans = ans+"="+sum;
					preserve.toinsert(ans);
				} 
			else if (i == 3) 	//除法 a÷b
				{
					sum = a / b;
					text.setText(sum.toString());
					sBuilder = new StringBuilder();
					sBuilder.append(sum);
					ans = ans+"="+sum;
					preserve.toinsert(ans);
				} 
			
			/**else if (i == 4)	 //	取余 a%b
				{
					sum=a % b;
					int m=(int)a;
					int n=(int)b;
					sum=(double)m % n;
					text.setText(sum.toString());
					sBuilder = new StringBuilder();
					sBuilder.append(sum);
				} */
			
			 else 
				text.setText(sBuilder.toString());
			ans = "";
		}
	}

}