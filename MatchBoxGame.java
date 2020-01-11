//Aryaman Suri
//game class, controls everything that happens
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class MatchBoxGame{
	private CPU computer;
	private Player player;
	private String[][] gameboard;
   //boolean for each individual game played
   private boolean gameOver;
   //boolean for the while loop for the entire game, where multiple rounds are played. Goes until user chooses to quit
   private boolean endGame;
   private int cpuWins;
   private int playerWins;
   private int moveTurn;
	
	public static void main(String[] args){
      CPU computer = new CPU();
      Player player = new Player();
      MatchBoxGame game = new MatchBoxGame(computer, player);
     
      //used to store where what attack the computer used, will be deleted if it loses
      int attackIndex;
      int moveTurnTrack;
      int boardIndex;
      
      //Text on startup
      System.out.println("Welcome to Hexapawn!");
      System.out.println("The game is simple. You are playing against the computer.");
      System.out.println("Everytime the computer loses, it will learn and become better at the game.");
      System.out.println("The game is a 3x3 grid, with your pawns represented by an \"o\",");
      System.out.println("and the computer's pawns represented by an \"x\".");
      System.out.println("Here is what the board looks like when the game starts.");
      game.printGameboard();
      System.out.println("The pawns work like they do in chess, meaning they can move forward one space or attack diagonally.");
      System.out.println("Someone wins by either getting their pawn to the opposite side or by not allowing their");
      System.out.println("opponent to have a possible move.");
      System.out.println("You can move by entering a certain combination of letters.");
      System.out.println("The moves are as follows: l - move left pawn forward. lR - left pawn attacks diagonally to the right.");
      System.out.println("c - center pawn moves forward. cL - center pawn attacks diagonally left.");
      System.out.println("cR - center pawn attacks diagonally to the right. r - right pawn moves forward.");
      System.out.println("rL - right pawn attacks diagonally left.");
      System.out.println("Important notes - capitalization matters! And, if a center pawn attacks left, it is now in the");
      System.out.println("left column and will be considered a left pawn. This is true for all other pawns.");
      System.out.println("After every game, if you'd like to play again, simply press the enter key when asked.");
      System.out.println("If you'd like to quit, type \"x\".");
      System.out.println("After every game, the score will show to see how well you are doing.");
      System.out.println("To fully experience the computer learning, it is recommended that you");
      System.out.println("play as many games as you can.");
      System.out.println("Good luck and enjoy!");
      System.out.println();
      
      
      while(!game.getEndGame()){
         attackIndex = 0;
         moveTurnTrack = 0;
         boardIndex = 0;
         
         game.printGameboard();
         
         while(!game.getGameOver()){
         
         //user will move       
         System.out.println("Select a move.");
         Scanner in = new Scanner(System.in);
         String move = in.nextLine();
         //makes sure they put in valid input
         while(!player.canMove(game.getGameboard(), move)){
            System.out.println("Invalid move. Select another move.");
            move = in.nextLine();
         }
         //will rearrange the gameboard depending on the move
         game.playerMove(move);
         game.moveTurn();
         game.printGameboard();
         
         //checks to see if the player won by doing their last move
         if(game.playerWin()){
               game.playerWinOne();
               //deletes the computers last attack so they remove a "losing" move
               computer.removeAttack(moveTurnTrack, boardIndex, attackIndex);
               //breaks the loop so the individual game is over
               game.setGameOver(true);
               System.out.println("Congratulations! You win!");
               break;
         }
         
         System.out.println("Computer's turn.");
         //cpu turn mechanic
         
         //array to store the index of which scenario had the matching board, and the index of which attack the computer executed
         int[] tracker = new int[2]; 
         //computerMove() returns the index of which scenario had the matching board, and the index of which attack the computer executed     
         tracker = game.computerMove();
         moveTurnTrack = game.getMoveTurn();
         boardIndex = tracker[0];
         attackIndex = tracker[1];
         
         game.moveTurn();

         game.printGameboard();
         
         //checks to see if the computer won after their last turn
         if(game.cpuWin()){
               game.cpuWinOne();
               game.setGameOver(true);
               System.out.println("The Computer Wins!");
               break;
         }
     
      }
      
      //shows wins of player vs computer after every game, asks if player wants to play again
      System.out.println("Your wins: " + game.getPlayerWins());
      System.out.println("Computer wins: " + game.getCpuWins());
      System.out.println("Would you like to continue playing?");
      System.out.println("Press the enter key to continue or \"x\" to quit.");
      Scanner in = new Scanner(System.in);
      String ans = in.nextLine();
      while(!ans.equals("") && !ans.equals("x")){
         System.out.println("Invalid answer. Please try again.");
         ans = in.nextLine();
      }
      if(ans.equals("x")){
         System.out.println("Thanks for playing!");
         game.setEndGame(false);
         break;
         }
      else
         game.restart();
         
     }
         
   }
   
   
   public MatchBoxGame(CPU computer, Player player){
		this.computer = computer;
		this.player = player;
      cpuWins = 0;
      playerWins = 0;
      moveTurn = 1;
		gameboard = new String[3][3];
		for(int i = 0; i < 3; i++){
			gameboard[0][i] = "x";
		}
		for(int i = 0; i < 3; i++){
			gameboard[2][i] = "o";
		}
      for(int i = 0; i < 3; i++){
			gameboard[1][i] = "";
		}
      
      gameOver = false;
	}
   
   public boolean getEndGame(){
      return endGame;
   }
   
   public boolean getGameOver(){
      return gameOver;
   }
   
   public String[][] getGameboard(){
      return gameboard;
   }
   
   public void printGameboard(){
      for (String[] x : gameboard){                          
         for (String y : x){
            if(y.equals(""))
               System.out.print("  ");
            else
               System.out.print(y + " ");
         }
         System.out.println();
      }
      System.out.println();

   }
   
   public void playerWinOne(){
      playerWins++;
   }
   
   public void cpuWinOne(){
      cpuWins++;
   }
   
   public int getPlayerWins(){
      return playerWins;
   }
   
   public int getCpuWins(){
      return cpuWins;
   }
   
   //checks to see if player has won
   public boolean playerWin(){
      //checks if pawn has reached other side
      for(int i = 0; i < 3; i++){
         if(gameboard[0][i].equals("o"))
            return true;
      }
      
      //if computer can't move
      if(computer.cantMove(gameboard))
         return true;
      
      return false;
   }
   
   //checks to see if cpu won
   public boolean cpuWin(){
      //checks if pawn has reached other side
      for(int i = 0; i < 3; i++){
         if(gameboard[2][i].equals("x"))
            return true;
      }
      
      //if player can't move
      if(player.cantMove(gameboard))
         return true;
      
      return false;
   }
   
   public void setGameOver(boolean t){
      gameOver = t;
   }
   
   public void setEndGame(boolean t){
      endGame = t;
   }
   
   public void moveTurn(){
      moveTurn++;
   }
   
   public void setMoveTurn(int x){
      moveTurn = x;
   }
   
   public int getMoveTurn(){
      return moveTurn;
   }
   
   //player movement, rearranges the game board based on string that player enters
   public void playerMove(String s){
      //move left pawn up
      if(s.equals("l")){
         if(gameboard[1][0].equals("o")){
            gameboard[1][0] = "";
            gameboard[0][0] = "o";
         }
         else{
            gameboard[2][0] = "";
            gameboard[1][0] = "o";
         }    
       } //left pawn attacks right
       else if(s.equals("lR")){
         if(gameboard[1][0].equals("o")){
            gameboard[1][0] = "";
            gameboard[0][1] = "o";
         }
         else{
            gameboard[2][0] = "";
            gameboard[1][1] = "o";
         } 
       } //center pawn moves forward
       else if(s.equals("c")){
         if(gameboard[1][1].equals("o")){
            gameboard[1][1] = "";
            gameboard[0][1] = "o";
         }
         else{
            gameboard[2][1] = "";
            gameboard[1][1] = "o";
         } 
       } //center pawn attacks left
       else if(s.equals("cL")){
         if(gameboard[1][1].equals("o")){
            gameboard[1][1] = "";
            gameboard[0][0] = "o";
         }
         else{
            gameboard[2][1] = "";
            gameboard[1][0] = "o";
         } 
       } //center pawn attacks right
       else if(s.equals("cR")){
         if(gameboard[1][1].equals("o")){
            gameboard[1][1] = "";
            gameboard[0][2] = "o";
         }
         else{
            gameboard[2][1] = "";
            gameboard[1][2] = "o";
         } 
       } //right pawn moves forward
       else if(s.equals("r")){
         if(gameboard[1][2].equals("o")){
            gameboard[1][2] = "";
            gameboard[0][2] = "o";
         }
         else{
            gameboard[2][2] = "";
            gameboard[1][2] = "o";
         } 
       } //right pawn attacks left
       else if(s.equals("rL")){
         if(gameboard[1][2].equals("o")){
            gameboard[1][2] = "";
            gameboard[0][1] = "o";
         }
         else{
            gameboard[2][2] = "";
            gameboard[1][1] = "o";
         } 
       }     
   }
   
   //computer movement
   public int[] computerMove(){
      int[] ans = new int[2];
      //checks to see if the move turn is 2, 4, or 6 so it knows which scenariolist to look in
      if(moveTurn == 2){
         //gets index of which scenario board matches the current gameboard, and then gets a random attack that the computer can do based on that scenario
         int index = computer.getScenarioBoard(2, gameboard);
         int attack = (int)(Math.random()*computer.getAttacks(index, 2));
         String s = computer.getAttack(index, attack, 2);
         computerAttack(s);
         ans[0] = index;
         ans[1] = attack;
      }
      else if(moveTurn == 4){
         int index = computer.getScenarioBoard(4, gameboard);
         int attack = (int)(Math.random()*computer.getAttacks(index, 4));
         String s = computer.getAttack(index, attack, 4);
         computerAttack(s);
         ans[0] = index;
         ans[1] = attack;
      }
      else{
         int index = computer.getScenarioBoard(6, gameboard);
         int attack = (int)(Math.random()*computer.getAttacks(index, 6));
         String s = computer.getAttack(index, attack, 6);
         computerAttack(s);
         ans[0] = index;
         ans[1] = attack;
      }
      //returns an array storing the board and attack index, will be later deleted if the computer loses
      return ans;
   }
   
   //similar to playerMove(String s), rearranges board based on attack
   public void computerAttack(String s){
      //move left pawn down
      if(s.equals("l")){
         if(gameboard[1][0].equals("x")){
            gameboard[2][0] = "x";
            gameboard[1][0] = "";
         }
         else{
            gameboard[1][0] = "x";
            gameboard[0][0] = "";
         }    
       } //left pawn attacks right
       else if(s.equals("lR")){
         if(gameboard[0][0].equals("x") && gameboard[1][1].equals("o")){
            gameboard[1][1] = "x";
            gameboard[0][0] = "";
         }
         else{
            gameboard[1][0] = "";
            gameboard[2][1] = "x";
         } 
       } //center pawn moves forward
       else if(s.equals("c")){
         if(gameboard[1][1].equals("x")){
            gameboard[2][1] = "x";
            gameboard[1][1] = "";
         }
         else{
            gameboard[1][1] = "x";
            gameboard[0][1] = "";
         } 
       } //center pawn attacks left
       else if(s.equals("cL")){
         if(gameboard[0][1].equals("x") && gameboard[1][0].equals("o")){
            gameboard[1][0] = "x";
            gameboard[0][1] = "";
         }
         else{
            gameboard[1][1] = "";
            gameboard[2][0] = "x";
         } 
       } //center pawn attacks right
       else if(s.equals("cR")){
         if(gameboard[0][1].equals("x")&& gameboard[1][2].equals("o")){
            gameboard[1][2] = "x";
            gameboard[0][1] = "";
         }
         else{
            gameboard[1][1] = "";
            gameboard[2][2] = "x";
         } 
       } //right pawn moves forward
       else if(s.equals("r")){
         if(gameboard[1][2].equals("x")){
            gameboard[2][2] = "x";
            gameboard[1][2] = "";
         }
         else{
            gameboard[0][2] = "";
            gameboard[1][2] = "x";
         } 
       } //right pawn attacks left
       else if(s.equals("rL")){
         if(gameboard[0][2].equals("x") && gameboard[1][1].equals("o")){
            gameboard[1][1] = "x";
            gameboard[0][2] = "";
         }
         else{
            gameboard[1][2] = "";
            gameboard[2][1] = "x";
         } 
       }
   }
   
   //gotten from https://examples.javacodegeeks.com/core-java/util/arrays/compare-two-dimensional-arrays/
   //compares to see if two 2D are equal, used in finding the right scenario board
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
   
   //returns board to original state
   public void resetBoard(){
         gameboard[0][0] = "x";
         gameboard[0][1] = "x";
         gameboard[0][2] = "x";
         gameboard[1][0] = "";
         gameboard[1][1] = "";
         gameboard[1][2] = "";
         gameboard[2][0] = "o";
         gameboard[2][1] = "o";
         gameboard[2][2] = "o";
   }
   
   //restarts the game by resetting the board and moveTurn
   public void restart(){
      moveTurn = 1;
		gameboard = new String[3][3];
		for(int i = 0; i < 3; i++){
			gameboard[0][i] = "x";
		}
		for(int i = 0; i < 3; i++){
			gameboard[2][i] = "o";
		}
      for(int i = 0; i < 3; i++){
			gameboard[1][i] = "";
		}
      
      gameOver = false;
   }
}