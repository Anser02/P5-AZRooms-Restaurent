package customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.Scanner;

import connection.CreateConnection;

public class BreakfastOrder extends CreateConnection
{
	Connection c;
	String inpu,qry,rno;
	Scanner ob=new Scanner(System.in);
	Scanner obb=new Scanner(System.in);

	public void Breakfastorder() throws SQLException
	{
		c=getConnection();
		PreparedStatement ps;
		Statement st=c.createStatement();
		ResultSet rs;
		
		System.out.println("Enter Your Room No:");
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
		System.out.println("      *** Breakfast Menu ***");
		System.out.println();
		System.out.println("*** 1 - Idli 4-Pieces      Rs.40 ***");
		System.out.println("*** 2 - Poori 2-Pieces     Rs.40 ***");
		System.out.println("*** 3 - Vada 1-Pieces      Rs.10 ***");
		System.out.println("*** 4 - Pongal             Rs.50 ***");
		System.out.println("*** c - Complete the Order       ***");
		System.out.println();
		inpu=obb.nextLine();
		int qty;

		switch(inpu)
		{
		case "1":
			System.out.println("Qty:");
			qty=ob.nextInt();
			qry="insert into Rooms_Food_Bill (Room_no,foodtime,Foodname,Price,Qty)values (?,'Breakfast ','Idli                      ',40,?);";
			ps=c.prepareStatement(qry);
			ps.setString(1, rno);
			ps.setInt(2, qty);
			ps.executeUpdate();
			System.out.println("*** Food Added into Cart ***");
			System.out.println();
			break;
			
		case "2":
			System.out.println("Qty:");
			qty=ob.nextInt();
			qry="insert into Rooms_Food_Bill (Room_no,foodtime,Foodname,Price,Qty)values (?,'Breakfast ','poori                     ',40,?);";
			ps=c.prepareStatement(qry);
			ps.setString(1, rno);
			ps.setInt(2, qty);
			ps.executeUpdate();
			System.out.println("*** Food Added into Cart ***");
			System.out.println();
			break;
			
		case "3":
			System.out.println("Qty:");
			qty=ob.nextInt();
			qry="insert into Rooms_Food_Bill (Room_no,foodtime,Foodname,Price,Qty)values (?,'Breakfast ','vada                      ',10,?);";
			ps=c.prepareStatement(qry);
			ps.setString(1, rno);
			ps.setInt(2, qty);
			ps.executeUpdate();
			System.out.println("*** Food Added into Cart ***");
			System.out.println();
			break;
			
		case "4":
			System.out.println("Qty:");
			qty=ob.nextInt();
			qry="insert into Rooms_Food_Bill (Room_no,foodtime,Foodname,Price,Qty)values (?,'Breakfast ','pongal                    ',50,?);";
			ps=c.prepareStatement(qry);
			ps.setString(1, rno);

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
