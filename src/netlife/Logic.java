package netlife;

import java.io.File;
import java.util.ArrayList;
import netlife.datamodels.InputCommand;

/**
 * Class for altering arrays
 */
public class Logic {
    
    public static ArrayList<InputCommand> getCommandList(String filePath){
        ArrayList<InputCommand> commands = new ArrayList<>();
      
        
        
        
        
        return commands;
    }
    
    public static String getFileName(InputCommand obj){
        String fileName = new File(obj.getPath()).getName();
        return fileName;
    }
    
    
    
    
}
