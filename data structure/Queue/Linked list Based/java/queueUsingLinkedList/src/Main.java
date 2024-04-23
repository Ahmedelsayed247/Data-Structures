public class Main {

    public static void main(String[] args) {
        // Create a new LinkedQueue
        LinkedQueue<Integer> queue = new LinkedQueue<>();

        // Add some elements to the queue
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        // Print the size of the queue
        System.out.println("Size of the queue: " + queue.size());

        // Peek at the element at the front of the queue
        System.out.println("Peek: " + queue.top());

        // Dequeue elements from the queue until it's empty
        while (!queue.isEmpty()) {
            System.out.println("Dequeue: " + queue.dequeue());
        }

    }
}
