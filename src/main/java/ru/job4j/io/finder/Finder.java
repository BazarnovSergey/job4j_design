package ru.job4j.io.finder;

import ru.job4j.io.ArgsName;
import ru.job4j.io.Search;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class Finder {

    private static final Pattern NAME = Pattern.compile("[\\w|*]+.[a-z]+");
    private static final Pattern TYPE = Pattern.compile("[a-z]+");

    private static List<Path> searchResult = new ArrayList<>();

    static void searchFiles(ArgsName argsName) throws IOException {
        checkValidation(argsName);
        Path start = Paths.get(argsName.get("d"));
        if (Objects.equals(argsName.get("t"), "mask")) {
            searchResult = Search.search(start, p -> p.toFile().getName().endsWith(argsName.get("n").substring(1)));
        }
        if (Objects.equals(argsName.get("t"), "name")) {
            searchResult = Search.search(start, p -> p.toFile().getName().endsWith(argsName.get("n")));
        }
        try (BufferedWriter out = new BufferedWriter(new FileWriter(argsName.get("o")))) {
            for (Path file : searchResult) {
                out.write(file.toString());
                out.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void checkValidation(ArgsName argsName) throws IllegalArgumentException {
        Path start = Paths.get(argsName.get("d"));
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException("Path is not directory");
        }
        if (!argsName.get("n").matches(String.valueOf(NAME))) {
            throw new IllegalArgumentException("File name is not correctly");
        }
        if (!argsName.get("t").matches(String.valueOf(TYPE))) {
            throw new IllegalArgumentException("Search type is not correctly");
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 4) {
            throw new IllegalArgumentException("Enter all arguments. Use pattern: "
                    + "-d=c:/ -n=*.?xt -t=mask -o=log.txt");
        }
        searchFiles(ArgsName.of(args));
    }
}
