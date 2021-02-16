package main;

public class MyMain {
    public static void main(String[] args) {
        //create MyDoublyLinkedList instance and
        // call all the method to test your implementation
        MyDoublLinkedList ll = new MyLinkedList();
        ll.addFirst(12);
        ll.addLast(13);
        ll.addLast(14);
        ll.traverse();
        System.out.println(ll.size());
        System.out.println(ll.first()+" "+ll.last());
        ll.removeFirst();
        ll.removeLast();
        ll.addLast(17);
        ll.addFirst(16);
        ll.addLast(28);
        ll.removeGivenNode(16);
        ll.traverse();
        System.out.println(ll.search(16)+" "+ll.isEmpty());
    }
}
