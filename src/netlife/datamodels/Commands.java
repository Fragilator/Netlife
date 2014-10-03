package netlife.datamodels;

/**
 * Class that holds the objects from input
 */
public final class Commands {
    String command;
    String path;
    String movePath;
    boolean catalog;
    
    public Commands(String command, String path, String movePath){
        this.command = command;
        this.path = path;
        this.movePath = movePath;
        this.catalog = isCatalog(path); 
        
    }

    public String getCommand() {
        return command;
    }
    
    public void setCommand(String command) {
        this.command = command;
    }
    
    public String getPath() {
        return path;
    }
    
    public String getMovePath() {
        return movePath;
    }

    public boolean getCatalog() {
        return catalog;
    }
    
    // Finds out if the path is a catalog
    public boolean isCatalog(String path) {
        catalog = path.substring(path.length() - 1).equals("/");
        return catalog;
    }
}
