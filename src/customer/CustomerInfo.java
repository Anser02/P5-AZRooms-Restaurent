package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.CreateConnection;

public class CustomerInfo extends CreateConnection
{
	Connection c;
	String qry;
	
	public void CustoIngo() throws SQLException
	{	
			c=getConnection();
			Statement st=c.createStatement();
			ResultSet rs;
			qry="select *from Rooms where room_available='no';";
			rs=st.executeQuery(qry);
			while(rs.next())
			{
				System.out.println();
				System.out.println("======================================");
				System.out.println("Room No                :"+rs.getString(1));
				System.out.println("Customer Name          :"+rs.getString(3));
				System.out.println("Mobile No              :"+rs.getString(4));
				//System.out.println("Address                :"+rs.getString(5));
				//System.out.println("Id prrof No            :"+rs.getString(6));
				//System.out.println("Check-In Time          :"+rs.getString(7));
				System.out.println();
				System.out.println("======================================");
				System.out.println();
				//System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
			}	
		}
	}
