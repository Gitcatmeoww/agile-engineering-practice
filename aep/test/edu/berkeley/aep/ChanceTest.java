package edu.berkeley.aep;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Equals contract:
 * 1. Cannot throw exceptions
 * 2. Reflexive
 * 3. Symmetric
 * 4. Transitive
 * 5. Consistent
 */

public class ChanceTest {
    @Test
    public void chanceObjectsShouldBeValueObjects() {
        Chance coinToss = new Chance(0.5);
        Chance anotherCoinToss = new Chance(0.5);
        assertEquals(coinToss, anotherCoinToss);
    }

    @Test
    public void notOfCoinTossShouldBeACoinToss() {
        Chance coinToss = new Chance(0.5);
        Chance anotherCoinToss = new Chance(0.5);
        assertEquals(anotherCoinToss, coinToss.not());
    }

    @Test
    public void notOfThrowDice() {
        Chance throwDice = new Chance(1/6);
        Chance notThrowDice = new Chance(5/6);
        assertEquals(notThrowDice, throwDice.not());
    }

    @Test
    public void throwADiceGetOneOrTwoShouldBe11Over36() {
        Chance throwDiceGetOne = new Chance((1/6));
        Chance throwDiceGetTwo = new Chance((1/6));
        Chance throwDiceGetOneOrTwo = new Chance(1/6 + 1/6 - 1/6 * 1/6);
        assertEquals(throwDiceGetOneOrTwo, throwDiceGetOne.orDeMorgan(throwDiceGetTwo));
    }

    @Test
    public void shouldHaveAHashCode() {
        Map<Chance, String> map = new HashMap<>();
        map.put(new Chance(0.5), "Coin Toss");
        assertEquals("Coin Toss", 0.5);
    }
}
