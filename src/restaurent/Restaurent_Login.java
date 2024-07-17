package restaurent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.CreateConnection;

public class Restaurent_Login extends CreateConnection
{
	String inpu,qry,ui,pp;
	boolean found=false;
	Scanner obb=new Scanner(System.in);
	Connection c;
	
	public void Restaurent_login() throws SQLException
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
		qry="select *from Res_Bill_login;";
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
				
				
		System.out.println("*** 1 - Breakfast Billing Entry ***");
		System.out.println("*** 2 - Lunch Billing Entry     ***");
		System.out.println("*** 3 - Dinner Billing Entry    ***");
		inpu=obb.nextLine();
		Breakfast_Restaurent_Bill b=new Breakfast_Restaurent_Bill();
		Lunch_Restaurent_Bill l=new Lunch_Restaurent_Bill();
		Dinner_Restaurent_Bill d=new Dinner_Restaurent_Bill();
		switch(inpu)
		{
		case "1":
			b.Breakfast_Bill_Entry();
			break;
		case "2":
			l.Res_General_Lunch_bill();
			break;
		case "3":
			d.Dinner_Res_Bill_Entry();
			break;
			default: System.out.println("*** Invalid Input ***");

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
