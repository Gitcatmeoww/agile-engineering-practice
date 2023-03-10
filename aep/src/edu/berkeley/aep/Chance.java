package edu.berkeley.aep;
public class Chance {
    // Value object should be im
    //
    ///**
    // * Understand the likelihood of something happening.
    // *
    // * Four principles of simple design:
    // * 1. It works
    // * 2. Communicates/expresses intent (e.g. should not use long method name)
    // * 3. No duplicate code (DRY: Don't repeat yourself)
    // * 4. No extra code (YAGNI: Don't start writing code unless you need it)
    // */mutable -> final
    private final double probability;

    @Override
    public boolean equals(Object other) {
        // Check identity
        if (other == this) {
            return true;
        }
        // Check type
        if (!(other instanceof Chance chance)) {
            return false;
        }
        // Compare value
        return Double.compare(chance.probability, probability) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(probability);
    }

    public Chance(double probability) {
        this.probability = probability;
    }

    public Chance not() {
        return new Chance(1 - probability);
    }

    public Chance and(Chance other) {
        return new Chance(probability * other.probability);
    }

    public Chance or(Chance other) {
        // P(A or B) = P(A) + P(B) - P(A) * P(B);
        return new Chance(probability + other.probability - probability * other.probability);
    }

    public Chance orDeMorgan(Chance other) {
        // !(!P(A) && !P(B)) DeMorgan's Law
        return this.not().and(other.not()).not();
    }
}
