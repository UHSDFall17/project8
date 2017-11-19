import java.util.Scanner;
public class Information {
	public void information() {
		System.out.println("*****What do you want to know?*****");
		help();
	}
	public void help(){
		Scanner scan = new Scanner(System.in);
		System.out.println("1.) What is trello?");
		System.out.println("2.) How can I register to Trello?");
		System.out.println("3.) How can I login into Trello?");
		System.out.println("4.) How can I reset my password?");
		System.out.println("Enter a number for the question that you wish to view: ");
		checkAnswers(scan.nextInt());
		scan.close();
	}
	public void checkAnswers(int input){
		Scanner scan = new Scanner(System.in);
		switch(input) {
		case 1:
			System.out.println("Trello helps you to manage and organize your projects.\n" + "Back to the questions.\n");
			help();
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		default:
			
			break;
		}
	}
}
