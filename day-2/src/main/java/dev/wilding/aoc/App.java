package dev.wilding.aoc;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class App {

    public static void main(String[] args) throws IOException {
        var userDir = System.getProperty("user.dir");
        var fileName = "/src/main/resources/example.txt";
        var filePath = Paths.get(userDir, fileName);

        var raw = Files.readString(filePath);
        var split = raw.strip().split(",");
        var intcode = Arrays.stream(split).map(Integer::valueOf).collect(Collectors.toCollection(ArrayList::new));

        // Part 1
        var iiOne = new IntcodeInterpreter(intcode);
        iiOne.restore(12, 2);
        var resultOne = iiOne.run();
        System.out.println(resultOne);

        // Part 2
        for (var noun = 0; noun < 100; noun++) {
            for (var verb = 0; verb < 100; verb++) {
                var iiTwo = new IntcodeInterpreter(intcode);
                iiTwo.restore(noun, verb);
                var candidate = iiTwo.run();

                if (candidate == 19690720) {
                    System.out.println(100 *  noun + verb);
                    break;
                }
            }
        }
    }

}
