package dev.wilding.aoc;

import java.util.ArrayList;

class IntcodeInterpreter {
    private static final int ADD = 1;
    private static final int MULTIPLY = 2;
    private static final int STOP = 99;

    private final ArrayList<Integer> intcode;

    IntcodeInterpreter(ArrayList<Integer> intcode) {
        this.intcode = new ArrayList<>(intcode);
    }

    ArrayList<Integer> getIntcode() {
        return intcode;
    }

    void restore(int noun, int verb) {
        intcode.set(1, noun);
        intcode.set(2, verb);
    }

    int run() {
        for (var i = 0; i < intcode.size(); i += 4) {
            var opcode = intcode.get(i);

            if (opcode == STOP) {
                return intcode.get(0);
            }

            var inAPos = intcode.get(i + 1);
            var valA = intcode.get(inAPos);

            var inBPos = intcode.get(i + 2);
            var valB = intcode.get(inBPos);

            var outPos = intcode.get(i + 3);

            int out = 0;

            if (opcode == ADD) {
                out = valA + valB;
            }

            if (opcode == MULTIPLY) {
                out = valA * valB;
            }

            intcode.set(outPos, out);
        }

        return intcode.get(0);
    }
}
