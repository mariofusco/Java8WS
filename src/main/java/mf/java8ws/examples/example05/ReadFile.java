package mf.java8ws.examples.example05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ReadFile {

    public static void main(String[] args) {
        long uniqueWords = calculateUniqueWords("src/main/resources/data.txt");
        System.out.println("Unique words in file: " + uniqueWords);
    }

    private static long calculateUniqueWords(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.flatMap(line -> Stream.of(line.split(" ")))
                         .distinct()
                         .count();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}