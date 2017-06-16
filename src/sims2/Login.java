package sims2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;



public class Login extends JFrame implements ActionListener,KeyListener{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Login login = new Login();
	}
	
	JLabel jl1,jl2,jp1_jl,jp2_jl;
	JPanel jp1,jp2,jp3;
	JTextField username;
	JPasswordField password;
	JButton b1,b2;	
	
	//���췽��
	public Login()
	{
		this.setLayout(new GridLayout(4,1));
		//ͼƬ��
		jl1 = new JLabel(new ImageIcon("image/��¼��ǩ.jpg"));
		jl1.setSize(389, 70);
		
		//��¼��
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		
		jp1_jl = new JLabel("����Ա");
		jp2_jl = new JLabel("��    ��");
		
		username = new JTextField(10);
		password = new JPasswordField(10);
		
		b1 = new JButton("��¼");
		b1.addActionListener(this);
		getRootPane().setDefaultButton(b1);/*���ﰴ Enter ����Ĭ�ϴ������� b1 ��ť��һ�� RootPane ��ֻ������һ�� default button��
											�ῴ�������ť����һȦ�����������*/
		b2 = new JButton("����");
		b2.addActionListener(this);
		
		jp1.add(jp1_jl);
		jp1.add(username);
		jp2.add(jp2_jl);
		jp2.add(password);
		jp3.add(b1);
		jp3.add(b2);
		
		
//		this.addKeyListener(this);//ע����̼���
		this.add(jl1);
		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
//		this.requestFocus();//���»�ȡ����
		
		this.setTitle("��¼����");
		this.setSize(400,300);
		this.setIconImage((new ImageIcon("image/ͼ��.jpg")).getImage());
		this.setResizable(false);//�����С���ܸı�
		this.setLocationRelativeTo(null);//������ʾ
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1)
		{
//			System.out.println(username.getText()+","+password.getPassword());
			if(username.getText().equals("admin") && password.getText().equals("123456"))
			{
				MainJFrame main=new MainJFrame();
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "��¼ʧ��");
			}
//			
		}
		else if(e.getSource()==b2)
		{
			username.setText(null);
			password.setText(null);
		}
	}
	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("key Press:" + e.getKeyCode() + " " + (e.getKeyCode()==KeyEvent.VK_ENTER));
		if(e.getKeyCode()==KeyEvent.VK_ENTER)
		{
			if(username.getText().equals("admin") && password.getText().equals("123456"))
			{
				MainJFrame main=new MainJFrame();
				this.dispose();
			}
			else{
				JOptionPane.showMessageDialog(null, "��¼ʧ��");
			}
		}
	}

	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
