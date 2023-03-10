package edu.berkeley.aep;

public class Bester {
    Bester(){

    }

    public static Bestable bestOne(Bestable... quantities) {
        if (quantities.length == 0) {
            throw new RuntimeException("Can not find the best quantity in an empty list");
        }

        Bestable best = quantities[0];
        for (Bestable quantity : quantities) {
            if (!(quantity.betterThan(quantity))) {
                best = quantity;
            }
        }
        return best;
    }

}
