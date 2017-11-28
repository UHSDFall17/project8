import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class ViewBoard {
	 static Scanner scan=new Scanner(System.in);

		static String boardname;
		static String star;
	public void displayBoards(String value) {
	

		
       
		String boardname;
	
	
		
			openBoard(value);
		
	}

	private void openBoard(String value) {

		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
			Statement s = conn.createStatement();
			
	         ResultSet rs1=s.executeQuery("SELECT * FROM board WHERE b_company_name = '"+value+"'");
		      while(rs1.next()){
		    	  star = rs1.getString("boardname");
		    	  System.out.println("Boardname: " + star);
		 
	      }
		      Card c=new Card();
		      c.menu();

		

	}
		catch(Exception e){
			System.out.println(e);
		}
}
	private void starBoard() {
		System.out.println("Do you wish to Star any of your boards");
		String option = scan.nextLine();
		if (option.equals("yes")) {
			System.out
					.println("Please enter the name of the board which you wish to star");
			boardname =scan.nextLine();
			try{
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
				Statement s=conn.createStatement(); 
				s.executeUpdate("UPDATE board SET star= '1' WHERE boardname ='" +boardname+ "'");
					System.out.println("Starred Successfully");
			      }
			catch(Exception e){ System.out.println(e);}
			
		} else
			System.out.println("No star operation");
	}
	}
