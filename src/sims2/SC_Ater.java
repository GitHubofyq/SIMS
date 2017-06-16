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

public class SC_Ater extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	JLabel jl1,jl2,jl3;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3;
	JPanel jp1,jp2,jp3;
	
	public SC_Ater(Frame owner,String title,boolean modal,SC_Model sc,int rowNum)
	{
		super(owner,title,modal);//调用父类构造方法，达到模式对话框效果
		jl1 = new JLabel("学号");
		jl2 = new JLabel("课程号");
		jl3 = new JLabel("成绩");
		
		
		jtf1 = new JTextField();
		//主键不能修改
		jtf1.setText((String) sc.getValueAt(rowNum, 0));
		jtf1.setEditable(false);
		jtf2 = new JTextField();
		jtf2.setText((String) sc.getValueAt(rowNum, 1));
		jtf3 = new JTextField();
		jtf3.setText((String) sc.getValueAt(rowNum, 2));
		
		
		jb1 = new JButton("修改");
		jb1.addActionListener(this);
		jb2 = new JButton("取消");
		jb2.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		//设置布局
		jp1.setLayout(new GridLayout(3,1));
		jp2.setLayout(new GridLayout(3,1));
		
		
		//添加组件
		jp1.add(jl1);
		jp1.add(jl2);
		jp1.add(jl3);
		
		
		jp2.add(jtf1);
		jp2.add(jtf2);
		jp2.add(jtf3);
		
		
		jp3.add(jb1);
		jp3.add(jb2);
		
		this.add(jp1,BorderLayout.WEST);
		this.add(jp2,BorderLayout.CENTER);
		this.add(jp3,BorderLayout.SOUTH);
	
		this.setSize(200, 250);
		this.setVisible(true);
		this.setIconImage((new ImageIcon("image/图标.jpg")).getImage());
     	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//写一个sql语句、
			String strsql = "update SC set Cno=?,Cgrade=? where Sno=?";
			String p[]={jtf2.getText(),jtf3.getText(),jtf1.getText()};
			
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
