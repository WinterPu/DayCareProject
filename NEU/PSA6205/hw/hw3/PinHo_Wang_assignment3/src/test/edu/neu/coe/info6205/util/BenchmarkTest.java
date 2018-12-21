/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.simple.InsertionSort;
import edu.neu.coe.info6205.sort.simple.SelectionSort;
import edu.neu.coe.info6205.sort.simple.Sort;
import org.junit.Test;

import java.util.Random;
import java.util.function.Function;

import static org.junit.Assert.assertEquals;

@SuppressWarnings("ALL")
public class BenchmarkTest {

    //@Test
    public void sort() throws Exception {
        Random random = new Random();
        int m = 100; // This is the number of repetitions: sufficient to give a good mean value of timing
        Integer[] array1 = new Integer[10000];
        for (int i = 0; i < 10000; i++) array1[i] = random.nextInt();
        double ts = benchmarkSort(array1, "SelectionSort", new SelectionSort<>(), m);
        Integer[] array2 = new Integer[10000];
        for (int j = 0; j < 10000; j++) array2[j] = random.nextInt();
        double ti = benchmarkSort(array2, "InsertionSort", new InsertionSort<>(), m);
        // The timing for selection sort and insertion sort should be about the same for random input.
        assertEquals(ts, ti, 1E-2);
    }


    private static double benchmarkSort(Integer[] array, String name, Sort<Integer> sorter, int m) {
        Function<Integer[], Void> sortFunction = (xs) -> {
            sorter.sort(xs);
            return null;
        };
        Benchmark<Integer[]> bm = new Benchmark<>(sortFunction);
        return bm.run(array, m);
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(BenchmarkTest.class);
    }

}