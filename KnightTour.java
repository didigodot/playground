import java.util.*;
import java.lang.*;

public class KnightTour
{
    static int[][] moves = new int[][]{{1, 1, -1, -1, 2, 2, -2, -2},{2, -2, 2, -2, 1, -1, 1, -1}}; 
    static int size = 5;
    static int[][] board = new int[size][size];

    public static void drawBoard(int[][] board)
    {
     for(int y = 0; y<size; y++)
            {   
            for(int x = 0; x<size; x++)
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
    public static void shuffle()
    {
        for(int i = 0; i<15; i++)
        {
            int a = (int)(Math.random()*size);
            int b = (int)(Math.random()*size);
            int[] temp = {moves[0][a], moves[1][a]};
            moves[0][a]=moves[0][b];
            moves[1][a]=moves[1][b];
            moves[0][b] = temp[0];
            moves[1][b]=temp[1];
        }
    }
	public static void move(int[] pos, int movenumber)
    {
        board[pos[0]][pos[1]] = movenumber;
        drawBoard(board);
        if(movenumber==size*size)
        {
            drawBoard(board);
            return;
        }
        else
        {
            for(int i = 0; i<8; i++)
            {
                int newx = pos[0]+moves[0][i];
                int newy = pos[1]+moves[1][i];
                // if bounded and not visited before
                if(newx>=0 && newx<size &&
                   newy>=0 && newy<size &&
                   board[newx][newy]==0)
                {       
                 int[] x = {newx, newy};
                 move(x, movenumber+1);
                 //shuffle();
                }
            }
        }
         board[pos[0]][pos[1]]=0;
     }
      
    public static void main(String[] args)
    {
        int[] pos = {(int)(Math.random()*size), (int)(Math.random()*size)};
        for(int i = 0; i<size; i++)
        {
            for(int y = 0;y<size; y++)
            {
                board[i][y]=0;
            }
        }
        //int[] pos = {0,0};
        move(pos, 1);
    }
}
