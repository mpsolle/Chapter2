/**
 *
 * @author Marietta E. Cameron
 * @since 2011-12-20
 */
package vacuumagentproject;

import java.util.Random;


public class VacuumAgent {
    final static int actionCOUNT = VacuumAction.numOfMoves();
    int[] actionCounts = new int[VacuumAction.numOfMoves()];
    VacuumAction[] actionList;
   
    VacuumAgent(){
         for (int i=0; i<actionCOUNT; i++)
            actionCounts[i] = 0;
         actionList = VacuumAction.values();
    }

    public VacuumAction getAction(VacuumPercept percept){
        if (percept instanceof VacuumLocPercept)
            return getActionRandomReflex((VacuumLocPercept)percept);
        else           
            return getActionRandomReflex((VacuumBumpPercept) percept);           
    }
    
    private VacuumAction getActionRandomReflex(VacuumLocPercept percept){
        if (percept.currentStatus == Status.DIRTY)
            return VacuumAction.SUCK;
        else {//choose a move randomly
            Random gen = new Random();
            
            int index = gen.nextInt(actionList.length);
            while (!actionList[index].isAMove())
                index = (index+1) % actionList.length;
            return actionList[index];
        }
        
    }
    
   private VacuumAction getActionRandomReflex(VacuumBumpPercept percept){
         if (percept.currentStatus == Status.DIRTY)
            return VacuumAction.SUCK;
        else {//choose a move randomly
            Random gen = new Random();
            actionList = VacuumAction.values();
            int index = gen.nextInt(actionList.length);
            while (!actionList[index].isAMove() && !percept.willBump(actionList[index]))
                index = (index+1) % actionList.length;
            return actionList[index];
        }
    }   
}
