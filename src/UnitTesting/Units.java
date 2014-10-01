package UnitTesting;

import java.util.ArrayList;
import netlife.FileReader;
import netlife.datamodels.InputCommand;


/**
 * Unit testing class
 */
public class Units {
   
    
   // Checks the method getCommandList from the FileReader class 
   public static boolean CheckGetCommandList(String path){
       boolean result = true;
       ArrayList<InputCommand> inputCommands;
       inputCommands = FileReader.getCommandList(path);
       for (InputCommand print : inputCommands) {
           if(print == null){
               result = false;
               break;
           }
           if(print.getCommand() == null || print.getPath() == null){
               result = false;
               break;
           }
       }
       return result;
   } 
 
   public static boolean CheckisCatalog(String path){
       InputCommand test = new InputCommand("DEL", "pictures/2012/");
       InputCommand test2 = new InputCommand("DEL", "pictures/2012");
       
       boolean check = test.getCatalog();
       boolean check2 = test2.getCatalog();
     //  if(check == true && check2 == false){
     //      return true;
      // }
       return check == true && check2 == false;
   }
}
