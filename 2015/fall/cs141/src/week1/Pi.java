/*
 * Copyright (C) 2015 Thomas Kercheval
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package week1;

/**
 * This little bit-lit determines pi to six sig-figs,
 *     and no more.
 * 
 * Though, it also displays the number of times we needed to
 *     iterate through a loop to determine the needed accuracy.
 *         (At least needed for this implementation...)
 * 
 * NOTE: To see what this program is doing, delete comments preceeding
 *           all print statements. All relevant print statements are commented 
 *           out at the beginning of their line.
 *               (This will result in a loss of program speed...)
 * 
 * @author Thomas Kercheval
 */
public class Pi 
{
    /**
     * The main() method here calls another method in the class,
     *     a loop (piLoop) to determine the values. piLoop then
     *     also calls another method.
     * 
     * piLoop() returns an array (basically a list of values). The
     *     elements of the array are then assigned to other 
     *     variables, or printed out. The reason to assign an
     *     element of an array to another variable is so we can
     *     make modifications on the element while improving the
     *     readability of the code.
     * 
     * compare() returns true or false depending on if the first several
     *     digits are equal in value and order.
     * 
     * Note: the phrase `values[0]` grabs the element at position 0
     *     of the array named "values".
     * 
     * @param args
     */
    public static void main(String[] args) 
    {
        double[] values = piLoop(); // piLoop is a method to determine pi
        double sixFigs = Math.floor(100000 * values[0]) / 100000;
            //// The line above this one makes the double prettier to print
        
        String someString = "Iterations needed to find pi to 6 sig-figs: ";
        System.out.println("Pi: " + sixFigs);
        System.out.println(someString + values[1]);
    }
    
    public static double[] piLoop()
    {
        double varx = 1; // What we will use to tell which iteration we are on
        double consOne = 1; // ALWAYS one
        double oldPi = 1; // Our first term in the series
        double posSum = 0; // Sum of positive terms
        double negSum = 0; // Sum of negative terms
        double[] values = new double[2]; // Declares an array, with two slots
            //// The slots in an array can be called elements of the array
        boolean infLoop = true;
        while (infLoop) { 
            double newNegSum = negSum + (4 / ((4 * varx) - 1)); // Math
            double newPosSum = posSum + (4 / ((4 * varx) + 1)); // Math
                /* These two lines above are terms in the infinite series
                 *     that calculates the value of pi in mathematics.
                 * Each time we pass through the loop, we take two more terms
                 */
//            System.out.println("pos:" + posSum + " neg: " + negSum);
            double currPi = 4 * consOne + posSum - negSum; // Current pi value
            
            if (compare(oldPi, currPi) & 
               (compare(newNegSum, negSum) ^ compare(newPosSum, posSum))
               ) {
            /* The above if statement can be read as:
             *   IF the return value of compare(oldPi, currPi) is true,
             *   AND the retrun value of either compare(newNegSum, negSum)  
             *   OR compare(newPosSum, posSum) are true, then execute
             *   the following block of code...
             */
                values[0] = currPi; // Put currPi in slot zero(0) of values
                values[1] = varx;  // Make varx an element of values at one(1)
                return values; /* This statement breaks the while loop.
                                * return statements pass values to the
                                *    thing that called the method
                                */
            }
            // If our if condition isn't met, the rest of the loop will play
            posSum = newPosSum; // Update our sums
            negSum = newNegSum;
//            System.out.println("varx: " + varx);
//            System.out.println("currPi: " + currPi);
            varx = varx + 1; // Increment our loop value by one
            oldPi = currPi; // Update old value for comparison
        }
        return values; // This should never execute...
    }

    public static boolean compare (double oldPi, double currPi) 
    {
        /* This method multiplies a double by 5-orders of magnitude,
         *     then truncates (removes) the remaining decimals.
         * We do this so we can tell if the first several digits are equal,
         *     in both value and order.
         */
        double sixFigOld = Math.floor(oldPi * 100000);
        double sixFigCurr = Math.floor(currPi * 100000);
//        System.out.println(sixFigOld + " vs. " + sixFigCurr);
        return sixFigCurr == sixFigOld; // returns true if equal, false if not
    }
}
