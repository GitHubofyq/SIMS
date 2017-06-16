package sims2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class StuManager extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StuManager si3=new StuManager();
	}
	
	//用到的控件
	JPanel jp1,jp2;
	JTextField jtf;
	JLabel jl;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jt;
	JScrollPane jsp;
	
	StuModel sm;

	//构造函数初始化各个控件
	public StuManager()
	{
		jp1=new JPanel();//默认是broderlayout的
		jl=new JLabel("请输入学生姓名");
		jtf=new JTextField(10);
		jb1=new JButton("查询");
		//注册监听
		jb1.addActionListener(this);
//		jb1.setActionCommand();
		
		
		//将各个控件加入到jp1
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		
		jb2=new JButton("添加");
		jb2.addActionListener(this);
		jb3=new JButton("修改");
		jb3.addActionListener(this);
		jb4=new JButton("删除");
		jb4.addActionListener(this);
		jb5=new JButton("返回");
		jb5.addActionListener(this);
		
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		

		//创建一个数据模型对象
		sm=new StuModel();
		String p[]={"1"};
		sm.queryStu("select * from stu where 1=?", p);
		
		//初始化JTable
		jt=new JTable(sm);
		
		//初始化jsp，JScrollPane
		jsp=new JScrollPane(jt);
		
		//JSP放入到JFrame
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		
		this.setIconImage((new ImageIcon("image/图标.jpg")).getImage());
		this.setTitle("学生信息管理系统");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLocationRelativeTo(null);//居中显示
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//判断是哪个按钮被点击
		if(e.getSource()==jb1)
		{
//			System.out.println("用户点击查询");
			
			//对数据库表的操作已经封装到stumodel中
			String name=this.jtf.getText().trim();
			//sql语句
			String sql="select * from stu where stuName=?";
			String p[]={name};
			//构建新的数据模型类并更新
			sm=new StuModel();
			sm.queryStu(sql, p);
			//更新JTable
			jt.setModel(sm);
			
		}
		//当用户点击添加
		
		else if(e.getSource()==jb2)
		{
			StuAddDialog sad=new StuAddDialog(this,"添加学生信息",true);

			//重新在获得新的数据模型
			//构建新的数据模型类并更新
			sm=new StuModel();
			String p1[]={"1"};
			sm.queryStu("select *from stu where 1=?", p1);
			//更新JTable
			jt.setModel(sm);
		}
		else if(e.getSource()==jb3)
		{
			//更改信息
			int rowNum = this.jt.getSelectedRow();
			//用户没有选择行，返回-1
			if(rowNum==-1)
			{
				//提示用户应该选中一行
				JOptionPane.showMessageDialog(this, "请选择要修改的对象");
				return;
			}
			
			//显示修改对话框
			new StuAlter(this,"修改学生信息",true,sm,rowNum);
			sm=new StuModel();
			String p1[]={"1"};
			sm.queryStu("select *from stu where 1=?", p1);
			//更新JTable
			jt.setModel(sm);
		}
		else if(e.getSource()==jb4)
		{
			//要删除记录，首先要明确学生学号,选中行row行
			int rowNum = this.jt.getSelectedRow();
			//用户没有选择行，返回-1
			if(rowNum==-1)
			{
				//提示用户应该选中一行
				JOptionPane.showMessageDialog(this, "请选择要删除的对象");
				return;
			}
			//没有上述情况，就可以得到学生编号
			String stuId=(String)sm.getValueAt(rowNum, 0);
//			System.out.println(stuId);
			//创建一个sql语句
			String sql="delete from stu where stuId=?";
			String p[]={stuId};
			StuModel t=new StuModel();
			t.updateStu(sql, p);
			//为了能立即观察到删除效果，要刷新JTable表
			sm=new StuModel();
			String p1[]={"1"};
			sm.queryStu("select *from stu where 1=?", p1);
			//更新JTable
			jt.setModel(sm);
		}
		else if(e.getSource()==jb5)
		{
			this.dispose();
		}
	}

}
