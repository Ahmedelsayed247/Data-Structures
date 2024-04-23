#include <iostream>

using namespace std;

class Queue {
private:
    int* arr;
    int first;
    int last;
    int size;
    int capacity;

public:
    Queue() {
        capacity = 1;
        arr = new int[capacity];
        first = 0;
        last = -1;
        size = 0;
    }

    ~Queue() {
        delete[] arr;
    }

    bool isEmpty() {
        return size == 0;
    }

    void push(int val) {
        if (size == capacity) {
            int newCapacity = capacity *2 ;
            int* new_arr = new int[newCapacity];
            for (int i = 0; i < size; i++) {
                new_arr[i] = arr[i];
            }
            first = 0;
            last = size - 1;
            capacity = newCapacity ;
            delete[] arr;
            arr = new_arr;
        }

        last++ ;
        arr[last] = val;
        size++;
    }

    void pop() {
        if (isEmpty()) {
            cout << "Queue is empty. Cannot dequeue." << endl;
            return;
        }

        first++ ;
        size--;
    }

    int getFront() {
        if (!isEmpty()) {
            return arr[first];
        }
        return -1;
    }

    int getBack() {
        if (!isEmpty()) {
            return arr[last];
        }
        return -1;
    }

    int getSize() {
        return size;
    }
    int getCapacity() {
    return capacity ;
    }

    void print () {
     while (!isEmpty()){
        cout << arr[first] << " " ;
        pop() ;
     }
    }
    /*

    void printQueue() {
        if (isEmpty()) {
            cout << "Queue is empty." << endl;
            return;
        }

        cout << "Queue elements: ";
        int current = first;
        for (int i = 0; i < size; i++) {
            cout << arr[current] << " ";
            current++ ;
        }
        cout << endl;
    }*/
};

int main() {
    Queue q;
    q.push(5);
    q.push(4);
    q.push(6);




    q.print();
    cout << endl ;
    cout << q.getCapacity() ;

    return 0;
}
