/**
 * stu���ģ��model2ģʽ
 */
package sims2;

import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.table.*;

public class StuModel extends AbstractTableModel{

	private static final long serialVersionUID = 1L;

	
	//rowData����������ݣ�columnNames�����������
	Vector rowData,columnNames;
	//��model�������ݿ�
	//���ѧ��(����ɾ����)
	public boolean updateStu(String sql,String p[])
	{
		//����һ��sql(�ǲ���)
		Sqlaide sqla=new Sqlaide();
		return sqla.upDate(sql, p); 
	}
	//��ѯ�ı����ǳ�ʼ��
	public void queryStu(String sql,String p[])
	{
		Sqlaide sqla=null;
		
		columnNames=new Vector();
		//��������
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("�Ա�");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("ϵ��");
		
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
				row.add(rs.getString(4));
				row.add(rs.getString(5));
				row.add(rs.getString(6));
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
		
	//�õ����ݿ���������õ����º���
	//�õ����ж�����
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
