package netlife;

import java.util.ArrayList;
import netlife.datamodels.InputCommand;

/**
 * Main class
 */
public class Main {
     
    public static void main(String[] args) {
        final String path = "C:\\Users\\Ferium\\Documents\\NetBeansProjects\\Netlife\\src\\Files\\sample.txt";
        ArrayList<InputCommand> inputCommands;
        
        inputCommands = FileReader.getCommandList(path);
        
        for (InputCommand print : inputCommands) {
            System.out.println("Command:" + print.getCommand() + "  Path:" + print.getPath() + "   Catalog: " + print.getCatalog());
        }
        
    }
    
}
