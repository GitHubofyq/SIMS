package sims2;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class CourseModel  extends AbstractTableModel{

	private static final long serialVersionUID = 1L;
	Vector rowData,columnNames;
	
	public void queryCourse(String sql,String p[])
	{
		Sqlaide sqla=null;
		
		columnNames=new Vector();
		//设置列名
		columnNames.add("课程号");
		columnNames.add("课程名");
		columnNames.add("先行课程");
		columnNames.add("学分");
		
		rowData=new Vector();
		
		try {
			
			sqla=new Sqlaide();
			ResultSet rs=sqla.queryExectue(sql,p);
			
			while(rs.next())
			{
				//rowData可以存放多行
				Vector row=new Vector();
				row.add(rs.getInt(1)+"");
				row.add(rs.getString(2));
				row.add(rs.getString(3));
				row.add(rs.getString(4));
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
