package receptionn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.CreateConnection;

public class CustomerDetails extends CreateConnection
{
	String qry;
	Connection c;
	
	public void CustomerInfo() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		qry="select *from Rooms where room_available='no';";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			System.out.println();
			System.out.println("------------------------------------------------");
			System.out.println("Room No                : "+rs.getString(1));
			System.out.println("Customer Name          : "+rs.getString(3));
			System.out.println("Mobile No              : "+rs.getString(4));
			System.out.println("Address                : "+rs.getString(5));
			System.out.println("Id proof No            : "+rs.getString(6));
			System.out.println("Check-In Time          : "+rs.getString(7));
			System.out.println("------------------------------------------------");
		}	
	}
}
