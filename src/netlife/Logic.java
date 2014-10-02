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
        String name;
        
        for(int i=0;i<list.size();i++){
            InputCommand one = list.get(i);
            for(int j=i+1;j<list.size();j++){
                InputCommand two = list.get(j);
                System.out.println("one: " + one.getPath());
                System.out.println("Two: " + two.getPath());
            }
        }
        
        
        
        
        return commands;
    }
    
    public static String getFileName(InputCommand obj){
        String fileName = new File(obj.getPath()).getName();
        return fileName;
    }
    
    
    
    
}
