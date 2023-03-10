package edu.berkeley.aep;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LengthUnitTest {

    @Test
    public void oneFootShouldEqualTo12Inch() {
        LengthUnit footLength1 = new LengthUnit(1, LengthUnit.Unit.FOOT);
        LengthUnit inchLength12 = new LengthUnit(12, LengthUnit.Unit.INCH);
        assertEquals(footLength1, inchLength12);
    }

    @Test
    public void threeFootShouldEqualToOneYard() {
        LengthUnit footLength3 = new LengthUnit(3, LengthUnit.Unit.FOOT);
        LengthUnit yardLength1 = new LengthUnit(1, LengthUnit.Unit.YARD);
        assertEquals(footLength3, yardLength1);
    }

    @Test
    public void oneMileShouldEqualTo1760Yard() {
        LengthUnit mileLength1 = new LengthUnit(1, LengthUnit.Unit.MILE);
        LengthUnit yardLength1760 = new LengthUnit(1760, LengthUnit.Unit.YARD);
        assertEquals(mileLength1, yardLength1760);
    }
}
