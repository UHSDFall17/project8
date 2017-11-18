import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		welcome();
		
	}
	public static String welcome(){
		String x=" ";
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
	return x;
		
	}

}
