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
	
	//�õ��Ŀؼ�
	JPanel jp1,jp2;
	JTextField jtf;
	JLabel jl;
	JButton jb1,jb2,jb3,jb4,jb5;
	JTable jt;
	JScrollPane jsp;
	
	StuModel sm;

	//���캯����ʼ�������ؼ�
	public StuManager()
	{
		jp1=new JPanel();//Ĭ����broderlayout��
		jl=new JLabel("������ѧ������");
		jtf=new JTextField(10);
		jb1=new JButton("��ѯ");
		//ע�����
		jb1.addActionListener(this);
//		jb1.setActionCommand();
		
		
		//�������ؼ����뵽jp1
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2=new JPanel();
		
		jb2=new JButton("���");
		jb2.addActionListener(this);
		jb3=new JButton("�޸�");
		jb3.addActionListener(this);
		jb4=new JButton("ɾ��");
		jb4.addActionListener(this);
		jb5=new JButton("����");
		jb5.addActionListener(this);
		
		jp2.add(jb2);
		jp2.add(jb3);
		jp2.add(jb4);
		jp2.add(jb5);
		

		//����һ������ģ�Ͷ���
		sm=new StuModel();
		String p[]={"1"};
		sm.queryStu("select * from stu where 1=?", p);
		
		//��ʼ��JTable
		jt=new JTable(sm);
		
		//��ʼ��jsp��JScrollPane
		jsp=new JScrollPane(jt);
		
		//JSP���뵽JFrame
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		
		this.setIconImage((new ImageIcon("image/ͼ��.jpg")).getImage());
		this.setTitle("ѧ����Ϣ����ϵͳ");
		this.setSize(400,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLocationRelativeTo(null);//������ʾ
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//�ж����ĸ���ť�����
		if(e.getSource()==jb1)
		{
//			System.out.println("�û������ѯ");
			
			//�����ݿ��Ĳ����Ѿ���װ��stumodel��
			String name=this.jtf.getText().trim();
			//sql���
			String sql="select * from stu where stuName=?";
			String p[]={name};
			//�����µ�����ģ���ಢ����
			sm=new StuModel();
			sm.queryStu(sql, p);
			//����JTable
			jt.setModel(sm);
			
		}
		//���û�������
		
		else if(e.getSource()==jb2)
		{
			StuAddDialog sad=new StuAddDialog(this,"���ѧ����Ϣ",true);

			//�����ڻ���µ�����ģ��
			//�����µ�����ģ���ಢ����
			sm=new StuModel();
			String p1[]={"1"};
			sm.queryStu("select *from stu where 1=?", p1);
			//����JTable
			jt.setModel(sm);
		}
		else if(e.getSource()==jb3)
		{
			//������Ϣ
			int rowNum = this.jt.getSelectedRow();
			//�û�û��ѡ���У�����-1
			if(rowNum==-1)
			{
				//��ʾ�û�Ӧ��ѡ��һ��
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫ�޸ĵĶ���");
				return;
			}
			
			//��ʾ�޸ĶԻ���
			new StuAlter(this,"�޸�ѧ����Ϣ",true,sm,rowNum);
			sm=new StuModel();
			String p1[]={"1"};
			sm.queryStu("select *from stu where 1=?", p1);
			//����JTable
			jt.setModel(sm);
		}
		else if(e.getSource()==jb4)
		{
			//Ҫɾ����¼������Ҫ��ȷѧ��ѧ��,ѡ����row��
			int rowNum = this.jt.getSelectedRow();
			//�û�û��ѡ���У�����-1
			if(rowNum==-1)
			{
				//��ʾ�û�Ӧ��ѡ��һ��
				JOptionPane.showMessageDialog(this, "��ѡ��Ҫɾ���Ķ���");
				return;
			}
			//û������������Ϳ��Եõ�ѧ�����
			String stuId=(String)sm.getValueAt(rowNum, 0);
//			System.out.println(stuId);
			//����һ��sql���
			String sql="delete from stu where stuId=?";
			String p[]={stuId};
			StuModel t=new StuModel();
			t.updateStu(sql, p);
			//Ϊ���������۲쵽ɾ��Ч����Ҫˢ��JTable��
			sm=new StuModel();
			String p1[]={"1"};
			sm.queryStu("select *from stu where 1=?", p1);
			//����JTable
			jt.setModel(sm);
		}
		else if(e.getSource()==jb5)
		{
			this.dispose();
		}
	}

}
