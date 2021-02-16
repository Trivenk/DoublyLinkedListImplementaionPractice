package implementation;

/**
 * This class will contain doubly linked list node. Complete the class as per
 * doubly linked list specification.
 * You are free to override Object class methods and
 * also free to implement any interface from java library.
 */
public class Node {
    private int data;
    private Node next,prev;
    public Node(int data)
    {
       this.data = data;
       next = null;
       prev = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}
