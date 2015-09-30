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

/**
 *
 * @author Thomas Kercheval
 */
public class Interest 
{
    /**
     * This little bit-lit calculates some interest.
     * @param args
     */
    public static void main(String[] args) 
    {
        double initial = 10000;
        double bank = 10000;
        for (int i = 1; i < 99999; i++) {
            double interest = bank * 0.2;
            System.out.println("Interest: " + interest);
            bank = bank + interest;
            System.out.println("Year# " + i);
            if (bank / initial > 2) {
                System.out.println("Final year: " + i);
                System.out.println("Final bank value: " + bank);
                break; 
            }
        }
    }
}
