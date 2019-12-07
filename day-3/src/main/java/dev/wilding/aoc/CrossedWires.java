package dev.wilding.aoc;

import java.util.HashSet;

class CrossedWires {
    private final Wire a;
    private final Wire b;

    CrossedWires(Wire a, Wire b) {
        this.a = a;
        this.b = b;
    }

    public int getManhattanDistanceOfClosestIntersection() {
        var closestIntersection = getClosestIntersection();
        return closestIntersection.getManhattanDistance();
    }

    private Point getClosestIntersection() {
        var routeA = new HashSet<>(a.getRoute());
        var routeB = b.getRoute();
        routeA.retainAll(routeB);
        return routeA.stream().sorted().findFirst().get();
    }
}
