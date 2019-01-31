import java.io.*;
import javax.swing.*;
import java.awt.*;

 class highscores 
 {
	double[] hour=new double[4];
	double[] minute=new double[4];
	double[] second=new double[4];
	String[] name=new String[4];
public void writeFile(int hr,int min,int sec,int level) 
{
	int i=0;
	int position=0;
	double one=0.00,two=0.00,three=0.00,input=0.00;
	String str="";
	String newstr="";
	name[0]="";name[1]="";name[2]="";name[3]="";
	try{
		try			//reading previous highscores
		{
			
			FileReader fileIp=new FileReader("library/hscr.dat");
			while (i!=-1) 
 			{
				i=fileIp.read();
				str=str+((char)(i+16));
				
			}
		}catch(Exception inp) //if highscore file does not exist create one
		{
			FileOutputStream fileOptmp = new FileOutputStream ("library/hscr.dat");
			PrintWriter pwtmp = new PrintWriter(fileOptmp);
			System.out.println("file does not exist .. writing new hsrc.dat");
			str="99999.00000000.99999.00000000.99999.00000000." +
				"99999.00000000.99999.00000000.99999.00000000." +
				"99999.00000000.99999.00000000.99999.00000000." +
				"99999.00000000.99999.00000000.99999.00000000";
			char[] tmp=str.toCharArray();
			for(i=0;i<tmp.length;i++)
			tmp[i]=(char)((int)tmp[i]-16);
			pwtmp.print(tmp);
			pwtmp.close();

		}
//		System.out.println(str);
		FileOutputStream fileOp = new FileOutputStream ("library/hscr.dat");
		PrintWriter pw = new PrintWriter(fileOp);
		if(level==2)
		position=45;
		if(level==3)
		position=90;
		if(level==4)
		position=135;
		int index=position;

		for(i=0;i<=2;i++)
		{
			hour[i]=Character.getNumericValue(str.charAt(index++));
			String temp=(String.valueOf(Character.getNumericValue(str.charAt(index++))))+(String.valueOf(Character.getNumericValue(str.charAt(index++))));
			minute[i]=Integer.parseInt(temp);
			temp=(String.valueOf(Character.getNumericValue(str.charAt(index++))))+(String.valueOf(Character.getNumericValue(str.charAt(index++))));
			second[i]=Integer.parseInt(temp);
			index++;  // for escaping "." 
			for(int x=0;x<8;x++)
			{
				name[i]=name[i]+str.charAt(index++);
			}
			index++;  // for escaping "."
		}
		hour[3]=hr;minute[3]=min;second[3]=sec;
		one=(hour[0]*60+minute[0]+second[0]/60);
		two=(hour[1]*60+minute[1]+second[1]/60);
		three=(hour[2]*60+minute[2]+second[2]/60);
		input=(hour[3]*60+minute[3]+second[3]/60);
		if(input<one) swapwith(0);
		if((input<two)&&(input>one)) swapwith(1);
		if((input<three)&&(input>two)) swapwith(2);
		index=0;
		
		while(index!=179)
		{
			if(index!=position)
			newstr=newstr+str.charAt(index++);
			else
			if(index==position)
			for(i=0;i<3;i++)
			{
				newstr=newstr+String.valueOf((int)hour[i]);index++;
				if(minute[i]<10)
				{newstr=newstr+String.valueOf(0)+String.valueOf((int)minute[i]);}
				else
				if(minute[i]>9)
				{newstr=newstr+String.valueOf((int)minute[i]);}
				index=index+2;
				if(second[i]<10)
				{newstr=newstr+String.valueOf(0)+String.valueOf((int)second[i]);}
				else
				if(second[i]>9)
				{newstr=newstr+String.valueOf((int)second[i]);}
				index=index+3;
				if((index!=170))
				{
					newstr=newstr+".";
					newstr=newstr+name[i];
					index=index+9;
					newstr=newstr+".";
				}
				else
				{
					newstr=newstr+".";
					newstr=newstr+name[i];
					index=index+8;
				}
			}
		}

		char[] c = newstr.toCharArray();
		for(i =0;i<c.length;i++)
		{
			c[i] = (char)((int)c[i]-16);
			
		} 
		pw.print(c);
		pw.close();
//		System.out.println(newstr);
	}catch(Exception e){
		e.printStackTrace();
	}
}


public void swapwith(int a)
{
	double temp=0;
	temp=hour[a];hour[a]=hour[3];hour[3]=temp;
	temp=minute[a];minute[a]=minute[3];minute[3]=temp;
	temp=second[a];second[a]=second[3];second[3]=temp;
	name[3]= JOptionPane.showInputDialog(panel1.panel2obj," Please input your name (8 Chars)","New Fastest Timing",JOptionPane.INFORMATION_MESSAGE);
	if(name[3].length() > 8)
	{
		name[3]=name[3].substring(0,8);
	}
	else 
		if(name[3].length() < 8)
		{
			for(int j=0;j<=(8-name[3].length());j++)
			{
				name[3]=name[3].concat("0");
			}
		}
	String temps="";
	temps = name[a];
	name[a] = name[3];
	name[3] = temps;
}

public void readFile(frame frameobj) 
{
	int i=0,index=0;
	int[] hr=new int[12];
	int[] min=new int[12];
	int[] sec=new int[12];
	String[] nm=new String[12];
	for(int j=0;j<12;j++) nm[j]="";
	JLabel timea1=new JLabel(" ");JLabel timeb1=new JLabel(" ");JLabel timec1=new JLabel(" ");
	JLabel timed1=new JLabel(" ");JLabel timee1=new JLabel(" ");JLabel timef1=new JLabel(" ");
	JLabel timeg1=new JLabel(" ");JLabel timeh1=new JLabel(" ");JLabel timei1=new JLabel(" ");
	JLabel timej1=new JLabel(" ");JLabel timek1=new JLabel(" ");JLabel timel1=new JLabel(" ");
	JLabel timea2=new JLabel(" ");JLabel timeb2=new JLabel(" ");JLabel timec2=new JLabel(" ");
	JLabel timed2=new JLabel(" ");JLabel timee2=new JLabel(" ");JLabel timef2=new JLabel(" ");
	JLabel timeg2=new JLabel(" ");JLabel timeh2=new JLabel(" ");JLabel timei2=new JLabel(" ");
	JLabel timej2=new JLabel(" ");JLabel timek2=new JLabel(" ");JLabel timel2=new JLabel(" ");
	
	String str="";
	try{
	FileInputStream fileObj = new FileInputStream("library/hscr.dat");

	while (i!=-1) 
 	{
			i=fileObj.read();
			str=str+((char)(i+16));
				
	}
	//working on the high score frame

	
	for(i=0;i<12;i++)
	{
		hr[i]=Character.getNumericValue(str.charAt(index++));
		String temp=(String.valueOf(Character.getNumericValue(str.charAt(index++))))+(String.valueOf(Character.getNumericValue(str.charAt(index++))));
		min[i]=Integer.parseInt(temp);
		temp=(String.valueOf(Character.getNumericValue(str.charAt(index++))))+(String.valueOf(Character.getNumericValue(str.charAt(index))));
		sec[i]=Integer.parseInt(temp);
		index=index+2;
		if(index!= 171)
		{
			for(int j=0;j<8;j++)
			{
				if(str.charAt(index) =='0')
				{
					nm[i]=nm[i]+" ";
				}
				else
				{
					nm[i]=nm[i]+str.charAt(index);
				}
				index++;
			}
			index=index+1;
		}
		else
		{
			for(int j=0;j<8;j++)
			{
				if(str.charAt(index) =='0')
				{
					nm[i]=nm[i]+" ";
				}
				else
				{
					nm[i]=nm[i]+str.charAt(index);
				}
				index++;
			}
		}
	}
	
	if(hr[0]==9)
	{timea1.setText("   1.   "+nm[0]);timea2.setText("        0:00:00");}
	else
	{timea1.setText("   1.   "+nm[0]);timea2.setText("        "+String.valueOf(hr[0])+":"+String.valueOf(min[0])+":"+String.valueOf(sec[0]));}
	
	if(hr[1]==9)
	{timeb1.setText("   2.   "+nm[1]);timeb2.setText("        0:00:00");}
	else
	{timeb1.setText("   2.   "+nm[1]);timeb2.setText("        "+String.valueOf(hr[1])+":"+String.valueOf(min[1])+":"+String.valueOf(sec[1]));}
	
	if(hr[2]==9)
	{timec1.setText("   3.   "+nm[2]);timec2.setText("        0:00:00");}
	else
	{timec1.setText("   3.   "+nm[2]);timec2.setText("        "+String.valueOf(hr[2])+":"+String.valueOf(min[2])+":"+String.valueOf(sec[2]));}
	
	if(hr[3]==9)
	{timed1.setText("   1.   "+nm[3]);timed2.setText("        0:00:00");}
	else
	{timed1.setText("   1.   "+nm[3]);timed2.setText("        "+String.valueOf(hr[3])+":"+String.valueOf(min[3])+":"+String.valueOf(sec[3]));}
	
	if(hr[4]==9)
	{timee1.setText("   2.   "+nm[4]);timee2.setText("        0:00:00");}
	else
	{timee1.setText("   2.   "+nm[4]);timee2.setText("        "+String.valueOf(hr[4])+":"+String.valueOf(min[4])+":"+String.valueOf(sec[4]));}
	
	if(hr[5]==9)
	{timef1.setText("   3.   "+nm[5]);timef2.setText("        0:00:00");}
	else
	{timef1.setText("   3.   "+nm[5]);timef2.setText("        "+String.valueOf(hr[5])+":"+String.valueOf(min[5])+":"+String.valueOf(sec[5]));}
	
	if(hr[6]==9)
	{timeg1.setText("   1.   "+nm[6]);timeg2.setText("        0:00:00");}
	else
	{timeg1.setText("   1.   "+nm[6]);timeg2.setText("        "+String.valueOf(hr[6])+":"+String.valueOf(min[6])+":"+String.valueOf(sec[6]));}
	
	if(hr[7]==9)
	{timeh1.setText("   2.   "+nm[7]);timeh2.setText("        0:00:00");}
	else
	{timeh1.setText("   2.   "+nm[7]);timeh2.setText("        "+String.valueOf(hr[7])+":"+String.valueOf(min[7])+":"+String.valueOf(sec[7]));}
	
	if(hr[8]==9)
	{timei1.setText("   3.   "+nm[8]);timei2.setText("        0:00:00");}
	else
	{timei1.setText("   3.   "+nm[8]);timei2.setText("        "+String.valueOf(hr[8])+":"+String.valueOf(min[8])+":"+String.valueOf(sec[8]));}
	
	if(hr[9]==9)
	{timej1.setText("   1.   "+nm[9]);timej2.setText("        0:00:00");}
	else
	{timej1.setText("   1.   "+nm[9]);timej2.setText("        "+String.valueOf(hr[9])+":"+String.valueOf(min[9])+":"+String.valueOf(sec[9]));}
	
	if(hr[10]==9)
	{timek1.setText("   2.   "+nm[10]);timek2.setText("        0:00:00");}
	else
	{timek1.setText("   2.   "+nm[10]);timek2.setText("        "+String.valueOf(hr[10])+":"+String.valueOf(min[10])+":"+String.valueOf(sec[10]));}
	
	if(hr[11]==9)
	{timel1.setText("   3.   "+nm[11]);timel2.setText("        0:00:00");}
	else
	{timel1.setText("   3.   "+nm[11]);timel2.setText("        "+String.valueOf(hr[11])+":"+String.valueOf(min[11])+":"+String.valueOf(sec[11]));}
	
	JFrame record_frame=new JFrame();
	JTabbedPane panel=new JTabbedPane();
	JPanel panel1 = new JPanel(); 
	JPanel panel2 = new JPanel();
	record_frame.setIconImage(new ImageIcon(highscores.class.getResource("images/top.png")).getImage());
	Point p=frameobj.getLocationOnScreen();
	p.translate((frameobj.getWidth()-250)/2,80);
	record_frame.setLocation(p);
	record_frame.setResizable(false);
	record_frame.setTitle("Records");
	panel1.setLayout(new GridLayout(16,2));
	panel1.add(new JLabel("      SIMPLE :"));panel1.add(new JLabel(" "));
	panel1.add(timea1);panel1.add(timea2);panel1.add(timeb1);panel1.add(timeb2);panel1.add(timec1);panel1.add(timec2);
	panel1.add(new JLabel("      EASY :"));panel1.add(new JLabel(" "));
	panel1.add(timed1);panel1.add(timed2);panel1.add(timee1);panel1.add(timee2);panel1.add(timef1);panel1.add(timef2);
	panel1.add(new JLabel("      MEDIUM :"));panel1.add(new JLabel(" "));
	panel1.add(timeg1);panel1.add(timeg2);panel1.add(timeh1);panel1.add(timeh2);panel1.add(timei1);panel1.add(timei2);
	panel1.add(new JLabel("      HARD :"));panel1.add(new JLabel(" "));
	panel1.add(timej1);panel1.add(timej2);panel1.add(timek1);panel1.add(timek2);panel1.add(timel1);panel1.add(timel2);
	
	panel2.setLayout(new GridLayout(20,0));
	int num_simple = Integer.parseInt(frame.pref.getPref(Prefs.SIMPLE_PUZZLE_COMPLETED));
	int tot_time_simple = Integer.parseInt(frame.pref.getPref(Prefs.SIMPLE_PUZZLE_TIME));
	int avg=0;
	if( num_simple != 0) 
	avg = tot_time_simple / num_simple;
	int[] tm = new int[3];
	tm = frame.pref.getTime(avg);
	panel2.add(new JLabel("      SIMPLE :"));
	panel2.add(new JLabel("    Puzzles generated 		" + frame.pref.getPref(Prefs.SIMPLE_PUZZLE_GENERATED)));
	panel2.add(new JLabel("    Puzzles completed 		" + frame.pref.getPref(Prefs.SIMPLE_PUZZLE_COMPLETED)));
	panel2.add(new JLabel("    Avg puzzle completion time " + tm[0]+":"+tm[1]+":"+tm[2]));
	
	int num_easy = Integer.parseInt(frame.pref.getPref(Prefs.EASY_PUZZLE_COMPLETED));
	int tot_time_easy = Integer.parseInt(frame.pref.getPref(Prefs.EASY_PUZZLE_TIME));
	avg=0;
	if( num_easy != 0) 
	avg = tot_time_easy / num_easy;
	tm = frame.pref.getTime(avg);
	panel2.add(new JLabel("      EASY :"));
	panel2.add(new JLabel("    Puzzles generated 		" + frame.pref.getPref(Prefs.EASY_PUZZLE_GENERATED)));
	panel2.add(new JLabel("    Puzzles completed 		" + frame.pref.getPref(Prefs.EASY_PUZZLE_COMPLETED)));
	panel2.add(new JLabel("    Avg puzzle completion time " + tm[0]+":"+tm[1]+":"+tm[2]));

	int num_medium = Integer.parseInt(frame.pref.getPref(Prefs.MEDIUM_PUZZLE_COMPLETED));
	int tot_time_medium = Integer.parseInt(frame.pref.getPref(Prefs.MEDIUM_PUZZLE_TIME));
	avg=0;
	if( num_medium != 0) 
	avg = tot_time_medium / num_medium;
	tm = frame.pref.getTime(avg);
	panel2.add(new JLabel("      MEDIUM :"));
	panel2.add(new JLabel("    Puzzles generated		 " + frame.pref.getPref(Prefs.MEDIUM_PUZZLE_GENERATED)));
	panel2.add(new JLabel("    Puzzles completed 		 " + frame.pref.getPref(Prefs.MEDIUM_PUZZLE_COMPLETED)));
	panel2.add(new JLabel("    Avg puzzle completion time " + tm[0]+":"+tm[1]+":"+tm[2]));
	
	int num_hard = Integer.parseInt(frame.pref.getPref(Prefs.HARD_PUZZLE_COMPLETED));
	int tot_time_hard = Integer.parseInt(frame.pref.getPref(Prefs.HARD_PUZZLE_TIME));
	avg=0;
	if( num_hard != 0) 
	avg = tot_time_hard / num_hard;
	tm = frame.pref.getTime(avg);
	panel2.add(new JLabel("      HARD :"));
	panel2.add(new JLabel("    Puzzles generated		 " + frame.pref.getPref(Prefs.HARD_PUZZLE_GENERATED)));
	panel2.add(new JLabel("    Puzzles completed 		 " + frame.pref.getPref(Prefs.HARD_PUZZLE_COMPLETED)));
	panel2.add(new JLabel("    Avg puzzle completion time " + tm[0]+":"+tm[1]+":"+tm[2]));
	
	int num_total = num_simple + num_easy + num_medium + num_hard;
	int tot_time_total = tot_time_simple + tot_time_easy + tot_time_medium + tot_time_hard;
	tm = frame.pref.getTime(tot_time_total);
	int tot_generated = Integer.parseInt(frame.pref.getPref(3)) +Integer.parseInt(frame.pref.getPref(6))+
	Integer.parseInt(frame.pref.getPref(9)) + Integer.parseInt(frame.pref.getPref(12));
	panel2.add(new JLabel("      TOTAL :"));
	panel2.add(new JLabel("    Total puzzles generated 		" + tot_generated));
	panel2.add(new JLabel("    Total puzzles completed 		" + num_total));
	panel2.add(new JLabel("    Total time played  " + tm[0]+":"+tm[1]+":"+tm[2]));
	
	
	panel.addTab("Best Timings",panel1);
	panel.addTab("Statistics",panel2);
		
	record_frame.getContentPane().add(panel);
	record_frame.setSize(275,500);
	record_frame.setVisible(true);
	
	}catch(Exception e)
	{
		try{
			e.printStackTrace();
			FileOutputStream fileOptmp = new FileOutputStream ("library/hscr.dat");
			PrintWriter pwtmp = new PrintWriter(fileOptmp);
			System.out.println("file does not exist .. writing new hsrc.dat");
			str="99999.00000000.99999.00000000.99999.00000000." +
				"99999.00000000.99999.00000000.99999.00000000." +
				"99999.00000000.99999.00000000.99999.00000000." +
				"99999.00000000.99999.00000000.99999.00000000";
			char[] tmp=str.toCharArray();
			for(i=0;i<tmp.length;i++)
			tmp[i]=(char)((int)tmp[i]-16);
			pwtmp.print(tmp);
			pwtmp.close();
		}catch(Exception eee){	}
//		JOptionPane.showMessageDialog(frameobj,"The Records File does not exist","File IO Error",JOptionPane.ERROR_MESSAGE);
		e.printStackTrace();
	}
	
}

}
