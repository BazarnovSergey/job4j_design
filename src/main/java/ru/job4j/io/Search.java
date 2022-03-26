package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    public static void main(String[] args) throws IOException {

        if (args.length != 2) {
            throw new IllegalArgumentException(
                    "You must specify the root folder and file extension."
                            + " Usage java -jar dir.jar ROOT_FOLDER FILE_EXTENSION.");
        }

        if (checkValidateParametersArgs(args)) {
            Path start = Paths.get(args[0]);
            search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static boolean checkValidateParametersArgs(String[] args) {
        if (!new File(args[0]).isDirectory()) {
            throw new IllegalArgumentException("First argument must be a directory");
        }

        if (!args[1].startsWith(".")) {
            throw new IllegalArgumentException(
                    "The second argument must start with character \".\"");
        }
        return true;
    }
}
