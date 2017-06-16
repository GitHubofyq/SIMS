package sims2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class StuCgrade extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JPanel jp1,jp2;
	JLabel jl;
	JTextField jtf;
	JButton jb1,jb2,jb3;
	JTable jt;
	JScrollPane jsp;
	
	SC_Model sc;
	
	public StuCgrade(){
		
		jp1 = new JPanel();
		
		jl = new JLabel("请输入学号");
		jtf = new JTextField(10);
		
		jb1 = new JButton("查询");
		jb1.addActionListener(this);
		
		jt = new JTable();
		jsp = new JScrollPane();
		
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2 = new JPanel();
		
		jb2 = new JButton("修改");
		jb2.addActionListener(this);
		
		jb3 = new JButton("返回");
		jb3.addActionListener(this);
		
		jp2.add(jb2);
		jp2.add(jb3);
		
		//创建一个数据模型对象
		sc=new SC_Model();
		String p[]={"1"};
		sc.querySC("select * from SC where 1=?", p);
		
		//初始化JTable
		jt=new JTable(sc);
		
		//初始化jsp，JScrollPane
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		
		this.setIconImage((new ImageIcon("image/图标.jpg")).getImage());
		this.setTitle("学生成绩管理");
		this.setSize(300,340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLocationRelativeTo(null);//居中显示
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//对数据库表的操作已经封装到stumodel中
			String sno=this.jtf.getText().trim();
			//sql语句
			String sql="select * from SC where Sno=?";
			String p[]={sno};
			//构建新的数据模型类并更新
			sc=new SC_Model();
			sc.querySC(sql, p);
			//更新JTable
			jt.setModel(sc);
		}
		else if(e.getSource()==jb2)
		{

//			System.out.println("修改课程");
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
			new SC_Ater(this,"修改学生成绩",true, sc, rowNum);
			sc=new SC_Model();
			String p1[]={"1"};
			sc.querySC("select *from sc where 1=?", p1);
			//更新JTable
			jt.setModel(sc);
		}
		else if(e.getSource()==jb3)
		{
			this.dispose();
		}
	}

}
