/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netlife;

import java.util.ArrayList;
import static netlife.Logic.isMove;
import netlife.datamodels.InputCommand;

/**
 *
 * @author Ferium
 */
public class testing {
    public static ArrayList<InputCommand> formatCommandList(ArrayList<InputCommand> list){
        ArrayList<InputCommand> commands = list;
        ArrayList<InputCommand> check = list; //List for scanning code
        ArrayList<InputCommand> duplicates = new ArrayList<>();
        int size = list.size(); // static list because of a growing arraylist
        
        for(int i=0;i<size;i++){
            InputCommand one = list.get(i);
            for(int j=i+1;j<size;j++){
                InputCommand two = list.get(j);
                if(isMove(one, two)){
                    InputCommand move = new InputCommand("MOVE", one.getPath(), two.getPath());
                    //commands.add(move);
                    check.add(move);
                    duplicates.add(one);
                    //duplicates.add(two);
                    break;
                }
            }
        }
        
        for(InputCommand kake : duplicates){
            for(InputCommand bake : check){
                if(kake.getPath().equals(bake.getPath())){
                    commands.remove(bake);
                }
                break;
            }
        }
        
        /*
        int size2 = commands.size();
        int size3 =  commands.size();
        for(int i=0;i<size;i++){
            InputCommand one = list.get(i);
            for(int j=i+1;j<size;j++){
                InputCommand two = list.get(j);
                if(isMove(one, two)){
                    
                }
            }
        }*/
        
        //!isMove(one, two) && (one.getPath() == kake.getPath()) || (one.getPath() == kake.getMovePath())
        
        return commands;
    }
}
