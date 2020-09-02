import javax.swing.*;
import java.awt.*;

public class Login {


	public static void main(String[] args){
		Login lo=new Login();
		lo.showUI();
	}
	public void showUI(){
		javax.swing.JFrame jf= new javax.swing.JFrame();
		jf.setTitle("QQ登录界面");
		jf.setSize(380,500);
		jf.setDefaultCloseOperation(3);
		jf.setLocationRelativeTo(null);

		java.awt.FlowLayout flow=new java.awt.FlowLayout();
		jf.setLayout(flow);

		javax.swing.ImageIcon icon = new javax.swing.ImageIcon("D:\\core\\tinjeck\\CrawlData\\src\\main\\client\\img\\loginP.jpg");
		javax.swing.JLabel jla= new javax.swing.JLabel(icon);
		java.awt.Dimension dm0=new java.awt.Dimension(280,200);
		jla.setPreferredSize(dm0);
		jf.add(jla);

		JLabel jl = new JLabel("***********************输入你的Cookie值************************");
		jf.add(jl);
		JLabel jl1 = new JLabel("Cookie");
		jf.add(jl1);
		javax.swing.JTextField jtf=new javax.swing.JTextField();
		java.awt.Dimension dm1=new java.awt.Dimension(200,30);
		jtf.setPreferredSize(dm1);
		jf.add(jtf);

		JLabel jl2 = new JLabel("**************************开始查询日期**************************");
		jf.add(jl2);
		JLabel jl3 = new JLabel("年");
		jf.add(jl3);
		javax.swing.JTextField jtf2=new javax.swing.JTextField();
		java.awt.Dimension dm2=new java.awt.Dimension(80,30);
		jtf2.setPreferredSize(dm2);
		jf.add(jtf2);
		JLabel jl4 = new JLabel("月");
		jf.add(jl4);
		javax.swing.JTextField jtf3=new javax.swing.JTextField();
		java.awt.Dimension dm3=new java.awt.Dimension(80,30);
		jtf3.setPreferredSize(dm3);
		jf.add(jtf3);


		JLabel jl5 = new JLabel("日");
		jf.add(jl5);
		javax.swing.JTextField jtf4=new javax.swing.JTextField();
		java.awt.Dimension dm4=new java.awt.Dimension(80,30);
		jtf4.setPreferredSize(dm4);
		jf.add(jtf4);
		JLabel jl6 = new JLabel("                            日期格式：yyyy-MM-dd                                 ");
		jl6.setForeground(Color.RED);
		jf.add(jl6);

		javax.swing.JButton jbu = new javax.swing.JButton("登陆");
		java.awt.Dimension dm5=new java.awt.Dimension(80,30);
		jbu.setPreferredSize(dm5);
		jf.add(jbu);

		//给按钮添加动作监听器方法
		ButListener but = new ButListener();
		//创建一个监听器
		jbu.addActionListener(but);
		//把监听器加在“登录”按钮上
		but.setJt(jtf,jtf2);


		jf.setVisible(true);
	}
}