//Aryaman Suri
//player class mainly used to check player moves and win/loss conditions for the player
import java.util.Arrays;
public class Player{
   
   public Player(){
   }
   
   //based on the gameboard and the desired attack, makes sure the attack works and the player can legally execute it
   public boolean canMove(String[][] board, String s){
      //left pawn can move up
      if(s.equals("l")){
         if((board[0][0].equals("x") && board[1][0].equals("o")) || (board[1][0].equals("x") && board[2][0].equals("o")) || (!board[1][0].equals("o") && !board[2][0].equals("o")))
            return false;
         else
            return true;
      }  //left pawn can attack right
      else if (s.equals("lR")){
         if((board[0][1].equals("x") && board[1][0].equals("o")) || (board[1][1].equals("x") && board[2][0].equals("o")))
            return true;
         else 
            return false;
      }  //center pawn can move forward 
      else if (s.equals("c")){
         if((board[0][1].equals("x") && board[1][1].equals("o")) || (board[1][1].equals("x") && board[2][1].equals("o")) || (!board[1][1].equals("o") && !board[2][1].equals("o")))
            return false;
         else
            return true;
      }  //center pawn can attack left
      else if(s.equals("cL")){     
         if((board[0][0].equals("x") && board[1][1].equals("o")) || (board[1][0].equals("x") && board[2][1].equals("o")))
            return true;
         else
            return false;
      }  //center pawn can attack right
      else if(s.equals("cR")){     
         if((board[0][2].equals("x") && board[1][1].equals("o")) || (board[1][2].equals("x") && board[2][1].equals("o")))
            return true;
         else
            return false;
      } //right pawn can move forward
      else if(s.equals("r")){     
         if((board[0][2].equals("x") && board[1][2].equals("o")) || (board[1][2].equals("x") && board[2][2].equals("o")) || (!board[1][2].equals("o") && !board[2][2].equals("o")))
            return false;
         else
            return true;
      }  //right pawn can attack left
      else if(s.equals("rL")){     
         if((board[0][1].equals("x") && board[1][2].equals("o")) || (board[1][1].equals("x") && board[2][2].equals("o")))
            return true;
         else
            return false;
      }
      else
         return false;
    }
    
    //there are only 8 possible board combinations that the gameboard could end up like that would not allow the player to move.
    //checks to see if the gameboard matches any 8 of those combinations
    public boolean cantMove(String[][] board){
      String[][] temp = new String[3][3];
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
      
      //case one
      temp[0][0] = "x";
      temp[1][0] = "o";
      temp[1][2] = "x";
      temp[2][2] = "o";
      if(equalTwoDArrays(board, temp))
         return true;
         
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
         
      //case two
      temp[0][0] = "x";
      temp[1][0] = "o";
      temp[1][1] = "x";
      temp[2][1] = "o";
      if(equalTwoDArrays(board, temp))
         return true;
         
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
         
      //case three
      temp[0][1] = "x";
      temp[1][1] = "o";
      temp[1][2] = "x";
      temp[2][2] = "o";  
      if(equalTwoDArrays(board, temp))
         return true; 
      
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
         
      //case four
      temp[1][0] = "x";
      temp[2][0] = "o";
      temp[0][1] = "x";
      temp[1][1] = "o";  
      if(equalTwoDArrays(board, temp))
         return true; 
      
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
         
      //case five
      temp[1][0] = "x";
      temp[2][0] = "o";
      temp[0][2] = "x";
      temp[1][2] = "o";  
      if(equalTwoDArrays(board, temp))
         return true;    
            
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
         
      //case six
      temp[0][2] = "x";
      temp[1][2] = "o";
      temp[1][1] = "x";
      temp[2][1] = "o";  
      if(equalTwoDArrays(board, temp))
         return true;
         
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
         
      //case seven
      temp[1][0] = "x";
      temp[1][1] = "x"; 
      if(equalTwoDArrays(board, temp))
         return true; 
         
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
         
      //case eight
      temp[1][1] = "x";
      temp[1][2] = "x"; 
      if(equalTwoDArrays(board, temp))
         return true;         
      
      return false;      
      
    }
    
    //gotten from https://examples.javacodegeeks.com/core-java/util/arrays/compare-two-dimensional-arrays/
    //compares two 2D arrays to see if they are equal
    public boolean equalTwoDArrays(String[][] arr1, String[][] arr2){
      if (arr1 == null) {
         return (arr2 == null);
      } 
      if (arr2 == null) {
         return false;
      }
      if (arr1.length != arr2.length) {
         return false; 
      }
      for (int i = 0; i < arr1.length; i++) {
         if (!Arrays.equals(arr1[i], arr2[i])) { 
            return false;
         }
 
      }
 
      return true;
   }  
     
}