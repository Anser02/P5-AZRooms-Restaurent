package azRooms_Retaurent;

import java.sql.SQLException;
import java.util.Scanner;

import customer.Bill;
import customer.CustomerLogin;
import customer.Food_Menu;
import receptionn.Available_RoomsDetails;
import receptionn.Receptionn_Loginn;
import receptionn.Receptionn_Rooms_Details;
import restaurent.Dinner_Restaurent_Bill;
import restaurent.Lunch_Restaurent_Bill;
import restaurent.MorningFoodMenu;
import restaurent.Restaurent_Login;

public class Mainnn {

	public static void main(String[] args) throws SQLException {
		
		Scanner obb=new Scanner(System.in);
		Receptionn_Loginn r=new Receptionn_Loginn();
		CustomerLogin c=new CustomerLogin();
		Restaurent_Login rr=new Restaurent_Login();
		System.out.println("   ***   Press '1'  -  Reception Login     ***   ");
		System.out.println("   ***   Press '2'  -  Customer Login      ***   ");
		System.out.println("   ***   Press '3'  -  Restaurent Login     ***   ");
		String inpu;
		inpu=obb.nextLine();
		
		switch(inpu)
		{
		case "1":
			r.Recep_Login();
			break;
			
		case "2":
			c.CustomerLginn();
			break;
		
		case "3":
			rr.Restaurent_login();
		break;	
		
		default : System.out.println("*** Invalid Input ***");
			
		}

	}

}
