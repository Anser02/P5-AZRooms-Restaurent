package receptionn;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.CreateConnection;

public class Receptionn_Loginn extends CreateConnection
{
	Connection c;
	String inpu,ui,pp,qry; 
	Scanner obb=new Scanner(System.in);
	boolean found=false;
	
	public void Recep_Login() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		while(true)
		{
		System.out.println("Enter User-Id:");
		ui=obb.nextLine();
		System.out.println("Enter Password:");
		pp=obb.nextLine();
		qry="select *from Recep_login;";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			if(ui.equals(rs.getString(1))&&pp.equals(rs.getString(2)))
			{
				found=true;
				System.out.println();
				System.out.println("---------------------------------");
				System.out.println("   *** Login Succssfully ***   ");
				System.out.println("---------------------------------");
				System.out.println();
			
		while(true)
		{
			System.out.println();
		System.out.println("   ***   Press '1'  -  Available Rooms     ***   ");
		System.out.println("   ***   Press '2'  -  Room Booking        ***   ");
		System.out.println("   ***   Press '3'  -  Customer Info       ***   ");
		System.out.println("   ***   Press '4'  -  CheckOut Entry      ***   ");
		System.out.println("   ***   Press '5'  -  Logout              ***   ");
		inpu=obb.nextLine();
		AvailableRooms a=new AvailableRooms();
		CustomerDetails c=new CustomerDetails();
		RoomBooking r=new RoomBooking();
		RoomVacateEntry rv=new RoomVacateEntry();
		switch(inpu)
		{
		case "1":
			a.AllAvailableRoom();
			break;
			
		case "2":
			r.Room_Booking();
			break;
			
		case "3":
			c.CustomerInfo();
			break;
		case "4":
			rv.Room_VacateEntry();
			break;
		case "5":
			System.out.println();
			System.out.println("---------------------------------");
			System.out.println("   *** Logout Successfull ***   ");
			System.out.println("---------------------------------");
			System.exit(0);
			break;		
			default : System.out.println("*** Invalid Input ***");
			
		}
	}
	}
		}
		if(!found)
		{
		System.out.println();
		System.out.println("         *** Invalid login ***   ");
		System.out.println();
		System.out.println(" *** Enter Correct Userid & Password *** ");
		System.out.println();
		}
		}
	}
}
