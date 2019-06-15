/* Alex(Jianuo)Wang 
 * k1327510
 * Period 6
 * 2/19/2016
 */
import java.util.Scanner;
public class HumanPlayer extends Player
{
	Scanner keyboard = new Scanner(System.in);
	public HumanPlayer(String name,int color)
	{
		super(name,color);
	}
	
	@Override
	public int move(ConnectFourGame game)
	{
		int move;
		do
		{
		System.out.print("\n" + getName() + " please enter a valid column <0-6>: ");
		move = keyboard.nextInt();
		}while(game.dropPiece(move,getColor())==false||move<0||move>6);
		return move;	
	}
}