import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Prefs 
{

	public static final int FRAME_SIZE = 1;
	public static final int WARNING_ON_OFF = 2;
	public static final int SIMPLE_PUZZLE_GENERATED=3;
	public static final int SIMPLE_PUZZLE_COMPLETED=4;
	public static final int SIMPLE_PUZZLE_TIME=5;
	public static final int EASY_PUZZLE_GENERATED=6;
	public static final int EASY_PUZZLE_COMPLETED=7;
	public static final int EASY_PUZZLE_TIME=8;
	public static final int MEDIUM_PUZZLE_GENERATED=9;
	public static final int MEDIUM_PUZZLE_COMPLETED=10;
	public static final int MEDIUM_PUZZLE_TIME=11;
	public static final int HARD_PUZZLE_GENERATED=12;
	public static final int HARD_PUZZLE_COMPLETED=13;
	public static final int HARD_PUZZLE_TIME=14;
	
	ArrayList<String> prefs = new ArrayList<String>(); 
		
	public Prefs()
	{
		try 
		{
			BufferedReader in = new BufferedReader(new FileReader("library/settings.dat"));
			while(in.ready())
			{
				prefs.add(in.readLine());
			}
			
		} 
		// if file not found create one
		catch (FileNotFoundException e) 
		{
			BufferedWriter out;
			try 
			{
				out = new BufferedWriter(new FileWriter("library/settings.dat"));
				out.write("463x608");
				prefs.add("463x608");
				for(int x=1;x<=14;x++)
				{
					out.newLine();
					out.write("0");
					prefs.add("0");
				}
				
				out.close();
			} 
			catch (IOException e1) 
			{
				e1.printStackTrace();
			}
			
		} 
		catch (IOException e1) 
		{
			e1.printStackTrace();
		}
				
	}
	
	public void setPref(int x, String val)
	{
		int count = 0;
		prefs.set((x-1),val);
		try 
		{
			BufferedWriter out =new BufferedWriter(new FileWriter("library/settings.dat"));
			while(prefs.size() != count)
			{
				out.write(prefs.get(count));
				out.newLine();
				count++;
			}
			out.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
				
	}
	
	public String getPref(int y)
	{
		String read = prefs.get(y-1); 
		return read;
	}
	
	public int[] getTime(int time )
	{
		int[] time_out=new int[3];
		time_out[0] = (int)(time/3600);
		time = time - (time_out[0]*3600);
		time_out[1] = (int) (time/60);
		time = time - (time_out[1]*60);
		time_out[2] = (int)time;
		return time_out;
	}
	
	public int getTimeInSeconds(int[] time)
	{
		return ((time[0] * 3600) + (time[1] *60) + time[2]);
	}
}

