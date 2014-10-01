package netlife.datamodels;

/**
 *
 * Class that holds the objects from input
 */
public final class InputCommand {
    String command;
    String path;
    boolean catalog;
    
    
    public InputCommand(String command, String path){
        this.command = command;
        this.path = path;
        this.catalog = isCatalog(path);
        
    }

    public String getCommand() {
        return command;
    }

    public String getPath() {
        return path;
    }
    public boolean getCatalog() {
        return catalog;
    }
    
    public boolean isCatalog(String path) {
        catalog = path.substring(path.length() - 1).equals("/");
        return catalog;
    }
    
    
    
}
