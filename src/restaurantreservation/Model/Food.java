package restaurantreservation.Model;

/**
 *
 * @author enxil
 */
public class Food {
    private String _name;
    private int _quantity;
    private char _portion;
    

    public String getName() {
        return _name;
    }

    public Food setName(String name) {
        _name = name;
        return this;
    }

    public int getQuantity() {
        return _quantity;
    }

    public Food setQuantity(int quantity) {
        _quantity = quantity;
        return this;
    }

    public char getPortion() {
        return _portion;
    }

    public Food setPortion(char portion) {
        _portion = portion;
        return this;
    }

    public void DrawFood(){
        System.out.printf(" %20s | %30s | %20s \n", _name, _quantity, _portion);
    }
    
    @Override
    public String toString(){
        return String.format("%s, %d, %s&", _name, _quantity, _portion);
    }
}
