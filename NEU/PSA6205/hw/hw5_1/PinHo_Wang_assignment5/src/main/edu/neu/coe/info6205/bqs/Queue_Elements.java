/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.bqs;

import java.util.Iterator;

public class Queue_Elements<Item> implements Iterable<Item>, Queue<Item>  {

    /**
     * Construct a new (empty) queue.
     */
    public Queue_Elements() {
        oldest = null;
        newest = null;
    }

    /**
     * Enqueue the given item into the linked list referenced by oldest
     *
     * @param item the item to add
     */
    public void enqueue( Item item) {
        // TODO
    	Element element = new Element<>(item);
        Element secondNewest = newest;
        if (isEmpty()) oldest = element;
        else {
            assert secondNewest != null; // Redundant Check
            secondNewest.next = element;
        }
        this.newest = element;
    }


    /**
     * Dequeue an element from the oldest list and return the item.
     *
     * @return the value of the oldest element.
     */
    public Item dequeue() {
    	if (isEmpty()) return null;
        else {
            assert oldest != null; // Redundant assertion
            Item result = oldest.item;
            oldest = oldest.next;
            if (isEmpty()) newest = null;
            return result;
            }
    }

    public boolean isEmpty() {
        return oldest == null;
    }

    // This Element essentially begins a LinkedList of Elements which correspond
    // to the elements that can be taken from the queue (head points to the oldest element).
    // However, it is built in manner that requires a pointer to the newest element.
    private Element<Item> oldest;

    // This Element always points to the newest (tail-most) element in the LinkedList referenced by oldest.
    private Element<Item> newest;

    @Override
    public String toString() {
        return (oldest!=null?"Queue: next: "+oldest+(oldest.next!=null?" and others...":""):"empty");
    }

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }

    class QueueIterator implements Iterator<Item> {
        public boolean hasNext() {
            return next!=null;
        }
        public Item next() {
            Item result = next.item;
            next = next.next;
            return result;
        }
        Element<Item> next = oldest;

    }
}
