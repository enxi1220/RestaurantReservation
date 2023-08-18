package restaurantreservation;

import restaurantreservation.Helper.PrintHelper;
import java.util.Scanner;

/**
 *
 * @author enxil
 */
public class RestaurantReservation {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationModule.ReadFile();
        ShowMenu(scanner);
    }

    public static void ShowMenu(Scanner scanner) {
        while (true) {
            PrintHelper.PrintTitle("Chong Qing Huo Guo Kitchen Reservation Service");
            System.out.println("1. Add New Reservation");//enqueue
            System.out.println("2. Remove First Reservation");//dequeue
            System.out.println("3. Delete Reservation");//remove
            System.out.println("4. View Current Reservation");//getFront
            System.out.println("5. View All Reservations");//loop get(i)
            System.out.println("6. Cut Queue Reservation");//cutQueue
            System.out.println("7. Clear All Reservations");//clear()
            System.out.println("(-1 to Exit)");
            System.out.println();
            System.out.print("Please select your choice: ");
            String choice = scanner.nextLine();
            
            
            switch (choice) {
                case "1":
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("Add Reservation");
                    ReservationModule.EnqueueReservation(scanner);
                    PrintHelper.Pause();
                    break;
                case "2":
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("Dequeue Reservation");
                    ReservationModule.DequeueReservation(scanner);
                    PrintHelper.Pause();
                    break;
                case "3":
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("Remove Reservation");
                    ReservationModule.RemoveReservation(scanner);
                    PrintHelper.Pause();
                    break;
                case "4":
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("View Current Reservation");
                    ReservationModule.ViewReservation();
                    PrintHelper.Pause();
                    break;
                case "5":
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("View All Reservation");
                    ReservationModule.ViewAllReservation();
                    PrintHelper.Pause();
                    break;
                case "6":
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("Cut Queue Reservation");
                    ReservationModule.CutQueueReservation(scanner);
                    PrintHelper.Pause();
                    break;
                case "7":
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("Clear All Reservations");
                    ReservationModule.ClearAll();
                    PrintHelper.Pause();
                    break;
                case "-1":
                    ReservationModule.WriteFile();
                    PrintHelper.ClearConsole();
                    PrintHelper.PrintTitle("Exit...Goodbye");
                    return;
                default:
                    PrintHelper.PrintMsgBox("Selection does not exist, please try again");
            }

        }
    }
}
