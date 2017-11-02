import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;




public class Team {
	private Connection con = null;
	String teamname;
	String teamdesc;
	String values;
	
	public void getInput()
	{
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Please enter Team Name:");
		 teamname  = inputReader.nextLine();
		System.out.println("Please enter Team Description(optional):");
	      teamdesc  = inputReader.nextLine();
	      inputReader.close();
	}
	
	public void team()
	{
		
		try {
			
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
			Statement s = null;
		
		Scanner inputReader = new Scanner (System.in);
		System.out.println("Press 1. for team /n Press 2. for business team ");
		int option = inputReader.nextInt();
		if (option == 1) 
		{
			System.out.println("---Create Team---");
			getInput();
		    System.out.println(".............");
			 values = "INSERT INTO team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";
			 System.out.println("end");
		}
		
		else if (option == 2) {
			System.out.println("---Create Business Team---");
			getInput();
			
			 values = "INSERT INTO business_team (bus_team_name,bus_team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";			
		}
		s = conn.createStatement();
		s.executeUpdate(values);  
		System.out.println(teamname + "Team created Successfully");
		inputReader.close();
		}
		catch(Exception e){ System.out.println(e);} 
	}

}