package edu.neu.coe.info6205.symbolTable;

import java.util.Random;

public class Experiment {

	public static void demo() {
		BSTSimple<Integer, Integer> bst = new BSTSimple<>();
		// Element number
		for(int elementNum = 100; elementNum < 2000; elementNum += 10) {
//		for(int oper = 1000; oper < 1000000; oper*=2) {
//		int elementNum = 100000;
		// Key range 0 ~ keyRange
//		int keyRange = 10000;
		int keyRange = 2*elementNum;
		// Deletes and insertions times
//		int oper = elementNum * 320;
		int oper = 10000;
		
		// Build tree with random 0 ~ 199 key values
		Random rBuild = new Random();
		for(int i = 0; i < elementNum; i++) {
			int seed = rBuild.nextInt(keyRange);
//			bst.put(seed, "'" + seed + "'");
			bst.put(seed, new Integer(1));
		}
		
//		System.out.print("Before " + oper + " times inserts and deletes, tree height: ");
//		System.out.println(bst.getMaxHeight());
//		System.out.println(bst);
		
		// 1000 times deletes and inserts
//		int deleteNum = 0, putNum = 0;
//		double deleteTimes = 0, putTimes = 0;
		Random r = new Random();
		for(int j = 0; j < oper; j++) {
			// True to Insert, False to Delete
			if(r.nextBoolean()) {
				int deleteItem = r.nextInt(keyRange);
//				double startTime = System.nanoTime();
				if(bst.contains(deleteItem)) bst.delete(deleteItem);
//				double endTime = System.nanoTime();
//				deleteTimes += (endTime - startTime);
//				deleteNum++;
			}
			else {
				int putItem = r.nextInt(keyRange);
//				double startTime = System.nanoTime();
				bst.put(putItem, new Integer(1));
//				double endTime = System.nanoTime();
//				putTimes += (endTime - startTime);
//				putNum++;
			}
		}
		
//		System.out.println("Average delete times: " + deleteTimes/(deleteNum*1000));
//		System.out.println("Average put times: " + putTimes/(putNum*1000));
//		System.out.print("After " + oper + " times inserts and deletes, tree height: ");
//		System.out.println(bst.getMaxHeight());
//		System.out.println(bst);
		
		System.out.println("Number of element: " + elementNum + " Sqrt(N): " + 
					Math.sqrt(elementNum) + " log(N): " + Math.log(elementNum)/Math.log(2) + 
					" operations: " + oper + " Height: " + bst.getMaxHeight());
		
//		System.out.println(elementNum + "\t" + Math.log(elementNum)/Math.log(2) 
//				+ "\t" + Math.sqrt(elementNum) + "\t" + bst.getMaxHeight());
		
//		System.out.println(bst.getMaxHeight());
		
//		System.out.println(elementNum + "\t" + Math.log(elementNum)/Math.log(2) + "\t" 
//				+ bst.getMaxHeight());
		
		} // End of element number
	}
}
