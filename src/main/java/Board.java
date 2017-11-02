import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class Board {
	 ArrayList<List> board=new ArrayList<List>();
	 public void addToBoard(List newboard){
		 board.add(newboard);
	 }
	 public List getBoard(int index){
		 return board.get(index);
	 }
     public int getBoardSize(){
		return board.size();
    	 
     }
     public void board() {
    		Scanner inputReader = new Scanner (System.in);
    		
    		System.out.println("Creeate Board \n Enter the title of the board");
    		String title = inputReader.nextLine();
    		try {
    				Class.forName("com.mysql.jdbc.Driver");
    				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
    				String parameters="Select team_name from team";
    				Statement s = conn.createStatement();
    		ResultSet rs=s.executeQuery(parameters);
    		if(rs.next() != true) {
    			System.out.println("There are no teams,Do you wish to create one");
    		}
    		else {
    		System.out.println("Would you like to select the team for the Board \n Type 'yes' to select team \n Type 'no' to proceed further ");
    		}
    		String input = inputReader.nextLine();
    		if(input.equals("yes")) {
    			while(rs.next()) {
    				System.out.println(rs.getString(1));
    			}
    			Team t = new Team();
    			t.team();
    			
    		}
    		
    		
    		else {
    			System.out.println("Please enter a valid option");
    		}

    	}
    		catch(Exception e){ System.out.println(e);} 
    	}

}