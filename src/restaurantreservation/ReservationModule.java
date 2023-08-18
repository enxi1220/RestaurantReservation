package restaurantreservation;

import java.util.Scanner;
import restaurantreservation.ADT.LinkedQueue;
import restaurantreservation.Helper.PrintHelper;
import restaurantreservation.Helper.ValidationHelper;
import restaurantreservation.Model.Food;
import restaurantreservation.Model.Reservation;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Character.toUpperCase;

/**
 *
 * @author enxil
 */
public class ReservationModule {

    private static LinkedQueue<Reservation> _reservations = new LinkedQueue<Reservation>();
    private final static String connectionPath = "src/restaurantreservation/Database/reservations.txt";

    public static void EnqueueReservation(Scanner in) {
        _reservations.enqueue(inputFields(in));
        PrintHelper.PrintMsgBox("Added Successfully");
    }

    public static void ViewReservation() {
        if (isExist()) {
            Reservation r = _reservations.getFront();
            PrintHelper.PrintMsgBox("Reservation Information");
            r.DrawReservation();
            PrintHelper.PrintMsgBox("Food Reservation");
            DrawFoodsTable(r);
            PrintHelper.PrintShortLine();
        }
    }

    public static void DequeueReservation(Scanner in) {
        if (isExist()) {
            PrintHelper.PrintMsgBox("Reservation Information");
            Reservation r = _reservations.dequeue();
            r.DrawReservation();
            PrintHelper.PrintMsgBox("Food Reservation");
            DrawFoodsTable(r);
            PrintHelper.PrintShortLine();
            PrintHelper.PrintMsgBox("Dequeue Successfully");
        }
    }

    public static void RemoveReservation(Scanner in) {
        if (isExist()) {
            ViewAllReservation();
            int position = inputPosition(in);
            PrintHelper.PrintMsgBox(_reservations.remove(position - 1));
        }
    }

    public static void CutQueueReservation(Scanner in) {
        if (isExist()) {
            ViewAllReservation();
            int position = inputPosition(in);
            PrintHelper.PrintMsgBox(_reservations.cutQueue(position - 1));
        }
    }

    public static void ViewAllReservation() {
        if (isExist()) {
            DrawReservationTable();
            PrintHelper.PrintMsgBox("Total reservation(s): " + _reservations.size());
        }
    }

    public static int inputPosition(Scanner in) {
        String sPosition = "";
        do {
            System.out.print("Enter the index number: ");
            sPosition = in.nextLine();

        } while (!ValidationHelper.ValidDigit(sPosition));
        return Integer.parseInt(sPosition);
    }

    public static Reservation inputFields(Scanner in) {
        PrintHelper.PrintMsgBox("Reservation Information");
        System.out.print("Customer Name: ");
        String name = in.nextLine();
        System.out.print("Customer Contact Number: ");
        String contact = in.nextLine();

        String temp = "";
        LinkedQueue<Food> foods = new LinkedQueue();
        PrintHelper.PrintMsgBox("Food Reservation");
        do {
            System.out.print("Food Name: ");
            String foodName = in.nextLine();
            do {
                System.out.print("Food Quantity: ");
                temp = in.nextLine();
            } while (!ValidationHelper.ValidDigit(temp));
            int quantity = Integer.parseInt(temp);
            System.out.print("Food Portion (S/M/L): ");
            char portion = in.nextLine().charAt(0);

            foods.enqueue(new Food()
                    .setName(foodName)
                    .setQuantity(quantity)
                    .setPortion(toUpperCase(portion)));
            PrintHelper.PrintMsgBox("Do you want to continue adding?");
            System.out.print("[Y = yes]: ");
            temp = in.nextLine();
        } while ("Y".equals(temp.toUpperCase()));

        Reservation reservation = new Reservation()
                .setCustomerName(name)
                .setContactNo(contact)
                .setFoods(foods);

        return reservation;
    }

    public static boolean isExist() {
        if (_reservations.isEmpty()) {
            PrintHelper.PrintMsgBox("Reservation does not exist");
            return false;
        }
        return true;
    }

    public static void WriteFile() {
        try {
            FileWriter myWriter = new FileWriter(connectionPath);
            myWriter.write(DataToString());
            myWriter.close();
            PrintHelper.PrintMsgBox("Changed saved");
        } catch (IOException e) {
            PrintHelper.PrintMsgBox("Server might be busy, changed unsaved");
//            e.printStackTrace();
        }
    }

    public static void ReadFile() {
        try {
            File myObj = new File(connectionPath);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                InitializeData(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            PrintHelper.PrintMsgBox("Server might be busy, unable to retrieve data");
//            e.printStackTrace();
        }
    }

    private static String DataToString() {
        String data = "";
        if (!_reservations.isEmpty()) {
            for (int i = 0; i < _reservations.size(); i++) {
                data += _reservations.get(i).toString();
            }
        }
        return data;
    }

    private static void InitializeData(String data) {
        //get food
        String[] datum = data.split("->", 0);
        String[] strFood = datum[1].split("&");
        LinkedQueue<Food> foods = new LinkedQueue();
        for (String f : strFood) {
            String[] foodObj = f.split(", ");
            Food food = new Food()
                    .setName(foodObj[0])
                    .setQuantity(Integer.parseInt(foodObj[1]))
                    .setPortion(foodObj[2].charAt(0));
            foods.enqueue(food);
        }
        //get reservation
        String[] reservation = datum[0].split(", ");
        Reservation r = new Reservation()
                .setReservationTime(reservation[0])
                .setCustomerName(reservation[1])
                .setContactNo(reservation[2])
                .setFoods(foods);
        _reservations.enqueue(r);
    }

    public static void DrawReservationTable() {
        for (int i = 0; i < _reservations.size(); i++) {
            Reservation r = (Reservation) _reservations.get(i);
            System.out.println("Index Number: " + (i + 1));
            PrintHelper.PrintLine();
            r.DrawReservation();
            DrawFoodsTable(r);

            PrintHelper.PrintShortLine();
            System.out.println("");
        }
    }

    public static void DrawFoodsTable(Reservation r) {
        PrintHelper.PrintShortLine();
        System.out.printf(" %5s | %20s | %30s | %20s \n", "No.", "Food Name", "Quantity", "Portion");
        for (int j = 0; j < r.getFoods().size(); j++) {
            System.out.printf(" %5s |", j + 1);
            Food food = r.getFoods().get(j);
            food.DrawFood();
        }
    }

    public static void ClearAll() {
        _reservations.clear();
        PrintHelper.PrintMsgBox("Clear Successfully");
    }
}
