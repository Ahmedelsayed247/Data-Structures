public class Main {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        // Pushing elements onto the stack
        stack.push(10);
        stack.push(20);
        stack.push(30);

        // Printing the size of the stack
        System.out.println("Size of the stack: " + stack.size());

        // Checking if the stack is empty
        System.out.println("Is the stack empty? " + stack.isEmpty());

        // Peeking at the top element of the stack
        System.out.println("Top element of the stack: " + stack.top());

        // Popping elements from the stack
        System.out.println("Popping elements from the stack:");
        while (!stack.isEmpty()) {
            System.out.println("Popped element: " + stack.pop());
        }

    }
}
