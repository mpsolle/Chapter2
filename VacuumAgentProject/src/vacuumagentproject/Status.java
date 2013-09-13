/**
 *
 * @author Marietta E. Cameron
 * @since 2011-12-20
 */
package vacuumagentproject;

/**
          * Status enumeration indicates the possible status for each square unit in 
          * VacuumEnvironment's floor.
     */
    public enum Status{
         
          OBSTACLE('X'),
          DIRTY('D'),
          CLEAN('-');
          private char charRep; //char that would be used in an array or string rep
          public char getChar(){
              return charRep;
          }//getChar
          Status(char initChar){
              charRep = initChar;
          }//Status
     }//enum Status
     