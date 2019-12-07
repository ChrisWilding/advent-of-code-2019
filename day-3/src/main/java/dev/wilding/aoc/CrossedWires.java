package dev.wilding.aoc;

import java.util.HashSet;
import java.util.stream.Collectors;

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

    public int getShortestIntersection() {
        var routeA = new HashSet<>(a.getRoute());
        var routeB = new HashSet<>(b.getRoute());

        routeA.retainAll(routeB);
        routeB.retainAll(routeA);

        var routeAList = routeA.stream().sorted().collect(Collectors.toList());
        var routeBList = routeB.stream().sorted().collect(Collectors.toList());

        var shortestPath = Integer.MAX_VALUE;

        for (int i = 0; i < routeAList.size(); i++) {
            var pointA = routeAList.get(i);
            var pointB = routeBList.get(i);
            var distance = pointA.getDistance() + pointB.getDistance();
            if (distance < shortestPath) {
                shortestPath = distance;
            }
        }

        return shortestPath;
    }

    private Point getClosestIntersection() {
        var routeA = new HashSet<>(a.getRoute());
        var routeB = b.getRoute();
        routeA.retainAll(routeB);
        return routeA.stream().sorted().findFirst().get();
    }
}
