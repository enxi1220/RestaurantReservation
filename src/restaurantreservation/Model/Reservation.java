package restaurantreservation.Model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import restaurantreservation.ADT.LinkedQueue;

/**
 *
 * @author enxil
 */
public class Reservation {

    private String _reservationTime;
    private String _customerName;
    private String _contactNo;
    private LinkedQueue<Food> _foods;

    public Reservation() {
        _reservationTime = ReservationNoGenerator();
    }

    public String getReservationTime() {
        return _reservationTime;
    }

    public Reservation setReservationTime(String reservationTime) {
        _reservationTime = reservationTime;
        return this;
    }

    public String getCustomerName() {
        return _customerName;
    }

    public Reservation setCustomerName(String customerName) {
        _customerName = customerName;
        return this;
    }

    public String getContactNo() {
        return _contactNo;
    }

    public Reservation setContactNo(String contactNo) {
        _contactNo = contactNo;
        return this;
    }

    public LinkedQueue<Food> getFoods() {
        return _foods;
    }

    public Reservation setFoods(LinkedQueue<Food> _foods) {
        this._foods = _foods;
        return this;
    }

    public void DrawReservation() {
        System.out.println("Reservation Time: " + _reservationTime);
        System.out.println("Customer Name: " + _customerName);
        System.out.println("Contact Number: " + _contactNo);
    }

    @Override
    public String toString() {
        String foods = "";
        for (int i = 0; i < this.getFoods().size(); i++) {
            Food food = this.getFoods().get(i);
            foods += food.toString();
        }
        return String.format("%s, %s, %s->%s\n", _reservationTime, _customerName, _contactNo, foods);
    }

    private static String ReservationNoGenerator() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
