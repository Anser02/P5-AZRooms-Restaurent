package customer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import connection.CreateConnection;

public class Food_Menu extends CreateConnection
{
	Connection c;
	String qry;
	

	public void BreakfastMenu() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		qry="select *from BreakfastMenu;";
		rs=st.executeQuery(qry);
		System.out.println("********************************");
		System.out.println("  Food_Item          Amount");
		System.out.println("********************************");
		while(rs.next())
		{
			System.out.println(rs.getString(2)+" Rs."+rs.getString(3));
			System.out.println("--------------------------------");
		}
	}
	
	public void LunchMenu() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		qry="select *from LunchMenu;";
		rs=st.executeQuery(qry);
		System.out.println("********************************");
		System.out.println("  Food_Item             Amount");
		System.out.println("********************************");
		while(rs.next())
		{
			System.out.println(rs.getString(2)+"   Rs."+rs.getString(3));
			System.out.println("--------------------------------");

		}
	}
	
	public void DinnerMenu() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		qry="select *from DinnerMenu;";
		rs=st.executeQuery(qry);
		System.out.println("*********************************");
		System.out.println("  Food_Item             Amount");
		System.out.println("*********************************");
		while(rs.next())
		{
			System.out.println(rs.getString(2)+"   Rs."+rs.getString(3));
			System.out.println("---------------------------------");

		}
	}	
}
