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
    	
    public static void move(int[][] board, int[] pos, int movenumber)
    {
        int[] oldpos = pos;
        board[pos[0]][pos[1]] = movenumber;
        drawBoard(board);
        if(checkFill(board)==true)
        {
            drawBoard(board);
        }
        else
        {
            for(int i = 0; i<8; i++)
            {
                int newx = pos[0]+moves[0][i];
                System.out.println(moves[0][i]+", "+moves[1][i]);
                int newy = pos[1]+moves[1][i];
                // if bounded and not visisted before
                if(newx>=0 && newx<8 &&
                   newy>=0 && newy<8 &&
                   board[newx][newy]==0)
                {       
                 int[] x = {newx, newy};
                 move(board, x, movenumber+1);
                }
            }
        }
         board[pos[0]][pos[1]]=0;
     }
      
    public static void main(String[] args)
    {
        int[][] board = new int[8][8];
        //int[] pos = {(int)(Math.random()*7), (int)(Math.random()*7)};
        int[] pos = {0,0};
        move(board, pos, 1);
    }
}
