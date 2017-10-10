import java.util.ArrayList;

public class List {

	String ListTitle;
	int ListNumber=0;
	ArrayList<Card> ListofCards=new ArrayList<Card>();
	
	public List(String Title){
		this.ListTitle=Title;
	}
	public void addCardToList(Card card){
		ListofCards.add(card);
	}
	public int getListofCardsSize(){
		return ListofCards.size();
	}
	public Card getListofCardsElements(int index){
		return ListofCards.get(index);
	}
	public String getListTitle(){
		return ListTitle;
	}
	public void setListTitle(String Title){
		this.ListTitle=Title;
	}
	
	
}
