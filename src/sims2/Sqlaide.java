/**
 * 对数据库操作的类
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
	
	//关闭数据库资源函数
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
	//写了一个不需要注入查询条件的方法
	public ResultSet queryExectue(String sql)
	{
		try {
			//1.加载驱动
			Class.forName(driver);
			//2.连接数据库
			ct=DriverManager.getConnection(url,user,password);
			//3.创建ps
			ps=ct.prepareStatement(sql);
			
			rs=ps.executeQuery();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			
		}
		return rs;
	}
	
	//查询数据库的操作
	public ResultSet queryExectue(String sql,String p[])
	{
		try {
			//1.加载驱动
			Class.forName(driver);
			//2.连接数据库
			ct=DriverManager.getConnection(url,user,password);
			//3.创建ps
			ps=ct.prepareStatement(sql);
			//给ps的？赋值
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
	
	//对数据库的增、删、改合并
	public boolean upDate(String sql,String p[])
	{
		boolean b=true;
		try {
			//1.加载驱动
			Class.forName(driver);
			//2.连接数据库
			ct=DriverManager.getConnection(url,user,password);
			//3.创建ps
			ps=ct.prepareStatement(sql);
			//给ps的？赋值
			for(int i=0;i<p.length;i++)
			{
				ps.setString(i+1, p[i]);
			}
			//4.执行操作
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
