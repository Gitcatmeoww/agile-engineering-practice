package edu.berkeley.aep;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MagnitudeUnitTest {

    @Test
    // 1tbsp = 3tsp
    public void oneTBSPEqualsToThreeTSP() {
        MagnitudeUnit tablespoon1 = new MagnitudeUnit(1, MagnitudeUnit.Unit.TBSP);
        MagnitudeUnit teaspoon3 = new MagnitudeUnit(3, MagnitudeUnit.Unit.TSP);
        assertEquals(tablespoon1, teaspoon3);
    }

    @Test
    // 1oz = 2tbsp
    public void oneOZEqualsToTwoTBSP() {
        MagnitudeUnit oz1 = new MagnitudeUnit(1, MagnitudeUnit.Unit.OZ);
        MagnitudeUnit tablespoon2 = new MagnitudeUnit(2, MagnitudeUnit.Unit.TBSP);
        assertEquals(oz1, tablespoon2);
    }

    @Test
    // 8oz = 1cup
    public void oneCUPEqualsToEightOZ() {
        MagnitudeUnit cup1 = new MagnitudeUnit(1, MagnitudeUnit.Unit.CUP);
        MagnitudeUnit oz8 = new MagnitudeUnit(8, MagnitudeUnit.Unit.OZ);
        assertEquals(cup1, oz8);
    }

    @Test
    // 2inch + 2inch = 4inch
    public void twoInchPlusTwoInchEqualsToFourInch() {
        MagnitudeUnit inch2 = new MagnitudeUnit(2, MagnitudeUnit.Unit.INCH);
        MagnitudeUnit inch4 = new MagnitudeUnit(4, MagnitudeUnit.Unit.INCH);
        assertEquals(inch2.add(inch2), inch4);
    }

    @Test
    // 2tbsp + 1oz = 12tsp
    public void twoTBSPPlusOneOZEqualsTo12TSP(){
        MagnitudeUnit tbsp2 = new MagnitudeUnit(2, MagnitudeUnit.Unit.TBSP);
        MagnitudeUnit oz1 = new MagnitudeUnit(1, MagnitudeUnit.Unit.OZ);
        MagnitudeUnit tsp12 = new MagnitudeUnit(12, MagnitudeUnit.Unit.TSP);
        assertEquals(tbsp2.add(oz1), tsp12);
    }

    @Test
    // 1inch = 3tsp, Test case for converting magnitudes with different units
    public void oneInchEqualsToThreeTSP() {
        MagnitudeUnit inch1 = new MagnitudeUnit(1, MagnitudeUnit.Unit.INCH);
        MagnitudeUnit teaspoon3 = new MagnitudeUnit(3, MagnitudeUnit.Unit.TSP);
        assertEquals(inch1, teaspoon3);
    }

    @Test
    // 1inch + 3tsp = 4oz, Test case for adding magnitudes with different units
    public void oneInchPlusThreeTSPEqualsToFourOZ() {
        MagnitudeUnit inch1 = new MagnitudeUnit(1, MagnitudeUnit.Unit.INCH);
        MagnitudeUnit teaspoon3 = new MagnitudeUnit(3, MagnitudeUnit.Unit.TSP);
        MagnitudeUnit oz4 = new MagnitudeUnit(4, MagnitudeUnit.Unit.OZ);
        assertEquals(inch1.add(teaspoon3), oz4);
    }

    @Test
    public void zeroCelsiusEqualsTo32Fahrenheit() {
        MagnitudeUnit celsius0 = new MagnitudeUnit(0, MagnitudeUnit.Unit.CELSIUS);
        MagnitudeUnit fahrenheit32 = new MagnitudeUnit(32, MagnitudeUnit.Unit.FAHRENHEIT);
        assertEquals(celsius0, fahrenheit32);
    }
}
