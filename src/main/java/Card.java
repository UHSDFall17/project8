import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import org.w3c.dom.Comment;

public class Card {
      String Title,Description;
      int CardNumber=0;
      String cardname, description, comments, date;
      Scanner input=new Scanner(System.in);
      ArrayList<Comment> Comments=new ArrayList<Comment>();
      public Card(String title,String descrption,Comment comment){
    	  this.Title=title;
    	  this.Description=Description;
    	  this.addComments(comment);
    	  
      }
	private void addComments(Comment comment) {
		Comments.add(comment);
		
	}
      public Card(String title,String descrption){
    	  this.Title=title;
    	  this.Description=Description;
      }
      public Card(){
    	  Title=" ";
    	  Description="Enter here";
      }
      public String getCardTitle(int index){
    	  return Title;
      }
      
      public void setCardTitle(String newtitle){
    	  Title=newtitle;
      }
      public void setCardDescription(String newDescription){
    	  Description=newDescription;
      }
      public String getCardDescription(){
    	 return Description;
      }

  	public void menu() throws ClassNotFoundException, SQLException {
  		System.out.println("------Viewing Cards------\n");
  Scanner input=new Scanner(System.in);
  		


  			System.out.println("1) Display the existing cards.\n"
  					+ "2) Create a new card.\n"
  					+ "3) Modify an existing card.\n"
 
  					+ "Enter the number for the option that you want: ");
  			chooseOption( input.nextInt());
  			String answer = input.nextLine();
 
  	}
  	private void chooseOption(int number) throws ClassNotFoundException, SQLException {
  		Class.forName("com.mysql.jdbc.Driver");
  		 Scanner input=new Scanner(System.in);
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
		switch(number) {
		case 1:
		String values="Select card_name from card ";
		Statement s = conn.createStatement();
		 ResultSet rs=s.executeQuery(values);
		    String value = null;
			while (rs.next())
		        value = rs.getString("card_name");
		
			break;
		case 2:
			System.out.println("Please enter the card name: ");
			this.cardname = input.nextLine();
			System.out.println("Please enter a description of the card: ");
			this.description = input.nextLine();
			System.out.println("Enter any comments for the card: ");
			this.comments = input.nextLine();
			String parameters="Insert into card (card_name,card_description,comments)"  + "VALUES ('" +cardname+ "', '" +description+"','" +comments+"')";
			Statement s1 = conn.createStatement();
			s1.executeUpdate(parameters);
			break;
		case 3:
			System.out.println("Provide the card name that you wish to modify: ");
			this.cardname = input.nextLine();
			System.out.println(cardname);
			System.out.println("What part do you wish to modify?\n"
					+ "1) The card name.\n"
					+ "2) The card description.\n"
					+ "3) The card comments.\n"
					+ "Enter a number: ");
			int change=input.nextInt();
			if(change==1){
				System.out.println("Enter the new value");
				String changed_value=input.next();
				System.out.println(changed_value);
				String parameters1="update card set card_name = '" +changed_value+ "' where card_name = '" +cardname+ "'";;
				Statement s2 = conn.createStatement();
				s2.executeUpdate(parameters1);
			}
			else if(change==2){
				System.out.println("Enter the new value");
				String changed_value=input.next();
				String parameters1="update  card set card_description='" +changed_value+ "' where card_name='"+cardname+"'";
				Statement s2 = conn.createStatement();
				s2.executeUpdate(parameters1);
			}
			else{
				System.out.println("Enter the new value");
				String changed_value=input.next();
				String parameters1="update  card set comments='" +changed_value+ "' where card_name='"+cardname+"'";
				Statement s2 = conn.createStatement();
				s2.executeUpdate(parameters1);
			}
			
			
			break;
		
		default:
			System.out.println("Invalid option.");
			break;
		}	
	}
      
}
