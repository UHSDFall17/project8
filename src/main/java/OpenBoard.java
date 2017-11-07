import java.util.Scanner;

public class OpenBoard {
	String boardname;
	public void boardDisplay()
	{
		System.out.println("Do you want to open an existing board?(Input Yes or No)");
		Scanner inputReader = new Scanner (System.in);
		String input = inputReader.nextLine();
		if(input.equals("yes"))
		{
			System.out.println("Please enter the board name that you want to open");
			boardname = inputReader.nextLine();
			boardOpen(boardname);
		}
		else
		{
			
		}
	}
	
	public void boardOpen(String boardname2)
	{
		
	}
}
