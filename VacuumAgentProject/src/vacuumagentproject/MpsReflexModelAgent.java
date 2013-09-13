/**
*
* @author sollemp
*/

package vacuumagentproject;
import java.util.*;

public class MpsReflexModelAgent extends VacuumAgent {

    //What we are overriding!
    
    //Have access to currentStatus and currentTime
    //Look at getActionRandomReflex and make it smarter
    //1. Just put in something to get it to work
    //command line arguments "-A MpsRelexModelAgent"
    //Make a map
    // VacuumLocPercept.perceptLoc = (VacuumLocPercept)percept;
    
    /*
int left = 0;
int forward = 1;
int right = 2;
int back = 3;
* 
* Generics:
* Data structure could be set up for int/string/any type of class created
* ArrayList<VacuumAction> possible = new ArrayList<VacuumAction>();
* int newRow = row + action.getRowMove():
* int newCol = col + actino.getColMove();
* if (map[newRow][newCol] ! WALL)
*   possible.add(action);
*/
    
    int ob = -1;
    int clean = 1;
    int pos = 0;
    
    int map[][]= new int[1000][1000];

    @Override
    public VacuumAction getAction(VacuumPercept perceptIn){        
        int x = 500;
        int y = 500;
        int row,col;
        int count = 0;
        
        VacuumBumpPercept percept = (VacuumBumpPercept) perceptIn;
        if(percept.currentStatus == Status.DIRTY) {
            map[y][x] =1;
            return VacuumAction.SUCK;
        } else {
                ArrayList<VacuumAction> possible = new ArrayList<VacuumAction>();
        //this loop determines possible actions
        for (VacuumAction action : VacuumAction.values()){
             if (action.isAMove() && (percept.willBump(action)==false)){
                 int newRow = y + action.getRowMove();
                 int newCol = x + action.getColMove();
                 map[newRow][newCol] = pos;
                     possible.add(action);
                     System.out.println("x: " + newCol + "  &  " + "y: " + newRow +  " and "+ action + "  Square is: " + pos);
             }
             if (action.isAMove() && (percept.willBump(action)==true)){
                 int newRow = y + action.getRowMove();
                 int newCol = x + action.getColMove();
                 map[newRow][newCol] = ob;
                 System.out.println("x: " + newCol + "  &  " + "y: " + newRow + " and "+ action + "  Square is: " + ob);
             } if(possible.size() > 0) {
                 VacuumAction move = possible.get(count);
                 int newRow = y + action.getRowMove();
                 int newCol = x + action.getColMove();
                 if(map[newRow][newCol] != clean) {
                    return move;
                 } else count++;
             } 
        }
//                 if(map[y-1][x] == pos) {
//                     map[y-1][x] = clean;
//                     return VacuumAction.FORWARD;                     
//                 } else if(map[y+1][x] == pos) {
//                     map[y+1][x] = clean;
//                     return VacuumAction.BACK;                      
//                 } else if(map[y][x+1] == pos) {
//                     map[y][x+1] = clean;
//                     return VacuumAction.RIGHT;                      
//                 } else if (map[y][x-1] == pos) {                    
//                     map[y][x-1] = clean;
//                     return VacuumAction.LEFT;                     
//                 }                 
            
         return VacuumAction.STOP;
        }
        
       
        
        
        
        
        
        
        
        
//        {
//        for (VacuumAction action : VacuumAction.values()) {
//             if (action.isAMove() && percept.willBump(action)){
//                 if (action == VacuumAction.LEFT) {
//                     map[x-1][y] = ob;
//                 }
//                  if (action == VacuumAction.RIGHT) {
//                     map[x+1][y] = ob;
//                 }
//                 if (action == VacuumAction.FORWARD) {
//                     map[x][y+1] = ob;
//                 }
//                 if (action == VacuumAction.BACK) {
//                     map[x][y-1] = ob;
//                 }
//             }
//             if (action.isAMove() && percept.willBump(action) == false){
//                 
//                 if (action == VacuumAction.LEFT) {
//                        map[x-1][y] = pos;
//                        System.out.println("X & Y:" + x + " "+ y + " =" + map[x][y]);
//                        return VacuumAction.LEFT;
//                 }
//                 if (action == VacuumAction.RIGHT) {
//                      map[x+1][y] = pos;
//                      System.out.println("X & Y:" + x + " "+ y + " =" + map[x][y]);
//                      return VacuumAction.RIGHT;
//                 }
//                 if (action == VacuumAction.FORWARD) {
//                     map[x][y+1] = pos;
//                     System.out.println("X & Y:" + x + " "+ y + " =" + map[x][y]);
//                     return VacuumAction.FORWARD;
//                 }
//                 if (action == VacuumAction.BACK) {;
//                     map[x][y-1] = pos;
//                     System.out.println("X & Y:" + x + " "+ y + " =" + map[x][y]);
//                     return VacuumAction.BACK;
//                 }//if dirty
//             }//if action
//                             //System.out.print(action);
//
//        }
//        
//        return null;
//        }//else
            
    }//getAction
}//MpsReflexModelAgent