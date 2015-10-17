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

/**
 * This class creates a car...
 * Inputs: Top-left (x,y) coordinates
 * Outputs: Car Object
 * @author Thomas Kercheval
 */
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Car {
    private int xLeft;
    private int yTop;
    
    public Car(int x, int y) {
        xLeft = x;
        yTop = y;
    }
    
    public void draw(Graphics2D g2) {
        Rectangle body = new Rectangle(xLeft, yTop + 10, 60, 10);
        Ellipse2D.Double frontTire
                = new Ellipse2D.Double(xLeft+10, yTop + 20, 10, 10);
        Ellipse2D.Double rearTire
                = new Ellipse2D.Double(xLeft+40, yTop + 20, 10, 10);
        
        // Front Windshield, bottom
        Point2D.Double r1  = new Point2D.Double(xLeft + 10, yTop + 10);
        // Roof Front
        Point2D.Double r2  = new Point2D.Double(xLeft + 20, yTop);
        // Roof Rear
        Point2D.Double r3  = new Point2D.Double(xLeft + 40, yTop);
        // Rear Windshield, bottom
        Point2D.Double r4  = new Point2D.Double(xLeft + 50, yTop + 10);
        
        Line2D.Double frontWindshield = new Line2D.Double(r1, r2);
        Line2D.Double roofTop = new Line2D.Double(r2, r3);
        Line2D.Double rearWindshield = new Line2D.Double(r3, r4);
        
        g2.draw(body);
        g2.draw(frontTire);
        g2.draw(rearTire);
        g2.draw(frontWindshield);
        g2.draw(roofTop);
        g2.draw(rearWindshield);
    }
}
