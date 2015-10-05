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
 * @author Thomas Kercheval
 */
public class Week1 {

    /**
     * This little bit-lit prints some characters.
     * @param args
     */
    public static void main(String[] args) {
        String name = "Thomas Kercheval";
            for(int i = 0; i< name.length(); i++)
            {
                String letter = name.substring(i,i+1);
                System.out.println(letter);
            }
        System.out.println("Greetings.");
    }
    
}
