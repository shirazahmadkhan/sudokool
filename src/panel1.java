import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.net.*;
import java.lang.String;
import java.io.*;

class panel1 extends JPanel 
{	
	String filename="";
	frame frameobj;
	static panel2 panel2obj;
	static int c=1;//for warn checking
	static int d=0;//for pause
	static int f=0;//for custom game
	static int g=0;//for show solution  and controlling hints display
	static int h=0;//for hints
	static int p=0;//for play again
	static int[] ques=new int[81];
	static JLabel time=new JLabel("0:0:0");
	static JRadioButton one=new JRadioButton("1");
	static JRadioButton two=new JRadioButton("2");
	static JRadioButton three=new JRadioButton("3");
	static JRadioButton four=new JRadioButton("4");
	static JRadioButton five=new JRadioButton("5");
	static JRadioButton six=new JRadioButton("6");
	static JRadioButton seven=new JRadioButton("7");
	static JRadioButton eight=new JRadioButton("8");
	static JRadioButton nine=new JRadioButton("9");
	ButtonGroup nos=new ButtonGroup();
	ImageIcon warnon=new ImageIcon(panel1.class.getResource("pics/waron.png"));
	ImageIcon warnoff=new ImageIcon(panel1.class.getResource("pics/waroff.png"));
	ImageIcon helpicon=new ImageIcon(panel1.class.getResource("pics/help.png"));
	ImageIcon pause=new ImageIcon(panel1.class.getResource("pics/pause.png"));
	ImageIcon hintson=new ImageIcon(panel1.class.getResource("pics/hintson.png"));
	ImageIcon hintsoff=new ImageIcon(panel1.class.getResource("pics/hintsoff.png"));
	ImageIcon resume=new ImageIcon(panel1.class.getResource("pics/play.png"));
	ImageIcon warn=warnon;
	ImageIcon paused=new ImageIcon(panel1.class.getResource("pics/paused.gif"));
	ImageIcon customicon=new ImageIcon(panel1.class.getResource("pics/custom.png"));
	ImageIcon verifyicon=new ImageIcon(panel1.class.getResource("pics/verify.png"));
	ImageIcon new3=new ImageIcon(panel1.class.getResource("pics/new.png"));
	ImageIcon pagain=new ImageIcon(panel1.class.getResource("pics/atlantik.png"));
	ImageIcon highscr=new ImageIcon(panel1.class.getResource("pics/high.png"));
	ImageIcon icon=new ImageIcon(panel1.class.getResource("pics/clock.png"));
	ImageIcon showicon=new ImageIcon(panel1.class.getResource("pics/sol.png"));
	ImageIcon exiticon=new ImageIcon(panel1.class.getResource("pics/exit.png"));
	ImageIcon openicon=new ImageIcon(panel1.class.getResource("pics/open.png"));
	ImageIcon saveicon=new ImageIcon(panel1.class.getResource("pics/save.png"));
		
	JButton btn1=new JButton("New ",new3);
	JButton btn2=new JButton("Again",pagain);
	JButton btn3=new JButton("Pause",pause);
	JButton btn5=new JButton("Records",highscr);
	JButton btn6=new JButton("Solution",showicon);
	JButton btn7=new JButton(" Exit ",exiticon);
	JButton btn8=new JButton(" Warn ",warn);
	JButton btn9=new JButton("Help",helpicon);
	JButton btn10=new JButton("Load",openicon);
	JButton btn11=new JButton("Save",saveicon);
	JButton btn12=new JButton("Custom",customicon);
	JButton btn13=new JButton("Hints",hintsoff);
	
	public panel1(frame temp,panel2 pane2)
	{	
		btn1.setVerticalTextPosition(AbstractButton.BOTTOM);btn1.setHorizontalTextPosition(AbstractButton.CENTER);
		btn2.setVerticalTextPosition(AbstractButton.BOTTOM);btn2.setHorizontalTextPosition(AbstractButton.CENTER);
		btn3.setVerticalTextPosition(AbstractButton.BOTTOM);btn3.setHorizontalTextPosition(AbstractButton.CENTER);
		btn5.setVerticalTextPosition(AbstractButton.BOTTOM);btn5.setHorizontalTextPosition(AbstractButton.CENTER);
		btn6.setVerticalTextPosition(AbstractButton.BOTTOM);btn6.setHorizontalTextPosition(AbstractButton.CENTER);
		btn7.setVerticalTextPosition(AbstractButton.BOTTOM);btn7.setHorizontalTextPosition(AbstractButton.CENTER);
		btn8.setVerticalTextPosition(AbstractButton.BOTTOM);btn8.setHorizontalTextPosition(AbstractButton.CENTER);
		btn9.setVerticalTextPosition(AbstractButton.BOTTOM);btn9.setHorizontalTextPosition(AbstractButton.CENTER);
		btn10.setVerticalTextPosition(AbstractButton.BOTTOM);btn10.setHorizontalTextPosition(AbstractButton.CENTER);
		btn11.setVerticalTextPosition(AbstractButton.BOTTOM);btn11.setHorizontalTextPosition(AbstractButton.CENTER);
		btn12.setVerticalTextPosition(AbstractButton.BOTTOM);btn12.setHorizontalTextPosition(AbstractButton.CENTER);
		btn13.setVerticalTextPosition(AbstractButton.BOTTOM);btn13.setHorizontalTextPosition(AbstractButton.CENTER);
		
		btn1.setFocusable(false);
		btn2.setFocusable(false);
		btn3.setFocusable(false);
		btn5.setFocusable(false);
		btn6.setFocusable(false);
		btn7.setFocusable(false);
		btn8.setFocusable(false);
		btn9.setFocusable(false);
		btn10.setFocusable(false);
		btn11.setFocusable(false);
		btn12.setFocusable(false);
		btn13.setFocusable(false);
		
		one.setFocusable(false);
		two.setFocusable(false);
		three.setFocusable(false);
		four.setFocusable(false);
		five.setFocusable(false);
		six.setFocusable(false);
		seven.setFocusable(false);
		eight.setFocusable(false);
		nine.setFocusable(false);
		
		frameobj=temp;
		panel2obj=pane2;
		one.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(one.isSelected())
				{	
					panel2.selected=1;
				}
			}	
		});
		two.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(two.isSelected())
				{	
					panel2.selected=2;
				}
			}	
		});
		three.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(three.isSelected())
				{	
					panel2.selected=3;
				}
			}	
		});
		four.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(four.isSelected())
				{	
					panel2.selected=4;
				}
			}	
		});
		five.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(five.isSelected())
				{	
					panel2.selected=5;
				}
			}	
		});
		six.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(six.isSelected())
				{	
					panel2.selected=6;
				}
			}	
		});
		seven.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(seven.isSelected())
				{	
					panel2.selected=7;
				}
			}	
		});
		eight.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(eight.isSelected())
				{	
					panel2.selected=8;
				}
			}	
		});
		nine.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				if(nine.isSelected())
				{	
					panel2.selected=9;
				}
			}	
		});
		

		JPanel panela=new JPanel();
		JPanel panelb=new JPanel();
		JPanel panelc=new JPanel();
		
		JLabel timeicon=new JLabel(icon);
		btn1.setToolTipText("New Puzzle");		btn1.setMnemonic(78);
		btn2.setToolTipText("Play Again");		btn2.setMnemonic(65);
		btn3.setToolTipText("Pause Game");		btn3.setMnemonic(80);
		btn5.setToolTipText("Records");			btn5.setMnemonic(82);
		btn6.setToolTipText("Show Solution");	btn6.setMnemonic(83);
		btn7.setToolTipText("Exit");			btn7.setMnemonic(88);
		if(Integer.parseInt(frame.pref.getPref(Prefs.WARNING_ON_OFF)) == 0)
		{
			btn8.setToolTipText("Warning Off");
			btn8.setIcon(warnoff);
			c = 0;
		}
		else
		{
			btn8.setToolTipText("Warning On");
			btn8.setIcon(warnon);
			c = 1;
		}
		btn8.setMnemonic(87);
		btn9.setToolTipText("Help");			btn9.setMnemonic(72);
		btn10.setToolTipText("Load Saved Puzzle");btn10.setMnemonic(79);
		btn11.setToolTipText("Save Puzzle");		btn11.setMnemonic(86);
		btn12.setToolTipText("Custom Puzzle");	btn12.setMnemonic(67);
		btn13.setToolTipText("Hints Off"); btn13.setMnemonic('I');
		btn1.setFocusPainted(false);btn2.setFocusPainted(false);
		btn3.setFocusPainted(false);
		btn5.setFocusPainted(false);btn6.setFocusPainted(false);
		btn7.setFocusPainted(false);btn8.setFocusPainted(false);
		btn9.setFocusPainted(false);btn10.setFocusPainted(false);
		btn11.setFocusPainted(false);btn12.setFocusPainted(false);
		btn13.setFocusPainted(false);
		
		btn13.addActionListener( new ActionListener()	//hints
		{
			public void actionPerformed(ActionEvent ee)
			{
				if(new2.diff !=0)
				{
					if(panel1.h==0)				
					{	
						btn13.setIcon(hintson);
						panel1.h=1;
						btn13.setToolTipText("Hints On");
						URL url=panel1.class.getResource("audio/hintson.wav");
						AudioClip clip=Applet.newAudioClip(url);
						clip.play();
					}
					else
					{   
						btn13.setIcon(hintsoff);
						panel1.h=0;
						btn13.setToolTipText("Hints Off");
						URL url=panel1.class.getResource("audio/hintsoff.wav");
						AudioClip clip=Applet.newAudioClip(url);
						clip.play();
					}
					
					panel2.setHints();
					btn13.invalidate();
				}
			}
		});
		btn5.addActionListener(new ActionListener()		//records
		{
			public void actionPerformed(ActionEvent ee)	
			{
				highscores hs=new highscores();
				hs.readFile(frameobj);
			}
		});
		btn11.addActionListener(new ActionListener()	//save game
		{
			public void actionPerformed(ActionEvent ee)
			{
				panel2obj.t.suspend();
				String data="";
				data = data + new2.diff;			// 	difficulty
				for(int tmp=0;tmp<81;tmp++)
				data=(data+panel2obj.ans[tmp]);	// 	filled data
				for(int tmp=0;tmp<81;tmp++)
				data=(data+panel2obj.q[tmp]);		// 	puzzle
				for(int tmp=0;tmp<81;tmp++)
				data=(data+panel2obj.s[tmp]);		//	solution
				if(timer.sec<10)					//	timer data
				data=(data+"0"+timer.sec);
				if(timer.sec>9)
				data=(data+timer.sec);
				if(timer.min<10)
				data=(data+"0"+timer.min);
				if(timer.min>9)
				data=(data+timer.min);
				data=data+timer.hr;
				byte[] byt=data.getBytes();
		
				try
				{
					filename="";
					JFileChooser save=new JFileChooser();
					save.setCurrentDirectory(new File("saves"));
					save.setSelectedFile(new File("Puzzle"));
					int result=save.showDialog(frameobj,"Save");
					if(result==JFileChooser.APPROVE_OPTION)
					{
						filename=save.getSelectedFile().getPath();
						FileOutputStream out=new FileOutputStream(filename);
						out.write(byt);
					}
				}
				catch(Exception ex)
				{ 
					JOptionPane.showMessageDialog(panel2obj,"There is some problem with file name","File IO Error",JOptionPane.ERROR_MESSAGE );
				}
				panel2obj.t.resume();
			}
		});
		
		btn10.addActionListener(new ActionListener()	//load game
		{
			public void actionPerformed(ActionEvent ee)
			{
				byte[] byt;
				String file="";
				int i=0,index=0;
				panel2obj.com=0;panel2obj.rem=0;
				try
				{
					filename="";
					JFileChooser open=new JFileChooser();
					open.setCurrentDirectory(new File("saves"));
					int result=open.showDialog(frameobj,"Load");
					if(result==JFileChooser.APPROVE_OPTION)
					{
						filename=open.getSelectedFile().getPath();
					
					FileInputStream in=new FileInputStream(filename);
					byt = new byte[in.available()];
					in.read(byt);
					String data=new String(byt);
					new2.diff=Character.getNumericValue(data.charAt(index++));
//					System.out.println("Difficulty :"+new2.diff);
					for(i=0;i<81;i++)
					panel2obj.ans[i]=Character.getNumericValue(data.charAt(index++));
					for(i=0;i<81;i++)
					{
						panel2obj.q[i]=Character.getNumericValue(data.charAt(index++));
						readsudoku.prob[i]=panel2obj.q[i];						// handling the case when user clicks on play again
					}																// after loading a file
					for(i=0;i<81;i++)
					{
						panel2obj.s[i]=Character.getNumericValue(data.charAt(index++));
						readsudoku.sol[i]=panel2obj.s[i];						// handling the case when user clicks on play again
					}																// after loading a file
					panel2obj.t.stop();
					panel2obj.t=new timer();
					if(Character.getNumericValue(data.charAt(index))==0)
					{
						panel2obj.t.sec=Character.getNumericValue(data.charAt(++index));
						index=index+1;
					}
					else
					{
						String temp=(String.valueOf(Character.getNumericValue(data.charAt(index++))))+(String.valueOf(Character.getNumericValue(data.charAt(index++))));
					 	panel2obj.t.sec=Integer.parseInt(temp);
					 }
					if(Character.getNumericValue(data.charAt(index))==0)
					{
						panel2obj.t.min=Character.getNumericValue(data.charAt(++index));
						index=index+1;
					}
					else
					{
						String temp=(String.valueOf(Character.getNumericValue(data.charAt(index++))))+(String.valueOf(Character.getNumericValue(data.charAt(index++))));
					 	panel2obj.t.min=Integer.parseInt(temp);
					}
					panel2obj.t.hr=Character.getNumericValue(data.charAt(index));
		
					String str = "Shiraz's Sudokool V2.5 - ";
					if(new2.diff == 1)
					str= str +"Simple";
					if(new2.diff == 2)
					str= str +"Easy";
					if(new2.diff == 3)
					str= str +"Medium";
					if(new2.diff == 4)
					str= str +"Hard";
					frameobj.setTitle(str);
					
					panel2.loadEntries();
		 				
					panel2obj.rem=81-panel2obj.com;
					panel2obj.comlabel.setText("Points Completed : "+panel2obj.com+"    ");
					panel2obj.remlabel.setText("Points Remaining : "+panel2obj.rem+"    ");
					panel2obj.t.start();
					panel1.g=0;
					if(panel1.h==1)
					{
						panel2.setHints();
					}
				}
				}
				catch(Exception ex)
				{
					if(file!=null)
					JOptionPane.showMessageDialog(panel2obj,"Game "+filename+" does not exist","File IO Error",JOptionPane.ERROR_MESSAGE );
					ex.printStackTrace();
				}
			}
		});
		
		btn9.addActionListener(new ActionListener()		//help
		{
			public void actionPerformed(ActionEvent ee)
			{
				new help(panel2obj);
			}
		});
	
		btn12.addActionListener(new ActionListener ()	//custom game
		{
			JButton btn;
			public void actionPerformed(ActionEvent ee)
			{
				btn=btn12;
				if(f==0)				
				{
					p=1; 		// so that a new sudoku puzzle is not loaded when getPuzzle is called	
					g=1;		// so that user cannot view hints while entering puzzle
					f=1;
					JOptionPane.showMessageDialog(panel2obj,"Enter puzzle carefully and then verify it !!!","Custom Puzzle",JOptionPane.INFORMATION_MESSAGE );
					for(int tmp=0;tmp<81;tmp++)
					{
						panel2obj.btn[tmp].setText(" ");
						panel2obj.btn[tmp].setForeground(Color.BLUE);
						panel2obj.q[tmp]=0;panel2obj.s[tmp]=0;panel2obj.ans[tmp]=0;
					}
					panel2obj.t.stop();
					time.setText("0:00:00");
					panel2obj.t.hr=0;panel2obj.t.min=0;panel2obj.t.sec=0;
					btn.setIcon(verifyicon);
					btn12.setToolTipText("Verify");
					panel2obj.comlabel.setText("Points Completed : "+"    ");
					panel2obj.remlabel.setText("Points Remaining : "+"    ");
					panel2obj.repaint();
					// toggle warning button
					if(c==1)				
					{   
						btn8.setIcon(warnoff);
						c=0;
						btn8.setToolTipText("Warning Off");
						btn8.invalidate();
					}
				}
				else
				{   
					for(int x=0;x<81;x++)
					{
						if((panel2obj.btn[x].getText())==" ")
						ques[x]=0;
						else
						ques[x]=Integer.parseInt(panel2obj.btn[x].getText());
					}
					f=2;
					QQWing qq=new QQWing();
					qq.Generator();
			
					if(qq.puzzleSolved==0)
					JOptionPane.showMessageDialog(panel2obj,"Puzzle doesn't have a unique solution !!!"," Please enter correctly !!! ",JOptionPane.ERROR_MESSAGE);
					if(qq.puzzleSolved==1)
					{
						JOptionPane.showMessageDialog(panel2obj,"Puzzle verified !!! Start Playing !!!","Custom Game success",JOptionPane.INFORMATION_MESSAGE);
						for(int x=0;x<81;x++)
						{
								panel2obj.q[x]=ques[x];
								panel2obj.ans[x]=ques[x];
								panel2obj.s[x]=qq.solution[x];
								readsudoku.prob[x]=ques[x];
								readsudoku.sol[x]=qq.solution[x];
						}
			/*			int meow=0;
						for(int x=0;x<9;x++)
						{
							for(int y=0;y<9;y++)
							{
								System.out.print(panel2obj.s[meow]);
								meow++;
							}
							System.out.println();
						}
				*/		
						panel2obj.getPuzzle();
						panel2obj.t =new timer();
						panel2obj.t.start();
						btn12.setToolTipText("Custom Game");f=0;g=0;p=0;btn.setIcon(customicon);//if solvable
						
						String str = "Shiraz's Sudokool V2.5 - ";
						if(new2.diff == 1)
						str= str +"Simple";
						if(new2.diff == 2)
						str= str +"Easy";
						if(new2.diff == 3)
						str= str +"Medium";
						if(new2.diff == 4)
						str= str +"Hard";
						frameobj.setTitle(str);
						frameobj.invalidate();
						// toggle back the warning button
						if(c==0)				
						{   
							btn8.setIcon(warnon);
							c=1;
							btn8.setToolTipText("Warning On");
							btn8.invalidate();
						}
					}
					
				}
					btn12.invalidate();
					panel2.btn[0].requestFocus();
			}
		});
		btn1.addActionListener(new ActionListener() //new button
		{
			public void actionPerformed(ActionEvent e)
			{
				if((f==1)||(f==2))			//user didn't finish entering the puzzle successfully previously
				{
					btn12.setToolTipText("Custom Game");f=0;btn12.setIcon(customicon);		// reset the custom game buttons
					// toggle back the warning button
					if(c==0)				
					{   
						btn8.setIcon(warnon);
						c=1;
						btn8.setToolTipText("Warning On");
						btn8.invalidate();
					}
				}
				JDialog dialog=new new2(frameobj,panel2obj,panel1.this);
				dialog.show();
			}
		});
		
		btn7.addActionListener(new ActionListener() //exit button
		{
			public void actionPerformed(ActionEvent e)
			{

				String x=String.valueOf(frameobj.getWidth());
				String y=String.valueOf(frameobj.getHeight());
				String size=x+'x'+y;
				frame.pref.setPref(Prefs.FRAME_SIZE,size);
				frame.pref.setPref(Prefs.WARNING_ON_OFF,Integer.toString(c));
				System.exit(0);
			}
		});
		btn8.addActionListener(new ActionListener() //warning on - off
		{	
			JButton btn;
			public void actionPerformed(ActionEvent e)
			{	
				btn=btn8;
				if(c==0)				
				{	btn.setIcon(warnon);
					c=1;
					panel2.loadEntries();
					panel2.setHints();
					btn8.setToolTipText("Warning On");
				}
				else
				{   btn.setIcon(warnoff);
					c=0;
					panel2.loadEntries();
					panel2.setHints();
					btn8.setToolTipText("Warning Off");
				}
				btn8.invalidate();
			}
		});
		btn2.addActionListener(new ActionListener() //play again
		{
			public void actionPerformed(ActionEvent e)
			{	
				if(f!=1)							// if not in intermediate state of entering custom game
				{
					panel1.p = 1;
					URL url=panel1.class.getResource("audio/start.wav");
					AudioClip clip=Applet.newAudioClip(url);
					clip.play();
					if(panel2obj.t.isAlive())
					{
						panel2obj.t.hr=0;panel2obj.t.min=0;panel2obj.t.sec=0;
					}
					panel2obj.t.resume();
					panel2obj.getPuzzle();
					g=0;
					panel1.p=0;
				}
			}
		});
		btn3.addActionListener(new ActionListener()//pause - resume
		{
			JButton btn;
			public void actionPerformed(ActionEvent e)
			{
				btn=btn3;
				URL url=panel1.class.getResource("audio/camera.wav");
				AudioClip clip=Applet.newAudioClip(url);
				clip.play();
				if(d==0)
				{
					panel2obj.t.suspend();d=1;btn.setIcon(resume);
					btn.setToolTipText("Resume Game");
					panel2obj.setVisible(false);
					panel2obj.removeAll();
					panel2obj.setLayout(new BorderLayout());
					panel2obj.add(new JLabel(paused));
					panel2obj.setPreferredSize(new Dimension(paused.getIconWidth(),paused.getIconHeight()));
					panel2obj.setVisible(true);
				}
				else
				{
					panel2obj.t.resume();d=0;btn.setIcon(pause);
					btn.setToolTipText("Pause Game");
					panel2obj.setVisible(false);
					panel2obj.removeAll();
					panel2obj.paintagain();		
					panel2obj.setVisible(true);
				}
				panel2.btn[0].requestFocus();
			}
		});
		btn6.addActionListener(new ActionListener() // show solution
		{
			public void actionPerformed(ActionEvent e)
			{
				int tmpy=0;
				for(int tmpx=0;tmpx<81;tmpx++)
				if(panel2obj.s[tmpx]==0) 
					tmpy++;
				if(tmpy!=81)
				{
					URL url=panel1.class.getResource("audio/chimes.wav");
					AudioClip clip=Applet.newAudioClip(url);
					clip.play();
					for(int i=0;i<81;i++)
					{
						panel2obj.btn[i].removeAll();
						if(panel2obj.btn[i].getForeground() == Color.RED)
							panel2obj.btn[i].setForeground(Color.BLUE);
						panel2obj.btn[i].setFont(MouseEntryEvent.font);
						panel2obj.btn[i].setText(Integer.toString(panel2obj.s[i]));
						panel2obj.btn[i].invalidate();
						panel2obj.t.suspend();
					}
					panel2obj.comlabel.setText("Points completed :      ");
					panel2obj.remlabel.setText("Points remaining :      ");
					g=1;
				}
			}
		});
		
		setLayout(new BorderLayout());
		JToolBar toolbar=new JToolBar();
		JToolBar toolbar2=new JToolBar();
		toolbar.add(btn3);
		toolbar.add(btn13);
		toolbar.add(btn8);
		toolbar.add(btn2);
		toolbar.add(btn6);
		toolbar.add(btn5);
		toolbar.add(btn9);
		toolbar.add(btn7);
		toolbar2.add(btn1);
		toolbar2.add(btn10);
		toolbar2.add(btn11);
		toolbar2.add(btn12);
		panela.setLayout(new BorderLayout());
		panela.add(toolbar2,BorderLayout.NORTH);
		panela.add(toolbar,BorderLayout.SOUTH);
		nos.add(one);nos.add(two);nos.add(three);
		nos.add(four);nos.add(five);nos.add(six);
		nos.add(seven);nos.add(eight);nos.add(nine);
		panelb.add(one);panelb.add(two);panelb.add(three);panelb.add(four);
		panelb.add(five);panelb.add(six);panelb.add(seven);panelb.add(eight);
		panelb.add(nine);
		panelc.add(timeicon);
		panelc.add(time);
		add(panela,BorderLayout.NORTH);
		add(panelb,BorderLayout.CENTER);
		add(panelc,BorderLayout.SOUTH);
		
	}
	
}



class new2 extends JDialog
{		
	static int diff=0;			// difficulty level 1:simple, 2: easy, 3: medium, 4:hard

	ImageIcon simple=new ImageIcon(panel1.class.getResource("pics/simple.png"));
	ImageIcon easy=new ImageIcon(panel1.class.getResource("pics/easy.png"));
	ImageIcon medium=new ImageIcon(panel1.class.getResource("pics/medium.png"));
	ImageIcon hard=new ImageIcon(panel1.class.getResource("pics/hard.png"));
	JButton bsimple=new JButton(simple);
	JButton beasy=new JButton(easy);
	JButton bmedium=new JButton(medium);
	JButton bhard=new JButton(hard);

	frame owner2;
	panel2 paneb;
	panel1 panea;
	
	public new2(frame owner,panel2 pane2,panel1 pane1)
	{	
		owner2=owner;
		paneb=pane2;
		panea=pane1;
		if(paneb.t.isAlive())
		{	
			paneb.t.suspend();
		}
		setTitle("Select a difficulty level");

		Container contentpane=getContentPane();
		contentpane.setLayout(new BorderLayout());
		ButtonGroup group=new ButtonGroup();
		JPanel panel11=new JPanel();
		panel11.setLayout(new BorderLayout());
		group.add(bsimple);group.add(beasy);group.add(bmedium);group.add(bhard);
	
		JPanel panel22=new JPanel();
		panel22.setLayout(new GridLayout(2,4));
		panel22.add(bsimple);panel22.add(beasy);panel22.add(bmedium);panel22.add(bhard);
		panel22.add(new JLabel("        Simple"));panel22.add(new JLabel("        Easy"));
		panel22.add(new JLabel("        Medium"));panel22.add(new JLabel("        Hard"));	
				

		contentpane.add(panel11,BorderLayout.PAGE_START);
		contentpane.add(panel22,BorderLayout.CENTER);
	
		
		bsimple.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
					diff=1;
					callAction();
			}
		});
		beasy.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
					diff=2;	
					callAction();
			}
		});
		bmedium.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
					diff=3;
					callAction();
			}
		});
		bhard.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{	
					diff=4;
					callAction();
			}
		});
		owner2.setIconImage(new ImageIcon(getClass().getResource("pics/top.png")).getImage());
		setSize(400,200);
		Point p=paneb.getLocationOnScreen();
		p.translate((paneb.getWidth()-400)/2,45);
		setLocation(p);
		addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                
                if(paneb.t.isAlive())
				{	
					paneb.t.resume();
					panea.p=0;panea.g=0;
				}
            }
        });
		panel2.btn[40].requestFocus();
		
	}
	public void callAction()
	{
		if (diff!=0) 
		{
			if((panea.f==1)||(panea.f==2))
			{
				panea.btn12.setToolTipText("Custom Game");panea.f=0;
				panea.btn12.setIcon(panea.customicon);
				paneb.t.suspend();
				paneb.t.hr=0;paneb.t.min=0;paneb.t.sec=0;
				paneb.t.resume();
				
			}
			else
			{
				for(int i=0;i<81;i++)
				{
					paneb.s[i]=0;paneb.q[i]=0;
				}
			}
			panea.g=0;
			paneb.repaint();
			
			new2.this.setVisible(false);
			Indeterminate indeter = new Indeterminate(paneb);
			String str = "Shiraz's Sudokool V2.5 - ";
			if(new2.diff == 1)
			str= str +"Simple";
			if(new2.diff == 2)
			str= str +"Easy";
			if(new2.diff == 3)
			str= str +"Medium";
			if(new2.diff == 4)
			str= str +"Hard";
			owner2.setTitle(str);
			owner2.invalidate();
			int puzzle_old_num = Integer.parseInt(frame.pref.getPref(diff*3));
			puzzle_old_num++;
			frame.pref.setPref(diff*3,Integer.toString(puzzle_old_num));
						
		}	
	}
}
