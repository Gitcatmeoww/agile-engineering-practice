package edu.berkeley.aep;

public class ScaledQuantity implements Bestable<ScaledQuantity> {
    protected final int magnitude;
    protected final Unit unit;

    public ScaledQuantity(int magnitude, Unit unit) {
        this.magnitude = magnitude;
        this.unit = unit;
    }

    protected ArithmeticQuantity convertTo(Unit unit) {
        return new ArithmeticQuantity(this.unit.convertTo(unit, magnitude), unit);
    }

    public boolean betterThan(ScaledQuantity other) {
        return this.convertTo(other.unit).magnitude > other.magnitude;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof ScaledQuantity otherQuantity)) {
            return false;
        }
        return magnitude == otherQuantity.convertTo(unit).magnitude;
    }

    @Override
    public String toString() {
        return magnitude + " " + unit;
    }
}
