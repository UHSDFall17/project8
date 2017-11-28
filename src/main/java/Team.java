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

 public void getInput()
 {
	 Scanner scan = new Scanner (System.in);
  System.out.println("Please enter Team Name:");
   teamname  = scan.next();
  System.out.println("Please enter Team Description:");
       teamdesc  = scan.next();
       scan.close();
 }
 
 public void team(String title)
 {
  
  try {
	  Scanner scan = new Scanner (System.in);
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
   Statement s = null;
  System.out.println("Press 1 to create team /n Press 2 to view teams /n Press 3 to add members to team ");
  int option = scan.nextInt();
  switch(option)
  {
  case 1:
	  createTeam(title);
	  break;
  case 2:
	  createTeam(title);
	  break;
  case 3:
	  addMembersToTeam();
	  break;
  }
  }
  catch(Exception e){ 
	  System.out.println(e);
	  }
 }
 public void Team()
 {
  
  try {
	  Scanner scan = new Scanner (System.in);
    Class.forName("com.mysql.jdbc.Driver");
    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
   Statement s = null;
  System.out.println("Press 1 to create team /n Press 2 to view teams /n Press 3 to add members to team ");
  int option = scan.nextInt();
  switch(option)
  {
  case 1:
	  createTeam();
	  break;
  case 2:
	  createTeam();
	  break;
  case 3:
	  addMembersToTeam();
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
		  Scanner scan = new Scanner (System.in);
		  System.out.println("Press 1 to create Team /n Press 2 to create Business Team");
		  int input = scan.nextInt();
		  if (input == 1)
		  {
		   System.out.println("---Create Team---");
		   getInput();
		   System.out.println(teamname);
		   System.out.println(teamdesc);
		   System.out.println("back");
		   Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
		    values = "INSERT INTO team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";
		    Statement s = conn.createStatement();
    		s.executeUpdate(values);
    		System.out.println("inserted successfully");
    		conn.close();

		  }
		  
		  else if (input == 2) {
		   System.out.println("---Create Business Team---");
		   getInput();
		   Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
		    values = "INSERT INTO business_team (bus_team_name,bus_team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";
		    Statement s = conn.createStatement();
    		s.executeUpdate(values);
		  }
	  }
	  catch(Exception e){ 
		  System.out.println(e);
		  }
  }
  public void createTeam(String title)
  {
	  try
	  {
		  Scanner scan = new Scanner (System.in);
		  System.out.println("Press 1 to create Team /n Press 2 to create Business Team");
		  int input = scan.nextInt();
		  if (input == 1)
		  {
		   System.out.println("---Create Team---");
		   getInput();
		   Class.forName("com.mysql.jdbc.Driver");
			Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
		    values = "INSERT INTO team (team_name,team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";
		    Statement s = conn.createStatement();
    		s.executeUpdate(values);
    		String params="update team set t_board_name = '" +title+ "' where team_name = '" +teamname+ "'";
    		Statement s1 = conn.createStatement();
    		s1.executeUpdate(params);
    		String params1="update board set b_team_name='"+teamname+"' where boardname='"+title+"'";
    		Statement s2 = conn.createStatement();
    		s2.executeUpdate(params1);
    		System.out.println("inserted successfully");
    		conn.close();
		  }
		  
		  else if (input == 2) {
		   System.out.println("---Create Business Team---");
		   getInput();
		   Class.forName("com.mysql.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
		    values = "INSERT INTO business_team (bus_team_name,bus_team_desc) " + "VALUES ('" +teamname+ "', '" +teamdesc+"')";
		    Statement s = conn.createStatement();
    		s.executeUpdate(values);
		  }
	  }
	  catch(Exception e){ 
		  System.out.println(e);
		  }
  }
  
  public void viewTeam()
  {
	  
  }
  
 public void addMembersToTeam()
 {  
	 try{
		 Scanner scan1 = new Scanner (System.in);
	 
  ArrayList<String> members = new ArrayList<String>(); 
   System.out.println("Press/n 1.to add members to Team /n  Press 2. to add members to Business Team ");
   System.out.println("----------	");
   int input = scan1.nextInt(); 
   System.out.println("Enter Team Name:");
   String teamName  = scan1.nextLine();
   String membername;
   System.out.println("Enter Member Name:");
   membername  = scan1.nextLine();
         members.add(membername); 
         addToDatabase(membername,teamName,input);
    System.out.println("Members added to the team successfully!");
	 }
	 catch(Exception e){
		 System.out.println(e);
	 }
   
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