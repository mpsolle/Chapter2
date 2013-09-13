/**
 *
 * @author Marietta E. Cameron
 * @since 2011-12-20
 */
package vacuumagentproject;


public enum VacuumAction {
       LEFT(-1,0, true), FORWARD(0,-1, true), RIGHT(1,0,true), BACK(0,1,true), SUCK(0,0,false),
       STOP(0,0,false);
       VacuumAction(int dxInit, int dyInit, boolean move){
           dx = dxInit; dy = dyInit;
           movement = move;
       }
       static int moveCount = 4;
       int dx,dy, pos;
       boolean movement;
       int getRowMove(){
           return dy;
       }
       int getColMove(){
           return dx;
       }
       boolean isAMove(){
           return movement;
       }
       static public int numOfMoves(){
           return moveCount;
       }
}
