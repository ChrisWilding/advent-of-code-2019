package dev.wilding.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        var userDir = System.getProperty("user.dir");
        var fileName = "/src/main/resources/example.txt";
        var filePath = Paths.get(userDir, fileName);

        try (Stream<String> stream = Files.lines(filePath)) {
            var lines = stream
                .map(line -> Arrays
                    .stream(line.split(","))
                    .collect(Collectors.toList()))
                .collect(Collectors.toList());

            var instructionsA = lines.get(0);
            var wireA = new Wire(instructionsA);

            var instructionsB = lines.get(1);
            var wireB = new Wire(instructionsB);

            var crossedWires = new CrossedWires(wireA, wireB);
            var result = crossedWires.getManhattanDistanceOfClosestIntersection();
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
