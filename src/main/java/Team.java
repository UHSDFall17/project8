import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;




public class Team {
 private Connection conn = null;
 String teamname;
 String teamdesc;
 String values;
 Scanner scan = new Scanner (System.in);
 public void getInput()
 {
  Scanner scan = new Scanner (System.in);
  System.out.println("Please enter Team Name:");
   teamname  = scan.nextLine();
  System.out.println("Please enter Team Description:");
       teamdesc  = scan.nextLine();
       scan.close();
 }
 
 public void team()
 {
  
  try {
   
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
   Statement s = null;
  
  Scanner scan = new Scanner (System.in);
  System.out.println("Press 1 to create team /n Press 2 to view teams /n Press 3 to add members to team ");
  int option = scan.nextInt();
  switch(option)
  {
  case 1:
	  createTeam();
	  break;
  }
  }
  catch(Exception e){ 
	  System.out.println(e);
	  }
 }
  public void createTeam()
  {
	  try
	  {
		  System.out.println("Press 1 to create Team /n Press 2 to create Business Team");
		  int input = scan.nextInt();
		  if (input == 1)
		  {
		   System.out.println("---Create Team---");
		   getInput();
		    values = "INSERT INTO team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";
		   
		  }
		  
		  else if (input == 2) {
		   System.out.println("---Create Business Team---");
		   getInput();
		   
		    values = "INSERT INTO business_team (bus_team_name,bus_team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";
		  }
	  }
	  catch(Exception e){ 
		  System.out.println(e);
		  }
  }
  
 public void addMembersToTeam()
 {  
  ArrayList<String> members = new ArrayList<String>(); 
   System.out.println("Press/n 1.to add members to Team /n  Press 2. to add members to Business Team ");
   int input = scan.nextInt();
   scan.nextLine(); 
   System.out.println("Enter Team Name:");
   String teamName  = scan.nextLine();
   String membername;
   System.out.println("Enter Member Name:");
   membername  = scan.nextLine();
         members.add(membername); 
         addToDatabase(membername,teamName,input);
    System.out.println("Members added to the team successfully!");
   
  }

 private void addToDatabase(String membername, String teamName2, int input) {
  try{
   Class.forName("com.mysql.jdbc.Driver");
   Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
  Statement s = null;
   if (input == 1)
   {
    values="UPDATE team SET team_members = '" +membername+ "' WHERE team_name ='" +teamName2+ "'";   
   }  
   else if (input == 2 ) 
   {
    values="UPDATE business_team SET bus_team_members = '" +membername+ "' WHERE bus_team_name ='" +teamName2+ "'";   
   }
  
 }
  catch(Exception e){
   System.out.println(e);
  }
 }
}