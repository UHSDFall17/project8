import java.util.Scanner;

public class Main {
	public static void main(String[] args)
	{
		welcome();
	}
	public static String welcome(){
		String x=" ";
	System.out.println("welcome to trello \n");
	System.out.println("Already Registered? (Yes/No)");
	Scanner s = new Scanner(System.in);
	String input=s.nextLine();
	if(input.equalsIgnoreCase("yes"))
	{
	Login l=new Login();
	l.login();
	}
	else if(input.equalsIgnoreCase("no")){
		Registration reg=new Registration();
		reg.Register();
	}
	else{
		x="Invalid";
	}
	return x;
		
	}

}
