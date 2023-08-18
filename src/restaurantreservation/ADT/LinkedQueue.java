package restaurantreservation.ADT;

/**
 *
 * @author enxil
 */
public class LinkedQueue<T> implements IQueue<T> {

    private Node _head;
    private Node _tail;
    private int _count = 0;

    public LinkedQueue() {
        _tail = null;
        _head = null;
    }

    @Override
    public void enqueue(T t) {
        //edit tail
        Node latest = new Node(t);
        if (isEmpty()) {
            _head = latest;
        } else {
            _tail.next = latest;
        }
        _tail = latest;
        _count++;
    }

    @Override
    public T dequeue() {
        T firstDatum = null;
        if (!isEmpty()) {
            //get data, then change linked data
            firstDatum = (T) _head.data;
            _head = _head.next;
        }
        if (_head == null) {
            _tail = null;
        }
        --_count;
        return firstDatum;
    }

    @Override
    public T getFront() {
        //peek
        if (!isEmpty()) {
            return (T) _head.data;
        }
        return null;
    }

    @Override
    public String remove(int position) {
        if (position >= _count) {
            return "Out of range";
        }
        if (isEmpty()) {
            return "Empty queue";
        }
        Node temp = _head;
        if (position == 0) {
            //is head
            dequeue();
        } else {
            for (int i = 1; i < position; i++) {
                temp = temp.next;
            }

            temp.next = temp.next.next;
        }

        --_count;
        _tail = getNode(_count - 1);

        return "Remove Successfully";
    }

    public Node getNode(int position) {
        Node temp = _head;
        for (int i = 0; i < position; i++) {
            temp = temp.next;
        }
        return temp;
    }

    @Override
    public T get(int position) {
        Node temp = getNode(position);
        return (T) temp.data;
    }

    @Override
    public String cutQueue(int position) {
        if (position >= _count) {
            return "Index number is out of range";
        }
        if (position > 0) {
            T t = get(position);
            remove(position);

            Node newNode = new Node(t);
            newNode.next = _head;
            _head = newNode;
            ++_count;
            return "Cut Queue Successfully";
        }
        return "Cut Queue Unsuccessfully";

    }

    @Override
    public boolean isEmpty() {
        return _tail == null;
    }

    @Override
    public void clear() {
        _head = null;
        _tail = null;
    }

    @Override
    public int size() {
        return _count;
    }
}
