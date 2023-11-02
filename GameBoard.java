// This is Simple X_O game. 
package x_o_game;
import java.util.*;

public class GameBoard {

    static String[][] board = new String[3][3];
    GameBoard(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                board[i][j]=" ";
            }
        }
    }
    public static void play(String let){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("Enter row to store "+let+" :");
            int row = sc.nextInt();
            --row;
            System.out.print("Enter column to store "+let+" :");
            int colm = sc.nextInt();
            --colm;
            if(board[row][colm].equals("x") || board[row][colm].equals("y")){
                System.out.println("Enter valid position to store "+let);
            }
            else{
                board[row][colm]=let;
                dispay(board,let);
                break;
            }
        }
    }
    public static void dispay(String[][] board,String let){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
        }
        checkRow(let);
    }
    public static void checkRow(String let){
        int count=0;
        for(int i=0;i<board.length;i++){
            count=0;
            for(int j=0;j<board[i].length;j++){
                if(let.equals(board[i][j])){
                    count++;
                }
            }
            if(count==3){
                System.out.println("Player "+let+" has won");
                System.out.println("Inside row");
                System.exit(0);
            }
        }
        checkCol(let);
    }

    public static void checkCol(String let){
        int count=0;
        for(int i=0;i<board.length;i++){
            count=0;
            for(int j=0;j<board[i].length;j++){
                if(board[j][i]==let){
                    count++;
                }
            }
            if(count==3){
                System.out.println("Player "+let+" has won");
                System.out.println("Inside col");
                System.exit(0);
            }
        }
        checkLeftDiog(let);
    }
    public static void checkLeftDiog(String let){
        int count=0;
        int row=0,col=0;
        for(int i=0;i<board.length;i++){
            if(board[row][col]==let){
                count++;
            }
            row++;
            col++;
            if(count==3){
                System.out.println("Player "+let+" has won");
                System.out.println("Inside Left dig");
                System.exit(0);
            }
        }
        checkRightDiog(let);
    }
    public  static void checkRightDiog(String let){
        int count=0;
        int row=0,col=board.length-1;
        for(int i=0;i<board.length;i++){
            if(board[row][col]==let){
                count++;
            }
            row++;
            col--;
            if(count==3){
                System.out.println("Player "+let+" has won");
                System.out.println("Inside Right dig");
                System.exit(0);
            }
        }
        checkDraw();
    }
    public static void checkDraw(){
        int total_space=board.length*board.length;
        int count=0;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]=="x" || board[i][j]=="y"){
                    count++;
                }
            }
        }
        if(count==total_space){
            System.out.println("Match is Draw....");
            System.exit(0);
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        GameBoard g = new GameBoard();
        System.out.println("**********Play game**********");
        System.out.print("Yes or No : ");
        String opt = in.next().toLowerCase();
        String[] let = {"x","y"};
        if(opt.equals("yes")){
            int n=1;
            for(int i=0;i<g.board.length*g.board.length;i++){
                if(n>2)
                    n=1;
                System.out.println("Player "+n+" turn");
                play(let[n-1]);
                n++;
            }
        }
        else{
            System.out.println("Go back to Home page");
        }
    }
}