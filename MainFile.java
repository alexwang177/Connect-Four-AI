
/* Alex(Jianuo)Wang 
 * k1327510
 * Period 6
 * 2/19/2016
 */
 
 import java.util.Scanner;
 public class MainFile
 {
 	public static void main(String[] args)
 	{
 		Scanner keyboard = new Scanner(System.in);
 		System.out.println("---Connect Four Graphical---\n");
 		int selection=0;

 		do
 		{
 			System.out.print("How many players will be playing? 1 or 2: ");
 			selection = keyboard.nextInt();
 		}while(selection!=1 && selection!=2);
 		
 		new ConnectFourFrame("Connect Four Graphical",selection);
 	}
 }
 
 
 