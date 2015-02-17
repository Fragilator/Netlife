package UnitTesting;

/**
 * Unit testing main class
 */
public class Testing_Main {
    public static void main(String[] args) {
      final String path = "C:\\Users\\Ferium\\Documents\\NetBeansProjects\\Netlife\\src\\Files\\sample.txt";
      
        // Checks boolean tests from the Units class
        boolean test1 = Units.CheckGetCommandList(path);
        System.out.println("Test 1: " + test1);
        boolean test2 = Units.CheckisCatalog(path);
        System.out.println("Test 2: " + test2);
        boolean test3 = Units.CheckGetFileName();
        System.out.println("Test 3: " + test3);
        boolean test4 = Units.CheckIsMove();
        System.out.println("Test 4: " + test4);
        
        //Not all methods are tested
        if(test1 && test2 && test3 && test4){
            System.out.println("All tests have passed");
        } else{
            System.out.println("One or more tests have failed");
        }
    }
}
