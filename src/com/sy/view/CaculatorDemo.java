
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
 * ����������������
 * @author sunset
 *
 */
public class CaculatorDemo {
	/**
	 * ʵ��������������
	 * @param args
	 */
	public static void main(String[] args) {
		JS win=new JS();
	}
}
/**
 * ������������
 *
 */
class JS extends JFrame implements ActionListener{
	/**
	 * ����StringBuilder������ʾ���Լ���������������
	 */
	private StringBuilder sBuilder = new StringBuilder();  //����StringBuilder������ʾ���Լ���������������

	JTextArea text=new JTextArea();
	/*
	 * ������
	 */
	double a,b;
	/**
	 * ������
	 */
	Double sum;
	Music music;
	int i;
	int x = 0;
	@SuppressWarnings("null")
	public JS()
	{
		setBounds(100,100,400,400);//���ô����С
		setTitle("������");
		JMenuBar menubar=new JMenuBar();//�����˵���
		JMenu menu1=new JMenu("�鿴(V)");//���������ò˵���
		JMenuItem jmenuitem=new JMenuItem("��ʷ��¼");
		jmenuitem.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				//System.out.println("�鿴��ʷ��¼");
				
					history his = new history();
					his.setVisible(true);
				
			}
		});
		
		menu1.add(jmenuitem);
		JMenu menu2=new JMenu("�༭(E)");//���������ò˵���
		JMenu menu3=new JMenu("����(H)");//���������ò˵���
		menubar.add(menu1);//���˵����뵽�˵�����
		menubar.add(menu2);
		menubar.add(menu3);
		this.setJMenuBar(menubar);//�����úõĲ˵������ڴ�����
		this.setLayout(new BorderLayout());//����ı���
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		text.setPreferredSize(new Dimension (370,60));//���������С
		p2.setLayout(new FlowLayout());
		p1.add(text);
		this.add(p1,BorderLayout.NORTH);
		p2.setLayout(new GridLayout(6,4));	//��Ӱ�ť
		JButton button[]=new JButton[24];
		button[0]=new JButton("AC");		//���
		button[1]=new JButton("��");	//���֮ǰ�����һ������
		button[2]=new JButton("NM");		//��ͣ����
		button[3]=new JButton("1/x");   //����
		button[4]=new JButton("+/-");   //���෴��
		button[5]=new JButton("sin");  //������
		button[6]=new JButton("sqrt"); //��ƽ��
		button[7]=new JButton("��");
		button[8]=new JButton("7");
		button[9]=new JButton("8");
		button[10]=new JButton("9");
		button[11]=new JButton("x");  //�˺�
		button[12]=new JButton("4");
		button[13]=new JButton("5");
		button[14]=new JButton("6");
		button[15]=new JButton("��");  //����
		button[16]=new JButton("1");
		button[17]=new JButton("2");
		button[18]=new JButton("3");
		button[19]=new JButton("+");  //�Ӻ�
		button[20]=new JButton("M");//���ţ���ͣ������
		button[21]=new JButton("0");
		button[22]=new JButton(".");  //С����
		button[23]=new JButton("="); //����
		for(int i=0;i<button.length;i++ )	//�������������
			p2.add(button[i]);
		button[23].setBackground(Color.ORANGE);//���ð�ť�ı�����ɫΪ��ɫ
		p2.add(button[23]);
		add(p2,BorderLayout.CENTER);
		for(int i=0;i<button.length;i++)	//Ϊÿһ���¼�(��ť)��Ӽ�����
			button[i].addActionListener(this);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //���X�ſ��Թرճ���
	}
	/**
	 * ��������ַ��������Ա��ں�����м�¼
	 */
	String ans="";
	/**
	 * ������Ӧ��ť�¼�
	 */
	public void actionPerformed(ActionEvent e) //�¼�����
	{
		// TODO Auto-generated method stub
		String lab=e.getActionCommand();			//�õ���ǰ�İ�ť�ַ����������ƥ��
		if(lab.equals("0"))								//����ť 0~9
		{
			/**
			 * ����StringBuilder��Ķ�����÷����������ݴ�����
			 */
			sBuilder.append("0");		//����StringBuilder��Ķ�����÷����������ݴ�����
			/**
			 * ��ʾ֮ǰ�������������
			 */
			text.setText(sBuilder.toString());	//��ʾ֮ǰ�������������
			/**
			 * ������Ӧ����
			 */
			ans=ans+"0";
		}
		else if(lab.equals("1"))
		{
			sBuilder.append("1");		//����StringBuilder��Ķ�����÷����������ݴ�����			
			text.setText(sBuilder.toString());	//��ʾ֮ǰ�������������	
			ans=ans+"1";
		}
		else if(lab.equals("2"))
		{
			sBuilder.append("2");		//����StringBuilder��Ķ�����÷����������ݴ�����
			ans=ans+"2";
			text.setText(sBuilder.toString());	 //��ʾ֮ǰ�������������
		}
		else if(lab.equals("3"))
		{
			sBuilder.append("3");		//����StringBuilder��Ķ�����÷����������ݴ�����
			ans=ans+"3";
			text.setText(sBuilder.toString());	//��ʾ֮ǰ�������������
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
			sBuilder.append("9");		//����StringBuilder��Ķ�����÷����������ݴ�����	
			ans=ans+"9";
			text.setText(sBuilder.toString());	//��ʾ֮ǰ�������������
		}
		
		else if(lab.equals("��"))    				//����"��"��ť�¼�   �������ǰ�����������
		{
			sBuilder.deleteCharAt(sBuilder.length() - 1);	//StringBuilder��ʵ����������÷����±��1����
			text.setText(sBuilder.toString());
		}
		else if(lab.equals("AC"))                   //����"AC"��ť�¼�   �����֮ǰ���������е�����
		{
			sBuilder = new StringBuilder();						//���´����������֮ǰ���������е�����
			text.setText(sBuilder.toString());
		}
		else if(lab.equals("."))						// ����ť "." �¼�
		{
			sBuilder.append(".");						//����StringBuilder��Ķ�����÷����������ݴ�����
			text.setText(sBuilder.toString());			//��ʾ֮ǰ���������
		}
		else if(lab.equals("+"))	//����+"��ť
		{
			/**
			 * �� ����� ֮ǰ������ ��Ϊ��һ�������� a
			 */
			a = Double.parseDouble(sBuilder.toString());	//�� ����� ֮ǰ������ ��Ϊ��һ�������� a
			i=0;                                            //�����������  ��"+"֮ǰ�����ݼ�����Ϊ����
			sBuilder = new StringBuilder();					//������������洢�ڶ��������� b
			text.setText("+");
			ans = ans +"+";
		}
		else if(lab.equals("��"))		//����"��"��ť
		{
			a = Double.parseDouble(sBuilder.toString());	//��ǰ���������� ��Ϊ��һ��������a
			i=1;											//�����������  ��"-"֮ǰ�����ݼ�����Ϊ������
			sBuilder = new StringBuilder();					//������������洢�ڶ��������� b	
			text.setText("��");
			ans = ans +"-";
		}
		else if(lab.equals("x"))    	//����"x"��ť
		{										
			a = Double.parseDouble(sBuilder.toString());	//��ǰ���������� ��Ϊ��һ��������a
			i=2;											//�����������  ��"*"֮ǰ�����ݼ�����Ϊ����
			sBuilder = new StringBuilder();					//������������洢�ڶ��������� b
			text.setText("x");
			ans = ans +"x";
		}
		else if(lab.equals("��"))		//����"��"��ť
		{
			a = Double.parseDouble(sBuilder.toString());	//��������������� ��Ϊ��һ��������a
			i=3;											//�����������  ��"��"֮ǰ�����ݼ�����Ϊ������
			sBuilder = new StringBuilder();					//������������洢�ڶ��������� b
			text.setText("��");
			ans = ans +"��";
		}
		/**else if(lab.equals("%"))	//����ȡ������
		{
			a = Double.parseDouble(sBuilder.toString());	//��ǰ���������� ��Ϊ��һ��������a
			i=4;											//���ȡ������
			sBuilder = new StringBuilder();					//������������洢�ڶ��������� b
			text.setText("%");
		}*/
		else if(lab.equals("1/x")) //��������
		{
			a = Double.parseDouble(sBuilder.toString());  //��ǰ���������� ��Ϊ��һ��������a
			sum=1/a;
			text.setText("1/x");
			sBuilder = new StringBuilder();
			text.setText(sum.toString());
			sBuilder.append(sum);
			ans = "1/"+a+"="+sum;
			preserve.toinsert(ans);
		}
		else if(lab.equals("+/-"))//�������෴��
		{
			a = Double.parseDouble(sBuilder.toString());  //��ǰ���������� ��Ϊ��һ��������a
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
		else if(lab.equals("sin"))//����������
		{
			a = Double.parseDouble(sBuilder.toString());  //��ǰ���������� ��Ϊ��һ��������a
			/**
			 * ������aת��Ϊ����
			 */
			sum=Math.toRadians(a);   //������aת��Ϊ"sum"����
			text.setText(sum.toString());
			sBuilder.append(Math.sin(sum));
			ans = "sin"+a+"="+sum;
			preserve.toinsert(ans);
		}
		else if(lab.equals("sqrt"))//������ƽ��
		{
			a=Double.parseDouble(sBuilder.toString());
			if(a>=0)
{
			sum=Math.sqrt(a); //ʹ��java.lang.Math���sqrt(double)����
			text.setText(sum.toString());
			sBuilder.append(sum);
			ans = "sqrt"+a+"="+sum;
			preserve.toinsert(ans);
}
			else
			text.setText("�����޷���ƽ��");
			preserve.toinsert(ans);
		}
		else if(lab.equals("M"))//��������
		{
			music=new Music();
			
		}
		else if(lab.equals("NM"))//��ͣ����
		{
			music.stopMusic();
		}
		/**else if(lab.equals("��ʷ��¼")) {
		public void actionPerformed(ActionEvent e1) {
	      //  if( e.getSource().equals("��ʷ��¼"))
	            this.dispose();
	            // System.exit( 0); 
	            
	       }}
		else if(lab.equals("��ʷ��¼")) {
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
			b = Double.parseDouble(sBuilder.toString());	//һ����"=",���Ǿ��ܵõ��ڶ���������b
			if (i == 0)			//�ӷ� a+b
				{
					sum=a+b;
					text.setText(sum.toString());		//����ڶ����������Ѿ����������
					sBuilder = new StringBuilder();		//������ݣ�Ϊ����Ĳ��������ռ�
					sBuilder.append(sum);
					ans = ans+"="+sum;
					preserve.toinsert(ans);
				} 
			else if (i == 1) 	//�ӷ�  a-b
				{
					sum = a - b;
					text.setText(sum.toString());
					sBuilder = new StringBuilder();		//������ݣ�Ϊ����Ĳ��������ռ�
					sBuilder.append(sum);
					ans = ans+"="+sum;
					preserve.toinsert(ans);
				}
			else if (i == 2) 	//�˷�a*b
				{
					sum = a * b;
					text.setText(sum.toString());
					sBuilder = new StringBuilder();
					sBuilder.append(sum);
					ans = ans+"="+sum;
					preserve.toinsert(ans);
				} 
			else if (i == 3) 	//���� a��b
				{
					sum = a / b;
					text.setText(sum.toString());
					sBuilder = new StringBuilder();
					sBuilder.append(sum);
					ans = ans+"="+sum;
					preserve.toinsert(ans);
				} 
			
			/**else if (i == 4)	 //	ȡ�� a%b
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