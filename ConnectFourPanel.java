/* Alex (Jianuo) Wang 
 * Period 6
 * k1327510
 * 5/5/2016
 **/
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
public class ConnectFourPanel extends JPanel implements MouseListener
{
	public static final int ONE_PLAYER = 1;
	public static final int TWO_PLAYER = 2;
	public int turn;
	public int mode;
	public ConnectFourGame game;
	public ConnectFourGame copy;
	public BufferedImage buffer;
	
	public ConnectFourPanel (int players)
	{
		super();
		setSize(700,600);
		buffer = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
		mode = players;
		turn = game.RED;
		addMouseListener(this);
		reset();  
	}
	public void paint(Graphics g)
	{
		Graphics bg = buffer.getGraphics();
        bg.setColor(Color.YELLOW);
        bg.fillRect(0,0,700,600);
        
        for(int r=0;r<7;r++)
        {
        	for(int c=0;c<6;c++)
        	{
        		if(game.board[c][r] == game.RED)
        			bg.setColor(Color.RED);
        		else if(game.board[c][r] == game.BLACK)
        			bg.setColor(Color.BLACK);
        		else
        			bg.setColor(Color.WHITE);
        		
        		bg.fillOval((r*100)+15,(c*100)+15,60,60);
        	}  	
        }
        
        Font f = new Font("Times New Roman",Font.BOLD,20);
        bg.setFont(f);
        
        if(game.status()!=0)
        {
	        if(game.status() == 1)
	        {
	        	bg.setColor(Color.RED);
	        	bg.drawString("Red Wins!!!",300,300);
	        }	
	        else if(game.status()==2)
	        {
	        	bg.setColor(Color.BLACK);
	        	bg.drawString("Black Wins!!!",300,300);
	        }
	        else if(game.status()==3)
	        {
	        	bg.setColor(Color.BLUE);
	        	bg.drawString("Draw!!!",300,300);
	        }
	        bg.setColor(Color.BLUE);
	        bg.drawString("Right Click to Restart.",250,400);
        }
 
        g.drawImage(buffer,0,0,null);
        // code to draw to the screen using Graphics Commands
	}
	
	public void reset()
	{
		game = new ConnectFourGame();
		copy = new ConnectFourGame();
	}
	
	public void mousePressed(MouseEvent e)
	{
		if(e.getButton() == MouseEvent.BUTTON3 && (game.status() == 1 || game.status() == 2 || game.status() == 3))
		{
			    turn = game.RED;
				reset();
		}
		else
		{
	 		ComputerPlayer com = new ComputerPlayer("",0);
	 		int status = 0;
		 	int column = 0;
		 	
		 	com = new ComputerPlayer("Computer BLACK",game.BLACK);
		 	    
			if(e.getButton() == MouseEvent.BUTTON1 && game.status()==0)
			{
				int x = e.getX();
			    if(x<=100)
			    	column = 0;
			    else if(x<=200)
			    	column = 1;
			    else if(x<=300)
			        column = 2;
			    else if(x<=400)
			    	column = 3;
			    else if(x<=500)
			        column = 4;
			    else if(x<=600)
			    	column = 5;
			    else if(x<=700)
			        column = 6;
			    
			    //Remember: dropPiece takes a column and a player
		 		
		 			if(mode==2)
		 			{ 
		 				 if(turn==game.RED)
		 				 	game.dropPiece(column,game.RED);
		 				 else
		 				 	game.dropPiece(column,game.BLACK);

		 			}
		
		 			if(mode==1)
		 			{	 
		 				 if(game.dropPiece(column,game.RED))
		 				 {
		 				 	column = com.move(game);
		 				 }
		 			}
		 			
		 			status = game.status();
			 			if(turn==game.RED)
			 				turn = game.BLACK;
			 			else
			 				turn = game.RED;
			}
		}
		repaint();
	}
	
	public void mouseReleased(MouseEvent e)
	{
		//Not used
	}
	
	public void mouseClicked(MouseEvent e)
	{
		//Not used
	}
	
	public void mouseEntered(MouseEvent e)
	{
		//Not used
	}
	
	public void mouseExited(MouseEvent e)
	{
		//Not used
	}
}