/*
 * Copyright (c) 2017. Phasmid Software
 */

package edu.neu.coe.info6205.randomwalk;

import java.util.Random;

public class RandomWalk {
    private int x = 0;
    private int y = 0;
    //private int l = 5; // Temporary set step length l there.

    private final Random random = new Random();

    private void move(int dx, int dy) {
        // TODO you need to implement this
        x += dx;
        y += dy;
    }

    /**
     * Perform a random walk of m steps
     * @param m the number of steps the drunkard takes
     */
    private void randomWalk(int m) {
        for (int i = 0; i < m; i++)
            randomMove();
    }

    private void randomMove() {
        // TODO you need to implement this
        // move(random.nextInt(Integer.MAX_VALUE), random.nextInt(Integer.MAX_VALUE));
        int xSide = 0, ySide = 0, condition = 0;

        do {
            xSide = random.nextInt() % 2;
            ySide = random.nextInt() % 2;
            condition = Math.abs(xSide + ySide);
        } while(condition != 1);

        move(xSide, ySide);
    }

    public double distance() {
        // TODO you need to implement this
        //System.out.println(Math.sqrt(x*x + y*y));
        return (double) Math.sqrt(x*x + y*y);
    }

    /**
     * Perform multiple random walk experiments, returning the mean distance.
     * @param m the number of steps for each experiment
     * @param n the number of experiments to run
     * @return the mean distance
     */
    public static double randomWalkMulti(int m, int n) {
        double totalDistance = 0;
        for (int i = 0; i < n; i++){
            RandomWalk walk = new RandomWalk();
            walk.randomWalk(m);
            // System.out.println(totalDistance);
            totalDistance = totalDistance + walk.distance();
        }
        return totalDistance/n;
    }

    public static void main(String[] args) {
        if (args.length==0)
            throw new RuntimeException("Syntax: RandomWalk steps [experiments]");
        int m = Integer.parseInt(args[0]);
        int n = 30;
        if (args.length > 1) n = Integer.parseInt(args[1]);
        for(int i = 0; i < 100; i+=10) {
            double meanDistance = randomWalkMulti(m, n+i);
            System.out.println(m + " steps: " + meanDistance + " over "+ n + " experiments");
        }
    }

}
