package edu.neu.coe.info6205.sort.simple;

import static edu.neu.coe.info6205.sort.simple.Helper.less;
import static edu.neu.coe.info6205.sort.simple.Helper.swap;

public class SelectionSort<X extends Comparable<X>> implements Sort<X> {
	// private Helper h = new Helper();

    @Override
    public void sort(X[] xs, int from, int to) {
        for(int i = from; i < to; i++) {
    		int minIdx = i;
    		for(int j = i+1; j < to; j++) {
    			if(Helper.less(xs[j], xs[minIdx])) minIdx = j;
    		}
            Helper.swap(xs, from, to, i, minIdx);
    	}
    }

    private void showArray(X[] a) {
        for(X i : a) {
            System.out.println(i);
        }
        System.out.println();
    }
}
