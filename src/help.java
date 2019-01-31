import javax.swing.*;
import javax.accessibility.*;
import java.awt.*;
import java.net.*;
import java.applet.*;
import java.io.*;


public class help extends JFrame
{
	public help(panel2 panel2obj)
	{
		setTitle("Sudokool Help");
		setIconImage(new ImageIcon(help.class.getResource("images/top.png")).getImage());
		setSize(450,600);
		JTabbedPane tabbedpane=new JTabbedPane();
		tabbedpane.addTab("How to Play",new play());
		tabbedpane.addTab("KeyBoard Shrtcts",new controls());
		tabbedpane.addTab("Version Tracker",new version());
		tabbedpane.addTab("Credits",new credits());
		getContentPane().add(tabbedpane);
		setResizable(false);
		Point p=panel2obj.getLocationOnScreen();
		p.translate(0,-250);
		setLocation(p);
		setVisible(true);
		setResizable(true);
	}
}
class controls extends JPanel
{
	JScrollPane scroller=new JScrollPane();
	JEditorPane html;
	controls()	
	{

		URL url= panel1.class.getResource("shortcuts.html");
		try{
			html=new JEditorPane(url);
			html.setEditable(false);
			scroller.setPreferredSize(new Dimension(420, 600));
			scroller.getViewport().add(html);
			scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
			add(scroller,BorderLayout.CENTER);
			}
			catch(MalformedURLException e){
			System.out.println("Malformed URL: " + e);}
			 catch (IOException e) { 
	             System.out.println("IOException: " + e); 
	         } 
	}
}
class credits extends JPanel
{
	JEditorPane html;
	JScrollPane scroller=new JScrollPane();
	credits()
	{
		URL url= panel1.class.getResource("credits.html");
		try{
		html=new JEditorPane(url);
		html.setEditable(false);
		scroller.setPreferredSize(new Dimension(420, 550));
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scroller.getViewport().add(html);
		add(scroller,BorderLayout.CENTER);
		}
		catch(MalformedURLException e){
		System.out.println("Malformed URL: " + e);}
		 catch (IOException e) { 
             System.out.println("IOException: " + e); 
         } 
		
	}
}
class play extends JPanel
{
	JScrollPane scroller=new JScrollPane();
	JEditorPane html;
	play()
	{
		
		URL url= panel1.class.getResource("howto.html");
		try{
		html=new JEditorPane(url);
		html.setEditable(false);
		scroller.setPreferredSize(new Dimension(420, 550));
		scroller.getViewport().add(html);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroller,BorderLayout.CENTER);
		}
		catch(MalformedURLException e){
		System.out.println("Malformed URL: " + e);}
		 catch (IOException e) { 
             System.out.println("IOException: " + e); 
         } 
	}
}
class version extends JPanel
{
	JScrollPane scroller=new JScrollPane();
	JEditorPane html;
	version()
	{
		
		URL url= panel1.class.getResource("version.html");
		try{
		html=new JEditorPane(url);
		html.setEditable(false);
		scroller.setPreferredSize(new Dimension(420, 550));
		scroller.getViewport().add(html);
		scroller.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroller.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scroller,BorderLayout.CENTER);
		}
		catch(MalformedURLException e){
		System.out.println("Malformed URL: " + e);}
		 catch (IOException e) { 
             System.out.println("IOException: " + e); 
         } 
	}
}
