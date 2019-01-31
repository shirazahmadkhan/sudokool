import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Thread.*;
import java.applet.*;
import java.net.*;

public class Indeterminate extends JDialog {

JProgressBar ipb;


public Indeterminate(){}

public Indeterminate(panel2 paneb) {
	final panel2 pane2obj;
	pane2obj = paneb;
	final Indeterminate in = new Indeterminate();		
	in.setTitle("Generating Puzzle");
	in.setSize(300,150);
	in.getContentPane().setLayout(new BorderLayout());
	Point p=paneb.getLocationOnScreen();
	p.translate((paneb.getWidth()-300)/2,40);
	in.setLocation(p);
//	in.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
	JPanel pane11 = new JPanel();
	JPanel pane22 = new JPanel();
	in.ipb = new JProgressBar(JProgressBar.HORIZONTAL);
	in.ipb.setIndeterminate(true);
	JLabel msg = new JLabel("Please wait ...");
	pane11.setLayout(new GridLayout(2,3));
	pane11.add(new JLabel(" "));pane11.add(new JLabel(" "));pane11.add(new JLabel(" "));
	pane11.add(new JLabel(" "));pane11.add(msg);pane11.add(new JLabel(" "));
	pane22.setLayout(new GridLayout(3,3));
	pane22.add(new JLabel(" "));pane22.add(new JLabel(" "));pane22.add(new JLabel(" "));
	pane22.add(new JLabel(" "));pane22.add(in.ipb);pane22.add(new JLabel(" "));
	pane22.add(new JLabel(" "));pane22.add(new JLabel(" "));pane22.add(new JLabel(" "));
	in.getContentPane().add(pane11,BorderLayout.PAGE_START);
	in.getContentPane().add(pane22,BorderLayout.CENTER);
	in.show();
	Thread t1 = new Thread ( new Runnable() {
         public void run () {
         	
            try    
            {
                pane2obj.getPuzzle();
             } 
            catch (Exception e) 
            {
                e.printStackTrace();
            }
               
                   finally 
                   {
                    // This IS on the event-dispatching thread
                    in.setVisible(false);
                    URL url=panel1.class.getResource("audio/start.wav");
					AudioClip clip=Applet.newAudioClip(url);
					clip.play();
					if(pane2obj.t.isAlive())
					{	
						pane2obj.t.hr=0;pane2obj.t.min=0;pane2obj.t.sec=0;
						pane2obj.t.resume();
					}
					else
					{
						pane2obj.t=new timer();
						pane2obj.t.hr=0;pane2obj.t.min=0;pane2obj.t.sec=0;
						pane2obj.t.start();
					}
                }
			}
            });
      t1.start();

	}

}
