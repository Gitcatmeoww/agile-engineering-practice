package edu.berkeley.aep;

/** Understands how to compare quantities in different units */
public class MagnitudeUnit {
    public final int magnitude;
    public final Unit unit;

    public MagnitudeUnit (int magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    public enum Unit {
        TSP(1, "volume"), TBSP(3, "volume"), OZ(6, "volume"), CUP(48, "volume"),
        INCH(1, "length"), FOOT(12, "length"), YARD(36, "length"), MILE(1760 * 36, "length"),
        CELSIUS(1, "temperature"), FAHRENHEIT(1, "temperature");

        private int conversionFactor;
        private String type;

        Unit(int conversionFactor, String type) {
            this.conversionFactor = conversionFactor;
            this.type = type;
        }

        public int convertToSmallest(int magnitude) {
            return magnitude * conversionFactor;
        }
    }

    private MagnitudeUnit convert(MagnitudeUnit other) {
        if (this.unit.type != other.unit.type) {
            throw new RuntimeException("Cannot covert magnitudes with different units");
        } else if (other.unit.type == "volume" || other.unit.type == "length") {
            int newMagnitude = this.unit.convertToSmallest(this.magnitude) / other.unit.convertToSmallest(1);
            return new MagnitudeUnit(newMagnitude, other.unit);
        } else if (other.unit.type == "temperature") {
            return new MagnitudeUnit((magnitude - 32) * 5 / 9, other.unit); // F to C
        } else {
            throw new RuntimeException("Invalid units");
        }
    }

//    private MagnitudeUnit convert(Unit newUnit) {
//        if (this.unit.type != newUnit.type) {
//            throw new RuntimeException("Cannot covert magnitudes with different units");
//        } else if () {
//
//        }
//        int newMagnitude = this.unit.convertToSmallest(this.magnitude) / newUnit.convertToSmallest(1);
//        return new MagnitudeUnit(newMagnitude, newUnit);
//    }

//    public MagnitudeUnit add(MagnitudeUnit other) {
//        if (this.unit.type != other.unit.type) {
//            throw new RuntimeException("Cannot add magnitudes with different units");
//        }
//        int newMagnitude = other.convert(unit).magnitude + magnitude;
//        return new MagnitudeUnit(newMagnitude, this.unit);
//    }

    public MagnitudeUnit add(MagnitudeUnit other) {
        if (this.unit.type != other.unit.type) {
            throw new RuntimeException("Cannot add magnitudes with different units");
        }
        int newMagnitude = other.convert(this).magnitude + magnitude;
        return new MagnitudeUnit(newMagnitude, this.unit);
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof MagnitudeUnit otherMagnitudeUnit)) {
            return false;
        }
        return magnitude == otherMagnitudeUnit.convert(this).magnitude;
    }

    @Override
    public String toString() {
        return magnitude + " " + unit;
    }
}
