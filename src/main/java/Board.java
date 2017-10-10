import java.util.ArrayList;
import java.util.List;
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

}
