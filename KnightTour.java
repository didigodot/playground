import java.util.*;
import java.lang.*;

public class KnightTour
{
    static int[][] moves = new int[][]{{1, 1, -1, -1, 2, 2, -2, -2},{2, -2, 2, -2, 1, -1, 1, -1}}; 
    public static void drawBoard(int[][] board)
    {
     for(int y = 0; y<8; y++)
            {   
            for(int x = 0; x<8; x++)
                {
                    if(x==0 && y>0)
                        System.out.println("");
	            if(board[x][y]>9)
		    	System.out.print(board[x][y]+" ");
	            else
                    	System.out.print(board[x][y]+"  ");

                }   
            }
        System.out.println("");
        System.out.println("---------------");
   
    }
	 public static boolean checkFill(int[][] a)
	 {
	 	boolean b = true; //assume it's filled until proved otherwise	
		   for(int x = 0; x<8; x++)
			for(int y = 0; y<8; y++)
				{
					if(a[x][y]==0)
					{
						b = false;
						return b;
					}
				}
		return b;
	 }
    //picks spot at random, doesn't care about whether it works
	public static int[] pickSpot(int[][] a, int[] pos)
    {
	    boolean selected = false;
        int[] pair = new int[2]; // wil hold return value
        while(selected!=true)
		    {
	            double r = Math.random();
                pair[0] = pos[0];
                pair[1] = pos[1];
	            if(r<0.125){ pos[0]+=2; pos[1]+=1; }    
	            if(r<0.25 && r>=0.125)
	            { pos[0]+=2; pos[1]-=1; }
	            if(r<0.375 && r>=0.25)
	            { pos[0]-=2; pos[1]+=1;}
	            if(r<0.5 && r>=0.375)
	            {pos[0]-=2; pos[1]-=1;}
	            if(r<0.625 && r>=0.375)
	            { pos[0]+=1; pos[1]+=2;}
	            if(r<0.8 && r>=0.625)
	            {pos[0]-=1; pos[1]+=2;}
	            if(r<0.925 && r>=0.8)
	            {pos[0]-=1; pos[1]-=2;}
	            if(r<1 && r>=0.925)
	            { pos[0]+=1; pos[1]-=2;}

		        if(pos[0]<8 && pos[0]>0 && pos[1]<8 && pos[1]>0)
	            {    
			       selected=true;
                   pair[0] = pos[0];
                   pair[1] = pos[1];
	               break;
	            }
	            //else reset values
	            pos[0]=pair[0];
	            pos[1]=pair[1];
		     }
            return pair;    
    }   
    	
    public static void move(int[][] board, int[] pos, int movenumber)
    {
        if(checkFill(board)==false)
        {
            for(int i = 0; i<8; i++)
            {
                int newx = pos[0]+moves[0][i];
                int newy = pos[1]+moves[1][i];
                if(newx>=0 && newx<8 &&
                   newy>=0 && newy<8 &&
                   board[newx][newy]==0)
                {       
                 movenumber++;
                 board[newx][newy]=movenumber;
                 int[] x = {newx, newy};
                 move(board, x, movenumber);
                }
            }
        }
     }
      
    public static void main(String[] args)
    {
        int[][] board = new int[8][8];
        int[] pos = {(int)(Math.random()*7), (int)(Math.random()*7)};
        int[] old = pos;
        board[pos[0]][pos[1]] = 1;
        int m = 1;
        move(board, pos, m);
        drawBoard(board); //figure it all out, then draw. 
    }
}
