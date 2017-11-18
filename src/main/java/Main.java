import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		System.out.println("welcome to trello \n");
		welcome();
		
	}
	public static String welcome(){
		System.out.println("Choose Options \n");
		System.out.println("Enter 1 to Login\n Enter 2 to Register\n Enter 3 for Password Reset\n Enter 4 for FAQs\n Enter 5 to Exit\n");
		Scanner scan = new Scanner(System.in);
		int input=scan.nextInt();
		switch(input){
		case 1:
 			Login l = new Login();
 			l.login();
 			break;
 		case 2: 
 			Registration reg=new Registration();
 			reg.Register();
   			break;
 		case 3:
 			Login l1 = new Login();
 			l1.ForgotPassword();
 			break;
 		case 4:
 			
 			break;
 		case 5:
	 		System.out.println("Terminataing the application");
	 		break;
 		default:
 			System.out.println("Invalid Option selected!");
		}
		/*String x=" ";
	System.out.println("welcome to trello \n");
	System.out.println("Already Registered? (Yes/No) or enter reset for password reset");
	Scanner s = new Scanner(System.in);
	String input=s.nextLine();
	if(input.equalsIgnoreCase("yes"))
	{
	Login l=new Login();
	l.login();
	Board b=new Board();
	b.board();
	}
	else if(input.equalsIgnoreCase("no")){
		Registration reg=new Registration();
		reg.Register();
	}
	else if (input.equalsIgnoreCase("reset")){
		Login l1 = new Login();
		l1.ForgotPassword();
	}
	else{
		x="Invalid";
	}
	return x;*/
		
	}

}
