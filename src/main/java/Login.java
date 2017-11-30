import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	Scanner scan= new Scanner(System.in);
	public String login( ){
		String x=" ";
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
			System.out.println("Enter Username or Email");
			String Username=scan.nextLine();
			System.out.println("Enter Password ");
			String Password=scan.nextLine();
			String parameters="Select Username, Password from Users where Username = '"+Username+"' and Password = '"+Password+"'";
			Statement s = conn.createStatement();
		    ResultSet rs=s.executeQuery(parameters);
		    if(rs.next())
		    {
		    	x="Login Successfull!";
		    	System.out.println("Login Successfull!");
		    	 Welcome w=new Welcome();
		    	 w.Welcome(Username);
		    }
		    else
		    {
		    	 x= "Invalid !! ";
		    	 System.out.println("Invalid");
		    }
		    	
		    conn.close();
		    
		}
		catch(Exception e){
			System.out.println(e);
		}
	return x;
		
	}
	
	public void Reset(){
		System.out.println("Fields Mismatch!");
		ForgotPassword();
	}

	public void ForgotPassword() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
			System.out.println("Enter Username or Email");
			String Username=scan.nextLine();
			String parameters="Select Username from Users where Username ='"+Username+"'";
			Statement s = conn.createStatement();
		    ResultSet rs=s.executeQuery(parameters);	
		    if(rs.next()){
		    	System.out.println("Enter a new password");
		    	String Password=scan.nextLine();
		    	System.out.println("done");
		    	parameters="Update Users set Password = '"+Password+"'"  + "where Username = '"+Username+"'";
		    	System.out.println("done update");
		    	s.executeUpdate(parameters);
		    	System.out.println("Updated successfully!!");
		    	conn.close();
		    	System.out.println("Do you want to login into Trello(yes/no)?");
		    	Scanner scan = new Scanner(System.in);
		    	String input=scan.nextLine();
		    	if(input.equalsIgnoreCase("yes")){
		    		login();
		    	}
		    	else
		    		System.out.println("You have not entered into Trello. Thank You!");
		    }
		    else
		    	Reset();	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
