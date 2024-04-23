#include <iostream>
using namespace std;

template<typename T>
struct Node {
    T data;
    Node* next;

    Node(T val) : data(val), next(NULL) {}
};

template<typename T>
class Queue {
private:
    Node<T>* head;
    Node<T>* tail;
    int sizee;

public:
    Queue() : head(NULL), tail(NULL), sizee(0) {}

    void enqueue(T val) {
        Node<T>* newNode = new Node<T>(val);
        if (tail == NULL) {
            head = tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
        sizee++;
    }

    T dequeue() {
        if (head == NULL) {
            cout << "Queue is empty" << endl;
            return T();
        }
        T data = head->data;
        Node<T>* temp = head;
        head = head->next;
        if (head == NULL) {
            tail = NULL;
        }
        delete temp;
        sizee--;
        return data;
    }

    T first() {
        if (head == NULL) {
            cout << "Queue is empty" << endl;
            return T();
        }
        return head->data;
    }

    bool isEmpty() {
        return sizee == 0;
    }

    int queueSize() {
        return sizee;
    }

    void clear() {
        while (head != NULL) {
            Node<T>* temp = head;
            head = head->next;
            delete temp;
        }
        tail = NULL;
        sizee = 0;
    }

    void print() const {
        if (head == NULL) {
            cout << "Queue is empty" << endl;
            return;
        }
        Node<T>* current = head;
        cout << "Queue: ";
        while (current != NULL) {
            cout << current->data << " ";
            current = current->next;
        }
        cout << endl;
    }
};


int main() {
    Queue<int> q;
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);

    q.print();

    cout << "First element: " << q.first() << endl;
    cout << "Queue size: " << q.queueSize() << endl;

    q.dequeue();

    cout << "First element after dequeue: " << q.first() << endl;
    cout << "Queue size after dequeue: " << q.queueSize() << endl;

    cout << "Is queue empty? " << (q.isEmpty() ? "Yes" : "No") << endl;

    q.clear();
    cout << "Queue cleared." << endl;

    cout << "Is queue empty after clear? " << (q.isEmpty() ? "Yes" : "No") << endl;

    return 0;
}
