import java.util.*;
import java.lang.*;

public class KnightTour
{
    
    public static void update(int[][] board)
    {
     for(int y = 0; y<8; y++)
            {   
            for(int x = 0; x<8; x++)
                {
                    if(x==0 && y>0)
                        System.out.println("");
                    System.out.print(board[x][y]+" ");

                }   
            }
        System.out.println("");
        System.out.println("---------------");
   
    }
    public static void move(int[][] a, int xpos, int ypos)
    {
        int[] pos = {xpos, ypos};
        double r = Math.random();
        if(r<0.125)
            pos[0]+=2;
            pos[1]+=1;
        if(r<0.25 && r>=0.125)
            pos[0]+=2;
            pos[1]-=1;
        if(r<0.375 && r>=0.25)
            pos[0]-=2;
            pos[1]+=1;
        if(r<0.5 && r>=0.375)
            pos[0]-=2;
            pos[1]-=1;
        if(r<0.625 && r>=0.375)
            pos[0]+=1;
            pos[1]+=2;
        if(r<0.8 && r>=0.625)
            pos[0]-=1;
            pos[1]+=2;
        if(r<0.925 && r>=0.8)
            pos[0]-=1;
            pos[1]-=2;
        if(r<1 && r>=0.925)
            pos[0]+=1;
            pos[1]-=2;
        a[pos[0]][pos[1]] = 1;
        
    }    
    public static void main(String[] args)
    {
        int[][] board = new int[8][8];
        int xpos = (int)(Math.random()*7);
        int ypos = (int)(Math.random()*7);
        board[xpos][ypos]=1;

        update(board);
        move(board, xpos, ypos);
        update(board);
    }
}
