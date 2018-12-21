package com.pq;

import java.util.Comparator;

/**
 * Priority Queue Data Structure which uses a binary heap.
 * <p>
 * It is unlimited in capacity, although there is no code to grow it after it has been constructed.
 * It can serve as a minPQ or a maxPQ (define "max" as either false or true, respectively).
 * <p>
 * It follows the code from Sedgewick and Wayne more or less. I have changed the names a bit. For example,
 * the methods to insert and remove the max (or min) element are called "give" and "take," respectively.
 * <p>
 * It operates on arbitrary Object types which implies that it requires a Comparator to be passed in.
 * <p>
 * For all details on usage, please see PriorityQueueTest.java
 *
 * @param <K>
 */

/*
    It is advised to complete the methods and test them in the following sequence. 

    1. unordered
    2. swim/sink
    3. give/take
    
*/

public class PriorityQueue<K> {

    /**
     * Basic constructor that takes the max value, an actually array of elements, and a comparator.
     *
     * @param max        whether or not this is a Maximum Priority Queue as opposed to a Minimum PQ.
     * @param binHeap    a pre-formed array with length one greater than the required capacity.
     * @param last       the number of elements in binHeap
     * @param comparator a comparator for the type K
     */
    public PriorityQueue(boolean max, Object[] binHeap, int last, Comparator<K> comparator) {

        this.max = max;
        this.comparator = comparator;
        this.last = last;
        //noinspection unchecked
        this.binHeap = (K[]) binHeap;
    }

    /**
     * Constructor which takes only the priority queue's maximum capacity and a comparator
     * @param n the desired maximum capacity.
     * @param max whether or not this is a Maximum Priority Queue as opposed to a Minimum PQ.
     * @param comparator a comparator for the type K
     */
    public PriorityQueue (int n, boolean max, Comparator<K> comparator) {

        // NOTE that we reserve the first element of the binary heap, so the length must be n+1, not n
        this(max, new Object[n + 1], 0, comparator);
    }

    /**
     * Constructor which takes only the priority queue's maximum capacity and a comparator
     * @param n the desired maximum capacity.
     * @param comparator a comparator for the type K
     */
    public PriorityQueue (int n, Comparator<K> comparator) {

        this(n, true, comparator);
    }

    /**
     * @return true if the current size is zero.
     */
    public boolean isEmpty() {
        return last == 0;
    }

    /**
     * @return the number of elements actually stored in this Priority Queue
     */
    public int size() {
        return last;
    }

    /**
     * Insert an element with the given key into this Priority Queue.
     *
     * @param key the value of the key to give
     */
    public void give(K key) {
        if (last == binHeap.length - 1)
            last--; // if we are already at capacity, then we arbitrarily trash the least eligible element
        // (even if it's more eligible than key).
        
        // TODO implement me (13 points)
      
           binHeap[++last]= key; 
           swimUp(last);
    }

    /**
     * Remove the root element from this Priority Queue and adjust the binary heap accordingly.
     * If max is true, then the result will be the maximum element, else the minimum element.
     * NOTE that this method is called DelMax (or DelMin) in the book.
     * @return If max is true, then the maximum element, otherwise the minimum element.
     * @throws PQException if this priority queue is empty
     */
    public K take() throws PQException {
        if (isEmpty()) throw new PQException("Priority queue is empty");
        K result = binHeap[1]; // get the root element (the largest or smallest, according to field max)
        // TODO implement me (15 points)
        swap(1,last--);
        sink(1);
        binHeap[last+1] =null; 
        return result;
    }

    /**
     * Sink the element at index k down
     */
    private void sink(@SuppressWarnings("SameParameterValue") int k) {
        // TODO implement me (22 points)
        int i=k;
        while(firstChild(i) <=last){
            int j= firstChild(i);
            if(j< last && unordered(j,j+1)) j++;
            if(!unordered(i,j)) break;
            swap(i,j);
            i=j;
        }
        
    }

    /**
     * Swim the element at index k up
     */
    private void swimUp(int k) {
        // TODO implement me (20 points)
        int i=k;
        while(i >1 && unordered(parent(i),i) ){
            swap(i,parent(i));
            i= parent(i);
        }
    }

    /**
     * Compare the elements at indices i and j.
     * We expect the first index (the smaller one) to be greater than the second, assuming that max is true.
     * In this case, we return false.
     *
     * @param i the lower index, numerically
     * @param j the higher index, numerically
     * @return true if the values are out of order.
     */
    private boolean unordered(int i, int j) {
        // TODO implement me (14 points)

      return ((comparator.compare(binHeap[i],binHeap[j]) <0) ^ max);
            
    }

    /**
     * Exchange the values at indices i and j
     */
    private void swap(int i, int j) {
        K tmp = binHeap[i];
        binHeap[i] = binHeap[j];
        binHeap[j] = tmp;
    }

    /**
     * Get the index of the parent of the element at index k
     */
    private int parent(int k) {
        return k / 2;
    }

    /**
     * Get the index of the first child of the element at index k.
     * The index of the second child will be one greater than the result.
     */
    private int firstChild(int k) {
        return k * 2;
    }

    /**
     * The following methods are for unit testing ONLY!!
     */

    @SuppressWarnings("unused")
    private K peek(int k) {
        return binHeap[k];
    }

    @SuppressWarnings("unused")
    private boolean getMax() {
        return max;
    }

    private final boolean max;
    private final Comparator<K> comparator;
    private final K[] binHeap; // binHeap[i] is ith element of binary heap (first element is reserved)
    private int last; // number of elements in the binary heap

}
