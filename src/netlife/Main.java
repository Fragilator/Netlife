package netlife;

import java.util.ArrayList;
import java.util.Scanner;
import netlife.datamodels.InputCommand;

/**
 * Main class
 */
public class Main {
     
    public static void main(String[] args) {
        final String path = "C:\\Users\\Ferium\\Documents\\NetBeansProjects\\Netlife\\src\\Files\\sample.txt";
        ArrayList<InputCommand> inputCommands;
        ArrayList<InputCommand> outputCommands;
        
        inputCommands = FileReader.getCommandList(path);
        /*
        for (InputCommand print : inputCommands) {
            System.out.println("Command:" + print.getCommand() + "  Path:" + print.getPath() + "   Catalog: " + print.getCatalog() + "  File name: " + Logic.getFileName(print));
        }
        */
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        
        outputCommands = Logic.formatCommandList(inputCommands);
        for (InputCommand print : outputCommands) {
            System.out.println("Command:" + print.getCommand() + "  Path:" + print.getPath() + "   Catalog: " + print.getCatalog() + " movePath: " + print.getMovePath());
        }
        Scanner scc = new Scanner(System.in);
        int j = scc.nextInt();
    }
    
}