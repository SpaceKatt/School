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
 *     Your teacher sympathizes with you, but in the syllabus stated no 
 *         missed exams can be made up.
 *     Deciding it would be an appropriate thing to do, your teacher gave you
 *         a challenge. Fail here and you fail the class, pass and you pass.
 * 
 * The Challenge:
 *     You are given twelve bits. 
 *         1 or 0.
 *     
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
    
    /**
     * 
     * @param bits
     * @return 
     */
    public int solutionSteps(boolean[] bits) {
        int answer = 0;
        //// Your answer goes here...
        
        //// Example of answer structure (this doesn't work)
        if (compareValues(bits, "1,2,3,4,5,6", "7,8,9,10,11,12") == 0) {
            
        } else {
            answer = 2;
        }
        //// END example, delete this and make your own!
        return answer;
    }
    
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

    /**
     * 
     * @param left
     * @param right
     * @param bits
     * @return 
     */
    public int compareValues(boolean[] bits, String left, String right) {
        click();
        int value = 0;
        String[] leftValues = left.split(",");
        String[] rightValues = right.split(",");
        int[] leftIndex = new int[leftValues.length];
        int[] rightIndex = new int[rightValues.length];
        
        //////// This section below is for printing and string parsing ///////
        System.out.println("\nMove number: " + returnTotal());
        System.out.println("We are currently comparing: ");
        for (int i = 0; i < leftValues.length; i++) {
            System.out.print(leftValues[i] + " ");
            leftIndex[i] = Integer.parseInt(leftValues[i]) - 1;
        }
        System.out.print("to: ");
        for (int i = 0; i < rightValues.length; i++) {
            System.out.print(rightValues[i] + " ");
            rightIndex[i] = Integer.parseInt(rightValues[i]) - 1;
        }
        System.out.println("\nAnd the the result is: ");
        //////// This section above is for printing and string parsing ///////
        
        boolean first = bits[leftIndex[0]];
        boolean second = bits[rightIndex[0]];
        for (int i = 1; i < leftValues.length; i++) {
            first = !(first ^ bits[leftIndex[i]]);
        }
        for (int i = 1; i < rightValues.length; i++) {
            second = !(second ^ bits[rightIndex[i]]);
        }
        boolean combined = first & second;
        
        if (combined == true) {
            value = 0;
        } else if (first == true) {
            value = 1;
        } else if (second == true) {
            value = 2;
        } else {
            System.out.println("Something weird has happened...");
            System.exit(0);
        }
        
        return value;
    }

    /**
     * 
     * 
     */
    public void startChallenge() {
        this.count = 0;
        Random zeroOneGenerator = new Random();
        boolean zeroOne = zeroOneGenerator.nextBoolean();
        boolean[] bits = new boolean[12];
        for (int i = 0; i < 12; i++) {
            bits[i] = zeroOne;
        }
        Scanner userInput = new Scanner (System.in);
        System.out.println("Which bit did the teacher flip? ");
        int flippedBit = userInput.nextInt();
        if (flippedBit < 13 && flippedBit > 0) {
            bits[flippedBit] = !zeroOne;
        } else {
            System.out.println("Pick a number 1-12 and start over!");
        }
        
        System.out.println("\nOur initial configuration is:");
        for (int i = 0; i < 12; i++) {
            System.out.print("Our bit at " + i + " is: ");
            System.out.println(bits[i]);
        }
        
        int answer = solutionSteps(bits);
        
        if (answer == flippedBit && count < 4) {
            System.out.println("\nYou WIN!");
        } else {
            System.out.println("\nYou FAIL! Try again... ;3");
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