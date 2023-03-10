package edu.berkeley.aep;


/**
 * "Understands" a 4-sided figure with sides at right angles
 * Note: 1. Should not contain "and": Single responsibility principle
 *       2. Should not contain the class name
 *       3. Start with "Ensures" for test classes
 */

public class Rectangle {

    /** Static Factory Method: Create a new instance of the class */
    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    private final int height;
    private final int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    /** Constructor chaining */
    public Rectangle(int side) {
        this(side, side);
    }

    public int getArea() {
        int area = height * width;
        return area;
    }

    public int getPerimeter() {
        int perimeter = 2 * height + 2 * width;
        return perimeter;
    }
}
