package receptionn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import connection.CreateConnection;

public class RoomVacateEntry extends CreateConnection
{
	Connection c;
	String rno,qry,pp,co,cr;
	Scanner obb=new Scanner(System.in);
	Scanner ob=new Scanner(System.in);
	private String rtt;

	
	public void Room_VacateEntry() throws SQLException
	{
		c=getConnection();
		Statement st=c.createStatement();
		ResultSet rs;
		PreparedStatement ps;
		int t1=0;
		
		System.out.println("Enter Room_No:");
		rno=obb.nextLine();
		qry="select *from Rooms;";
		rs=st.executeQuery(qry);
		while(rs.next())
		{
			if(rno.equals(rs.getString(1)))
			{
				System.out.println();
				System.out.println("------------------------------------------------");
				System.out.println("Room No                : "+rs.getString(1));
				System.out.println("Room Type              : "+rs.getString(2));
				System.out.println("Customer Name          : "+rs.getString(3));
				System.out.println("Mobile No              : "+rs.getString(4));
				System.out.println("Check-In Time          : "+rs.getString(7));
				System.out.println("------------------------------------------------");
			}
		}
		System.out.println();
		System.out.println("P - Proceed for CheckOut the Room");
		
		int nd;
		pp=obb.nextLine();
		int t = 0;
		switch(pp)
		{
		case "p":
			System.out.println();
			System.out.println("Enter CheckOut Time:");
			co=obb.nextLine();
			System.out.println();
			System.out.println("Enter No of Staying Days:");
			nd=ob.nextInt();
			System.out.println();
			System.out.println("		.................... AZ Rooms & Restaurent ..................");
			System.out.println("		#11, Tirupattur - Vellore Main Road, MC Road, Ambur-635802.");
			System.out.println("		                 GST No : ABCD98765432175865     ");
			System.out.println("		           Contact No : +91 9043536088/9876543210     ");
			System.out.println();
			System.out.println();
			System.out.println("		                  -------------------                      ");
			System.out.println("		                   *** Room Bill ***                      ");
			System.out.println("		                  -------------------                      ");
			System.out.println();
			qry="select *from Rooms;";
			rs=st.executeQuery(qry);
			while(rs.next())
			{
				if(rno.equals(rs.getString(1)))
				{
				System.out.println("		============================================================");
				System.out.println();
				System.out.println("		Customer Name                  : "+rs.getString(3));
				System.out.println("		Mobile No                      : "+rs.getString(4));
				System.out.println();
				System.out.println("		Room No                        : "+rs.getString(1));
				System.out.println("		Room Type                      : "+rs.getString(2));			
				System.out.println("		Check-In  Time                 : "+rs.getString(7));
				System.out.println("		Check-Out Time                 : "+co);
				}
			}
			
			qry="select *from Room_Rent_Amount;";
			rs=st.executeQuery(qry);
			while(rs.next())
			{
				if(rno.equals(rs.getString(1)))
				{
					int rr;
					rr=nd*rs.getInt(3);
				System.out.println();
				System.out.println("		                              ------------------");
				System.out.println("		Room Rent Amount               : Rs. "+rr);
				System.out.println("		                              ------------------");
				int g1,g2,tt;
				g1=rr/100*6;
				g2=rr/100*6;
				int rtt = rr+g1+g2;
				System.out.println("		SGST   - 6%                    : Rs. "+g1);
				System.out.println("		CGST   - 6%                    : Rs. "+g2);
				System.out.println();
				System.out.println("				              ================");
				System.out.println("		Total Amount                   : Rs. "+rtt);
				System.out.println("				              ================");
				System.out.println();
				System.out.println("		============================================================");
				
				}
			}
			System.out.println();
			System.out.println();
			//System.out.println("		          *** THANKS FOR YOUR VISITING ***          ");
			//System.out.println("		              *** Have a Nice Day ***          ");
			System.out.println("		                  -------------------                      ");
			System.out.println("		                   *** Food Bill ***          ");
			System.out.println("		                  -------------------                      ");
			System.out.println();
			qry="select *from Rooms_food_Bill;";
			rs=st.executeQuery(qry);
			System.out.println("                *************************************************************");
			System.out.println("                Desc          Food_Item                Amt    Qty   Total_Amt");
			System.out.println("                *************************************************************");
			while(rs.next())
			{
				if(rno.equals(rs.getString(1)))
				{
					System.out.println("		"+rs.getString(2)+ "    "+rs.getString(3)+""+rs.getInt(4)+"     "+rs.getInt(5)+"      "+rs.getInt(6));
					t1 = t1+rs.getInt(6);	
				}
			}
				System.out.println();
				System.out.println("		                                 --------------------------");
				System.out.println("		                                    Sub Amount: Rs. "+t1);
				System.out.println("		                                 --------------------------");
				System.out.println();
				float tt1;
				float g11,g12;
				g11=t1*2.5f/100;
				g12=t1*2.5f/100;
				tt1=t1+g11+g12;
				System.out.println("                                            SGST   - 2.5%       Rs. "+g11);
				System.out.println("                                            CGST   - 2.5%       Rs. "+g12);
				System.out.println();
				System.out.println("		                               ============================");
				System.out.println("		                                  Total Amount: Rs. "+tt1);
				System.out.println("		                               ============================");
				System.out.println("		                 ");
				
				
//				System.out.println("		                    Room Rent Total Amount: Rs. "+rtt);
//				System.out.println("		                    Food Total Amount: Rs. "+tt1);
//				System.out.println("		                               ============================");
//				System.out.println("		                                Total Amount: Rs. "+tt1+rtt);
//				System.out.println("		                               ============================");
				System.out.println("		============================================================");
				System.out.println();
				System.out.println("		            *** THANKS FOR YOUR VISITING ***          ");
				System.out.println("		                *** Have a Nice Day ***          ");
				System.out.println();
			System.out.println();
			System.out.println("Cash Received:-");
			cr=obb.nextLine();
			qry="Update Rooms set Customer_Name='',Contact_No='',Address='',Id_Proof_No='',Check_in_Time='',room_available='yes' where Room_No=?;";
			ps=c.prepareStatement(qry);
			ps.setString(1, rno);
			ps.executeUpdate();
			System.out.println();
			System.out.println(" *** Room Status Updated ***");
			System.out.println();
								
		}
				
	}

}
