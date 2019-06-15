/* Alex(Jianuo)Wang 
 * k1327510
 * Period 6
 * 2/19/2016
 */
import java.util.Scanner;
public class ConnectFourGame
{
	public int board[][] ={{6,6,6,6,6,6,6},
		                  {6,6,6,6,6,6,6},
		                  {6,6,6,6,6,6,6},
		                  {6,6,6,6,6,6,6},
		                  {6,6,6,6,6,6,6},
		                  {6,6,6,6,6,6,6}};
 
	public static final int PLAYING = 0;
	public static final int RED_WINS = 1;
	public static final int BLACK_WINS = 2;
	public static final int DRAW = 3;
	public static final int RED = 4;
	public static final int BLACK = 5;
	public static final int EMPTY = 6;
	public static final int BLOCK = 7;
	
	public ConnectFourGame()
	{
 		this.board = board;
	}
	
	public boolean dropPiece(int column, int player)
	{
		/*boolean dropPiece = true;
		boolean columnFull = columnFull(column);
		if(columnFull==false)
		{
			int x = 0;
			for(int lowest = 0;board[lowest][column]!=6;lowest++)
				x++;
			board[x][column] = player;	
		}
		else
			dropPiece = false;
		return dropPiece;*/
		
		boolean dropPiece;
		boolean columnFull = columnFull(column);
		if(columnFull==false)
		{
			int x = 5;
			for(int lowest = 5;board[lowest][column]!=6;lowest--)
				x--;
				board[x][column] = player;
			    dropPiece = true;
		}
		else 
		 	dropPiece = false;
		return dropPiece;
	}
	public int status()
	{
		//Horizontal
		for(int r=0; r<6;r++)
		{
			for(int c=0; c<=3; c++)
			{
				if(board[r][c] == RED &&board[r][c+1] == RED &&board[r][c+2] == RED &&board[r][c+3] == RED)
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r][c+1] == BLACK&&board[r][c+2] == BLACK &&board[r][c+3] == BLACK)
					return BLACK_WINS;
			}
        }
        //Vertical
        for(int r=0; r<3;r++) 
		{
			for(int c=0; c<=6; c++)
			{
				if(board[r][c] == RED &&board[r+1][c] == RED &&board[r+2][c] == RED &&board[r+3][c] == RED)
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r+1][c] == BLACK&&board[r+2][c] == BLACK &&board[r+3][c] == BLACK)
					return BLACK_WINS;
			}
        }
        //Diagonal
        /*for(int r=0; r<3;r++)
		{
			for(int c=0; c<=3; c++)
			{
				if(board[r][c] == RED &&board[r-1][c+1] == RED &&board[r-2][c+2] == RED &&board[r-3][c+3] == RED) 
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r-1][c+1] == BLACK&&board[r-2][c+2] == BLACK &&board[r-3][c+3] == BLACK)
					return BLACK_WINS;
			}
        }*/
        
        for(int r=0; r<3;r++)
		{
			for(int c=0; c<=3; c++)
			{
				if(board[r][c] == RED &&board[r+1][c+1] == RED &&board[r+2][c+2] == RED &&board[r+3][c+3] == RED) 
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r+1][c+1] == BLACK&&board[r+2][c+2] == BLACK &&board[r+3][c+3] == BLACK)
					return BLACK_WINS;
			}
        }
        
        for(int r=3; r<6;r++)
		{
			for(int c=0; c<=3; c++)
			{
				if(board[r][c] == RED &&board[r-1][c+1] == RED &&board[r-2][c+2] == RED &&board[r-3][c+3] == RED)
					return RED_WINS;
				else if(board[r][c] == BLACK &&board[r-1][c+1] == BLACK &&board[r-2][c+2] == BLACK &&board[r-3][c+3] == BLACK)
					return BLACK_WINS;
			}
        }
        
        //Draw
        int x = 0;
        for(int[] row: board)
    	{
    		for(int num: row)
    		{
     			if(num!=6)
     			x++;
    		}
    	}
    	if(x==42)
    	return DRAW;
    	
        return PLAYING;
	}
	public boolean columnFull(int column)
	{
		return board[0][column] != 6;
	}
    public void draw()
    {
    	for(int[] row: board)
    	{
    		for(int num: row)
    		{
    			if(num == 7)
    				System.out.print(" ");
    			else if(num == 6)
    				System.out.print("| ");
    			else if(num == 4)
    				System.out.print("|R");
    			else if(num == 5)
    				System.out.print("|B");
    		}
    		System.out.println("|");
    	}
    	System.out.println("---------------");
    }
    public int getSpot(int col, int row)
    {
   		if((row<=5 && row>=0)&&(col<=6 && col>=6))
   			return board[row][col];
   		else
   			return -1;
    }
    
    //Ignore, this method is not used in this lab it was for the extra credit of the first ConnectFour Lab.
    public int blockPlayer(int player,int computer)
    {
    	//rip dude
    	int column = -1;
    	//int status = copy.status();
    	/*for(int x=0;x<7;x++)
    	{
    		if(copy.dropPiece(x,copy.RED))
    			
    	}*/
    	
    	return column;
    }
}