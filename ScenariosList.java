//Aryaman Suri
import java.util.ArrayList;
/*
This class is meant to account for every possible board configuration, and then add the possible computer attacks for each respective scenario.
Creates an arraylist of each possible scenario of the game
*/
public class ScenariosList{
   private ArrayList<Scenario> scenarios;
   private String[][] board;
   private ArrayList<String> attacks;
   
   public ScenariosList(String s){                 
        board = new String[3][3];
        attacks = new ArrayList<String>();
        scenarios = new ArrayList<Scenario>();
        //resets the board to its original orientation, with 3 x's in the top row, and 3 o's in the bottom row
        resetBoard();
        //creates every possible scenario for game turn 2
        if(s.equals("two")){
         board[1][0] = "o";
         board[2][0] = "";
         attacks.add("cL");
         attacks.add("c");
         attacks.add("r");
         //turn 2, scenario 1
         //adds the potential scenario created to the scenarios array
         scenarios.add(new Scenario(copyBoard(board), attacks));
         resetBoard();
         //clears the attacks array list
         attacks = new ArrayList<String>();
         board[1][1]= "o";
         board[2][1]= "";
         attacks.add("l");
         attacks.add("lR");
         attacks.add("rL");
         attacks.add("r");
         //turn 2, scenario 2
         scenarios.add(new Scenario(copyBoard(board), attacks));
         resetBoard();
         attacks = new ArrayList<String>();
         board[1][2]= "o";
         board[2][2]= "";
         attacks.add("l");
         attacks.add("c");
         attacks.add("cR");
         //turn 2, scenario 3
         scenarios.add(new Scenario(copyBoard(board), attacks));
       }
       //creates every possible situation for turn 4
       else if(s.equals("four")){
         board[0][1] = "";
         board[1][0] = "o";
         board[2][0] = "";
         board[2][1] = "";
         attacks.add("r");
         //turn 4, scenario 1
         scenarios.add(new Scenario(copyBoard(board), attacks));
         resetBoard();
         attacks = new ArrayList<String>();
         board[0][1] = "";
         board[1][0] = "x";
         board[2][0] = "";
         board[1][1] = "o";
         board[2][1] = "";
         attacks.add("rR");
         attacks.add("r");
         attacks.add("l");
         attacks.add("lR");
         //turn 4, scenario 2
         scenarios.add(new Scenario(copyBoard(board), attacks));
         resetBoard();
         attacks = new ArrayList<String>();
         board[0][1] = "";
         board[1][0] = "x";
         board[1][2] = "o";
         board[2][0] = "";
         board[2][2] = "";
         attacks.add("l");
         attacks.add("lR");
         //turn 4, scenario 3
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[1][0] = "o";
        board[1][1] = "o";
        board[2][0] = "";
        board[2][2] = "";
        attacks.add("lR");
        attacks.add("rL");
        attacks.add("r");
        //turn 4, scenario 4
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][2] = "";
        board[1][0] = "o";
        board[1][1] = "o";
        board[1][2] = "x";
        board[2][0] = "";
        board[2][1] = "";
        attacks.add("lR");
        attacks.add("cL");
        //turn 4, scenario 5
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][2] = "";
        board[1][0] = "o";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        attacks.add("c");
        attacks.add("cR");
        //turn 4, scenario 6
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[1][0] = "x";
        board[1][1] = "o";
        board[1][2] = "o";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("cR");
        attacks.add("rL");
        //turn 4, scenario 7
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[1][0] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[1][1] = "x";
        attacks.add("cL");
        attacks.add("c");
        attacks.add("cR");
        attacks.add("r");
        //turn 4, scenario 8
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[1][1] = "o";
        board[2][0] = "";
        board[2][1] = "";
        attacks.add("rL");
        attacks.add("r");
        //turn 4, scenario 9
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[1][1] = "o";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("rL");
        attacks.add("r");
        //turn 4, scenario 10
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[1][1] = "x";
        board[1][2] = "o";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("cR");
        attacks.add("cL");
        attacks.add("c");
        //turn 4, scenario 11
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][2] = "";
        board[1][0] = "o";
        board[1][1] = "x";
        board[2][0] = "";
        board[2][1] = "";
        attacks.add("cL");
        attacks.add("cR");
        attacks.add("c");
        //turn 4, scenario 12
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][2] = "";
        board[1][1] = "o";
        board[2][2] = "";
        board[2][1] = "";
        attacks.add("l");
        attacks.add("lR");
        //turn 4, scenario 13
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][2] = "";
        board[1][1] = "x";
        board[1][2] = "o";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("l");
        attacks.add("cR");
        attacks.add("cL");
        attacks.add("c");
        //turn 4, scenario 14
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[1][1] = "o";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][2] = "";
        attacks.add("l");
        attacks.add("lR");
        attacks.add("rL");
        //turn 4, scenario 15
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[1][0] = "o";
        board[1][2] = "x";
        board[2][0] = "";
        board[2][2] = "";
        attacks.add("rL");
        attacks.add("r");
        //turn 4, scenario 16
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[1][1] = "o";
        board[1][2] = "x";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("l");
        attacks.add("lR");
        attacks.add("r");
        attacks.add("rL");
        //turn 4, scenario 17
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[1][2] = "o";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("l");
        //turn 4, scenario 18
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][2] = "";
        board[1][1] = "o";
        board[2][0] = "";
        board[2][1] = "";
        attacks.add("l");
        attacks.add("lR");
        //turn 4, scenario 19
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[1][0] = "o";
        board[1][2] = "o";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("c");
        attacks.add("cL");
        //turn 4, scenario 20
        scenarios.add(new Scenario(copyBoard(board), attacks));
       }
       //creates every possible situation for turn 6
      else if(s.equals("six")){
        board[0][0] = "";
        board[0][1] = "";
        board[1][0] = "x";
        board[1][1] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("rL");
        attacks.add("r");
        attacks.add("l");
        //turn 6, situation 1
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][0] = "";
        board[1][0] = "x";
        board[1][1] = "x";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("c");
        attacks.add("l");
        //turn 6, situation 2
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[0][2] = "";
        board[1][0] = "x";
        board[1][1] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("lR");
        attacks.add("l");
        //turn 6, situation 3
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[0][2] = "";
        board[1][0] = "x";
        board[1][1] = "x";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("l");
        attacks.add("c");
        //turn 6, situation 4
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[0][2] = "";
        board[1][0] = "o";
        board[1][1] = "o";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("lR");
        //turn 6, situation 5
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][2] = "";
        board[1][0] = "o";
        board[1][1] = "o";
        board[1][2] = "x";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("cL");
        attacks.add("r");
        //turn 6, situation 6
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][2] = "";
        board[1][0] = "x";
        board[1][1] = "o";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("cR");
        attacks.add("l");
        //turn 6, situation 7
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][1] = "";
        board[1][0] = "x";
        board[1][1] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("rL");
        attacks.add("r");
        attacks.add("l");
        //turn 6, situation 8
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][2] = "";
        board[1][1] = "x";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("cR");
        attacks.add("c");
        //turn 6, situation 9
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][2] = "";
        board[1][1] = "x";
        board[1][0] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("cL");
        attacks.add("c");
        //turn 6, situation 10
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][1] = "";
        board[1][0] = "o";
        board[1][1] = "x";
        board[1][2] = "x";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("c");
        attacks.add("r");
        //turn 6, situation 11
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][1] = "";
        board[1][1] = "o";
        board[1][2] = "x";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("rL");
        attacks.add("r");
        //turn 6, situation 12
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[0][2] = "";
        board[1][0] = "x";
        board[1][1] = "x";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("c");
        attacks.add("l");
        //turn 6, situation 13
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[0][2] = "";
        board[1][0] = "x";
        board[1][1] = "x";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("c");
        attacks.add("l");
        //turn 6, situation 14
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][1] = "";
        board[0][2] = "";
        board[1][1] = "o";
        board[1][2] = "x";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("lR");
        attacks.add("l");
        attacks.add("r");
        //turn 6, situation 15
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
        board[0][0] = "";
        board[0][1] = "";
        board[1][0] = "o";
        board[1][1] = "o";
        board[1][2] = "o";
        board[2][0] = "";
        board[2][1] = "";
        board[2][2] = "";
        attacks.add("rL");
        //turn 6, situation 16
        scenarios.add(new Scenario(copyBoard(board), attacks));
        resetBoard();
        attacks = new ArrayList<String>();
      }
      
         
      
   
   }  
   
   public ArrayList<Scenario> getScenarios(){
      return scenarios;
   }
   
   public String[][] getBoardScenario(int x){
      return scenarios.get(x).getBoardScenario();
   }
   
   public String getAttack(int x, int y){
      return scenarios.get(x).getAttack(y);
   }
   
   public int getAttacks(int index){
      return scenarios.get(index).getAttacks();
   }
   //removes desired attack at certain index
   public void removeAttack(int boardIndex, int attackIndex){
      scenarios.get(boardIndex).removeAttack(attackIndex);
   }
   
   public void resetBoard(){
         board[0][0] = "x";
         board[0][1] = "x";
         board[0][2] = "x";
         board[1][0] = "";
         board[1][1] = "";
         board[1][2] = "";
         board[2][0] = "o";
         board[2][1] = "o";
         board[2][2] = "o";
   }
   //used when creating scenario list to prevent duplicate boards, because arrays are reference variables
   public String[][] copyBoard(String[][] s){
      String[][] temp = new String[3][3];
      for(int r = 0; r < 3; r++){
         for(int c = 0; c < 3; c++){
            temp[r][c] = s[r][c];  
         }
      }
      return temp;  
   }
}   