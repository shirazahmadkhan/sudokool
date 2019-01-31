import javax.swing.*;
import java.util.TimerTask;

class timer extends Thread
{	
	static int sec;
	static int min;
	static int hr;
	public void run() 
	{	
		while(true)	
		{		
			if(sec<10)
			panel1.time.setText(hr+":"+min+":0"+sec);
			else
			panel1.time.setText(hr+":"+min+":"+sec);
			panel1.time.invalidate();
			try
			{
				sleep(1000);
				sec+=1;
			if(sec==60)
				{
					min++;
					sec=0;
				}
			if(min==60)
				{
					hr++;
					min=0;
				}
		
			}
			catch(InterruptedException e)
			{}
			
		}
	}	
}
