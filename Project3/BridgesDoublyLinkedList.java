/****************************************************************************
 * BridgesDoublyLinkedList.java
 ****************************************************************************
 * This is a class that utilizes the Bridges API to create a Doubly linked list that stores, finds, and prints out 35
 * states. With the Bridges API this class creates a Doubly innked list with the methods Insert, append, remove,
 * moveToStart, moveToEnd, prev, next, length, currPos, moveToPos, isAtEnd, getValue, isEmpty, and a toString that
 * prints out the elements in the doubly linked list. Each method performs specific actions  that allow you to modify
 * and traverse through the doubly linked string.
 *_____________________________________________________
 * Pratham Choksi
 * 03/19/2021
 * CMSC 256-004
 ****************************************************************************/

package cmsc256;

import bridges.base.DLelement;
import bridges.connect.Bridges;


public class BridgesDoublyLinkedList<E> implements List<E> {
    private DLelement<E> first;
    private DLelement<E> last;
    private DLelement<E> curr;
    private int size;


    public BridgesDoublyLinkedList() {
        clear();
    }

    public BridgesDoublyLinkedList(DLelement<E> node) {
        first = new DLelement<>();
        last = new DLelement<>();
        node.setPrev(first);
        node.setNext(last);
        first.setNext(node);
        last.setPrev(node);
        curr = node;
        size = 1;
    }

    // Remove all contents from the list, so it is once again empty
    @Override
    public void clear() {
        first = new DLelement<>();
        last = new DLelement<>();
        first.setNext(last);
        last.setPrev(first);
        curr = last;
        size = 0;
    }

    // Insert "it" at the current location
    // The client must ensure that the list's capacity is not exceeded
    @Override
    public boolean insert(E it) {

        curr = new DLelement<>(it, curr, curr.getPrev());
        curr.getPrev().setNext(curr);
        curr.getNext().setPrev(curr);
        size++;
        return true;
    }

    // Append "it" at the end of the list
    // The client must ensure that the list's capacity is not exceeded
    @Override
    public boolean append(E it) {
        curr = last;
        insert(it);
        return true;
    }

    // Remove and return the current element
    @Override
    public E remove() {
        if (curr == last) {
            return last.getValue();
        }
        E it = curr.getValue();
        curr.getPrev().setNext(curr.getNext());
        curr.getNext().setPrev(curr.getPrev());
        curr = curr.getNext();
        size--;
        return it;
    }

    // Set the current position to the start of the list
    @Override
    public void moveToStart() {
        curr = first.getNext();
    }

    // Set the current position to the end of the list
    @Override
    public void moveToEnd() {
        curr = last;
    }

    // Move the current position one step left, no change if already at beginning
    @Override
    public void prev() {
        if (curr != first) {
            curr = curr.getPrev();
        }
    }

    // Move the current position one step right, no change if already at end
    @Override
    public void next() {
        if (curr != last) {
            curr = curr.getNext();
        }
    }

    // Return the number of elements in the list
    @Override
    public int length() {
        return size;
    }

    // Return the position of the current element
    @Override
    public int currPos() {
        DLelement<E> temp = first.getNext();
        int i;
        for(i=0; curr != temp; i++) {
            temp = temp.getNext();
        }
        if(isEmpty()) {
            return -1;
        }
        return i;
    }

    // Set the current position to "pos"
    @Override
    public boolean moveToPos(int pos) {
        if ((pos < 0) || (pos > size)) {
            return false;
        }
        curr = first.getNext();
        for(int i=0; i<pos; i++) {
            curr = curr.getNext();
        }
        return true;
    }

    // Return true if current position is at end of the list
    @Override
    public boolean isAtEnd() {
        return curr == last;
    }

    // Return the current element
    @Override
    public E getValue() {
        return curr.getValue();
    }

    //returns true or false if the list is empty.
    public boolean isEmpty() {
        return size == 0;
    }

    //returns the values in each node of the doubly linked list as a string.
    public String toString() {
        StringBuilder string = new StringBuilder();
        curr = first.getNext();
        while(curr != last) {
            string.append(curr.getValue()).append(" ");
            curr = curr.getNext();
            }
        return string.toString();
    }


    public static void main(String[] args){
        Bridges bridges = new Bridges(4, "prathch2", "981657926324");
        BridgesDoublyLinkedList<String> states = new BridgesDoublyLinkedList<>();

        states.insert("Texas");
        states.insert("Florida");
        states.insert("California");
        states.insert("Minnesota");
        states.insert("Virginia");
        states.insert("Georgia");
        states.insert("Alaska");
        states.insert("Washington");
        states.insert("Hawaii");
        states.insert("Michigan");
        states.insert("Arizona");
        states.insert("Ohio");
        states.insert("New Jersey");
        states.insert("Maine");
        states.insert("Utah");
        states.insert("Nevada");
        states.insert("Pennsylvania");
        states.insert("Massachusetts");
        states.insert("Colorado");
        states.insert("North Carolina");
        states.insert("Oregon");
        states.insert("New York");
        states.insert("Maryland");
        states.insert("Alabama");
        states.insert("Tennessee");
        states.insert("Montana");
        states.insert("Wisconsin");
        states.insert("Louisiana");
        states.insert("Kentucky");
        states.insert("South Carolina");
        states.insert("Connecticut");
        states.insert("New Mexico");
        states.insert("Delaware");
        states.insert("Nebraska");
        states.insert("Idaho");

        System.out.println(states);

        bridges.setDataStructure(states.first);
        try {
            bridges.visualize();
        }
        catch(Exception exc) {
            System.out.println(exc.getMessage());
        }
    }

}
