package company;


import org.w3c.dom.Node;

public class funciones<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    /**
     *
     * @param value
     */
    public void insertAtHead(E value) {
        Node<E> newNode = new Node<E>(value);

        if (null == head) {

            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            newNode.prev = null;
            head.prev = newNode;
            head = newNode;
            size++;

        }


    }

    /**
     *
     *
     * @param value
     */
    public void insertAtTail(E value) {
        Node<E> newNode = new Node<E>(value);
        if (null == tail) {
            /* If list is empty */
            newNode.next = null;
            newNode.prev = null;
            head = newNode;
            tail = newNode;
            size++;
        } else {
            tail.next = newNode;
            newNode.next = null;
            newNode.prev = tail;
            tail = newNode;
            size++;
        }
    }

    /**
     *
     * @param value
     * @param position
     */
    public void insertAtPosition(E value, int position) {
        if (position < 0 || position > size) {
            throw new IllegalArgumentException("Position is Invalid");
        }
        /* Conditions check passed, let's insert the node */
        if (position == 0) {
            /* Insertion should happen at head */
            insertAtHead(value);
        } else if (position == size -1) {
            /* Insertion should happen at tail */
            insertAtTail(value);
        } else {
            /* Insertion is happening somewhere in middle */
            Node<E> currentNode = head;
            for (int i = 0; i < position; i++) {
                currentNode = currentNode.next;
            }
            Node<E> previousNode = currentNode.prev;
            /* Insertion of new node will happen in
             * between previous node and current node */
            Node<E> newNode = new Node<E>(value);
            newNode.next = currentNode;
            newNode.prev = previousNode;
            previousNode.next = newNode;
            currentNode.prev = newNode;
            size++;
        }
    }
    public void traverseForward() {
        Node<E> temp = head;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }
    public void traverseBackward() {
        Node<E> temp = tail;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.prev;
        }
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public Node<E> searchByIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index passed while searching for a value");
        }
        /* Validation passed, let's search for value using the index */
        Node<E> temp = head;
        for (int i = 0; i < index; i++) {
            /* Start from 0 and go till one less then index
             * because we are jumping to next node inside the loop */
            temp = temp.next;
        }
        return temp;
    }

    public Node<E> searchByValue(E value) {
        /* Traverse through each node until this value is found */
        Node<E> temp = head;
        while (null != temp.next && !temp.item.equals(value)) {
            temp = temp.next;
        }
        if (temp.item.equals(value)) {
            return temp;
        }
        return null;
    }
    public void deleteFromHead() {
        /* If list is empty, return */
        if (null == head) {
            return;
        }
        Node<E> temp = head;
        head = temp.next;
        head.prev = null;
        size--;
    }
    public void deleteFromTail() {
        /* If list is empty, return */
        if (null == tail) {
            return;
        }
        Node<E> temp = tail;
        tail = temp.prev;
        tail.next = null;
        size--;
    }
    public void deleteFromPosition(int position) {
        if (position < 0 || position >= size) {
            throw new IllegalArgumentException("Position is Invalid");
        }
        /* Conditions check passed, let's delete the node */
        Node<E> nodeToBeDeleted = head;
        for (int i = 0; i < position; i++) {
            nodeToBeDeleted = nodeToBeDeleted.next;
        }
        Node<E> previousNode = nodeToBeDeleted.prev;
        Node<E> nextNode = nodeToBeDeleted.next;
        previousNode.next = nextNode;
        nextNode.prev = previousNode;
        size--;
    }
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node<E> x = head; x != null; x = x.next) {
            result[i++] = x.item;
        }
        return result;
    }
    public class Node<T> {

        /* Data item in the node */
        T item;

        /* Pointer to next node */
        Node<T> next;

        /* Pointer to previous node */
        Node<T> prev;

        /* Constructor to create a node */
        public Node(T item) {
            this.item = item;
        }

        /* toString implementation to print just the data */
        @Override
        public String toString() {
            return String.valueOf(item);
        }    }



}
