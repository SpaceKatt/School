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
 *
 * @author Thomas Kercheval
 * 
 */
import java.util.Scanner;

public class ValueCalculator {
    
    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Item price?");
        double unitPrice = scanner.nextDouble();
        System.out.println("How many items?");
        int quantity = scanner.nextInt();
        double totalCost = quantity * unitPrice;
        System.out.printf("Total cost: " + totalCost);
    }
}