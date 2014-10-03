package netlife;

import UnitTesting.Units;
import java.util.ArrayList;
import java.util.Scanner;
import netlife.datamodels.Commands;

/**
 * Main class
 */
public class Main {
     
    public static void main(String[] args) {
        ArrayList<Commands> inputCommands;
        ArrayList<Commands> outputCommands;
        ArrayList<Commands> sorted;
        
        Scanner inputText = new Scanner(System.in);
        String text;
        String path = "";
        System.out.println("Enter path-name or leave blank for a sample text: ");
        boolean check = false;
        while(check == false){
            text = inputText.nextLine();
            if(text.equals("")){
                path = "src\\Files\\sample.txt";
                break;
            } else {
                path = text;
            } if(!Units.CheckGetCommandList(path)){
                break;
            }
            System.out.println("Not a valid path, enter path-name or leave blank for a sample text: ");
        }
        inputCommands = FileReader.getCommandList(path);
        outputCommands = Logic.formatCommandList(inputCommands);
        sorted = Logic.Sort(outputCommands);
        
        //Prints everything with a dynamic length
        String format = "%1$-9s %2$-20s %3$-19s %4$-1s";
        System.out.format(format,"Command:","Source path:","Target path:","Catalog:");
        System.out.print("\n");
        for (Commands print : sorted) {
            System.out.format(format, print.getCommand()
                                    , print.getPath()
                                    , print.getMovePath()
                                    , print.getCatalog()
                                    + "\n");
        }
    }
}