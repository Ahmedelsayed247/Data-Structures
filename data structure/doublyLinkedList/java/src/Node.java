public class Node<T>{
    T data ;
    Node<T>next , prev ;
    public Node(T data , Node<T> prev ,Node<T> next){
        this.data = data ;
        this.next = next ;
        this.prev = prev ;
    }
    @Override
    public String toString(){
        return data.toString() ;
    }

}