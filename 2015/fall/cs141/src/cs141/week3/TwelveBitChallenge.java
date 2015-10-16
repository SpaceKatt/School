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
package cs141.week3;

/**
 * Which of these twelve bits are different that the others?
 * 
 * The Story:
 *     You have been a relatively successful student all quarter.
 *         On the last day of class, you sleep in and miss the final exam.
 *     Your teacher sympathizes with you, but in the syllabus they stated no 
 *         missed exams can be made up.
 *     Deciding it would be an appropriate thing to do, your teacher gave you
 *         a challenge. Fail here and you fail the class, pass and you pass.
 * 
 * The Challenge:
 *     You are given twelve bits. 
 *         1 or 0. (true or false)
 *     11 are all true or all false, and one is the opposite of the others.
 *     
 *     How do you determine which bit is different?
 * 
 *     You must only use a few built-in java statements (detailed below),
 *         and method provided by your teacher.
 * 
 *     You may only call the provided method a maximum of three times...
 * 
 *     The teacher also assigns the initial condition to be random.
 *         (i.e., the different bit might be true or false, as long
 *          as it's opposite from all the others)
 * 
 * Instructions:
 *     Rewrite the `solutionSteps` method to determine the correct answer.
 * 
 *     We are dealing with bits: "1,2,3,4,5,6,7,8,9,10,11,12"
 * 
 *     We many only call `compareValues(bits, "1,12,4", "9,5,10)` a maximum
 *         of 3 times if we want our solution to be valid.
 * 
 *     Compare 2 sets of bits to each other, using the `compareValues` 
 *         method detailed below. This method returns 0, 1, or 2.
 *             0 - Both sides are equal
 *             1 - The left string has more true bits
 *             2 - The right string has more true bits
 * 
 *     An example of what the solution will look like has been provided for
 *         you to write over.
 * 
 *     Use the code detailed in next section...
 * 
 * The Code:
 *     This should be possible using only a few built-in statements,
 *         along with a method defined in this source file.
 * 
 *     Built-in statements:
 *         `if`, `else`, `==`, and `else if`
 * 
 *     Google these if they are unclear: 
 *         google -> "if statement java"
 * 
 *                 The defined method is as follows:
 * 
 *     `int returnValue = compareValues(bits, "1,2,3,4", "5,6,7,8")`
 *     
 *     The return value of this method can be one of the following three:
 *         0, which means that "1,2,3,4,5,6,7,8" are all equal
 *         1, which means "1,2,3,4" has more true bits
 *         2, which means "5,6,7,8" has more true bits
 * 
 *     The first argument, bits, is the boolean array that contains our bits,
 *         and you also don't have to worry about it. Just include it in
 *         every call of this method.
 * 
 *     The second and third arguments are strings, which refer to which
 *         bits we are putting on which side of our evaluator (left/right).
 * 
 *     Our strings, referring to the bits we are currently comparing,
 *         must have an equal amount of numbers on each side. Our strings
 *         must also be of exactly this form: "1,2,3,4" (though may contain
 *         any numbers 1-12, in any order).
 * 
 *     The commas in between our numbers in our input string are
 *         vital, the code will break otherwise.
 * 
 *     Don't modify the code below the point where it says:
 *             "Don't edit anything below this point"
 * 
 *     An example of solution structure has been provided...
 * 
 * Hints:
 *     Try it first, then check the hint at the very end of this file~
 * 
 *     If you are confused about what is going on, run the provided example
 *         a few times. If you run this script, what is going on will be
 *         printed to your output.
 * 
 *     Seriously, check the hint at the end of the file, if you get stuck.
 * 
 * @author Thomas Kercheval
 */
import java.util.Scanner;
import java.util.Random;

public class TwelveBitChallenge {
        
    public static void main(String[] args) {
        TwelveBitChallengeSecret challenge = new TwelveBitChallengeSecret();
        challenge.startChallenge();
    }
}

class TwelveBitChallengeSecret {
    private int count;    
    private boolean zeroOne;
    
    /**
     * 
     * @param bits
     * @return 
     */
    public int solutionSteps(boolean[] bits) {
        int answer = 0;
        //// Your answer goes here...
        
        //////////////////////////////////////////////////////////////////////
        //// Example of answer structure (this doesn't work) /////////////////
        int moveOne = compareValues(bits, "1,2,3,4,5", "6,7,8,9,10");
        if (moveOne == 0) { // If "1,2,3,4,5" has the same amount of true
                            //     values as "6,7,8,9,10", execute this
                            //     following block of code...
            int returnValue = compareValues(bits, "3,10", "4,8");
                                        // This would be our second comparison
                                        //     if our first `if` statement
                                        //     proved to be true
            if (returnValue == 0) {
                answer = 12; // if "3,10" and "4,8" are equal, our answer is 12
            } else if (returnValue == 1) { // else, if "3,10" is more true...
                int returnVal = compareValues(bits, "10", "9");
                if (returnVal == 0) {
                    answer = 1;
                } else if (returnVal == 2) {
                    answer = 4;
                } else if (returnVal == 1) {
                    answer = 7;
                }
            } 
        } else if (moveOne == 1) { // If moveOne has more true bits on the 
                                   //     left side of our comparison  
                                   //     (i.e., "1,2,3,4,5"), then do...
            int moveTwo = compareValues(bits, "4,5,6", "2,3,7");
            if (moveTwo == 0) {
                int threeDeep = compareValues(bits, "2", "7");
                if (threeDeep == 0) {
                    answer = 2;
                } else { // The `else` statement executes if no `if` or
                         //     `else if` statement conditions are met.
                    answer = 9;
                }
            }
        }
        //// END example, delete this and make your own! /////////////////////
        //////////////////////////////////////////////////////////////////////
        
        return answer;
    }

//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////    
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////                                            ////////////////////
//////////////     Don't edit anything below this point   ////////////////////
//////////////                                            ////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////
    /**
     * int returnValue = compareValues(bits, "1,2,3,4", "5,6,7,8")
     * 
     * The return value of this method can be one of the following three:
     *     0, which means that 1,2,3,4,5,6,7,and 8 are all equal
     *     1, which means 1,2,3,4 has more true bits
     *     2, which means 5,6,7,8 has more true bits
     *
     * The first argument, bits, is the boolean array that contains our bits,
     *     and you also don't have to worry about it. Just include it in
     *     every call of this method.
     *
     * The second and third arguments are strings, which refer to which
     *     bits we are putting on which side of our evaluator.
     * 
     * Our strings, referring to the bits we are currently comparing,
     *      must have an equal amount of numbers on each side. Our strings
     *      must also be of exactly this form: "1,2,3,4" (though may contain
     *      any numbers 1-12, in any order).
     * 
     * The commas in between our numbers in our input string are
     *     vital, the code will break otherwise.
     * 
     * @param left
     * @param right
     * @param bits
     * @return 
     */
    public int compareValues(boolean[] bits, String left, String right) {
        click();            // Adds tick to total move count
        int value = 0;      // Initialize our return integer
        String[] leftValues = left.split(",");      // Split string at commas
        String[] rightValues = right.split(",");
        int[] leftIndex = new int[leftValues.length];    // Declare array
        int[] rightIndex = new int[rightValues.length]; // with correct size
        
        if (leftValues.length != rightValues.length) {
            String stringOne = "If both inputs aren't of equal quantity then";
            String stringTwo = " our comparison is meaningless... Try again!";
            System.out.println("\n" + stringOne + stringTwo);
            System.exit(0); // If both sides of comparison aren't
        }                   //     of equal length, exit.
        
        //////// This section below is for printing and string parsing ///////
        System.out.println("\nMove number: " + returnTotal());
        System.out.println("We are currently comparing: ");
        for (int i = 0; i < leftValues.length; i++) {
            System.out.print(leftValues[i] + " ");
            leftIndex[i] = (Integer.parseInt(leftValues[i]) - 1);
        }   //// Above line parses split string into sequence of numbers
        System.out.print(":to: ");
        for (int i = 0; i < rightValues.length; i++) {
            System.out.print(rightValues[i] + " ");
            rightIndex[i] = (Integer.parseInt(rightValues[i]) - 1);
        }   //// Index will be used to call bits out of our bits array
        System.out.print("\nAnd the the result is: ");
        //////// This section above is for printing and string parsing ///////
        
        boolean first = bits[leftIndex[0]]; // Our first true/false for left
        boolean firstEqual = true; // Assume left is equal until proved false
        boolean second = bits[rightIndex[0]]; // First true/false for right
        boolean secondEqual = true; // Assume right is equal until...
        for (int i = 1; i < leftValues.length; i++) {
            //System.out.println("Bit value " + bits[leftIndex[i]]);
            if (first == bits[leftIndex[i]]) {
                first = bits[leftIndex[i]];
            } else if (first != bits[leftIndex[i]]) { // If proved false
                firstEqual = false;                   // it is proved false...
                break;                                // and break for loop
            }
        }
        for (int i = 1; i < rightValues.length; i++) {
            if (second == bits[rightIndex[i]]) {
                second = bits[rightIndex[i]];
            } else if (second != bits[rightIndex[i]]) {
                secondEqual = false;
                break;
            }
        }
        boolean combined = firstEqual && secondEqual; // Are both equal?
        boolean greaterThanOne = leftIndex.length > 1;
        if (combined == true && first == second) {
            value = 0;
            System.out.println("The sides are equal...");
        } else if (firstEqual == this.zeroOne && greaterThanOne) {
            value = 1;
            System.out.println("The left side side is more true...");
        } else if (secondEqual == this.zeroOne && greaterThanOne) {
            value = 2;
            System.out.println("The right side is more true...");
        } else if (!greaterThanOne) { // If not greater than one...
            if (first == true) {      // and first value on left is true...
                value = 1;            // The left side is more true...
                System.out.println("The left side is more true...");
            } else if (second == true) {
                value = 2;
                System.out.println("The right side is more true...");
            }
        } else {
            System.out.println("Something weird has happened...");
            System.exit(0); // Unexpected logic has occured, exit.
        }
        System.out.println("Giving us a return value of: " + value);
        return value;
    }

    /**
     * Begins the challenge.
     * Sets up our bit array, flips the off bit.
     * Starts our solution implementation.
     * Tells us if we won, or failed...
     */
    public void startChallenge() {
        this.count = 0;  // Move count initialization
        Random zeroOneGenerator = new Random(); // Random generator
        this.zeroOne = zeroOneGenerator.nextBoolean(); // Random true or false
        boolean[] bits = new boolean[12]; // Declare boolean array, size 12
        for (int i = 0; i < 12; i++) {
            bits[i] = zeroOne;   // Set all bits to random true/false
        }
        Scanner userInput = new Scanner (System.in);
        System.out.println("Which bit did the teacher flip? ");
        int flippedBit = userInput.nextInt();  // Get user input
        if (flippedBit < 13 && flippedBit > 0) {
            bits[flippedBit - 1] = !zeroOne; // Flip bit from user input
        } else {
            System.out.println("Pick a number 1-12 and start over!");
            System.exit(0); // Catches bad input
        }
        System.out.println("\nOur initial configuration:");
        for (int i = 0; i < 12; i++) {
            System.out.print("Bit number " + (i+1) + " is: ");
            System.out.println(bits[i]);
        }
        
        int answer = solutionSteps(bits); // Where it calls our solution!
        
        System.out.println("\nGiving us an answer of: " + answer);
        System.out.println("So, after " + returnTotal() + " moves...");
        if (answer == flippedBit && count < 4) { // If answer is correct
            System.out.println("\nYou WIN!");    // and used 3 or less moves..
        } else {
            System.out.println("\nYou FAIL! Try again... ;D");
        }
    }    
    
    public int Counter() {
        this.count = 0;
        return this.count;
    }
    
    public void click() {
        this.count = this.count + 1;
    }
    
    public int returnTotal() {
        return this.count;
    }
    
    public void printTotal() {
        System.out.println(this.count);
    }    
}

// This is a java version of the 12 coins problem.
// Google it, the logical steps in the problem's solution are well documented.
// 
// Though, instead of one side of the scale being heavier or lighter,
//     one side of our evaluator is more true (which you can interpret as
//                                             either heavier or lighter).
// if (returnValue == heavier) {
//     doThis
// } else if (returnValue == lighter) { ...etc.              
//
// Remember to have fun! :D
