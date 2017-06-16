/**
 * �����ݿ��������
 */

package sims2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Sqlaide {
	PreparedStatement ps=null;
	Connection ct=null;
	ResultSet rs=null;
	
	String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	String url="jdbc:sqlserver://localhost:1433;databaseName=MIMS";
	String user="sa";
	String password="123456";
	
	//�ر����ݿ���Դ����
	public void close()
	{

		try {
			if(rs!=null)rs.close();
			if(ps!=null)ps.close();
			if(ct!=null)ct.close();
		} catch (Exception e2) {
			// TODO: handle exception
			e2.printStackTrace();
		}
	
	}
	//д��һ������Ҫע���ѯ�����ķ���
	public ResultSet queryExectue(String sql)
	{
		try {
			//1.��������
			Class.forName(driver);
			//2.�������ݿ�
			ct=DriverManager.getConnection(url,user,password);
			//3.����ps
			ps=ct.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
		return rs;
	}
	
	//��ѯ���ݿ�Ĳ���
	public ResultSet queryExectue(String sql,String p[])
	{
		try {
			//1.��������
			Class.forName(driver);
			//2.�������ݿ�
			ct=DriverManager.getConnection(url,user,password);
			//3.����ps
			ps=ct.prepareStatement(sql);
			//��ps�ģ���ֵ
			for(int i=0;i<p.length;i++)
			{
				ps.setString(i+1, p[i]);
			}
			
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
		return rs;
	}
	
	//�����ݿ������ɾ���ĺϲ�
	public boolean upDate(String sql,String p[])
	{
		boolean b=true;
		try {
			//1.��������
			Class.forName(driver);
			//2.�������ݿ�
			ct=DriverManager.getConnection(url,user,password);
			//3.����ps
			ps=ct.prepareStatement(sql);
			//��ps�ģ���ֵ
			for(int i=0;i<p.length;i++)
			{
				ps.setString(i+1, p[i]);
			}
			//4.ִ�в���
			if(ps.executeUpdate()!=1)
			{
				b=false;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			this.close();
		}
		
		return b;
	
	}
}
