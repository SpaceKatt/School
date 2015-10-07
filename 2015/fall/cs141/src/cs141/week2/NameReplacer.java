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
package cs141.week2;

/**
 * This little bit-lit takes a user input and replaces it,
 *     character by character, with my name.
 * 
 * @author Thomas Kercheval
 */
import java.util.Scanner;

public class NameReplacer {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        String myName = "Thomas Kercheval";
        System.out.print("Enter something silly: ");
        String userInput = scanner.nextLine();
        int nameLength = myName.length();
        int inputLength = userInput.length();
        if (inputLength == 1) { // This will catch short inputs
            userInput = userInput + " ";
        } else if (inputLength == 0) { 
            userInput = "Why didn't you enter anything?";
        }
        System.out.print("\nStarting with input string:\n" + userInput + " ");
        if (nameLength == inputLength) {
            userInput = caseOne(myName, userInput);
        } else if (nameLength > inputLength) {
            userInput = caseTwo(myName, userInput);
        } else { // nameLength < inputLength
            userInput = caseThree(myName, userInput);
        }
        System.out.println("\nAfter final replacement:\n" + userInput);
    }
    
    public static String caseOne(String myName, String userInput) {
        String replacedStuff = ""; /* Where we will put characters that
                                    *   have already been replaced so there's
                                    *   no conflicts with previous replacement.
                                    */
        for (int i = 0; i< myName.length(); i++) {
            char userLetter = userInput.charAt(0);
            char nameLetter = myName.charAt(i);
            System.out.print("...replace: " + userLetter);
            System.out.println(" with: " + nameLetter + " ");
            userInput = userInput.replace(userLetter, nameLetter);
            replacedStuff = replacedStuff + userInput.charAt(0);
            userInput = userInput.substring(1, myName.length() - i);
            System.out.print(replacedStuff + userInput + " ");
        }
        return replacedStuff;
    }
    
    public static String caseTwo(String myName, String userInput) {
        String replacedStuff = "";
        int inputLength = userInput.length();
        for (int i = 0; i< myName.length(); i++) {
            char userLetter = userInput.charAt(0);
            char nameLetter = myName.charAt(i);
            System.out.print("...replace: " + userLetter);
            System.out.println(" with: " + nameLetter + " ");
            userInput = userInput.replace(userLetter, nameLetter);
            replacedStuff = replacedStuff + userInput.charAt(0);
            userInput = userInput.substring(1, inputLength - i);
            System.out.print(replacedStuff + userInput + " ");
            if (userInput.length() == 1) {
                String userPart = userInput.substring(0, 1);
                String namePart = myName.substring(i + 1, myName.length());
                System.out.print("\nUser input is running out of values, ");
                System.out.print("so replace: " + userPart);
                System.out.println(" with: " + namePart + " ");
                userInput = userInput.replace(userPart, namePart);
                replacedStuff = replacedStuff + userInput;    
                return replacedStuff;
            }
        }
        return replacedStuff;
    }
    
    public static String caseThree(String myName, String userInput) {
        String replacedStuff = "";
        int nameLength = myName.length();
        int inputLength = userInput.length();
        for (int i = 0; i< inputLength; i++) {
            char userLetter = userInput.charAt(0);
            char nameLetter = myName.charAt(i);
            System.out.print("...replace: " + userLetter);
            System.out.println(" with: " + nameLetter + " ");
            userInput = userInput.replace(userLetter, nameLetter);
            replacedStuff = replacedStuff + userInput.charAt(0);
            userInput = userInput.substring(1, inputLength - i);
            System.out.print(replacedStuff + userInput + " ");
            if (i > myName.length() - 3) {
                String namePart = myName.substring(nameLength - 1, nameLength);
                String userPart = userInput.substring(0, userInput.length());
                System.out.print("\nMy name is running out of values, ");
                System.out.print("so replace: " + userPart);
                System.out.println(" with: " + namePart + " ");
                userInput = userInput.replace(userPart, namePart);
                replacedStuff = replacedStuff + userInput;    
                return replacedStuff;
            }
        }
        return replacedStuff;        
    }
}
