package dev.wilding.aoc;

class Point implements Comparable<Point> {

    private final int x;
    private final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getManhattanDistance() {
        return Math.abs(x) + Math.abs(y);
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(getManhattanDistance(), o.getManhattanDistance());
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }

        if (!(o instanceof Point)) {
            return false;
        }

        var op = (Point) o;
        return (x == op.x && y == op.y);
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }

}
