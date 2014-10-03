package netlife;

import java.io.File;
import java.util.ArrayList;
import netlife.datamodels.InputCommand;

/**
 * Class for altering arrays
 */
public class Logic {
    
    // Converts the ADD and DEL commands to ADD, DEL and MOVE
     public static ArrayList<InputCommand> formatCommandList(ArrayList<InputCommand> list){
        ArrayList<InputCommand> commands = new ArrayList<>();
        ArrayList<InputCommand> listCheck = new ArrayList<>(); //Used for parsing
        
        int size = list.size(); // static list because of a growing arraylist
        boolean check;
        boolean check2;
        
        for(int i=0;i<size;i++){
            InputCommand one = list.get(i);
            check = false;
            check2 = false;
            for(int j=i+1;j<size;j++){
                InputCommand two = list.get(j);
                if(isMove(one, two)){
                    InputCommand move = new InputCommand("MOVE", one.getPath(), two.getPath());
                    commands.add(move); //adds all the MOVE commands
                    listCheck.add(move);
                    check = true;
                    break;
                }
            }
             if(check == false){
                 for(InputCommand kake : listCheck){
                     if(getFileName(one).equals(getFileName(kake)) ){
                         if (getFileName(one).equals(getMoveFileName(kake))) {
                             check2 = true;
                             break;
                         }
                     }
                 }
                 if(check2 == false){
                 commands.add(one); //adds all the ADD and DEL commands
                 }
             }
        }
        return commands;
    }
    
     //Finds the filename of path of the InputCommand object
    public static String getFileName(InputCommand obj){
        String fileName = new File(obj.getPath()).getName();
        return fileName;
    }
        //Finds the filename of movePath of the InputCommand object
        public static String getMoveFileName(InputCommand obj){
        String fileName = new File(obj.getPath()).getName();
        return fileName;
    }
    
    // Finds matching ADD and DEL commands and replaces them with one MOVE command
    public static boolean isMove(InputCommand one, InputCommand two){ 
        //InputCommand kake = new InputCommand("DEL", "pictures/2012/1.jpg");
        //InputCommand bake = new InputCommand("ADD", "bilder/2012/1.jpg");
        
        boolean path = getFileName(one).equals(getFileName(two));
        //System.out.println("Path: " + path);
        boolean cata = one.getCatalog() == two.getCatalog();
        //System.out.println("cata: " + cata);
        //Null check and makes sure that the commands are opposite
        boolean comm = (one.getCommand() == null ? two.getCommand() != null : !one.getCommand().equals(two.getCommand())); 
        //System.out.println("comm: " + comm);
        
        boolean move = path && cata && comm;
    return move;
}
    
    
}
