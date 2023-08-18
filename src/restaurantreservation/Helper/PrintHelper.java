package restaurantreservation.Helper;

/**
 *
 * @author enxil
 */
public class PrintHelper {
    public static void PrintHeadings() {
        System.out.println("\n================================================================================================================================================================================================================================================\n");
    }

    public static void PrintLine() {
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }

    public static void PrintShortLine() {
        System.out.println("-------------------------------------------------------------------------------------------");
    }
    
    public static void PrintTitle(String title){
        PrintHelper.PrintHeadings();
        System.out.println("   " + title);
        PrintHelper.PrintHeadings();
    }

    public static void PrintMsgBox(String msg){
        System.out.println("\n.----------------------------------------------.");
        System.out.printf("| %-44s |", msg);
        System.out.println("\n'----------------------------------------------'\n");
    }
    
    public static void ClearConsole() {
        for (int i = 0; i < 30; i++) {
            System.out.print("\n");
        }
    }
    
    public static void Pause(){
        System.out.println("Press any key to continue...");
        new java.util.Scanner(System.in).nextLine();
        ClearConsole();
    }
}
