//Aryaman Suri
/*computer class, holds every possible scenario and move the computer could make. It turns out that somebody is guaranteed to win by the end of turn 7, and since the
   computer goes on even turns, it can only move on turns 2, 4, and 6.
*/
import java.util.ArrayList;
import java.util.Arrays;
public class CPU{
   //three ScenarioLists, for each of the 3 move turns the computer can move
   //so twoScenarios represents every possible scenario for the computer on move turn 2, same goes for fourScenarios and sixScenarios
   private ScenariosList twoScenarios;
   private ScenariosList fourScenarios;
   private ScenariosList sixScenarios;
   
   public CPU(){
      twoScenarios = new ScenariosList("two");
      fourScenarios = new ScenariosList("four");
      sixScenarios = new ScenariosList("six");
   }
   
   
   //gets the scenario board that matches the current game board. x is the move turn
   //works by setting every scenario board equal to ans and then comparing it to the gameboard
   //returns the index of the gameboard
   public int getScenarioBoard(int x, String[][] s){
      String[][] ans = new String[3][3];
      if(x == 2){
         for(int i = 0; i < 3; i++){
            for(int r = 0; r < 3; r++){
               for(int c = 0; c < 3; c++){
                  ans[r][c] = twoScenarios.getScenarios().get(i).getBoardScenario()[r][c];
               }
            }
            if(equalTwoDArrays(s, ans))
               return i;
         }
      }   
      else if (x == 4){
         for(int i = 0; i < 20; i++){
            for(int r = 0; r < 3; r++){
               for(int c = 0; c < 3; c++){
                  ans[r][c] = fourScenarios.getScenarios().get(i).getBoardScenario()[r][c];
               }
            }
            if(equalTwoDArrays(s, ans))
               return i;
         }
      }   
      else{
      for(int i = 0; i < sixScenarios.getScenarios().size(); i++){
            for(int r = 0; r < 3; r++){
               for(int c = 0; c < 3; c++){
                  ans[r][c] = sixScenarios.getScenarios().get(i).getBoardScenario()[r][c];
               }
            }
            if(equalTwoDArrays(s, ans))
               return i;
         }
      } 
      return -1;  
   }
   
   public String getAttack(int x, int y, int z){
      if(z == 2)
         return twoScenarios.getAttack(x, y);
      if(z == 4)
         return fourScenarios.getAttack(x, y);
      return sixScenarios.getAttack(x, y);
   }
   
   public int getAttacks(int index, int move){
      if(move == 2)
         return twoScenarios.getAttacks(index);
      if(move == 4)
         return fourScenarios.getAttacks(index);
      return sixScenarios.getAttacks(index);
   }  
   
   //depending on the move turn, will remove the attack at desired board index and attack index of that board
   public void removeAttack(int moveTurn, int boardIndex, int attackIndex){
      if(moveTurn == 2)
         twoScenarios.removeAttack(boardIndex, attackIndex);
      else if(moveTurn == 4)
         fourScenarios.removeAttack(boardIndex, attackIndex);
      else 
         sixScenarios.removeAttack(boardIndex, attackIndex);
   }  
   
   //there happen to be only two scenarios where the computer can't make any moves, so checks to see if the gameboard looks like that
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
      temp[1][1] = "x";
      temp[2][1] = "o";
      temp[0][2] = "x";
      temp[1][2] = "o";
      if(equalTwoDArrays(board, temp))
         return true;
         
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = "";
         }
      }
            
      //case two
      temp[0][1] = "x";
      temp[1][1] = "o";
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
   
   //used for debugging
   public void printGameboard(String[][] s){
      for (String[] x : s){                          
         for (String y : x){
            System.out.print(y + " ");
         }
         System.out.println();
      }
      System.out.println();
   }
   
}