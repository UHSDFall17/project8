import java.util.Scanner;

public class Welcome {
int user_input;
Scanner scan=new Scanner(System.in);
public void Welcome(){
	do{
System.out.println("Select the options below \n 1.Create Board \n 2.Team \n 3.Create Business Board \n 4. Display Boards \n 5. Logout");
user_input=scan.nextInt();

switch (user_input) {

			case 1:
				Board b = new Board();
				b.board();

				break;
			case 2:
				Team t = new Team();

				t.team();

				break;

			case 3:

				Board c = new Board();
				c.board();
				break;
			case 4:
			ViewBoard vb = new ViewBoard();
						vb.displayBoards();
		
			case 5:
			   System.exit(1);
			   break;
		    default:
			
		    System.out.println("invalid option");
			break;
		}
		
} while (user_input != 5);

}
}