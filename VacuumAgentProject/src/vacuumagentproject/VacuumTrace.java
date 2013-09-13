/*
 * @author Marietta E. Cameron
 * @version 1.0
 * @since 2011-12-20
 * 
 */

package vacuumagentproject;


public class VacuumTrace {
    VacuumPercept percept;
    VacuumAction  action;
    int agentRow;
    int agentCol;
    Status newStatus;
    double performMeasure=0;
    
    VacuumTrace(VacuumPercept p, VacuumAction a, int r, int c, Status s, double m){
        percept = p;
        action  = a;
        agentRow = r;
        agentCol = c;        
        newStatus =s;
        performMeasure = m;
    }
    @Override
    public String toString(){
        return String.format("%s %s (%d,%d), %1.2f\n", percept, action, agentCol, agentRow, 
                                                               performMeasure);
        
    }
}
