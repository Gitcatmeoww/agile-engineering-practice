package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SquareTest {
    @Test
    public void squareWithSideOneShouldHaveAreaOne() {
        Square square = new Square(1);
        assertEquals(1, square.getArea());
    }

    @Test
    public void squareWithSideTwoShouldHaveAreaFour() {
        Square square = new Square(2);
        assertEquals(4, square.getArea());
    }

    @Test
    public void squareWithSideOneShouldHavePerimeterFour() {
        Square square = new Square(1);
        assertEquals(4, square.getPerimeter());
    }

    @Test
    public void squareWithSideTwoShouldHavePerimeterEight() {
        Square square = new Square(2);
        assertEquals(8, square.getPerimeter());
    }
}
