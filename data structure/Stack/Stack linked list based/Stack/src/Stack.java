import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

public class Stack <T>{
private java.util.LinkedList<T> list = new LinkedList<T>();
    public Stack(){}
    public Stack(T firstElement) {
    push(firstElement) ;
    }
    public int size() {
    return list.size();
    }
    public boolean isEmpty(){
       return size()==0 ;}
    public void push(T element){
     list.addLast(element); ;
    }
    public T pop(){
        if(isEmpty())throw new EmptyStackException();
        return list.removeLast() ;
    }
    public T top (){
        if(isEmpty())throw new EmptyStackException();
        return list.peekLast();
    }


}
