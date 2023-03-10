package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * TDD Cycle:
 * 1. Write failing test
 * 2. Make the test pass
 * 3. Refactor: a small change that improves the structure of the code without changing its behavior
 *    (easier to maintain, understand)
 * 4. Ensure tests still run
 */

public class RectangleTest {

    // Test method name should like a specification
    @Test
    public void rectangleWithSideOneShouldHaveAreaOne() {
        Rectangle rectangle = new Rectangle(1,1);
        assertEquals(1, rectangle.getArea());
    }

    @Test
    public void rectangleWithSideTwoShouldHaveAreaFour() {
        Rectangle rectangle = new Rectangle(2,2);
        assertEquals(4, rectangle.getArea());
    }

    @Test
    public void squareWithSideTwoShouldHaveAreaFour() {
        Rectangle square = Rectangle.createSquare(2);
        assertEquals(4, square.getArea());
    }



    @Test
    public void test(){
        Rectangle rect = new Rectangle(2,5);
        assertEquals(10, rect.getArea());
        assertEquals(14, rect.getPerimeter());
    }
}
