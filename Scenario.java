//Aryaman Suri
/*
Represents one possible scenario for the computer's move.
Holds a "gameboard" and the possible attacks the computer can do as an arraylist in accordance with that gameboard configuration.
*/
import java.util.ArrayList;
public class Scenario{
   private String[][] boardScenario;
   private ArrayList<String> attacks;
   
   public Scenario(String[][] y, ArrayList<String> z){
      boardScenario = y;
      attacks = z;
   }
   
   public String[][] getBoardScenario(){
      return boardScenario;
   }
   
   public String getAttack(int x){
      return attacks.get(x);
   }
   
   public int getAttacks(){
      return attacks.size();
   }
   
   public void removeAttack(int x){
      attacks.remove(x);
   }
}