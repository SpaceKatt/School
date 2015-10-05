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
package cs141.week1;

/**
 *
 * @author Thomas Kercheval
 */
import java.util.Scanner;
import java.util.ArrayList;

public class SimpleCalculator 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner (System.in); // Scanner grabs user input
        ArrayList<String> cmdList = new ArrayList<>(); // ArrayList declared
        cmdList.add("Enter 1 for addition,"); // Adds an element to cmdList
        cmdList.add("... 2 for multiplication,");
        cmdList.add("... 3 for subtraction.");
        cmdList.add("... 4 for division.");
        for(String element : cmdList) { // Enhanced for-loop
            System.out.println(element); // Print each element of cmdList
        }
        int operation = scanner.nextInt(); // Scanner looks for user int
        
        System.out.println("Enter first number:");
        Double first = scanner.nextDouble(); // Scanner looks for double
        System.out.println("Enter second number:");
        Double second = scanner.nextDouble(); // Scanner looks for more input
        
        if (operation == 1) { // If... Then...
            Double result = first + second;
            System.out.print("First + Second = ");
            System.out.println(result);
        } else if (operation == 2) { // If not 1... If 2... Then...
            Double result = first * second;
            System.out.print("First * Second = ");
            System.out.println(result);
        } else if (operation == 3) { // If not 1 or 2... If 3... Then...
            Double result = first - second;
            System.out.print("First - Second = ");
            System.out.println(result);
        } else if (operation == 4) {
            Double result = first / second;
            System.out.print("First / Second = ");
            System.out.println(result);
        } else { // If something unexpected happens, this is triggered.
            String result = "You fail at choosing numbers...";
            System.out.println(result);
        }
    }
}