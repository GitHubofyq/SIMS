package sims2;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

public class SC_Model extends AbstractTableModel{
	
	private static final long serialVersionUID = 1L;
		//rowData����������ݣ�columnNames�����������
		Vector rowData,columnNames;
		//��model�������ݿ�
	
		//��ѯ�ı����ǳ�ʼ��
		public void querySC(String sql,String p[])
		{
			Sqlaide sqla=null;
			
			columnNames=new Vector();
			//��������
			columnNames.add("ѧ��");
			columnNames.add("�γ̺�");
			columnNames.add("�ɼ�");
			
			rowData=new Vector();
			
			try {
				
				sqla=new Sqlaide();
				ResultSet rs=sqla.queryExectue(sql,p);
				
				while(rs.next())
				{
					//rowData���Դ�Ŷ���
					Vector row=new Vector();
					row.add(rs.getString(1));
					row.add(rs.getString(2));
					row.add(rs.getString(3));
					//�ӵ�rowData
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

	//�õ����ж�����
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.size();
	}
	//�õ�ĳ��ĳ�е�����
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
	}

	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return (String)this.columnNames.get(column);
	}
	

}