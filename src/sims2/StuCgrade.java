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
		
		jl = new JLabel("������ѧ��");
		jtf = new JTextField(10);
		
		jb1 = new JButton("��ѯ");
		jb1.addActionListener(this);
		
		jt = new JTable();
		jsp = new JScrollPane();
		
		jp1.add(jl);
		jp1.add(jtf);
		jp1.add(jb1);
		
		jp2 = new JPanel();
		
		jb2 = new JButton("�޸�");
		jb2.addActionListener(this);
		
		jb3 = new JButton("����");
		jb3.addActionListener(this);
		
		jp2.add(jb2);
		jp2.add(jb3);
		
		//����һ������ģ�Ͷ���
		sc=new SC_Model();
		String p[]={"1"};
		sc.querySC("select * from SC where 1=?", p);
		
		//��ʼ��JTable
		jt=new JTable(sc);
		
		//��ʼ��jsp��JScrollPane
		jsp=new JScrollPane(jt);
		
		this.add(jsp);
		this.add(jp1,"North");
		this.add(jp2,"South");
		
		this.setIconImage((new ImageIcon("image/ͼ��.jpg")).getImage());
		this.setTitle("ѧ���ɼ�����");
		this.setSize(300,340);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);	
		this.setLocationRelativeTo(null);//������ʾ
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//�����ݿ��Ĳ����Ѿ���װ��stumodel��
			String sno=this.jtf.getText().trim();
			//sql���
			String sql="select * from SC where Sno=?";
			String p[]={sno};
			//�����µ�����ģ���ಢ����
			sc=new SC_Model();
			sc.querySC(sql, p);
			//����JTable
			jt.setModel(sc);
		}
		else if(e.getSource()==jb2)
		{

//			System.out.println("�޸Ŀγ�");
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
			new SC_Ater(this,"�޸�ѧ���ɼ�",true, sc, rowNum);
			sc=new SC_Model();
			String p1[]={"1"};
			sc.querySC("select *from sc where 1=?", p1);
			//����JTable
			jt.setModel(sc);
		}
		else if(e.getSource()==jb3)
		{
			this.dispose();
		}
	}

}
