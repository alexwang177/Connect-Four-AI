/* Alex (Jianuo) Wang 
 * Period 6
 * k1327510
 * 5/5/2016
 **/
 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
public class ConnectFourFrame extends JFrame  
{
	public ConnectFourFrame(String frameName, int players)
	{
		super(frameName);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		pack();
			
		ConnectFourPanel p = new ConnectFourPanel(players);
		Insets frameInsets = getInsets();
		int frameWidth = p.getWidth() + (frameInsets.left + frameInsets.right);
		int frameHeight = p.getHeight() + (frameInsets.top + frameInsets.bottom);
		setPreferredSize(new Dimension(frameWidth, frameHeight));
	
		setLayout(null);
		add(p);
		pack();
		setVisible(true);
	}
}