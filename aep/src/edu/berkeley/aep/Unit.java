package edu.berkeley.aep;

/** Understands how to convert between different types of quantity */
enum Unit {
    INCH(1, Type.LENGTH),
    FOOT(12, Type.LENGTH),
    YARD(36, Type.LENGTH),
    MILE(1760 * 36, Type.LENGTH),
    TBSP(3, Type.VOLUME),
    TSP(1, Type.VOLUME),
    OZ(6, Type.VOLUME),
    CUP(48, Type.VOLUME),
    CELSIUS(9, 0, Type.TEMPERATURE),
    FAHRENHEIT(5, 32, Type.TEMPERATURE);

    enum Type {
        LENGTH, VOLUME, TEMPERATURE
    }

    private final int ratio;
    private final int offset;
    private final Type type;

    Unit(int ratio, int offset, Type type){
        this.ratio = ratio;
        this.offset = offset;
        this.type = type;
    }

    Unit(int ratio, Type type) {
        this(ratio, 0, type);
    }

    int convertTo(Unit unit, int magnitude) {
        if (this.type != unit.type) {
            throw new RuntimeException("Cannot convert a " + this.type + " to a " + unit.type);
        }
        return (magnitude - offset) * this.ratio / unit.ratio + unit.offset;
    }
}
