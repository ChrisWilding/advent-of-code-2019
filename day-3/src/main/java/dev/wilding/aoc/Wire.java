package dev.wilding.aoc;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Wire {
    private final List<String> instructions;
    private final Set<Point> route = new HashSet<Point>();

    Wire(List<String> instructions) {
        this.instructions = instructions;
        walk();
    }

    public Set<Point> getRoute() {
        return route;
    }

    void walk() {
        int x = 0;
        int y = 0;
        int distance = 0;

        for (String instruction : instructions) {
            var direction = instruction.charAt(0);
            var travel = Integer.parseInt(instruction.substring(1));

            for (var i = 0; i < travel; i++) {
                distance++;
                switch (direction) {
                    case 'U':
                        y++;
                        break;
                    case 'D':
                        y--;
                        break;
                    case 'L':
                        x--;
                        break;
                    case 'R':
                        x++;
                        break;
                }

                route.add(new Point(x, y, distance));
            }
        }
    }
}
