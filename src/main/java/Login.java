import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Login {
	public static void main(String[] args){
		Login l=new Login();
		l.login();
		}
 
	Scanner scan= new Scanner(System.in);
	public void login(){
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
		    	System.out.println("Login Successfull");
		    else
		    	System.out.println("Invalid !! ");
		    	
		    conn.close();
		    
		}
		catch(Exception e){
			System.out.println(e);
		}
		
	}
	
	public void Reset(){
		System.out.println("Fields Mismatch!");
		ForgotPassword();
	}

	private void ForgotPassword() {
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
		    	parameters="Update Users(Username, Password) " + "VALUES ('" +Username+ "', '" +Password+ "')";
		    	s.executeUpdate(parameters);
		    	System.out.println("Updated successfully!!");
		    	conn.close();
		    	login();
		    }
		    else
		    	Reset();	
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
