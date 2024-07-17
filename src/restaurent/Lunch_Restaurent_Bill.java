package restaurent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.CreateConnection;

public class Lunch_Restaurent_Bill extends CreateConnection
{

	String qry,inpu;
	Connection c;
	Scanner ob=new Scanner(System.in);
	Scanner obb=new Scanner(System.in);

	public void Res_General_Lunch_bill() throws SQLException
	{
		
			c=getConnection();
			Statement st=c.createStatement();
			ResultSet rs;
			PreparedStatement ps;
			int bn,i;
			while(true)
			{
			System.out.println("Bill No:");
			bn=ob.nextInt();
			
			for(i=0;i<4;i++)
			{
				System.out.println();
			System.out.println("*** 1 - Chicken Briyani    Rs.100 ***");
			System.out.println("*** 2 - Mutton Briyani     Rs.200 ***");
			System.out.println("*** 3 - white-Rice         Rs.80  ***");
			System.out.println("*** 4 - Chicken 65 250g    Rs.100 ***");
			System.out.println("*** c - Complete the bill         ***");

			inpu=obb.nextLine();
			int qty;

			switch(inpu)
			{
			case "1":
				System.out.println("Qty:");
				qty=ob.nextInt();
				qry="insert into R_Lunch_Bill (billno,Foodname,Price,Qty)values (?,'Chicken Briyani       ',100,?);";
				ps=c.prepareStatement(qry);			
				ps.setInt(1,bn );
				ps.setInt(2, qty);
				ps.executeUpdate();
				System.out.println("*** Food Added into Cart ***");
				System.out.println();				break;
				
			case "2":
				System.out.println("Qty:");
				qty=ob.nextInt();
				qry="insert into R_Lunch_Bill (billno,Foodname,Price,Qty)values (?,'Mutton Briyani        ',200,?);";
				ps=c.prepareStatement(qry);
				ps.setInt(1,bn );
				ps.setInt(2, qty);
				ps.executeUpdate();
				System.out.println("*** Food Added into Cart ***");
				System.out.println();
				break;
				
			case "3":
				System.out.println("Qty:");
				qty=ob.nextInt();
				qry="insert into R_Lunch_Bill (billno,Foodname,Price,Qty)values (?,'White-Rice             ',80,?);";
				ps=c.prepareStatement(qry);
				ps.setInt(1,bn );
				ps.setInt(2, qty);
				ps.executeUpdate();
				System.out.println("*** Food Added into Cart ***");
				System.out.println();
				break;
				
			case "4":
				System.out.println("Qty:");
				qty=ob.nextInt();
				qry="insert into R_Lunch_Bill (billno,Foodname,Price,Qty)values (?,'Chicken65 250g        ',100,?);";
				ps=c.prepareStatement(qry);
				ps.setInt(1,bn );
				ps.setInt(2, qty);
				ps.executeUpdate();
				System.out.println("*** Food Added into Cart ***");
				System.out.println();
				break;
				
			case "c":
				int t=0;
				qry="select *from R_Lunch_Bill";
				rs=st.executeQuery(qry);
				System.out.println();
				System.out.println("	.................... AZ Rooms & Restaurent ..................");
				System.out.println("	#11, Tirupattur - Vellore Main Road, MC Road, Ambur-635802.");
				System.out.println();
				System.out.println("		                    Bill                        ");
				System.out.println();
				System.out.println("		=============================================");
				System.out.println("		Food Iteam           Price   Qty    Amount");
				System.out.println("		=============================================");
				System.out.println();
				while(rs.next())
				{
					if(bn==rs.getInt(1))
					{
					System.out.println("		"+rs.getString(2)+ ""+rs.getInt(3)+"     "+rs.getInt(4)+"      "+rs.getString(5));
					t=t+rs.getInt(5);
					}
					}
				System.out.println("		                     =======================");
				System.out.println("		                     Sub Amount: Rs. "+t);
				System.out.println("		                     =======================");
				System.out.println();
				float tt;
				float g1,g2;
				g1=t*2.5f/100;
				g2=t*2.5f/100;
				tt=t+g1+g2;
				System.out.println("	         	   	SGST   - 2.5%    Rs. "+g1);
				System.out.println("			        CGST   - 2.5%    Rs. "+g2);
				System.out.println("		                 ===========================");
				System.out.println("		                   Total Amount: Rs. "+tt);
				System.out.println("		                 ===========================");
				System.out.println("		                 ");
				System.out.println();
				System.out.println("		     *** THANKS FOR YOUR VISITING ***          ");
				System.out.println("		         *** Have a Nice Day ***          ");
				System.out.println();
				break;
				
				//default: System.out.println("*** Invalid Input ***");

			}
			}
			}
		}
	}
