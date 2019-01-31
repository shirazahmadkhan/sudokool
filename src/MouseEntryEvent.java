import java.awt.event.*;
import javax.swing.*;

import java.awt.*;
import java.applet.*;
import java.net.*;

class MouseEntryEvent extends Applet implements MouseListener
{	
	JButton btna;
	int x;
	AudioClip clip;
	public static Font font = new Font("SanSerif", Font.BOLD,14);
	public MouseEntryEvent(JButton temp,int y)
	{	
		btna=temp;
		x=y;
	}
	@SuppressWarnings("deprecation")
	public void mouseClicked(MouseEvent e)  
	{	
	//	panel1.timer.invalidate();
		int a=e.getButton();
		if(panel2.selected==0);			// do anything only if one of the radio buttons is selected
		else
		{
			if(a==1)	//left click
			{	
				if(panel2.ans[x]==0)  	// put mark at blank places with blue
				{							//if correct else with red	
					URL url;
					if((panel1.c==1)&&(panel2.s[x]!=panel2.selected))		// if marking warning is ON and incorrect answer
					{
						btna.removeAll();
						btna.setFont(font);
						btna.setForeground(Color.RED);
						url=MouseEntryEvent.class.getResource("audio/wrong.wav");
					}
					else
					{
						btna.removeAll();
						btna.setForeground(Color.BLUE);
						btna.setFont(font);
						url=MouseEntryEvent.class.getResource("audio/mark.wav");
					}	
					panel2.com++;panel2.rem--;
					panel2.comlabel.setText("Points Completed : "+panel2.com+"    ");
					panel2.remlabel.setText("Points Remaining : "+panel2.rem+"    ");
					panel2.comlabel.invalidate();
					panel2.remlabel.invalidate();
					panel2.ans[x]=panel2.selected;				
					btna.setText(Integer.toString(panel2.selected));
					btna.invalidate();
					clip=Applet.newAudioClip(url);
					clip.play();
					panel2.setHints();
					
					// auto submit 
					if((panel2.com == 81) && (panel1.g == 0))	
					{
						int p=0;int val1=0,val2=0;
						for(int i=0;i<81;i++)
						{
							val1=panel2.ans[i];
							val2=panel2.s[i];
							if((val1!=0)&&(val1==val2)&&((panel2.btn[i].getForeground())!=Color.RED)&&((panel2.btn[i].getForeground())!=Color.GRAY))
							p++;
						}
						if(p==81)
						{
							URL url2=panel2.class.getResource("audio/yahoo.wav");
							AudioClip clip=Applet.newAudioClip(url2);
							clip.play();
							JOptionPane.showMessageDialog(panel1.panel2obj,"You have successfully completed the puzzle","Congrats !!!",JOptionPane.PLAIN_MESSAGE );
							panel1.panel2obj.t.suspend();
							if((new2.diff==1)||(new2.diff==2)||(new2.diff==3)||(new2.diff==4))
							{
								highscores hw=new highscores();
								hw.writeFile(timer.hr,timer.min,timer.sec,new2.diff);
							}
						}
						else
						JOptionPane.showMessageDialog(panel1.panel2obj,"The puzzle was not correctly solved !!!","Puzzle submission Error",JOptionPane.ERROR_MESSAGE);
					}
						
				}
			}
			if((a==2)||(a==3)) //right click
			{	
				if(panel2.ans[x] !=0)		// if some value has been set on this button
				{
					if(((btna.getForeground())==Color.BLUE)||((btna.getForeground())==Color.GRAY)||((btna.getForeground())==Color.RED))
					 //erase the entry if it is either blue or gray or red
					{	
						if(panel1.c==1)					// if warning is ON delete only red entries 
						{
							if((btna.getForeground())==Color.RED)
							{
								panel2.rem++;panel2.com=81-panel2.rem;
								panel2.comlabel.setText("Points Completed : "+panel2.com+"    ");
								panel2.remlabel.setText("Points Remaining : "+panel2.rem+"    ");
								panel2.comlabel.invalidate();panel2.comlabel.invalidate();
								btna.setForeground(Color.BLUE);
								btna.setFont(font);
								btna.setText(" ");
								btna.invalidate();
								URL url=MouseEntryEvent.class.getResource("audio/delete.wav");
								clip=Applet.newAudioClip(url);
								clip.play();
								panel2.ans[x]=0;	// value from the button has been deleted
								panel2.setHints();
							}
						}
						if(panel1.c==0)					// if warning is OFF delete blue entries 
						{
							if((btna.getForeground())==Color.BLUE)	
							{
								panel2.rem++;panel2.com=81-panel2.rem;
								panel2.comlabel.setText("Points Completed : "+panel2.com+"    ");
								panel2.remlabel.setText("Points Remaining : "+panel2.rem+"    ");
								panel2.comlabel.invalidate();panel2.comlabel.invalidate();
							}
							btna.setForeground(Color.BLUE);
							btna.setFont(font);
							btna.setText(" ");
							btna.invalidate();
							URL url=MouseEntryEvent.class.getResource("audio/delete.wav");
							clip=Applet.newAudioClip(url);
							clip.play();
							panel2.ans[x]=0;			// value from the button has been deleted
							panel2.setHints();
						}
						if(panel1.h==0)					// if hints are OFF then delete pencil marks
						{
							if((btna.getForeground())==Color.GRAY)
							{
								btna.setForeground(Color.BLUE);
								btna.setFont(font);
								btna.setText(" ");
								btna.invalidate();
								URL url=MouseEntryEvent.class.getResource("audio/delete.wav");
								clip=Applet.newAudioClip(url);
								clip.play();
								panel2.ans[x]=0;		// value from the button has been deleted
								panel2.setHints();											
							}
						}
					}
				}
				else
				if((panel2.ans[x]==0)&&(panel1.h==0)) //pencil mark at blank places with gray color
				{
					btna.setForeground(Color.GRAY);
					btna.setFont(font);
					btna.setText(Integer.toString(panel2.selected));
					btna.invalidate();
					URL url=MouseEntryEvent.class.getResource("audio/pencil.wav");
					clip=Applet.newAudioClip(url);
					clip.play();
					panel2.ans[x]=panel2.selected;
				}
			}
			btna.requestFocus();
		}
	}
	public void mousePressed(MouseEvent e)
	{
		
	}
	public void mouseEntered(MouseEvent e)
	{
		
	}
	public void mouseExited(MouseEvent e)
	{
		
	}
	public void mouseReleased(MouseEvent e)
	{
		
	}
	public void init()
	{
	}
	public static void autoSubmit()
	{
		
		int p=0;int val1=0,val2=0;
		for(int i=0;i<81;i++)
		{
			val1=panel2.ans[i];
			val2=panel2.s[i];
			if((val1!=0)&&(val1==val2)&&((panel2.btn[i].getForeground())!=Color.RED)&&((panel2.btn[i].getForeground())!=Color.GRAY))
			p++;
		}
		if(p==81)
		{
			URL url2=panel2.class.getResource("audio/yahoo.wav");
			AudioClip clip=Applet.newAudioClip(url2);
			clip.play();
			JOptionPane.showMessageDialog(panel1.panel2obj,"You have successfully completed the puzzle","Congrats !!!",JOptionPane.PLAIN_MESSAGE );
			panel1.panel2obj.t.suspend();
			if((new2.diff==1)||(new2.diff==2)||(new2.diff==3)||(new2.diff==4))
			{
				highscores hw=new highscores();
				hw.writeFile(timer.hr,timer.min,timer.sec,new2.diff);
			}
			int time_old = Integer.parseInt(frame.pref.getPref((new2.diff*3+2)));
			int[] time = new int[3];time[0]= timer.hr;time[1]= timer.min;time[2]= timer.sec;
			int time_in_sec = frame.pref.getTimeInSeconds(time);
			frame.pref.setPref((new2.diff*3)+2,Integer.toString(time_old+time_in_sec));
			int completed_old = Integer.parseInt(frame.pref.getPref((new2.diff*3)+1));
			completed_old++;
			frame.pref.setPref((new2.diff*3)+1,Integer.toString(completed_old));
			
		}
		else
		JOptionPane.showMessageDialog(panel1.panel2obj,"The puzzle was not correctly solved !!!","Puzzle Error",JOptionPane.ERROR_MESSAGE);
		
	}
}
