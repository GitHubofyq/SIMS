package sims2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Stucourse extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	JPanel jp1,jp2;
	JButton jb1,jb2,jb3;
	JTable jta;
	JScrollPane jsp;
	
	CourseModel cm;
	
	public Stucourse(){
		jp1 = new JPanel();
//		jp2 = new JPanel();
		
//		jb1 = new JButton("��ѯ�γ�");
//		jb1.addActionListener(this);
		
		jb2 = new JButton("�޸Ŀγ�");
		jb2.addActionListener(this);
		
		jb3 = new JButton("����");
		jb3.addActionListener(this);
		
		jta = new JTable();
		
		cm = new CourseModel();
		String p[]={"1"};
		cm.queryCourse("select * from course where 1=?", p);
		
		//��ʼ��JTable
		jta=new JTable(cm);
		
		//��ʼ��jsp��JScrollPane
		jsp=new JScrollPane(jta);
		
//		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		
		
		//JSP���뵽JFrame
		this.add(jsp);
		
		this.add(jp1,"North");
//		this.add(jp2);
		
		this.setSize(400, 300);
		this.setIconImage((new ImageIcon("image/ͼ��.jpg")).getImage());
		this.setTitle("�γ̹���");
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Stucourse sc = new Stucourse();

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==jb2)
		{
//			System.out.println("�޸Ŀγ�");
			//������Ϣ
			int rowNum = this.jta.getSelectedRow();
			//�û�û��ѡ���У�����-1
			if(rowNum==-1)
			{
				//��ʾ�û�Ӧ��ѡ��һ��
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵĶ���");
				return;
			}
			
			//��ʾ�޸ĶԻ���
			new CourseupdaDialog(this,"�޸Ŀγ���Ϣ",true,cm,rowNum);
			cm=new CourseModel();
			String p1[]={"1"};
			cm.queryCourse("select *from course where 1=?", p1);
			//����JTable
			jta.setModel(cm);
		}
		else if(e.getSource()==jb3)
		{
			this.dispose();
		}
		
	}

}
