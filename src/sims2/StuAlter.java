/**
 * 对话框，更改信息
 */
package sims2;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StuAlter extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//定义需要的组件
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	
	//构造函数，owner父窗口，title窗口标题，modal指定是否模式窗口
	public StuAlter(Frame owner,String title,boolean modal,StuModel sm,int rowNum)
	{
		super(owner,title,modal);//调用父类构造方法，达到模式对话框效果
		jl1 = new JLabel("学号");
		jl2 = new JLabel("姓名");
		jl3 = new JLabel("性别");
		jl4 = new JLabel("年龄");
		jl5 = new JLabel("籍贯");
		jl6 = new JLabel("系别");
		
		jtf1 = new JTextField();
		//主键不能修改
		jtf1.setText((String) sm.getValueAt(rowNum, 0));
		jtf1.setEditable(false);
		jtf2 = new JTextField();
		jtf2.setText((String) sm.getValueAt(rowNum, 1));
		jtf3 = new JTextField();
		jtf3.setText((String) sm.getValueAt(rowNum, 2));
		jtf4 = new JTextField();
		jtf4.setText((String) sm.getValueAt(rowNum, 3));
		jtf5 = new JTextField();
		jtf5.setText((String) sm.getValueAt(rowNum, 4));
		jtf6 = new JTextField();
		jtf6.setText((String) sm.getValueAt(rowNum, 5));
		
		
		jb1 = new JButton("修改");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		//设置布局
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));
		
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		jp1.add(jl4);
		jp1.add(jl5);
		jp1.add(jl6);
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		jp2.add(jtf4);
		jp2.add(jtf5);
		jp2.add(jtf6);
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
	
		this.setSize(300, 250);
		this.setVisible(true);
		this.setIconImage((new ImageIcon("image/图标.jpg")).getImage());
     	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//写一个sql语句、
			String strsql = "update stu set stuname=?,"
					+ "stusex=?,stuage=?,stujg=?,studept=? where stuId=?";
			String p[]={jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText(),jtf1.getText()};
			
			StuModel t=new StuModel();
			t.updateStu(strsql, p);
			this.dispose();
		}
		else if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
}

