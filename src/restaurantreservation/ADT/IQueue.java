package restaurantreservation.ADT;

/**
 *
 * @author enxil
 */
public interface IQueue<T> {
//    add an entry to the back of the queue
    void enqueue(T object);
    
//    remove the entry at the front of the queue
    T dequeue();
    
//    remove the entry in the queue
    String remove(int position);

//    check if the queue is empty
    boolean isEmpty();

//    retrieve the front object in the queue wihout removing
    T getFront();
    
//    remove all entries in the queue
    void clear();
    
//    return the number of entries in the queue
    int size();
    
//    return an entry
    T get(int position);
    
//move an entry to the front of queue
    String cutQueue(int position);
}