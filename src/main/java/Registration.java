import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Registration {
  
	public static void main(String[] args){
		
	}
	public String Register(){
	String x=" ";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
			Scanner scan= new Scanner(System.in);
			System.out.println("Enter Username");
			String Username=scan.nextLine();
			if(Username.length()==0)
			Validate(1);
			if(!checkNameRegularExpression(Username))
				Validate(7);
			System.out.println("Enter Email ");
			String Email=scan.nextLine();
			if(Email.length()==0)
				Validate(2);
			if(!checkEmailRegularExpression(Email))
				Validate(3);
			System.out.println("Enter Password ");
			String Password=scan.nextLine();
			if(Password.length()==0)
				Validate(4);
			System.out.println("Confirm Password ");
			String ConfirmPassword=scan.nextLine();
			if(ConfirmPassword.length()==0)
				Validate(5);
			
			if(!(ConfirmPassword.equals(Password))){
				Validate(6);
				x="Passwords don't match!";
				
			}
			
			
			String parameters="Insert into Users (Username, Email, Password)"  + "VALUES ('" +Username+ "', '" +Email+"','" +Password+"')";
			Statement s = conn.createStatement();
			s.executeUpdate(parameters);
			x="Registration Successfull!!";
			scan.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
		return x;
	}
	public boolean checkNameRegularExpression(String username) {
		String reg_name="[a-zA-Z0-9]+";
		Boolean b=username.matches(reg_name);
		return b;
	}
	private void Validate(int casenum) {
		switch(casenum){
		case 1:System.out.println("Enter a valid name!");
		Register();
		break;
	    case 2:System.out.println("Enter a valid email address!");
	    Register();
	    break;
	    case 3:System.out.println("email address is invalid");
	    Register();
	    break;
	    case 4:System.out.println("Enter a valid password!");
		Register();
		break;
	    case 5:System.out.println("Enter a valid Confirm Password!");
		Register();
		break;
	    case 6:System.out.println("Passwords don't match!");
		/*Register();*/
		break;
	    case 7:System.out.println("Name is invalid!");
		Register();
		break;
		}

		
	}
	private boolean checkEmailRegularExpression(String Email){
		String reg_email="[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
		boolean b = Email.matches(reg_email);
		return b;
		
	}
}
