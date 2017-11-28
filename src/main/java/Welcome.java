import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Welcome {
int user_input;
Scanner scan=new Scanner(System.in);
public void Welcome(String Username) throws ClassNotFoundException, SQLException{

		Class.forName("com.mysql.jdbc.Driver");
		Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/Trello","root","root");
	String parameters ="Select company_name from users where Username = '" +Username+ "'";
	Statement s = conn.createStatement();
    ResultSet rs=s.executeQuery(parameters);
    String value = null;
	while (rs.next())
        value = rs.getString("company_name");
	
System.out.println("Select the options below \n 1.Create Board \n 2.Team \n 3.Create Business Board \n 4. Display Boards \n 5. Logout");
user_input=scan.nextInt();


switch (user_input) {

			case 1:
				Board b = new Board();
				b.board(value);

				break;
			case 2:
				Team t = new Team();

				t.Team();

				break;

			case 3:

				Board c = new Board();
				c.board(value);
				break;
			case 4:
			ViewBoard vb = new ViewBoard();
			vb.displayBoards(value);
		
			case 5:
			   System.exit(1);
			   break;
		    default:
			
		    System.out.println("invalid option");
			break;
		}
		


}
}