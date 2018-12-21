package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.less;
import static edu.neu.coe.info6205.sort.simple.Helper.swap;

public class InsertionSort<X extends Comparable<X>> implements Sort<X> {
	// private Helper h = new Helper();

    @Override
    public void sort(X[] xs, int from, int to) {
        // TODO implement insertionSort
        for(int i = from; i < to; i++) {
    		for(int j = i; j > 0; j--) {
    			if(Helper.less(xs[j], xs[j-1])) {
    				Helper.swap(xs, from, to, j, j-1);
    			}
                else break;
    		}
    	}
        //showArray(xs);
    }

    private void showArray(X[] a) {
        for(X i : a) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
