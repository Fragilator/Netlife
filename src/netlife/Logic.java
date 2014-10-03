package netlife;

import java.io.File;
import java.util.ArrayList;
import netlife.datamodels.Commands;

/**
 * Logic class
 */
public class Logic {
    
     // Converts the ADD and DEL commands to ADD, DEL and MOVE
     public static ArrayList<Commands> formatCommandList(ArrayList<Commands> list){
        ArrayList<Commands> commands = new ArrayList<>();
        ArrayList<Commands> listCheck = new ArrayList<>(); //Used for parsing
        int size = list.size(); // static list size because of a growing arraylist
        boolean check;
        boolean check2;
        
        for(int i=0;i<size;i++){
            Commands one = list.get(i);
            check = false;
            check2 = false;
            for(int j=i+1;j<size;j++){
                Commands two = list.get(j);
                // Checks for potensial MOVE commands
                if(isMove(one, two)){ 
                    Commands move = new Commands("MOVE", one.getPath(), two.getPath());
                    commands.add(move); //adds all the MOVE commands
                    listCheck.add(move);
                    check = true;
                    break;
                }
            }
            // Filters out ADD and DEL commands not transformed into MOVE
            if(check == false){
                for(Commands kake : listCheck){
                    if(getFileName(one).equals(getFileName(kake)) ){
                        if (getFileName(one).equals(getMoveFileName(kake))) {
                            check2 = true;
                            break;
                        }
                    }
                }
                if(check2 == false){
                    commands.add(one); // adds all the ADD and DEL commands
                }
            }
        }
       return commands;
    }
    
     //Finds the filename of path of the Commands object
     public static String getFileName(Commands obj){
        String fileName = new File(obj.getPath()).getName();
     return fileName;
    }
     //Finds the filename of movePath of the Commands object
     public static String getMoveFileName(Commands obj){
        String fileName = new File(obj.getPath()).getName();
     return fileName;
    }
    
     // Finds matching ADD and DEL commands and replaces them with one MOVE command
     public static boolean isMove(Commands one, Commands two){ 
        boolean path = getFileName(one).equals(getFileName(two));
        boolean cata = one.getCatalog() == two.getCatalog();
        //Null check and makes sure that the commands are opposite
        boolean comm = (one.getCommand() == null ? two.getCommand() != null : !one.getCommand().equals(two.getCommand())); 
     return path && cata && comm;
     }
     
     public static ArrayList<Commands> Sort(ArrayList<Commands> list){
         ArrayList<Commands> commands = new ArrayList<>();
         
         for(Commands var1 : list){
             if(var1.getCommand().equals("ADD")){
                 commands.add(var1);
                }
         }
         for(Commands var2 : list){
             if(var2.getCommand().equals("MOVE")){
                 commands.add(var2);
             }  
         }
         for(Commands var3 : list){
             if(var3.getCommand().equals("DEL")){
                 commands.add(var3);
             }
         }
         return commands;
     }
}
