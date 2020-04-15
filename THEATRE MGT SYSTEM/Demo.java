import java.util.*;
import java.io.*;
import java.lang.*;


// ABSTRACT CLASSES

abstract class Billing{
	abstract void bill();
}

class Working{
	
	Scanner sc;

	void nowShowing(){
		System.out.println("           	>>  NOW SHOWING  <<              ");

		// EXCEPTION HANDLING

		try{
			sc = new Scanner(new File("C:\\Users\\sahee\\OneDrive\\Desktop\\THEATRE MGT SYSTEM\\current.txt"));

			// FILE HANDLING 

			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	void upcomingMovies(){
		System.out.println("           	>>  UPCOMING MOVIES  <<           ");
		try{
			sc = new Scanner(new File("C:\\Users\\sahee\\OneDrive\\Desktop\\THEATRE MGT SYSTEM\\upcoming.txt"));
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}
}

//	INHERITANCE

class Tickets extends Billing{
	Scanner sc;
	String movieName;
	char c;
	int count;
	double tax,total;
	
	void buyTickets(){	
		
		System.out.println("           	     >>  BUY TICKETS  <<                  ");
		System.out.println("*due to lockdown all tickets are of 200 rupees each*");
		System.out.println();
		try{
			sc = new Scanner(new File("C:\\Users\\sahee\\OneDrive\\Desktop\\THEATRE MGT SYSTEM\\current.txt"));
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	void bill(){

		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter movie name : ");
		movieName = s.nextLine();
		System.out.println("Enter number of tickets : ");
		count = s.nextInt();
		total = count*200;
	}

	//	METHOD OVERLOADING OR POLYMORPHISM

	void bill(double tempTotal){

		Scanner s = new Scanner(System.in);
		tax = tempTotal*0.09;
		total += tax;
		System.out.println("Total amount payable : " + total + " (including GST)");
		System.out.println("Payment Confirmation, do u want to continue? (y/n) : ");
		c = s.next().charAt(0);
		if(c == 'y'){
			System.out.println("Tickets are booked successfully!!");
		}
		else{
			System.out.println("Payment Failed!");
			System.exit(0);
		}
	}
}

class Snacks extends Billing{
	Scanner sc;
	String snackName;
	char c;
	int count;
	double total,tax;

	void orderMeals(){
		
		System.out.println("           	     >>  MEALS MENU  <<          		");
		System.out.println("*due to lockdown all snacks are of 100 rupees each*");
		System.out.println();
		try{
			sc = new Scanner(new File("C:\\Users\\sahee\\OneDrive\\Desktop\\THEATRE MGT SYSTEM\\snacks.txt"));
			while(sc.hasNextLine()){
				System.out.println(sc.nextLine());
			}
			sc.close();
		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
	}

	void bill(){

		Scanner s = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter snack name : ");
		snackName = s.nextLine();
		System.out.println("Enter number of items : ");
		count = s.nextInt();
		total = count*100;
		tax = total * 0.04;
		total+= tax;
		System.out.println("Total amount payable : " + total+ " (including GST)");
		System.out.println("Payment Confirmation, do u want to continue? (y/n) : ");
		c = s.next().charAt(0);
		if(c == 'y'){
			System.out.println("Order placed successfully!!");
		}
		else{
			System.out.println("Payment Failed!");
			System.exit(0);
		}
	}
}

class Demo extends Working{
	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		int ch;
		Working obj = new Working();
		Tickets t = new Tickets();
		Snacks sn = new Snacks();

		System.out.println("	   >> THEATER MANAGEMENT SYSTEM <<      ");
		System.out.println("=============================================================");
		System.out.println("|\t\t1.	NOW SHOWING\t\t\t    |");
		System.out.println("|\t\t2.	UPCOMING MOVIES\t\t\t    |");
		System.out.println("|\t\t3.	BUY TICKETS\t\t\t    |");
		System.out.println("|\t\t4.	PRE ORDER MEALS\t\t\t    |");
		System.out.println("|\t\t5.	QUIT\t\t\t\t    |");
		System.out.println("=============================================================");
		System.out.println("		 	-saheel kumar das				");
		System.out.println();
		System.out.println("Enter a choice : ");
		ch = sc.nextInt();
		switch(ch){
		case 1:
			System.out.println();
			obj.nowShowing();
			break;
		case 2:
			System.out.println();
			obj.upcomingMovies();
			break;
		case 3:
			System.out.println();
			t.buyTickets();
			t.bill();
			t.bill(t.total);
			break;
		case 4:
			System.out.println();
			sn.orderMeals();
			sn.bill(); 
			break;
		case 5:
			System.out.println();
			System.out.println("Have a nice day! :)");
			System.exit(0);
			break;
		default:
			System.out.println("Enter a valid option (a,b,c,d,e) !!");
			break;
		}

	}
}