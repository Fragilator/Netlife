package UnitTesting;

import java.util.ArrayList;
import netlife.FileReader;
import static netlife.Logic.getFileName;
import netlife.datamodels.Commands;

/**
 * Unit testing class
 */
public class Units {
    
   // Checks the method getCommandList from the FileReader class 
   public static boolean CheckGetCommandList(String path){
       boolean result = false;
       ArrayList<Commands> inputCommands;
       inputCommands = FileReader.getCommandList(path);
       for (Commands print : inputCommands) {
           if(print == null){
               result = true;
               break;
           }
           if(print.getCommand() == null || print.getPath() == null){
               result = true;
               break;
           }
       }
       return !result;
   } 
 
   // Checks the method isCatalog from the Commands class
   public static boolean CheckisCatalog(String path){
       Commands test = new Commands("DEL", "pictures/2012/", "");
       Commands test2 = new Commands("DEL", "pictures/2012", "");
       
       boolean check = test.getCatalog();
       boolean check2 = test2.getCatalog();
       return check == true && check2 == false;
   }
   
   // Checks the method getFileName from the Logic class
   public static boolean CheckGetFileName(){
       Commands com = new Commands("ADD", "bilder/2012/1.jpg", "");
       Commands com2 = new Commands("DEL", "bilder/2012/1.jpg/", "");
       
       String test = getFileName(com);
       String test2 = getFileName(com2);
       
       boolean check = test.equals("1.jpg");
       boolean check2 = test.equals("1.jpg");
       return (check && check2) == true;
       }
   }

