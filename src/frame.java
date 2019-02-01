import javax.swing.*;
import java.awt.*;

class frame extends JFrame
{
	public static Prefs pref;
	public frame()
	{
		int x=416,y=559;
		JFrame.setDefaultLookAndFeelDecorated(true);
		setTitle("Shiraz's Sudokool V2.5");
		setIconImage(new ImageIcon(frame.class.getResource("images/top.png")).getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pref = new Prefs();
		String s = pref.getPref(Prefs.FRAME_SIZE);
		x=Integer.parseInt(s.substring(0,3));
		y=Integer.parseInt(s.substring(4,7));
		System.out.println("setting window size x "+x+" y "+y);
		setSize(x,y);
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension dim=kit.getScreenSize();
		int w=dim.width;
		int h=dim.height;
		setLocation((w/2)-207,(h/2)-278);
		getContentPane().setLayout(new BorderLayout());
		panel2 pane2=new panel2();
		panel1 pane1=new panel1(frame.this,pane2);
		getContentPane().add(pane1,BorderLayout.NORTH);
		getContentPane().add(pane2,BorderLayout.CENTER);
		setResizable(true);
		setVisible(true);
		panel2.btn[0].requestFocus();
	}

	public static void main(String arg[])
	{
		try 
		{
		      UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}
		catch (Exception e) 
		{
		      System.out.println("Substance Raven Graphite failed to initialize");
		}
		SwingUtilities.invokeLater(new Runnable() {
		      public void run() {
		        new frame();
		      }
		    });
	}
	
}

