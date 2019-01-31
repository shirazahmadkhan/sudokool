public class possibilities
{
	static int[][] sol=new int[9][9];
	static int[][][] poss=new int[9][9][10];
	static int[][] pos = new int[81][9];
	
	public possibilities()
	{
		int x=0;int y=0;int z=0;int p=0;
		for(x=0;x<9;x++)	
		{
			for(y=0;y<9;y++)
			{
				sol[x][y]=0;							// initialising the array : resetting older values
				if(panel2.ans[p] == panel2.s[p])		// initialise the array with only correct entries marked by user
				sol[x][y]=panel2.ans[p];
		//		System.out.print(sol[x][y]);
				p++;
			}
		//	System.out.println();
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
				}
				
			}
		}
		check();
		p=0;			//check possibilities in boxes,rows,columns
		for(int l=0;l<9;l++)
		{
			for(int m=0;m<9;m++)
			{
				for(int n=1;n<10;n++)
				{
					pos[p][n-1]=poss[l][m][n];
				}
				p++;
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

