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
     public void board(String value) {
    		Scanner inputReader = new Scanner (System.in);
    		
    		System.out.println(" \n Enter the title of the board");
    		String title = inputReader.nextLine();
    		try {
    				Class.forName("com.mysql.jdbc.Driver");
    				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
    				String parameters="Insert into board (boardname, star, b_company_name)"  + "VALUES ('" +title+ "','0','" +value+"')";
    				Statement s = conn.createStatement();
    		s.executeUpdate(parameters);
    		String parameters1="Select b_team_name from board where boardname= '"+title+"'";
			Statement s1 = conn.createStatement();
	ResultSet rs1=s.executeQuery(parameters1);
	while (rs1.next())
        value = rs1.getString("b_team_name");
	 System.out.println(value);
    		if(rs1.next() != true) {
    			System.out.println("There are no teams,Do you wish to create one");
    		}
    		else {
    		System.out.println("Would you like to select the team for the Board \n Type 'yes' to select team \n Type 'no' to proceed without selection ");
    		}
    		String input = inputReader.nextLine();
    		if(input.equals("yes")) {
    			while(rs1.next()) {
    				System.out.println(rs1.getString(1));
    			}
    			Team t = new Team();
    			t.team(title);
    			
    		}
    		
    		
    		else {
    			System.out.println("Please enter a valid option");
    		}

    	}
    		catch(Exception e){ System.out.println(e);} 
 
    	}

}