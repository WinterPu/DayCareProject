package edu.neu.coe.info6205.union_find;

import java.util.Random;

public class Client {

	/* Take the argument n, create n sites and return how much edges do they connected together */
	public static int count(int n) {
		int edges = 0;
		UF_HWQUPC w = new UF_HWQUPC(n, true);
		//WQUPC w = new WQUPC(n);
		while(w.components() > 1) {
			int[] pair = randomPairGen(n);
			if(!w.connected(pair[0], pair[1])) {
				w.union(pair[0], pair[1]);
			}
			edges++;
		}
		return edges;
	}
	
	/* Randomly generate (0 ~ number-1) */
	public static int[] randomPairGen(int number) {
		int[] rPair = new int[2];
		Random r = new Random();
		int first = r.nextInt(number);
		int second = r.nextInt(number);
		while(first == second) {
			second = r.nextInt(number);
		}
		rPair[0] = first;
		rPair[1] = second;
		return rPair;
	}
	
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		int initial = 100;
		//System.out.println("n" + "%5dmean # edges" + "%10d1/2 n ln n");
		System.out.printf("%s%20s%15s%n", "n", "mean # edges", "1/2 n ln n");
		while(initial <= 204800) {
			int n = initial;
			int[] edges = new int[100]; // Test 100 times and get there means
			for(int t = 0; t < 100; t++) {
				edges[t] = count(initial);
			}
			
			double sum = 0;
			for(double d : edges) {
				sum += d;
			}
			
			System.out.printf("%-9d%-17.2f%-27.2f%n", initial, sum/edges.length, 0.5*n*Math.log(n));
//			System.out.print(intial);
//			System.out.print("\t" + sum/edges.length);
//			System.out.print("\t\t\t" + 0.5*n*Math.log(n));
//			System.out.println();
			initial *= 2;
		}
		/* This section is for input arguments
		int n = Integer.parseInt(args[0]);
		int trials = Integer.parseInt(args[1]);
		int[] edges = new int[trials];
		
		for(int t = 0; t < trials; t++) {
			edges[t] = count(n);
		}
		
		double sum = 0;
		for(double i : edges) {
			sum += i;
		}
		
		System.out.println("1/2 n ln n = " + 0.5*n*Math.log(n));
		System.out.println("mean       = " + sum/edges.length);
		*/

		long endTime = System.currentTimeMillis();
		double time = (endTime - startTime) / 1000.0;
		System.out.println("\nElapsed Time is: " + time);
	}
}
