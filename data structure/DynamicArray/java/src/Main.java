import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        // Create an instance of Array class
        Array<Integer> array = new Array<>();

        // Add elements to the array
        array.add(5);
        array.add(10);
        array.add(15);
        array.add(20);

        // Print the size of the array
        System.out.println("Size of the array: " + array.size());

        // Print all elements in the array using iterator
        System.out.println("Elements in the array (using iterator):");
        Iterator<Integer> iterator = array.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        // Remove an element from the array
        array.remove(10);

        // Print the size of the array after removal
        System.out.println("Size of the array after removal: " + array.size());

        // Print all elements in the array using forEach
        System.out.println("Elements in the array (using forEach):");
        array.forEach(System.out::println);

        // Check if the array contains a specific element
        System.out.println("Does the array contain 15? " + array.contain(15));
        System.out.println("Does the array contain 25? " + array.contain(25));
    }
}