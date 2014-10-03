package netlife;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import netlife.datamodels.Commands;

/**
 * File reader class
 */
public class FileReader {
    
    //Reads from file to an Arraylist
    public static ArrayList<Commands> getCommandList(String filePath){
        ArrayList<Commands> commands = new ArrayList<>();
        String path;
        String command;
        BufferedReader b;
        
        try{
            b = new BufferedReader(new java.io.FileReader(new File(filePath)));
            try {      
                Scanner sc;
                String line = b.readLine();
                while(line!= null){
                    sc = new Scanner(line);
                    command = sc.next();
                    //Program terminates if the command isn't valid
                    if(!command.equals("ADD")){
                       if(!command.equals("DEL")){
                        System.out.println("Illigal command: " + command + ". Commands must be either 'ADD' or 'DEL'");
                        System.exit(0); 
                        }
                    }
                    path = sc.next();
                    sc.close();
                    commands.add(new Commands(command, path, ""));
                    line = b.readLine();        
                }
            }catch(Exception e){
		e.printStackTrace(); 
                System.out.println("File read, but not scanned");
		}
        }catch(FileNotFoundException e){
            //Error messages removed for smoother main interface
		}            
        return commands;
    }
}