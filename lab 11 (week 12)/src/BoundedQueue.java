
/**
 * Bounded queue implemented in a 'wrap-around' style.
 *
 * @author Kane Walter
 */
public class BoundedQueue<E> {
    /**
     * Constructs an empty queue.
     *
     * @param capacity Maximum capacity of the queue.
     */
    public BoundedQueue(int capacity) {
       elements = new Object[capacity];
       head = 0;
       tail = 0;
       size = 0;
    }

    /**
     * Removes the object at the head.
     *
     * @precondition !isEmpty()
     * @return       the object that has been removed from the queue
     */
    public synchronized E remove() throws InterruptedException {
        // Added this wait() call to provided code.
        // wait() causes this thread to be added to a set of threads
        // waiting for a condition to be satisfied (then this thread
        // will wake up). In this case we are waiting for the queue to
        // not be empty.
        while (size == 0)
            wait();

        E r = (E) elements[head];

        head++;
        size--;

        if (head == elements.length)
            head = 0;

        // Added this notifyAll() call to provided code.
        // This will notifyAll() threads that are blocked and waiting
        // for the queue to be not empty.
        notifyAll();

        return r;
    }

    /**
     * Appends an object at the tail.
     *
     * @param        newValue the object to be appended
     * @precondition !isFull();
     */
    public synchronized void add(E newValue)
            throws InterruptedException {
        // Added this wait() call to provided code.
        // wait() causes this thread to be added to a set of threads
        // waiting for a condition to be satisfied (then this thread
        // will wake up). In this case we are waiting for the queue to
        // not be full.
        while (isFull())
            wait();

        elements[tail] = newValue;

        tail++;
        size++;

        if (tail == elements.length)
           tail = 0;

        // Added this notifyAll() call to provided code.
        // This will notifyAll() threads that are blocked and waiting
        // for the queue to be not full.
        notifyAll();

    }

    public boolean isFull() {
       return size == elements.length;
    }

    public boolean isEmpty() {
       return size == 0;
    }

    public void setDebug(boolean newValue) {
       debug = newValue;
    }

    private Object[] elements;
    private int head;
    private int tail;
    private int size;
    private boolean debug;
}
