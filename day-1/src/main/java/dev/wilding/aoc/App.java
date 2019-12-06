package dev.wilding.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

    public static void main(String[] args) {
        var userDir = System.getProperty("user.dir");
        var fileName = "/src/main/resources/example.txt";
        var filePath = Paths.get(userDir, fileName);

        var fcu = new FuelCounterUpper();

        try (Stream<String> stream = Files.lines(filePath)) {
            var result = stream.map(Integer::valueOf)
                .mapToInt(fcu::calculate)
                .sum();
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
