package sims2;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class SC_Model extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
		//rowData用来存放数据，columnNames用来存放列名
		Vector rowData,columnNames;
		//在model操作数据库
	
		//查询的本质是初始化
		public void querySC(String sql,String p[])
		{
			Sqlaide sqla=null;
			
			columnNames=new Vector();
			//设置列名
			columnNames.add("学号");
			columnNames.add("课程号");
			columnNames.add("成绩");
			
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
