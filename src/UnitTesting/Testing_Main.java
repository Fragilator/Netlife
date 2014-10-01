package UnitTesting;

/**
 *
 * Unit testing main class
 */
public class Testing_Main {
    public static void main(String[] args) {
      final String path = "C:\\Users\\Ferium\\Documents\\NetBeansProjects\\Netlife\\src\\Files\\sample.txt";
      
        // Checks the method getCommandList from the FileReader class
        boolean test1 = Units.CheckGetCommandList(path);
        System.out.println("Test 1: " + test1);
        boolean test2 = Units.CheckisCatalog(path);
        System.out.println("Test 2: " + test2);
        boolean test3 = Units.CheckGetFileName();
        System.out.println("Test 3: " + test3);
    }
}
