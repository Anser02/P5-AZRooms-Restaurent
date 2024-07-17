package receptionn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.CreateConnection;

public class AvailableRooms extends CreateConnection
{
	String qry;
	Connection c;

	public void AllAvailableRoom() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		qry="select Room_No,Room_Type from Rooms where Customer_Name='';";
		rs=st.executeQuery(qry);
		System.out.println("********************************");
		System.out.println("  Room_No        Room_Type");
		System.out.println("********************************");
		while(rs.next())
		{
			System.out.println("---------------------------------");
			System.out.println("    "+rs.getString(1)+"         "+rs.getString(2));
			System.out.println("---------------------------------");

		}
		System.out.println();
	}
}
