package edu.berkeley.aep;

/** Understands various physical units and how to compare them. */
public class ArithmeticQuantity extends ScaledQuantity {

    public ArithmeticQuantity(int magnitude, Unit unit) {
        super(magnitude, unit);
    }

    public ArithmeticQuantity add(ArithmeticQuantity other) {
        return new ArithmeticQuantity(other.convertTo(unit).magnitude + magnitude, unit);
    }
}
