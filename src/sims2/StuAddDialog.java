/**
 * ���
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StuAddDialog extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	//������Ҫ�����
	JLabel jl1,jl2,jl3,jl4,jl5,jl6;
	JButton jb1,jb2;
	JTextField jtf1,jtf2,jtf3,jtf4,jtf5,jtf6;
	JPanel jp1,jp2,jp3;
	
	//���캯����owner�����ڣ�title���ڱ��⣬modalָ���Ƿ�ģʽ����
	public StuAddDialog(Frame owner,String title,boolean modal)
	{
		super(owner,title,modal);//���ø��๹�췽�����ﵽģʽ�Ի���Ч��
		jl1 = new JLabel("ѧ��");
		jl2 = new JLabel("����");
		jl3 = new JLabel("�Ա�");
		jl4 = new JLabel("����");
		jl5 = new JLabel("����");
		jl6 = new JLabel("ϵ��");
		
		jtf1 = new JTextField();
		jtf2 = new JTextField();
		jtf3 = new JTextField();
		jtf4 = new JTextField();
		jtf5 = new JTextField();
		jtf6 = new JTextField();
		
		jb1 = new JButton("���");
		jb1.addActionListener(this);
		jb2 = new JButton("ȡ��");
		jb2.addActionListener(this);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		//���ò���
		jp1.setLayout(new GridLayout(6,1));
		jp2.setLayout(new GridLayout(6,1));

		//������
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
		this.setIconImage((new ImageIcon("image/ͼ��.jpg")).getImage());
     	
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1)
		{
			//����û���Ϣ
			StuModel t=new StuModel();
			String sql="insert into stu values(?,?,?,?,?,?)";
			String p[]={jtf1.getText(),jtf2.getText(),jtf3.getText(),jtf4.getText(),jtf5.getText(),jtf6.getText()};
			if(!t.updateStu(sql,p))
			{
				JOptionPane.showMessageDialog(this, "���ʧ��");
			}
			//�ر���ӶԻ���
			this.dispose();
		}
		else if(e.getSource()==jb2)
		{
			this.dispose();
		}
	}
}
