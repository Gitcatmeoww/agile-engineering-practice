package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuantityTest {

    @Test
    // 1foot = 12inch
    public void oneFootShouldEqualTo12Inch() {
        var foot1 = new ArithmeticQuantity(1, Unit.FOOT);
        var inch12 = new ArithmeticQuantity(12, Unit.INCH);
        assertEquals(foot1, inch12);
    }

    @Test
    // 3feet = 1yard
    public void threeFootShouldEqualToOneYard() {
        var feet3 = new ArithmeticQuantity(3, Unit.FOOT);
        var yard1 = new ArithmeticQuantity(1, Unit.YARD);
        assertEquals(feet3, yard1);
    }

    @Test
    // 1mile = 1760yard
    public void oneMileShouldEqualTo1760Yard() {
        var mile1 = new ArithmeticQuantity(1, Unit.MILE);
        var yard1760 = new ArithmeticQuantity(1760, Unit.YARD);
        assertEquals(mile1, yard1760);
    }

    @Test
    // 1tbsp = 3tsp
    public void oneTBSPEqualsToThreeTSP() {
        var tablespoon1 = new ArithmeticQuantity(1, Unit.TBSP);
        var teaspoon3 = new ArithmeticQuantity(3, Unit.TSP);
        assertEquals(tablespoon1, teaspoon3);
    }

    @Test
    // 1oz = 2tbsp
    public void oneOZEqualsToTwoTBSP() {
        var oz1 = new ArithmeticQuantity(1, Unit.OZ);
        var tablespoon2 = new ArithmeticQuantity(2, Unit.TBSP);
        assertEquals(oz1, tablespoon2);
    }

    @Test
    // 8oz = 1cup
    public void oneCUPEqualsToEightOZ() {
        var cup1 = new ArithmeticQuantity(1, Unit.CUP);
        var oz8 = new ArithmeticQuantity(8, Unit.OZ);
        assertEquals(cup1, oz8);
    }

    @Test
    // 2inch + 2inch = 4inch
    public void twoInchPlusTwoInchEqualsToFourInch() {
        var inch2 = new ArithmeticQuantity(2, Unit.INCH);
        var inch4 = new ArithmeticQuantity(4, Unit.INCH);
        assertEquals(inch2.add(inch2), inch4);
    }

    @Test
    // 2tbsp + 1oz = 12tsp
    public void twoTBSPPlusOneOZEqualsTo12TSP(){
        var tbsp2 = new ArithmeticQuantity(2, Unit.TBSP);
        var oz1 = new ArithmeticQuantity(1, Unit.OZ);
        var tsp12 = new ArithmeticQuantity(12, Unit.TSP);
        assertEquals(tbsp2.add(oz1), tsp12);
    }

    @Test(expected = RuntimeException.class)
    // 1foot = 1tsp, Test case for converting magnitudes with different units
    public void shouldNotBeAbleToAddFeetAndTeaspoons() {
        var foot1 = new ArithmeticQuantity(1, Unit.FOOT);
        var teaspoon1 = new ArithmeticQuantity(1, Unit.TSP);
        assertEquals(foot1, teaspoon1);
    }

    @Test(expected = RuntimeException.class)
    // 1inch + 3tsp = 4oz, Test case for adding magnitudes with different units
    public void oneInchPlusThreeTSPEqualsToFourOZ() {
        var inch1 = new ArithmeticQuantity(1, Unit.INCH);
        var teaspoon3 = new ArithmeticQuantity(3, Unit.TSP);
        var oz4 = new ArithmeticQuantity(4, Unit.OZ);
        assertEquals(inch1.add(teaspoon3), oz4);
    }

    @Test
    // 212F = 100C
    public void oneHundredCelsiusEqualsTo212Fahrenheit() {
        var celsius100 = new ScaledQuantity(100, Unit.CELSIUS);
        var fahrenheit212 = new ScaledQuantity(212, Unit.FAHRENHEIT);
        assertEquals(celsius100, fahrenheit212);
    }

    @Test
    // 32F = 0C
    public void zeroCelsiusEqualsTo32Fahrenheit() {
        var celsius0 = new ScaledQuantity(0, Unit.CELSIUS);
        var fahrenheit32 = new ScaledQuantity(32, Unit.FAHRENHEIT);
        assertEquals(celsius0, fahrenheit32);
    }

    @Test
    // 1mile > 1inch
    public void oneMileBetterThanOneInch() {
        var mile1 = new ArithmeticQuantity(1, Unit.MILE);
        var inch1 = new ArithmeticQuantity(1, Unit.INCH);
        assertEquals(mile1.betterThan(inch1), true);
    }

    @Test(expected = RuntimeException.class)
    public void emptyListShouldThrowException(){
        ScaledQuantity[] listOfQuantities = new ScaledQuantity[0];
        assertEquals(Bester.bestOne(listOfQuantities), null);
    }

    @Test
    // 1mile > 1foot & 1inch
    public void theBestOneIsOneMile(){
        ArithmeticQuantity[] listOfQuantities = new ArithmeticQuantity[3];
        listOfQuantities[0] = new ArithmeticQuantity(1, Unit.INCH);
        listOfQuantities[1] = new ArithmeticQuantity(1, Unit.FOOT);
        listOfQuantities[2] = new ArithmeticQuantity(1, Unit.MILE);
        assertEquals(Bester.bestOne(listOfQuantities), listOfQuantities[2]);
    }

}
