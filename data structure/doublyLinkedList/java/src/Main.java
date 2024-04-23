public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Adding elements to the list
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Printing the list using forEach
        System.out.println("List elements using forEach: " + list);

        // Printing the list using iterator
        System.out.print("List elements using iterator: ");
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Printing the list using spliterator
        System.out.print("List elements using spliterator: ");
        list.spliterator().forEachRemaining(System.out::print);
        System.out.println();

        // Removing elements from the list
        list.removeFirst();
        list.removeLast();

        // Printing the modified list
        System.out.println("Modified List after removing first and last elements: " + list);

        // Checking if list contains a certain element
        System.out.println("Does list contain 30? " + list.contain(30));
        System.out.println("Does list contain 100? " + list.contain(100));

        // Getting the index of an element
        System.out.println("Index of element 20: " + list.indexOf(20));

        // Iterating through the list using for-each loop
        System.out.print("List elements: ");
        for (Integer element : list) {
            System.out.print(element + " ");
        }
        System.out.println();

        // Clearing the list
        list.clean();
        System.out.println("List after clearing: " + list);
    }
}
