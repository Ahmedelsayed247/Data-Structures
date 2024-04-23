import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class DoublyLinkedList<T> implements Iterable<T> {


    private int size =0 ;
    private Node<T> head = null;
    private Node<T> tail = null;


    // O(n)
    public void clean(){
        Node<T> trav = head ;
        while (trav !=null){
            Node<T>next = trav.next ;
            trav.prev = trav.next = null ;
            trav.data = null ;
            trav = next ;

        }
        head = tail = null ;
        size = 0 ;
    }
    public int size () {
        return size ;
    }
    public boolean isEmpty(){
        return size() == 0 ;
    }
    public void addFromFirst(T element){
        if(isEmpty()){
            head = tail = new Node<T>(element ,null ,null) ;
        }
        else {
            head.prev = new Node<T>(element,null,head) ;
            head = head.prev;

        }
        size++ ;
    }
    public void addFromTail(T element){
        if(isEmpty()){
            head = tail = new Node<T>(element ,null ,null) ;
        }
        else {
            tail.next = new Node<T>(element,tail,null) ;
            tail = tail.next;

        }
        size++ ;
    }
    public void add (T element){
        addFromTail(element);
    }

    public T peekFirst (){
        if (isEmpty()) throw new RuntimeException("Empty list") ;
        return head.data;
    }
    public T peekLast (){
        if (isEmpty()) throw new RuntimeException("Empty list") ;
        return tail.data;
    }

    public T  removeFirst (){
        if (isEmpty()) throw new RuntimeException("Empty list") ;

        T data = head.data ;
        head = head.next ;
        --size ;
        if (isEmpty()){
            tail = null ;
        }
        else{
            head.prev= null ;
        }
        return data ;
    }

    public T  removeLast (){
        if (isEmpty()) throw new RuntimeException("Empty list") ;

        T data = head.data ;
        tail = tail.prev ;
        --size ;
        if (isEmpty()){
            head = null ;
        }
        else{
            tail.next= null ;
        }
        return data ;
    }
    private T remove (Node<T> node) {
        if(node.prev == null ) return removeFirst();
        if(node.next == null ) return removeLast();

        node.next.prev = node.prev;
        node.prev.next = node.next;

        T data = node.data ;
        node.data = null ;
        node = node.prev = node.next = null ;

        size-- ;
        return data ;
    }
    public T removeAt (int idx) {
     if (idx <0 || idx >=size)throw new IllegalArgumentException() ;
     int i ;
     Node<T> trav ;
     if(idx <size/2){
         for (i=0, trav = head; i!=idx;i++){
             trav = trav.next;
         }

     }
     else {
         for(i = size-1 ,trav=tail ;i!=idx ;i--){
             trav=trav.prev ;
         }
     }
     return remove(trav) ;
    }

    public boolean remove (Object obj) {
        Node<T> trav ;

        if(obj == null ){
            for(trav = head ;trav!=null;trav =trav.next){
                if(trav.data == null){
                    remove(trav) ;
                    return true;
                }

            }
        }else {
            for(trav = head ;trav!=null;trav =trav.next){
                if(obj.equals(trav.data)){
                    remove(trav) ;
                    return true;
                }
            }

        }
        return false;
    }
     public int indexOf (Object obj) {
        Node<T> trav ;
        int idx =0 ;
        if(obj == null ){
            for(trav = head ;trav!=null;trav =trav.next,idx++){
                if(trav.data == null){
                    return idx;
                }

            }
        }else {
            for(trav = head ;trav!=null;trav =trav.next,idx++){
                if(obj.equals(trav.data)){
                    return idx;
                }
            }

        }
        return -1;
    }
    public boolean contain(Object obj){
        return indexOf(obj) !=-1 ;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext())
                    throw new RuntimeException("No more elements in the list");
                T data = current.data;
                current = current.next;
                return data;
            }
        };
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Node<T> current = head;
        while (current != null) {
            action.accept(current.data);
            current = current.next;
        }
    }

    @Override
    public Spliterator<T> spliterator() {
        // Implementing the spliterator for simplicity
        return java.util.Spliterators.spliteratorUnknownSize(iterator(), Spliterator.ORDERED);
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
