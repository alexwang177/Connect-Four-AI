/* Alex(Jianuo)Wang 
 * k1327510
 * Period 6
 * 2/19/2016
 */
public abstract class Player
{
	private String name;
	private int color;
	
	public Player(String name, int color)
	{
		this.name=name;
		this.color=color;
	}
	
	public String getName()
	{
		return name;
	}
	
	public int getColor()
	{
		return color;
	}
	
	public abstract int move(ConnectFourGame game);

}