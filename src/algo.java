public class algo
{
	static int[][] sol=new int[9][9];
	static int sak=0;
	static int[][][] poss=new int[9][9][10];
	static int loop=0;
	static int solved=1;
	public algo(int[][] prob)
	{
		sak=0;
		loop=0;
		int x=0;int y=0;int z=0;
		int sakpre=0;
		for(x=0;x<9;x++)	
		{
			for(y=0;y<9;y++)
			{
				sol[x][y]=prob[x][y];
			}
		}
		for(x=0;x<9;x++)	//initialising possibilities array
		{
			for(y=0;y<9;y++)
			{	
				for(z=0;z<10;z++)
				{
					if((sol[x][y])!=0)		//if nonzero entry poss[0]=1 rest all[1to9]=0
					{	
						if(z!=0) poss[x][y][z]=0;
					}
					else
					poss[x][y][z]=z;
				}
				if((sol[x][y])!=0)		
				{	
					poss[x][y][0]=1;	
					sak=sak+1;
				}
				
			}
		}
	
			 		 	 	 
	while(sak!=sakpre)		//until all points left with just one possibility
	{ 
		sakpre=sak;
		check();			//check possibilities in boxes,rows,columns
		pair();
		for(x=0;x<9;x++)
		box(x);				//calling 9 box eliminations
		
		for(x=0;x<3;x++)	//calling 6 grid eliminations
		{
			gridh(x);
			gridv(x);
		}
		solve();
		loop++;	
	}		//while ends
	if(sak<81)
	solved=0;
	if(sak==81)
	solved=1;
	
	System.out.println("No of loops "+loop);
	System.out.println("No of points solved "+sak);
	
	}
	
	public static void gridh(int no)
	{
		int w=0,p=0,x=0,y=0,z=0,m=0;
		if(no==1) m=3;
		if(no==2) m=6;
		int[][] check={ {0,0,0},
						{0,0,0},
						{0,0,0}	};
		int temp=0,position=0;
		for(w=1;w<=9;w++)		//nos 1 to 9
		{
			p=0;
			for(x=0;x<3;x++)		//moving in 3 rows
			{
				for(y=0;y<3;y++)	//moving in 3 boxes
				{
					for(z=0;z<3;z++) 	//moving in 3 elements
					{
						if(poss[x+m][p][0]==0)
						for(int zz=1;zz<10;zz++)
						{
							if(poss[x+m][p][zz]==w)
							check[x][y]=1;
						}
						p++;	
					}
				}
				p=0;
			}
		
			//now working on checkbox
			
			for(y=0;y<3;y++)			//column
			{
				temp=0;position=0;
				for(x=0;x<3;x++)		//moving vertically in a column
				{
					if(check[x][y]==1)
					{
						temp++;
						position=x;
					}
				}
				if((temp==1)&&(y==0))				//only one 1 in a column 1
				{
					check[position][1]=0;
					check[position][2]=0;
				}
				if((temp==1)&&(y==1))				//only one 1 in a column 2
				{
					check[position][0]=0;
					check[position][2]=0;
				}
				if((temp==1)&&(y==2))				//only one 1 in a column 3
				{
					check[position][0]=0;
					check[position][1]=0;
				}
				
			}
			for(x=0;x<3;x++)		//row
			{
				temp=0;position=0;
				for(y=0;y<3;y++)
				{
					if(check[x][y]==1)
					{
						temp++;
						position=y;
					}
				}
				if((temp==1)&&(x==0))
				{
					check[1][position]=0;
					check[2][position]=0;
				}
				if((temp==1)&&(x==1))
				{
					check[0][position]=0;
					check[2][position]=0;
				}
				if((temp==1)&&(x==2))
				{
					check[0][position]=0;
					check[1][position]=0;
				}
			}
			p=0;
			//modifying poss in terms of checkbox
			for(x=0;x<3;x++)		//moving in 3 rows
			{
				for(y=0;y<3;y++)	//moving in 3 boxes
				{
					if(check[x][y]==0)
					for(z=0;z<3;z++) 	//moving in 3 elements
					{
						if(poss[x+m][p][0]==0)
						{
							poss[x+m][p][w]=0;
						}
						p++;	
					}
					else 
					p=p+3;
				}
				p=0;
			}
		for(x=0;x<3;x++)
		{
			for(y=0;y<3;y++)
			{
				check[x][y]=0;
			}
		}
		}
		
	}

	public static void gridv(int no)
	{
		int w=0,p=0,x=0,y=0,z=0,m=0;
		if(no==1) m=3;
		if(no==2) m=6;
		int[][] check={ {0,0,0},
						{0,0,0},
						{0,0,0}	};
		int temp=0,position=0;
		for(w=1;w<=9;w++)		//nos 1 to 9
		{
			for(y=0;y<3;y++)		//moving in 3 columns
			{
				for(x=0;x<3;x++)	//moving in 3 boxes
				{
					for(z=0;z<3;z++) 	//moving in 3 elements
					{
						if(poss[p][y+m][0]==0)
						for(int zz=1;zz<10;zz++)
						{
							if(poss[p][y+m][zz]==w)
							check[x][y]=1;
						}
						p++;
					}
				}
				p=0;
			}
			//now working on checkbox
			for(x=0;x<3;x++)			//row
			{
				temp=0;position=0;
				for(y=0;y<3;y++)		//moving horizontally in a row
				{
					if(check[x][y]==1)
					{
						temp++;
						position=y;
					}
				}
				if((temp==1)&&(x==0))				//only one 1 in a column 1
				{
					check[1][position]=0;
					check[2][position]=0;
				}
				if((temp==1)&&(y==1))				//only one 1 in a column 2
				{
					check[0][position]=0;
					check[2][position]=0;
				}
				if((temp==1)&&(y==2))				//only one 1 in a column 3
				{
					check[0][position]=0;
					check[1][position]=0;
				}
				
			}
			for(y=0;y<3;y++)
			{
				temp=0;position=0;
				for(x=0;x<3;x++)
				{
					if(check[x][y]==1)
					temp++;position=x;
				}
				if((temp==1)&&(x==0))
				{
					check[position][1]=0;
					check[position][2]=0;
				}
				if((temp==1)&&(x==1))
				{
					check[position][0]=0;
					check[position][2]=0;
				}
				if((temp==1)&&(x==2))
				{
					check[position][0]=0;
					check[position][1]=0;
				}
			}
			
			p=0;
		
			//modifying poss in terms of checkbox
			for(y=0;y<3;y++)		//moving in 3 columns
			{
				for(x=0;x<3;x++)	//moving in 3 boxes
				{
					if(check[x][y]==0)
					for(z=0;z<3;z++) 	//moving in 3 elements
					{
						if(poss[p][y+m][0]==0)
						{
							poss[p][y+m][w]=0;
						}
						p++;	
					}
					else 
					p=p+3;
				}
				p=0;
			}
			for(x=0;x<3;x++)
			{
				for(y=0;y<3;y++)
				{
					check[x][y]=0;
				}
			}
		}
	}
	
	public static void pair()		
	{
		int[][] a2=new int[9][10];
		int[][] a3=new int[10][10];
		int[][] pairs=new int[9][2];
		int x=0,y=0,z=0,j=0,k=0,one=0,two=0;
		int r,s,temp;
		x=3;
		for(x=0;x<9;x++)			//moving in rows
		{
			for(y=0;y<9;y++)		//eliminating visible pairs
			{
				for(z=0;z<10;z++)
				{
					a2[y][z]=poss[x][y][z];
					a3[y][z]=poss[x][y][z];
				}
			}
			for(y=0;y<9;y++)
			{
				pairs[y][0]=0;
				pairs[y][1]=0;
			}
			r=0;s=0;				
			for(y=0;y<9;y++)
			{
				temp=0;
				if(a2[y][0]!=1)		
				for(z=1;z<10;z++)
				{
					if(a2[y][z]!=0)
					temp++;
				}
				s=0;
				if(temp==2)
				for(z=1;z<10;z++)
				{
					if(a2[y][z]!=0)
					{
						pairs[r][s]=a2[y][z];
						s++;
					}
				
				}
				r++;	
			}
			
			int brk=0;
			for(y=0;y<8;y++)
			{
				if(pairs[y][0]!=0)
				{
					for(z=y+1;z<9;z++)
					{
						if((pairs[y][0]==pairs[z][0])&&(pairs[y][1]==pairs[z][1]))
						{brk=1;break;}
					}
					if(brk==1) break;
				}
				if(brk==1) break;
			}
			if(brk==1)
			{
				for(j=0;j<9;j++)
				if((j!=y)&&(j!=z))
				{	
					poss[x][j][pairs[z][0]]=0;
					poss[x][j][pairs[z][1]]=0;
				}
			}
	
			for(z=1;z<10;z++)		//eliminating hidden pairs
			{
				temp=0;
				for(y=0;y<9;y++)
				{
					if((a3[y][z]!=0)&&(a3[y][0]!=1))
					temp++;
				}
				a3[9][z]=temp;	
			}
		/*	for(y=0;y<10;y++)		
			{
				for(z=0;z<10;z++)
				{
					System.out.print(a3[y][z]);
				}
				System.out.println(" for column no "+y)	;
			}*/
			brk=0;
			for(z=1;z<9;z++)
			{
				if(a3[9][z]==2)	
				for(j=z+1;j<10;j++)	
				{
					if(a3[9][j]==2)
					for(k=0;k<9;k++)
					{
						if((a3[k][z]!=0)&&(a3[k][j]!=0))
						{brk++;
						if(brk==1) one=k;}
						if(brk==2){two=k;break;}
					}
					if(brk==2)break;
					brk=0;					
				}
				if(brk==2)break;
			}
		/*	if(brk==2)
			{
				for(y=0;y<9;y++)
				System.out.print(a3[y][z]);
				System.out.println();
				for(y=0;y<9;y++)
				System.out.print(a3[y][j]);
				System.out.println(" z is "+z+" j is "+j+" k is "+k+" one,two "+one+","+two);
			}*/
			if(brk==2)
			for(y=0;y<9;y++)
			{
				if((y==one)||(y==two)&&(a3[y][0]!=1))
				for(k=0;k<10;k++)
				{
					if((k!=z)&&(k!=j))
					{
						poss[x][y][k]=0;
					}
				}
			}
			
		}
		for(y=0;y<9;y++)			//moving in columns
		{
			for(x=0;x<9;x++)		//eliminating visible pairs
			{
				for(z=0;z<10;z++)
				{
					a2[x][z]=poss[x][y][z];
					a3[x][z]=poss[x][y][z];
				}
			}
			for(x=0;x<9;x++)
			{
				pairs[x][0]=0;
				pairs[x][1]=0;
			}
			r=0;s=0;				
			for(x=0;x<9;x++)
			{
				temp=0;
				if(a2[x][0]!=1)		
				for(z=1;z<10;z++)
				{
					if(a2[x][z]!=0)
					temp++;
				}
				s=0;
				if(temp==2)
				for(z=1;z<10;z++)
				{
					if(a2[x][z]!=0)
					{
						pairs[r][s]=a2[x][z];
						s++;
					}
				
				}
				r++;	
			}
			int brk=0;
			for(x=0;x<8;x++)
			{
				if(pairs[x][0]!=0)
				{
					for(z=x+1;z<9;z++)
					{
						if((pairs[x][0]==pairs[z][0])&&(pairs[x][1]==pairs[z][1]))
						{brk=1;break;}
					}
					if(brk==1) break;
				}
				if(brk==1) break;
			}
			if(brk==1)
			{
				for(j=0;j<9;j++)
				if((j!=x)&&(j!=z))
				{	
					poss[j][y][pairs[z][0]]=0;
					poss[j][y][pairs[z][1]]=0;
				}
			}
			for(z=1;z<10;z++)		//eliminating hidden pairs
			{
				temp=0;
				for(x=0;x<9;x++)
				{
					if((a3[x][z]!=0)&&(a3[x][0]!=1))
					temp++;
				}
				a3[9][z]=temp;	
			}
			brk=0;
			for(z=1;z<9;z++)
			{
				if(a3[9][z]==2)	
				for(j=z+1;j<10;j++)	
				{
					if(a3[9][j]==2)
					for(k=0;k<9;k++)
					{
						if((a3[k][z]!=0)&&(a3[k][j]!=0))
						{brk++;
						if(brk==1) one=k;}
						if(brk==2){two=k;break;}
					}
					if(brk==2)break;
					brk=0;					
				}
				if(brk==2)break;
			}
		/*	if(brk==2)
			{
				for(x=0;x<9;x++)
				System.out.print(a3[x][z]);
				System.out.println();
				for(x=0;x<9;x++)
				System.out.print(a3[x][j]);
				System.out.println(" z is "+z+" j is "+j+" k is "+k+" one,two "+one+","+two);
			}*/
			if(brk==2)
			for(x=0;x<9;x++)
			{
				if((x==one)||(x==two)&&(a3[x][0]!=1))
				for(k=0;k<10;k++)
				{
					if((k!=z)&&(k!=j))
					{
						poss[x][y][k]=0;
					}
				}
			}
		}//y ends
}
	
	public static void box(int bx)
	{
		int temp=0,temp1=0,temp2=0;int position=0;
		int k=0,j=0,one=0,two=0;
		int[][] a2=new int[9][10];
		int[][] a3=new int[10][10];
		int[][] pairs=new int[9][2];
		int p=0;int x=0,y=0,z=0,l=0,m=0;
		int s,r;
		switch(bx)
		{	
			case 0:l=0;m=0;break;
			case 1:l=0;m=3;break;
			case 2:l=0;m=6;break;
			case 3:l=3;m=0;break;
			case 4:l=3;m=3;break;
			case 5:l=3;m=6;break;
			case 6:l=6;m=0;break;
			case 7:l=6;m=3;break;
			case 8:l=6;m=6;break;
		}
		for(x=0;x<3;x++)
		{
			for(y=0;y<3;y++)
			{
				for(z=0;z<10;z++)
				{
					a2[p][z]=poss[x+l][y+m][z];
				}
				p++;
			}
			
		}
		r=0;s=0;				//eliminating visible pairs
		for(x=0;x<9;x++)		
		{
			temp=0;
			if(a2[x][0]!=1)		//check it
			for(y=1;y<10;y++)
			{
				if(a2[x][y]!=0)
				temp++;
			}
			s=0;
			if(temp==2)
			for(y=1;y<10;y++)
			{
				if(a2[x][y]!=0)
				{
					pairs[r][s]=a2[x][y];
					s++;
				}
				
			}
			r++;	
		}
		int brk=0;
		for(x=0;x<8;x++)
		{
			if(pairs[x][0]!=0)
			{
				for(z=x+1;z<9;z++)
				{
					if((pairs[x][0]==pairs[z][0])&&(pairs[x][1]==pairs[z][1]))
					{brk=1;break;}
				}
				if(brk==1) break;
			}
			if(brk==1) break;
		}
		if(brk==1)
		{
			p=0;
			for(r=0;r<3;r++)
			{
				for(s=0;s<3;s++)
				{
					if((p!=x)&&(p!=z))
					{
						a2[p][pairs[x][0]]=0;
						a2[p][pairs[x][1]]=0;
						poss[r+l][s+m][pairs[x][0]]=0;
						poss[r+l][s+m][pairs[x][1]]=0;
					}
					p++;
				}
			}
		}
		for(z=1;z<10;z++)		//eliminating hidden pairs
		{
			temp=0;
			for(x=0;x<9;x++)
			{
				if((a3[x][z]!=0)&&(a3[x][0]!=1))
				temp++;
			}
			a3[9][z]=temp;	
		}
		brk=0;
		for(z=1;z<9;z++)
		{
			if(a3[9][z]==2)	
			for(j=z+1;j<10;j++)	
			{
				if(a3[9][j]==2)
				for(k=0;k<9;k++)
				{
					if((a3[k][z]!=0)&&(a3[k][j]!=0))
					{brk++;
					if(brk==1) one=k;}
					if(brk==2){two=k;break;}
				}
				if(brk==2)break;
				brk=0;					
			}
			if(brk==2)break;
		}
		p=0;
		if(brk==2)
		for(x=0;x<3;x++)
		{
			for(y=0;y<3;y++)
			{
				if((p==one)||(p==two)&&(a3[p][0]!=1))
				for(k=0;k<10;k++)
				{
					if((k!=z)&&(k!=j))
					{
						poss[x+l][y+l][k]=0;
					}
				}
				p++;
			}
		}
		for(y=1;y<10;y++)  
		{
			temp=0;position=0;
			for(x=0;x<9;x++)
			{
				if(a2[x][0]!=1)
				{
					if(a2[x][y]==y)
					{
						temp++;position=x;
					}
				}
			}
							
			//checking if only one vertical possibility
			if(temp==1)
			{
				p=0;
				for(r=0;r<3;r++)
				{
					for(s=0;s<3;s++)
					{
						if(p==position)
						{
							for(z=1;z<10;z++)
							{
								if(z!=y)
								poss[r+l][s+m][z]=0;
							}
							
						}
						p++;
					}
				}
			}
		}
	
		
	}
	
	public static void solve()
	{
		int x=0,y=0,temp=0,z=0;
		for(x=0;x<9;x++)	
		{
			for(y=0;y<9;y++)
			{
				temp=0;				//for counting the number of possibilities
				for(z=1;z<10;z++)
				{
					if((poss[x][y][z])!=0)
					temp++;
				}
				if((temp==1)&&(poss[x][y][0]==0)) ///where there is only one possibility
				{
					poss[x][y][0]=1;
					for(z=1;z<10;z++)
					{
						if(poss[x][y][z]!=0)
						{
							sol[x][y]=poss[x][y][z];
							poss[x][y][z]=0;
						}
					}
					sak++;
				}
				
			}
		}
	}
	
	public static void check()
	{
		int x=0,y=0,z=0,l=0,m=0;
		for(x=0;x<9;x++)
		{
			for(y=0;y<9;y++)
			{
				if((poss[x][y][0])==0) //the point is not already filled
				for(z=1;z<10;z++)
				{
					if((x<3)&&(y<3))
					for(l=0;l<3;l++)		//a
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l][m])
							poss[x][y][z]=0;
						}
					}
					if((x<3)&&(y>2)&&(y<6))
					for(l=0;l<3;l++)		//b
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l][m+3])
							poss[x][y][z]=0;
						}
					}
					if((x<3)&&(y>5))
					for(l=0;l<3;l++)		//c
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l][m+6])
							poss[x][y][z]=0;
						}
					}
					if((x>2)&&(x<6)&&(y<3))		//d
					for(l=0;l<3;l++)
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l+3][m])
							poss[x][y][z]=0;
						}
					}
					if((x>2)&&(x<6)&&(y>2)&&(y<6))		//e
					for(l=0;l<3;l++)
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l+3][m+3])
							poss[x][y][z]=0;
						}
					}
					if((x>2)&&(x<6)&&(y>5))			//f
					for(l=0;l<3;l++)
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l+3][m+6])
							poss[x][y][z]=0;
						}
					}
					if((x>5)&&(y<3))			//g
					for(l=0;l<3;l++)
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l+6][m])
							poss[x][y][z]=0;
						}
					}
					if((x>5)&&(y>2)&&(y<6))		//h
					for(l=0;l<3;l++)
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l+6][m+3])
							poss[x][y][z]=0;
						}
					}
					if((x>5)&&(y>5))			//i
					for(l=0;l<3;l++)
					{
						for(m=0;m<3;m++)
						{
							if(poss[x][y][z]==sol[l+6][m+6])
							poss[x][y][z]=0;
						}
					}
					for(int k=0;k<9;k++) //compare with rows
					{
						if((poss[x][y][z])==sol[k][y])
							poss[x][y][z]=0;
					}
					for(int k=0;k<9;k++) //compare with columns
					{
						if((poss[x][y][z])==sol[x][k])
							poss[x][y][z]=0;
					}
				}
			}
		}
	}
}
