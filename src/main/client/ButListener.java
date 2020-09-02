import constant.ConstantPara;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
import javax.swing.JTextField;
//按钮监听器的父类ActionListener里面有函数可以直接检测按钮是否被点击
public class ButListener implements ActionListener {
	//定义JTextFieldb变量jt,用来保存传递过来的文本框对象
	private JTextField cookie;
	private JTextField jt2;
	
	//定义set方法，初始化jt
	public void setJt(JTextField cookie,JTextField jt2){
		this.cookie = cookie;
		this.jt2=jt2;
	}
 
	public void actionPerformed(ActionEvent e) {
//		CrawQBApplication run = new CrawQBApplication();
//		run.run();

		//检测到按钮被点击自动计入到这个函数，这个函数是ActionListener类的方法

		//获取Cookie的值
		String cookieValue = cookie.getText();
		ConstantPara.YOURCOOKIE = cookieValue;

		String password=jt2.getText();
		//验证账号和密码，如果正确显示登陆成功的界面
		//账号123对应密码789

	}	
}