/* Alex(Jianuo)Wang 
 * k1327510
 * Period 6
 * 2/19/2016
 */
//import java.util.Scanner;
public class ComputerPlayer extends Player
{
	//Scanner keyboard = new Scanner(System.in);
	public ComputerPlayer(String name,int color)
	{
		super(name,color);
	}
	
	@Override
	public int move(ConnectFourGame game)
	{
		int move;
		do
		{
		move = (int)(Math.random()*7+0);
		}while(game.dropPiece(move,getColor())==false||move<0||move>6);
		return move;
		
		
	}
}