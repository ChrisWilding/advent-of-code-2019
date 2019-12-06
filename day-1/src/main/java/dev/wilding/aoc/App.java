package dev.wilding.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        var userDir = System.getProperty("user.dir");
        var fileName = "/src/main/resources/example.txt";
        var filePath = Paths.get(userDir, fileName);

        var fcu = new FuelCounterUpper();

        try (Stream<String> stream = Files.lines(filePath)) {

            var values = stream.map(Integer::valueOf).collect(Collectors.toList());

            var resultOne = values.stream()
                .mapToInt(fcu::calculate)
                .sum();
            System.out.println(resultOne);

            var resultTwo = values.stream()
                .mapToInt(fcu::calculateFuelForFuel)
                .sum();
            System.out.println(resultTwo);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
