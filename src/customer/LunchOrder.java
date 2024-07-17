package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.CreateConnection;

public class LunchOrder extends CreateConnection
{
	Connection c;
	String inpu,qry,rno;
	Scanner ob=new Scanner(System.in);
	Scanner obb=new Scanner(System.in);


	public void lunchorderr() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		PreparedStatement ps;
		int bn,i;
		System.out.println("Room No:");
		rno=obb.nextLine();
		qry="select *from Rooms where room_available='no';";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			if(rno.equals(rs.getString(1)))
			{
			System.out.println();
			System.out.println("-----------------------------------------");
			System.out.println("Room No                :"+rs.getString(1));
			System.out.println("Customer Name          :"+rs.getString(3));
			System.out.println("Mobile No              :"+rs.getString(4));
			System.out.println("-----------------------------------------");
			System.out.println();
			}
		}
		
		while(true)
		{
		System.out.println();
		System.out.println("          *** Lunch Menu ***");
		System.out.println();
		System.out.println("*** 1 - Chicken Briyani      Rs.100 ***");
		System.out.println("*** 2 - Mutton Briyani       Rs.200 ***");
		System.out.println("*** 3 - white-Rice           Rs.80  ***");
		System.out.println("*** 4 - Chicken 65 250g      Rs.100 ***");
		System.out.println("*** c - Complete the bill           ***");
		inpu=obb.nextLine();
		int qty;

		switch(inpu)
		{
		case "1":
			System.out.println("Qty:");
			qty=ob.nextInt();
			qry="insert into Rooms_food_Bill (Room_no,foodtime,Foodname,Price,Qty)values (?,'Lunch     ','Chicken Briyani          ',100,?);";
			ps=c.prepareStatement(qry);			
			ps.setString(1,rno );
			ps.setInt(2, qty);
			ps.executeUpdate();
			System.out.println("*** Food Added into Cart ***");
			System.out.println();
			break;
			
		case "2":
			System.out.println("Qty:");
			qty=ob.nextInt();
			qry="insert into Rooms_food_Bill (Room_no,foodtime,Foodname,Price,Qty)values (?,'Lunch     ','Mutton Briyani           ',200,?);";
			ps=c.prepareStatement(qry);
			ps.setString(1,rno );
			ps.setInt(2, qty);
			ps.executeUpdate();
			System.out.println("*** Food Added into Cart ***");
			System.out.println();
			break;
			
		case "3":
			System.out.println("Qty:");
			qty=ob.nextInt();
			qry="insert into Rooms_food_Bill (Room_no,foodtime,Foodname,Price,Qty)values (?,'Lunch     ','White-Rice               ',80,?);";
			ps=c.prepareStatement(qry);
			ps.setString(1,rno );
			ps.setInt(2, qty);
			ps.executeUpdate();
			System.out.println("*** Food Added into Cart ***");
			System.out.println();
			break;
			
		case "4":
			System.out.println("Qty:");
			qty=ob.nextInt();
			qry="insert into Rooms_food_Bill (Room_no,foodtime,Foodname,Price,Qty)values (?,'Lunch     ','Chicken65 250g           ',100,?);";
			ps=c.prepareStatement(qry);
			ps.setString(1,rno );
			ps.setInt(2, qty);
			ps.executeUpdate();
			System.out.println("*** Food Added into Cart ***");
			System.out.println();
			break;
		case "c":
			System.out.println();
			System.out.println("-------------------------------------------------------");
			System.out.println("            *** Your Order is Confirm ***");
			System.out.println("   *** Your Order will be Deliver in 15-minutes ***   ");
			System.out.println("-------------------------------------------------------");
			System.exit(0);
			break;
			default: System.out.println("*** Invalid Input ***");
	}
}
}
}