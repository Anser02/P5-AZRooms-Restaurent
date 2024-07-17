package customer;

import java.sql.SQLException;
import java.util.Scanner;

public class CustomerLogin 
{
	String inpu;
	Scanner obb=new Scanner(System.in);

	public void CustomerLginn() throws SQLException
	{
		while(true)
		{
			System.out.println();
		System.out.println("   ***   Press '1'  -  Breakfast Menu     ***   ");
		System.out.println("   ***   Press '2'  -  Lunch Menu         ***   ");
		System.out.println("   ***   Press '3'  -  Dinner Menu        ***   ");
		System.out.println("   ***   Press '4'  -  Breakfast Order    ***   ");
		System.out.println("   ***   Press '5'  -  Lunch Order        ***   ");
		System.out.println("   ***   Press '6'  -  Dinner Order        ***   ");
		inpu=obb.nextLine();
		Food_Menu f=new Food_Menu();
		BreakfastOrder b=new BreakfastOrder();
		LunchOrder l=new LunchOrder();
		DinnerOrder d=new DinnerOrder();
		switch(inpu)
		{
		case "1":
			f.BreakfastMenu();
			break;
		case "2":
			f.LunchMenu();
			break;
		case "3":
				f.DinnerMenu();
				break;
		case "4":
			b.Breakfastorder();
			break;
		case "5":
			l.lunchorderr();
			break;
		case "6":
			d.Dinnerorderr();
			break;
			default:
				System.out.println("*** Invalid Input ***");					
		}
		
	}
	}
}
