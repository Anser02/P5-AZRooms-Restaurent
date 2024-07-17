package receptionn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.CreateConnection;

public class RoomBooking extends CreateConnection
{
	Connection c;
	String qry,rno,name,add,mo,p,ct;
	Scanner obb=new Scanner(System.in);
	Scanner ob=new Scanner(System.in);
	AvailableRooms a=new AvailableRooms();

	
	public void Room_Booking() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		PreparedStatement ps;
		System.out.println();
		a.AllAvailableRoom();
		System.out.println("Enter Room_No:");
		rno=obb.nextLine();
		System.out.println("Enter Customer_Name:");
		name=obb.nextLine();
		System.out.println("Enter Mobile_No:");
		mo=obb.nextLine();
		System.out.println("Enter Address:");
		add=obb.nextLine();
		System.out.println("Enter Id_Proof_No:");
		p=obb.nextLine();
		System.out.println("Enter Check_In_Time:");
		ct=obb.nextLine();
		qry="Update Rooms set Customer_Name=?,Contact_No=?,Address=?,Id_Proof_No=?,Check_in_Time=?,room_available='no' where Room_No=?;";
		ps=c.prepareStatement(qry);
		ps.setString(1,name);
		ps.setString(2, mo);
		ps.setString(3, add);
		ps.setString(4, p);
		ps.setString(5, ct);
		ps.setString(6, rno);
		ps.executeUpdate();
		System.out.println();
		System.out.println("-----------------------------");
		System.out.println(" *** Booking Confirmed ***");	
		System.out.println("-----------------------------");
	}

}
