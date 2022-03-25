package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        DuplicatesVisitor duplicatesVisitor = new DuplicatesVisitor();
        Files.walkFileTree(Path.of("."), duplicatesVisitor);
        duplicatesVisitor.getDuplicates().forEach(s -> {
            try {
                System.out.println(s + " Size : " + Files.size(s) / 1024 + " Kb");
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}