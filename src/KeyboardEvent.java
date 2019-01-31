import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;



class KeyboardEvent implements KeyListener
{
	AudioClip clip;
	JButton btn;
	int x;
	
	KeyboardEvent(JButton temp,int y)
	{	
		btn = temp;
		x=y;
	}
	
	public void keyTyped(KeyEvent e) 
	{
		if(e.isAltDown() == false)
		{
			char c = e.getKeyChar();
			switch(c)
			{
				case '1'	:	
					panel1.one.setSelected(true);
					panel2.selected = 1;
					leftClick();
					panel2.btn[x].requestFocus();
					break;
				case '2'	:	
					panel1.two.setSelected(true);
					panel2.selected = 2;
					leftClick();
					panel2.btn[x].requestFocus();
					break;
				case '3'	:	
					panel1.three.setSelected(true);
					panel2.selected = 3;
					leftClick();
					panel2.btn[x].requestFocus();
					break;
				case '4'	:	
					panel1.four.setSelected(true);
					panel2.selected = 4;
					leftClick();
					panel2.btn[x].requestFocus();
					break;
				case '5'	:	
					panel1.five.setSelected(true);
					panel2.selected = 5;
					leftClick();
					panel2.btn[x].requestFocus();
					break;
				case '6'	:	
					panel1.six.setSelected(true);
					panel2.selected = 6;
					leftClick();
					panel2.btn[x].requestFocus();
					break;
				case '7'	:	
					panel1.seven.setSelected(true);
					panel2.selected = 7;
					leftClick();
					panel2.btn[x].requestFocus();
					break;
				case '8'	:	
					panel1.eight.setSelected(true);
					panel2.selected = 8;
					leftClick();
					panel2.btn[x].requestFocus();
					break;
				case '9'	:	
					panel1.nine.setSelected(true);
					panel2.selected = 9;
					leftClick();
					panel2.btn[x].requestFocus();
			}
			
		}
		else
		{
			char c = e.getKeyChar();
			int d = (int) c;
			if((c=='1')||(d==1))
			{
				panel1.one.setSelected(true);
				panel2.selected = 1;
				rightClick();
				panel2.btn[x].requestFocus();
			}
			if((c=='2')||(d==2))
			{
				panel1.two.setSelected(true);
				panel2.selected = 2;
				rightClick();
				panel2.btn[x].requestFocus();
			}
			if((c=='3')||(d==3))
			{
				panel1.three.setSelected(true);
				panel2.selected = 3;
				rightClick();
				panel2.btn[x].requestFocus();
			}
			if((c=='4')||(d==4))
			{
				panel1.four.setSelected(true);
				panel2.selected = 4;
				rightClick();
				panel2.btn[x].requestFocus();
			}
			if((c=='5')||(d==5))
			{
				panel1.five.setSelected(true);
				panel2.selected = 5;
				rightClick();
				panel2.btn[x].requestFocus();
			}
			if((c=='6')||(d==6))
			{
				panel1.six.setSelected(true);
				panel2.selected = 6;
				rightClick();
				panel2.btn[x].requestFocus();
			}
			if((c=='7')||(d==7))
			{
				panel1.seven.setSelected(true);
				panel2.selected = 7;
				rightClick();
				panel2.btn[x].requestFocus();
			}
			if((c=='8')||(d==8))
			{
				panel1.eight.setSelected(true);
				panel2.selected = 8;
				rightClick();
				panel2.btn[x].requestFocus();
			}
			if((c=='9')||(d==9))
			{
				panel1.nine.setSelected(true);
				panel2.selected = 9;
				rightClick();
				panel2.btn[x].requestFocus();
			}
		}
		
	}
	public void keyPressed(KeyEvent e) 
	{
		int m = e.getKeyCode();
		int tmp = x;
		switch(m)
		{
			case KeyEvent.VK_LEFT 	:
				if(x==0) tmp=81;
				panel2.btn[tmp-1].requestFocus();
				break;
			case KeyEvent.VK_RIGHT 	:
				if(x==80) tmp=-1;
				panel2.btn[tmp+1].requestFocus();
				break;
			case KeyEvent.VK_DOWN 	:
				if(x>71)  tmp=tmp-81;
				panel2.btn[tmp+9].requestFocus();
				break;
			case KeyEvent.VK_UP 	:
				if(x<9)	  tmp=tmp+81;
				panel2.btn[tmp-9].requestFocus();
				break;
			case KeyEvent.VK_DELETE	:
				rightClick();
				panel2.btn[x].requestFocus();
				break;
		}
		
	}

	public void keyReleased(KeyEvent e) 
	{
				
	}

	public void leftClick()
	{
		if(panel2.ans[x]==0)  	// put mark at blank places with blue
		{							//if correct else with red	
			URL url;
			if((panel1.c==1)&&(panel2.s[x]!=panel2.selected))		// if marking warning is ON and incorrect answer
			{
				btn.removeAll();
				btn.setFont(MouseEntryEvent.font);
				btn.setForeground(Color.RED);
				url=MouseEntryEvent.class.getResource("audio/wrong.wav");
			}
			else
			{
				btn.removeAll();
				btn.setForeground(Color.BLUE);
				btn.setFont(MouseEntryEvent.font);
				url=MouseEntryEvent.class.getResource("audio/mark.wav");
			}	
			panel2.com++;panel2.rem--;
			panel2.comlabel.setText("Points Completed : "+panel2.com+"    ");
			panel2.remlabel.setText("Points Remaining : "+panel2.rem+"    ");
			panel2.comlabel.invalidate();
			panel2.remlabel.invalidate();
			panel2.ans[x]=panel2.selected;				
			btn.setText(Integer.toString(panel2.selected));
			btn.invalidate();
			clip=Applet.newAudioClip(url);
			clip.play();
			panel2.setHints();
			// auto submit 
			if((panel2.com == 81) && (panel1.g == 0))
			MouseEntryEvent.autoSubmit();
							
		}
	}
	
	public void rightClick()
	{
		if(panel2.ans[x] !=0)		// if some value has been set on this button
		{
			if(((btn.getForeground())==Color.BLUE)||((btn.getForeground())==Color.GRAY)||((btn.getForeground())==Color.RED))
			 //erase the entry if it is either blue or gray or red
			{	
				if(panel1.c==1)					// if warning is ON delete only red entries 
				{
					if((btn.getForeground())==Color.RED)
					{
						panel2.rem++;panel2.com=81-panel2.rem;
						panel2.comlabel.setText("Points Completed : "+panel2.com+"    ");
						panel2.remlabel.setText("Points Remaining : "+panel2.rem+"    ");
						panel2.comlabel.invalidate();panel2.comlabel.invalidate();
						btn.setForeground(Color.BLUE);
						btn.setFont(MouseEntryEvent.font);
						btn.setText(" ");
						btn.invalidate();
						URL url=MouseEntryEvent.class.getResource("audio/delete.wav");
						clip=Applet.newAudioClip(url);
						clip.play();
						panel2.ans[x]=0;	// value from the button has been deleted
						panel2.setHints();
					}
				}
				if(panel1.c==0)					// if warning is OFF delete blue entries 
				{
					if((btn.getForeground())==Color.BLUE)	
					{
						panel2.rem++;panel2.com=81-panel2.rem;
						panel2.comlabel.setText("Points Completed : "+panel2.com+"    ");
						panel2.remlabel.setText("Points Remaining : "+panel2.rem+"    ");
						panel2.comlabel.invalidate();panel2.comlabel.invalidate();
					}
					btn.setForeground(Color.BLUE);
					btn.setFont(MouseEntryEvent.font);
					btn.setText(" ");
					btn.invalidate();
					URL url=MouseEntryEvent.class.getResource("audio/delete.wav");
					clip=Applet.newAudioClip(url);
					clip.play();
					panel2.ans[x]=0;			// value from the button has been deleted
					panel2.setHints();
				}
				if(panel1.h==0)					// if hints are OFF then delete pencil marks
				{
					if((btn.getForeground())==Color.GRAY)
					{
						btn.setForeground(Color.BLUE);
						btn.setFont(MouseEntryEvent.font);
						btn.setText(" ");
						btn.invalidate();
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
			btn.setForeground(Color.GRAY);
			btn.setFont(MouseEntryEvent.font);
			btn.setText(Integer.toString(panel2.selected));
			btn.invalidate();
			URL url=MouseEntryEvent.class.getResource("audio/pencil.wav");
			clip=Applet.newAudioClip(url);
			clip.play();
			panel2.ans[x]=panel2.selected;
		}
	}
	
}