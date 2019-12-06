package dev.wilding.aoc;

import java.util.ArrayList;

public class FuelCounterUpper {

    int calculate(int input) {
       return Math.floorDiv(input, 3) - 2;
    }

    int calculateFuelForFuel(int input) {
        var all = new ArrayList<Integer>();

        var amount = calculate(input);
        while (amount > 0) {
            all.add(amount);
            amount = calculate(amount);
        }

        return all.stream().mapToInt(Integer::intValue).sum();
    }

}
