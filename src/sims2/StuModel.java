/**
 * stu表的模型model2模式
 */
package sims2;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.*;

public class StuModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	
	//rowData用来存放数据，columnNames用来存放列名
	Vector rowData,columnNames;
	//在model操作数据库
	//添加学生(增，删，改)
	public boolean updateStu(String sql,String p[])
	{
		//创建一个sql(非并发)
		Sqlaide sqla=new Sqlaide();
		return sqla.upDate(sql, p); 
	}
	//查询的本质是初始化
	public void queryStu(String sql,String p[])
	{
		Sqlaide sqla=null;
		
		columnNames=new Vector();
		//设置列名
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("性别");
		columnNames.add("年龄");
		columnNames.add("籍贯");
		columnNames.add("系别");
		
		rowData=new Vector();
		
		try {
			
			sqla=new Sqlaide();
			ResultSet rs=sqla.queryExectue(sql,p);
			
			while(rs.next())
			{
				//rowData可以存放多行
				Vector row=new Vector();
				row.add(rs.getString(1));
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
				//加到rowData
				rowData.add(row);
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			sqla.close();
		}
		
	}
		
	//得到数据库的数据需用到以下函数
	//得到共有多少行
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.rowData.size();
	}

	//得到共有多少列
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}
	//得到某行某列的数据
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}
	
}
