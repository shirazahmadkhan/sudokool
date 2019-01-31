import javax.swing.*;
import java.io.*;

public class readsudoku
{

	static int exist=1;
	public static int[] prob=new int[81];
	public static int[] sol=new int[81];
	
	public readsudoku()
	{
		
		for(int i=0;i<81;i++)
		{
			prob[i]=0;
			sol[i]=0;
		}

		QQWing qq = new QQWing();
		qq.Generator();
		for(int l=0;l<81;l++)
		{
				prob[l] = qq.puzzle[l];
				sol[l]= qq.solution[l];
		}
	}
}
	
