package UnitTesting;

import java.util.ArrayList;
import netlife.FileReader;
import static netlife.Logic.getFileName;
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
 
   // Checks the method isCatalog from the InputCommand class
   public static boolean CheckisCatalog(String path){
       InputCommand test = new InputCommand("DEL", "pictures/2012/", "");
       InputCommand test2 = new InputCommand("DEL", "pictures/2012", "");
       
       boolean check = test.getCatalog();
       boolean check2 = test2.getCatalog();
       return check == true && check2 == false;
   }
   
   // Checks the method getFileName from the Logic class
   public static boolean CheckGetFileName(){
       InputCommand com = new InputCommand("ADD", "bilder/2012/1.jpg", "");
       InputCommand com2 = new InputCommand("DEL", "bilder/2012/1.jpg/", "");
       
       String test = getFileName(com);
       String test2 = getFileName(com2);
       
       boolean check = test.equals("1.jpg");
       boolean check2 = test.equals("1.jpg");
       return (check && check2) == true;
       }
       
   // Checks the method isMove in the Logic class 
       /*public static boolean isMove(){ //InputCommand one, InputCommand two
        InputCommand kake = new InputCommand("DEL", "pictures/2012/1.jpg");
        InputCommand bake = new InputCommand("ADD", "bilder/2012/1.jpg");
        
        boolean path = getFileName(kake).equals(getFileName(bake));
        System.out.println("Path: " + path);
        boolean cata = kake.getCatalog() == bake.getCatalog();
        System.out.println("cata: " + cata);
        //Null check and makes sure that the commands are opposite
        boolean comm = (kake.getCommand() == null ? bake.getCommand() != null : !kake.getCommand().equals(bake.getCommand())); 
        System.out.println("comm: " + comm);
        
        boolean move = path && cata && comm;
        return move;
       }*/
   
   
   }

