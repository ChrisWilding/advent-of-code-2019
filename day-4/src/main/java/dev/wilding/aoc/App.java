package dev.wilding.aoc;

import java.util.stream.IntStream;

public class App {
    public static void main(String[] args) {
        var resultOne = IntStream
            .rangeClosed(183564, 657474)
            .filter(App::matchesWithAtLeastAPair)
            .count();

        System.out.println(resultOne);

        var resultTwo = IntStream
            .rangeClosed(183564, 657474)
            .filter(App::matchesWithOnlyAPair)
            .count();

        System.out.println(resultTwo);
    }

    public static boolean matchesWithOnlyAPair(int input) {
        var adjacent = false;
        var adjacentCount = 1;
        var last = 0;

        for (var i = 0; i < 6; i++) {
            var next = nthDigit(input, i);

            if (next < last) {
                return false;
            }

            if (!adjacent) {
                if (next == last) {
                    adjacentCount++;
                } else {
                    adjacent = adjacentCount == 2;
                    adjacentCount = 1;
                }
            }


            last = next;
        }

        return adjacent || adjacentCount == 2;
    }

    public static boolean matchesWithAtLeastAPair(int input) {
        var adjacent = false;
        var last = 0;

        for (var i = 0; i < 6; i++) {
            var next = nthDigit(input, i);

            if (next < last) {
                return false;
            }

            if (next == last) {
                adjacent = true;
            }

            last = next;
        }

        return adjacent;
    }

    static int nthDigit(int number, int index) {
        var digit = 5 - index;
        var dividend = Double.valueOf(number % Math.pow(10, digit + 1)).intValue();
        var divisor = Double.valueOf(Math.pow(10, digit)).intValue();
        return dividend / divisor;
    }
}
