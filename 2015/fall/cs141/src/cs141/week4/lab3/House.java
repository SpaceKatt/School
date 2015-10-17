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

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
/**
 * This class creates a house object...
 * Inputs: Top-Left (x, y) coordinates
 * Outputs: House Object
 * @author Thomas Kercheval
 */
public class House {
    private int xLeft;
    private int yTop;
    
    /**
     * Constructs a house, placing the top left corner on our frame at (x, y)
     * @param x
     * @param y 
     */
    public House(int x, int y) {
        xLeft = x;
        yTop = y;
    }
    
    public void draw(Graphics2D g2) {
        Rectangle mainHousePart = new Rectangle(xLeft + 10, yTop + 10, 30, 40);
        Rectangle window = new Rectangle(xLeft + 20, yTop + 20, 10, 10);
        Rectangle door = new Rectangle(xLeft + 20, yTop + 35, 10, 15);
        
        Ellipse2D.Double doorknob 
                = new Ellipse2D.Double(xLeft + 26, yTop + 45, 3, 3);
        
        // Roof, Left
        Point2D.Double rL = new Point2D.Double(xLeft + 0, yTop + 17);
        // Roof, Right
        Point2D.Double rR = new Point2D.Double(xLeft + 50, yTop + 17);
        // Roof, Middle
        Point2D.Double rM = new Point2D.Double(xLeft + 25, yTop + 0);
        
        Line2D.Double roofLeft = new Line2D.Double(rL, rM);
        Line2D.Double roofRight = new Line2D.Double(rM, rR);
        
        // Window, Vertical
        Line2D.Double windowVertical 
                = new Line2D.Double(xLeft + 25, yTop + 20, xLeft+25, yTop+30);
        // Window, Horizontal
        Line2D.Double windowHorizontal 
                = new Line2D.Double(xLeft + 20, yTop + 25, xLeft+30, yTop+25);
        
        g2.draw(mainHousePart);
        g2.draw(window);
        g2.draw(door);
        g2.draw(doorknob);
        g2.draw(roofLeft);
        g2.draw(roofRight);
        g2.draw(windowVertical);
        g2.draw(windowHorizontal);
    }
}