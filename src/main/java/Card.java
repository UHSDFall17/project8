import java.util.ArrayList;

import org.w3c.dom.Comment;

public class Card {
      String Title,Description;
      int CardNumber=0;
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
      
}
