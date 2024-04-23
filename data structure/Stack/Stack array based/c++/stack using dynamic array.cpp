#include <iostream>

using namespace std;

template<typename T>
class Stack {
private:
    T* arr;
    int top;
    int capacity;

public:
    Stack() {
        capacity = 5;
        arr = new T[capacity];
        top = -1;
    }

    ~Stack() {
        delete[] arr;
    }

    void push(T element) {
        if (top >= capacity - 1) {
            int newcap = capacity * 2;
            T* newArr = new T[newcap];

            for (int i = 0; i <= top; i++) {
                newArr[i] = arr[i];
            }

            delete[] arr;
            arr = newArr;
            capacity = newcap;
        }
        top++ ;
        arr[top] = element;
    }

    T pop() {
        if (isEmpty()) {
            cout << "Stack is empty" << endl;
            return T();
        }
        return arr[top--];
    }

    T topElement() {
        if (isEmpty()) {
            cout << "Stack is empty" << endl;
            return T();
        }
        return arr[top];
    }

    bool isEmpty() {
        return top == -1;
    }

    int stackSize() {
        return top + 1;
    }

    void clear() {
        top = -1;
    }

    void print() {
        cout << "Stack elements: ";
        for (int i = top; i >= 0; i--) {
            cout << arr[i] << " ";
        }
        cout << endl;
    }
};

int main() {
    Stack<int> stack;

    stack.push(10);
    stack.push(20);
    stack.push(30);
    cout << "Stack size: " << stack.stackSize() << endl;
    cout << "Top element: " << stack.topElement() << endl;

    cout << stack.pop() << endl;
    cout << "Stack size after pop: " << stack.stackSize() << endl;
    cout << "Top element after pop: " << stack.topElement() << endl;

    stack.print();

    return 0;
}
