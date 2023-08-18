package restaurantreservation.ADT;

/**
 *
 * @author enxil
 */
public class Node<T> {

    protected T data;
    protected Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
}
