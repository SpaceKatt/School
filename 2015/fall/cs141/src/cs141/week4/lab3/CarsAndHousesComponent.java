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
package cs141.week4.lab3;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;

/**
 * This little doodle will draw our car stuff
 * @author Thomas Kercheval
 */
public class CarsAndHousesComponent extends JComponent {
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        
        Car car1 = new Car(50, 90);
        
        int x = getWidth() - 65;
        int y = getHeight() - 40;
        
        Car car2 = new Car(x, y);
        
        int houseX = (int) Math.floor(.5 * getWidth());
        int houseY = (int) Math.floor(.5 * getHeight());
        
        House house1 = new House(houseX, houseY);
        House house2 = new House(0, getHeight() - 55);
        
        car1.draw(g2);
        car2.draw(g2);
        house1.draw(g2);
        house2.draw(g2);
    }
}
