package game;
import board.Board;
import player.*;
import java.util.*;


public class Game {
 Player players[];
 Board board;
 int turn, moves;
 boolean gameover;
 String zero, cross;

 public Game(Player[] p, Board b)
 {
     players=p;
     board=b;
    this.turn=0;
    this.moves=0;
    this.gameover=false;
    StringBuilder z= new StringBuilder();
    StringBuilder x= new StringBuilder();
    for(int i=0;i<board.size;i++)
    {
        z.append('o');
        x.append('x');
    }
    this.zero=z.toString();
    this.cross=x.toString();
 }
 public void printBoard()
 {
     int sz=board.size;
     for(int i=0;i<sz;i++)
     {
         for(int j=0;j<sz;j++)
         {
             System.out.print(board.matrix[i][j]+" ");
         }
         System.out.println();
     }
 }

 public void play()
 {
    printBoard();
    int sz=board.size;
    while(!gameover)
    {
        moves++;
        int idx=get_index();
        int row=idx/sz;
        int col=idx%sz;

        board.matrix[row][col]=players[turn].get_symbol();
        if(moves>=sz*sz)
        {
            System.out.println("Game Draw ");
            return ;
        }
        if((moves >= 2*sz -1 && check() )==true)
        {
            gameover =true;
            printBoard();
            System.out.println("Winner : "+players[turn].get_name());
            return ;
        }
        
        turn =(turn+1)%2;
        printBoard();


    }

 }

 public int get_index()
 {
    while(true)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Player: "+players[turn].get_name()+"  Position: ");
        int p=sc.nextInt()-1;

        int r=p/board.size;
        int c=p%board.size;

        if(r<0 || r>=board.size || c<0 || c>=board.size)
        {
            System.out.println("Invalid position! ");
            continue;
        }

        if(board.matrix[r][c]!='-')
        {
            System.out.println("Position Occupied! ");
            continue;
        }
        return p;
    }
 }

 boolean check()
 {
    int sz=board.size;
    // Rowwise

    for(int i=0;i<sz;i++)
    {
        StringBuilder sb= new StringBuilder();
        for(int j=0;j<sz;j++)
        {
            sb.append(board.matrix[i][j]);
        }
        String pattern = sb.toString();
        if(pattern.equals(zero) || pattern.equals(cross))
        return true;
    }

    // Coulmnwise
    for(int i=0;i<sz;i++)
    {
        StringBuilder sb= new StringBuilder();
        for(int j=0;j<sz;j++)
        {
            sb.append(board.matrix[j][i]);
        }
        String pattern = sb.toString();
        if(pattern.equals(zero) || pattern.equals(cross))
        return true;
    }

    //Diagonal
    int i=0,j=0;
    StringBuilder sb= new StringBuilder();
    while(i<sz)
    {
        sb.append(board.matrix[i][j]);
        i++;
        j++;
    }
    String pattern = sb.toString();
    if(pattern.equals(zero) || pattern.equals(cross))
    return true;

     //AntiDiagonal
      i=0;
      j=sz-1;
     sb= new StringBuilder();
     while(i<sz)
     {
         sb.append(board.matrix[i][j]);
         i++;
         j--;
     }
      pattern = sb.toString();
     if(pattern.equals(zero) || pattern.equals(cross))
     return true;

     return false;
 }

}

