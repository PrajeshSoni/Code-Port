import java.io.*;
import java.sql.*;
class studjdisp
{
	public static void main(String ar[])
	{
		Connection cn;
		Statement st;
		ResultSet rs;
		int no;
		String nm,ct,q;
		try
		{
			
			Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			cn=DriverManager.getConnection("jdbc:odbc:studdsn");
			st=cn.createStatement();//This will initialise the statement 
			q="select * from student";
			rs=st.executeQuery(q);
			System.out.println("No\tName\t\t\t\t\tCity");
			while(rs.next())
			{
				no=rs.getInt(1);
				nm=rs.getString(2);
				ct=rs.getString(3);
				System.out.println("Rno: "+no);
				System.out.println("Name: "+nm);
				System.out.println("City: "+ct);
				//System.out.println(no+"\t"+nm+"\t\t\t\t\t"+ct);

			}
			rs.close();
			st.close();
			cn.close();
		}
		catch(ClassNotFoundException ce)
		{
			System.out.println("Class not found: "+ce);
		}
		catch(SQLException se)
		{
			System.out.println("SQL ERROR: "+se);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}