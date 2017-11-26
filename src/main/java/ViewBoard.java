import java.util.Scanner;

public class ViewBoard {
	public void displayBoards() {
	  Scanner scan=new Scanner(System.in);

		System.out.println("Do you wish to open board");
       
		String boardname;
		String open =scan.nextLine();
		if (open.equals("yes")) {
			System.out
					.println("Please enter the name of the board which you wish to open");
			boardname =scan.nextLine();
			openBoard(boardname);
		} else
			System.out.print("Back functionality");
	}

	private void openBoard(String boardname) {
		// TODO Auto-generated method stub
		

		

	}
}
