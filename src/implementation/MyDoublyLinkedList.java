package implementation;

import myinterface.DoublyLinkedListADT;

/**
 * Implement all the methods from DoublyLinkedListADT
 */

public class MyDoublyLinkedList implements DoublyLinkedListADT {
    private Node head,tail;
    private int size;
    public MyDoublyLinkedList()
    {
        head = null;
        tail = null;
        size = 0;

    }
    /**
     * This method will add a new node in the linked list at the head.
     * It is also known as insertAtBeginning or insertAtHead.
     * It also increase the size of linked list
     *
     * @param element it is the element of the sequence, we are creating
     *                an integer linked list.
     */
    @Override
    public void addFirst(int element) {
        Node node = new Node(element);
        if(isEmpty())
        {
            head = node;
            tail = node;
            size++;
            return;
        }
        head.setPrev(node);
        node.setNext(head);
        head = node;
        size++;
        return;

    }

    /**
     * This method will add a new node in the linked list at the end or tail.
     * It is also known as insertAtTail or insertAtEnd.
     * It also increase the size of linked list
     *
     * @param element it is the element of the sequence, we are creating
     *                an integer linked list.
     */
    @Override
    public void addLast(int element) {
        Node node = new Node(element);
        if(isEmpty())
        {
            head = node;
            tail = node;
            size++;
            return;
        }
        node.setPrev(tail);
        tail.setNext(node);
        tail = node;
        size++;
        return;

    }

    /**
     * This method will add a new node in the linked list after the node containing givenElement,
     * if the givenElement not present in the list it will not add the node.
     * It also increase the size of linked list if givenElement is present.
     *
     * @param element      it is the element of the sequence.
     * @param givenElement it is the element after which we have to add the node
     */
    @Override
    public void addInBetween(int element, int givenElement) {
        if(!isEmpty())
        {
            Node node = new Node(element);
            Node temp = head;
            while(temp!=null && temp.getData()!=givenElement)
            {
                temp = temp.getNext();
            }
            if(temp==null)
                return;
            if(temp.getNext()==null && temp.getData()==givenElement)
            {
                temp.setNext(node);
                node.setPrev(temp);
                tail = node;
                size++;
                return;
            }
                node.setNext(temp.getNext());
                node.setPrev(temp);
                temp.getNext().setPrev(node);
                temp.setNext(node);
                size++;
                return;


        }
        return;

    }

    /**
     * This method will remove the first node of the linked list.
     * It is also known as deleteFromHead or deleteFromBeginning.
     *
     * @return data of the first node, if list not empty, otherwise it will return 0,
     * considering 0 as invalid data.
     */
    @Override
    public int removeFirst() {
        if(!isEmpty())
        {
            Node temp = head;
            head = head.getNext();
            size--;
            return temp.getData();
        }
        return 0;
    }

    /**
     * This method will remove the last node of the linked list.
     * It is also known as deleteFromTail or deleteFromEnd.
     * This method will use tail reference to delete the last node.
     *
     * @return data of the last node, if list not empty, otherwise it will return 0,
     * considering 0 as invalid data.
     */
    @Override
    public int removeLast() {
         if(!isEmpty())
        {
            Node temp = tail;
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
            return temp.getData();
        }
        return 0;
    }

    /**
     * This method will remove the last node of the linked list.
     * It is also known as deleteFromTail or deleteFromEnd.
     * This method will not use tail reference to delete the last node.
     * In this you have to traverse and identify the last node to delete
     *
     * @return data of the last node, if list not empty, otherwise it will return 0,
     * considering 0 as invalid data.
     */
    @Override
    public int removeLastWithoutUsingTail() {
        int res = 0;
        if(!isEmpty())
        {
            Node temp = head;
            while(temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
            tail = temp.getPrev();
            tail.setNext(null);
            size--;
            res = temp.getData();
        }
        return res;
    }

    /**
     * This method will remove the given node, which contains the givenElement.
     * If givenElement present in the list, it will delete the node containing givenElement
     * otherwise it will return 0.
     *
     * @param givenElement the element of the given linked list
     * @return will return the data of deleted node, if node present in list otherwise it will
     * return 0, considering 0 as invalid data.
     */
    @Override
    public int removeGivenNode(int givenElement) {
        int res = 0;
        if(!isEmpty())
        {
            Node temp = head;
            while(temp!=null && temp.getData()!=givenElement)
            {
                temp = temp.getNext();
            }
            if(temp==head)
            {
                res = head.getData();
                head = temp.getNext();
                size--;
                return res;
            }
            if(temp == tail)
            {
                res = temp.getData();
                tail = temp.getPrev();
                tail.setNext(null);
                size--;
                return res;
            }
            res = temp.getData();
            temp.getPrev().setNext(temp.getNext());
            temp.getNext().setPrev(temp.getPrev());
            size--; 
        }
        return res;
    }

    /**
     * This method will return the data of the first node, if linked list is not empty.
     * This is also known as headElement or firstElement
     *
     * @return will return data of the first node if linked list is not empty,
     * otherwise it will return 0, considering 0 as invalid data.
     */
    @Override
    public int first() {
        if(!isEmpty())
        return head.getData();
        return 0;
    }

    /**
     * This method will return the data of the last node, if linked list is not empty.
     * This is also known as tailElement or lastElement.
     * This method will use tail reference.
     *
     * @return will return data of the last node if linked list is not empty,
     * otherwise it will return 0, considering 0 as invalid data.
     */
    @Override
    public int last() {
         if(!isEmpty())
            return tail.getData();
        return 0;
    }

    /**
     * This method will return the data of the last node, if linked list is not empty.
     * This is also known as tailElement or lastElement.
     * This method will not use tail reference.
     * In this you have to traverse and identify the last node
     *
     * @return will return data of the last node if linked list is not empty,
     * otherwise it will return 0, considering 0 as invalid data.
     */
    @Override
    public int lastWithoutUsingTail() {
        int res = 0;
        if(!isEmpty())
        {
            Node temp = head;
            while(temp.getNext()!=null)
            {
                temp = temp.getNext();
            }
            res = temp.getData();
        }
        return res;
    }

    /**
     * This method will check if linked list is empty or not.
     *
     * @return will return true is linked list is empty, otherwise false.
     */
    @Override
    public boolean isEmpty() {
        return head==null;
    }

    /**
     * This method will return total number of nodes in given linked list.
     *
     * @return will return an integer value that is total number of nodes in linked list.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * This method will print data of each node in the linked list. if linked list is not empty,
     * otherwise it will do nothing.
     */
    @Override
    public void traverse() {
         Node temp = head;
        System.out.print("[");
        while(temp!=null)
        {
            System.out.print(temp.getData()+",");
            temp = temp.getNext();
        }
        System.out.println("]");

    }

    /**
     * This method will check if the searchElement is present in the linked list.
     * You have to traverse each node and compare data of node with the searchElement.
     *
     * @param searchElement is the element we have to search in the linked list
     * @return it will return true if the searchElement is present in the list otherwise false
     */
    @Override
    public boolean search(int searchElement) {
         Node temp = head;
        while(temp!=null && temp.getData()!=searchElement)
        {
            temp = temp.getNext();
        }
        if(temp!=null)
            return true;
        return false;
    }
}
