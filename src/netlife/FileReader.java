package netlife;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import netlife.datamodels.InputCommand;

/**
 * File reader class
 */
public class FileReader {
    
    
    public static ArrayList<InputCommand> getCommandList(String filePath){
        ArrayList<InputCommand> commands = new ArrayList<>();
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
                    path = sc.next();
                    sc.close();
                    commands.add(new InputCommand(command, path, ""));
                    line = b.readLine();        
                }
            }catch(Exception e){
		e.printStackTrace(); //Mer feilhåndtering?
                System.out.println("File read, but not scanned");
		}
        }catch(FileNotFoundException e){
            e.printStackTrace(); //Mer feilhåndtering?
            System.out.println("File not read");
		}            
        return commands;
    }
}