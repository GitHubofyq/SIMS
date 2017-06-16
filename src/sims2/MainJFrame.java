package sims2;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class MainJFrame extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	JButton jb1,jb2,jb3;
	
	public MainJFrame()
	{

		jb1 = new JButton("学生信息管理");
		jb1.addActionListener(this);
		
		jb2 = new JButton("课程管理");
		jb2.addActionListener(this);
		
		jb3 = new JButton("学生成绩管理");
		jb3.addActionListener(this);

		 //水平间隔0，垂直间隔40
		this.setLayout(new GridLayout(3,3,0,40));
		//边缘空30,80,30,80
		((JComponent) this.getContentPane()).setBorder(BorderFactory.createEmptyBorder(30,80,30,80));
		this.add(jb1);
		this.add(jb2);
		this.add(jb3);
		
		this.setIconImage((new ImageIcon("image/图标.jpg")).getImage());
		this.setTitle("学生信息管理系统");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLocationRelativeTo(null);//居中显示
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			StuManager stum = new StuManager();
		}
		else if(e.getSource()==jb2)
		{
			Stucourse stuc = new Stucourse();
		}
		else if(e.getSource()==jb3)
		{
			StuCgrade sc = new StuCgrade();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainJFrame mjf = new MainJFrame();
	}

}
