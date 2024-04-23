#include <iostream>
using namespace std;

template<typename T>
struct Node {
    T data;
    Node* next;

    Node(T val) : data(val), next(NULL) {}
};

template<typename T>
class Stack {
private:
    Node<T>* top;
    int sizee;

public:
    Stack() : top(NULL), sizee(0) {}

    void push(T val) {
        Node<T>* newNode = new Node<T>(val);
        newNode->next = top;
        top = newNode;
        sizee++;
    }

    T pop() {
        if (top == NULL) {
            cout << "Stack is empty" << endl;
            return T();
        }
        T data = top->data;
        Node<T>* temp = top;
        top = top->next;
        delete temp;
        sizee--;
        return data;
    }

    T topElement() {
        if (top == NULL) {
            cout << "Stack is empty" << endl;
            return T();
        }
        return top->data;
    }

    bool isEmpty() {
        return sizee == 0;
    }

    int stackSize() {
        return sizee;
    }

    void clear() {
        while (top != NULL) {
            Node<T>* temp = top;
            top = top->next;
            delete temp;
        }
        sizee = 0;
    }

    void print()  {
        if (top == NULL) {
            cout << "Stack is empty" << endl;
            return;
        }
        Node<T>* current = top;
        cout << "Stack: ";
        while (current != NULL) {
            cout << current->data << " ";
            current = current->next;
        }
        cout << endl;
    }
};

int main() {
    Stack<int> s;
    s.push(1);
    s.push(2);
    s.push(3);
    s.push(4);

    s.print();

    cout << "Top element: " << s.topElement() << endl;
    cout << "Stack size: " << s.stackSize() << endl;

    s.pop();

    cout << "Top element after pop: " << s.topElement() << endl;
    cout << "Stack size after pop: " << s.stackSize() << endl;

    cout << "Is stack empty? " << (s.isEmpty() ? "Yes" : "No") << endl;

    s.clear();
    cout << "Stack cleared." << endl;

    cout << "Is stack empty after clear? " << (s.isEmpty() ? "Yes" : "No") << endl;

    return 0;
}
