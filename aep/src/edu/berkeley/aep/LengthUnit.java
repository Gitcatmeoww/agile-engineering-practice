package edu.berkeley.aep;

/** Understands the conversion of quantities of different units */
public class LengthUnit {
    public final int length;
    public final Unit unit;

    public LengthUnit (int length, Unit unit) {
        this.length = length;
        this.unit = unit;
    }

    public enum Unit {
        INCH(1), FOOT(12), YARD(36), MILE(1760 * 36);

        private int conversionFactor;

        Unit(int conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public int convertToInch(int length) {
            return length * conversionFactor;
        }
    }

    private LengthUnit convertLengthUnit(Unit newUnit) {
        int newLength = this.unit.convertToInch(this.length) / newUnit.convertToInch(1);
        return new LengthUnit(newLength, newUnit);
    }

    @Override
    public String toString() {
        return length + " " + unit;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof LengthUnit otherLength)) {
            return false;
        }
        return length == otherLength.convertLengthUnit(unit).length;
    }
}
