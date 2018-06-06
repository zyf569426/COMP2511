
/**
 * An action that repeatedly removes a greeting from a queue.
 */
public class Consumer implements Runnable {
    /**
     * Constructs the consumer object.
     * @param aQueue the queue from which to retrieve greetings
     * @param count the number of greetings to consume
     */
    public Consumer(BoundedQueue<String> aQueue, int count) {
        queue = aQueue;
        greetingCount = count;
    }

    @Override
    public void run() {
        try {
            int i = 1;

            // Commented out code was checking if queue was empty.
            // This is now moved to the remove() method.
            while (i <= greetingCount) {
                // if (!queue.isEmpty()) {
                String greeting = queue.remove();
                System.out.println(greeting);
                i++;
                // }
                Thread.sleep((int)(Math.random() * DELAY));
            }
        } catch (InterruptedException exception) {

        }
    }

    private BoundedQueue<String> queue;
    private int greetingCount;

    private static final int DELAY = 10;
}
