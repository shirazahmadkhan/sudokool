import javax.swing.*;
import java.awt.*;


class panel2 extends JPanel 
{	
	
	static JButton[] btn=new JButton[81];
	static int[] q=new int[81];
	static int[] s=new int[81];
	static int[] ans=new int[81];			// storing the user response
	static public int selected;				// selected radio button
	static int com=0,rem=0;
	static JLabel comlabel=new JLabel("Points completed :      ");
	static JLabel remlabel=new JLabel("Points remaining :      ");
	timer t=new timer();
	Color colour=new Color(0,0,255);
	public panel2()
	{	
		setLayout(new BorderLayout());
		JPanel paneone=new JPanel();
		JPanel panetwo=new JPanel();
		paneone.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		paneone.setLayout(new GridLayout(9,9,4,4));
		for(int i=0;i<81;i++)
		{
			btn[i]=new JButton(" ");
			btn[i].setForeground(Color.BLACK);
			paneone.add(btn[i]);
			btn[i].addMouseListener(new MouseEntryEvent(btn[i],i));
			btn[i].addKeyListener(new KeyboardEvent(btn[i],i));
		}

		panetwo.setLayout(new FlowLayout());
		panetwo.add(comlabel);
		panetwo.add(remlabel);
		add(paneone,BorderLayout.CENTER);
		add(panetwo,BorderLayout.SOUTH);

	}
	
	public void getPuzzle()			//	function called from new2 of panel1 when new puzzle is generated
	{	
		com=0;rem=0;
		if(new2.diff!=0)
		{
			if(panel1.p !=1)
			{
				new readsudoku();
			}
			for(int z=0;z<81;z++)
			{
	
				q[z]=readsudoku.prob[z];
				ans[z]=readsudoku.prob[z];
	 			s[z]=readsudoku.sol[z];
		 	}
			
		 loadEntries();
		 setHints();
		 rem=81-com;
		 comlabel.setText("Points Completed : "+com+"    ");
		 remlabel.setText("Points Remaining : "+rem+"    ");
		 }
		 repaint();
	}
	
	public void paintagain()
	{
		com=0;rem=0;
		setLayout(new BorderLayout());
		JPanel paneone=new JPanel();
		JPanel panetwo=new JPanel();
		comlabel.setText("Points completed:"+com+"    ");
		remlabel.setText("Points remaining:"+rem+"    ");
		paneone.setBorder(BorderFactory.createLineBorder(Color.BLUE,3));
		paneone.setLayout(new GridLayout(9,9,4,4));
		for(int i=0;i<81;i++)
		 {	
		  	if(ans[i] !=0 )
		 	{
		 		if(panel1.c==1)
		 		{
		 			if((ans[i]==s[i]) && ((btn[i].getForeground())!=Color.GRAY))
		 			com++;
		 		}
		 		if(panel1.c==0)
		 		{
		 			if((btn[i].getForeground())!=Color.GRAY)
		 			com++;
		 		}
		 	}
		 	paneone.add(btn[i]);
		 }
		rem=81-com;
		comlabel.setText("Points Completed : "+com+"    ");
		remlabel.setText("Points Remaining : "+rem+"    ");
		panetwo.setLayout(new FlowLayout());
		panetwo.add(comlabel);
		panetwo.add(remlabel);
		add(paneone,BorderLayout.CENTER);
		add(panetwo,BorderLayout.PAGE_END);
		repaint();
		btn[0].requestFocus();
	}
	public void paint(Graphics g)			// for drawing lines in the puzzle grid
	{	
		super.paint(g);
		if(panel1.d!=1)
		{
			int x1,x2,y1,y2;
			int xend,yend;
			x1=btn[3].getX();x2=btn[6].getX();
			y1=btn[27].getY();y2=btn[54].getY();
			Dimension d=panel2.this.getSize();
			xend=d.width;
			yend=panel2.this.getHeight()-27;
			g.setColor(colour);
			g.drawLine(x1-3,0,x1-3,yend);g.drawLine(x1-2,0,x1-2,yend);
			g.drawLine(x2-3,0,x2-3,yend);g.drawLine(x2-2,0,x2-2,yend);
			g.drawLine(0,y1-3,xend,y1-3);g.drawLine(0,y1-2,xend,y1-2);
			g.drawLine(0,y2-3,xend,y2-3);g.drawLine(0,y2-2,xend,y2-2);
		}
	}
	public static void setHints()
	{
		if((panel1.h == 1) && (panel1.g != 1))		// don't show hints if user has viewed solution
		{
			possibilities possobj = new possibilities(); 
			for(int x=0;x<81;x++)
			{
				if(panel2.ans[x] == 0)			// user has not put any data on the button then generate possibilities on those buttons
				{
					panel2.btn[x].removeAll();
					GridLayout grid = new GridLayout(3,3);
					panel2.btn[x].setLayout(grid);
					panel2.btn[x].setMargin( new Insets(0,4,0,0));	
					for(int y=0;y<9;y++)
					{
						JLabel label= new JLabel();
						label.setFont(new Font("SanSerif", Font.PLAIN,9));
						if(possibilities.pos[x][y] != 0)
						{
							label.setText(Integer.toString(possibilities.pos[x][y]));
						}
						else
						{
							label.setText(" ");
						}
						panel2.btn[x].add(label);
					}
					panel2.btn[x].invalidate();
				}
			}
		}
		else
		if((panel1.h == 0)&& (panel1.g != 1))
		{										// toggle hints button, make the buttons blank
			for(int x=0;x<81;x++)
			{
				if(panel2.ans[x] == 0)
				{
					panel2.btn[x].removeAll();
					panel2.btn[x].setText(" ");
				}
				panel2.btn[x].invalidate();
			}
			
		}
		panel1.panel2obj.setVisible(false);
		panel1.panel2obj.removeAll();
		panel1.panel2obj.paintagain();		
		panel1.panel2obj.repaint();
		panel1.panel2obj.setVisible(true);
		btn[0].requestFocus();
	}
	public static void loadEntries()		// for loading and reloading the puzzle 
	{
		for(int i=0;i<81;i++)
		{	
			panel2.btn[i].removeAll();
			panel2.btn[i].setFont(MouseEntryEvent.font);
			panel2.btn[i].setForeground(Color.BLACK);
			if(panel1.panel2obj.q[i]!=0)						// setting all the original puzzle entries to black color
			{
				panel2.btn[i].setText(Integer.toString(panel1.panel2obj.q[i]));
				panel1.panel2obj.com++;
			
			}
			else
			{
				panel2.btn[i].setForeground(Color.BLUE);
				if(panel1.panel2obj.ans[i] == panel1.panel2obj.s[i])			// correctly marked entries to blue color
				{
					panel2.btn[i].setText(Integer.toString(panel1.panel2obj.ans[i]));
					panel1.panel2obj.com++;
				}
				else
				{
					if(panel1.panel2obj.ans[i] != 0)			// entries which are non zero and incorrect
					{
						if(panel1.c==1)				// set if Warning is ON set these to red	
						{
							panel2.btn[i].setForeground(Color.RED);
						}
						panel2.btn[i].setText(Integer.toString(panel1.panel2obj.ans[i]));
						panel1.panel2obj.com++;
					}
					else
					panel2.btn[i].setText(" ");
				}
			}
		}
	}
}

