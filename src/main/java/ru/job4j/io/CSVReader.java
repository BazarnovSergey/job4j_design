package ru.job4j.io;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CSVReader {
    public static void handle(ArgsName argsName) throws Exception {
        if (chekValidateArgs(argsName)) {
            try (Scanner in = new Scanner(new File(argsName.get("path")))) {
                String delimiter = argsName.get("delimiter");
                String filter = argsName.get("filter");
                List<Integer> skipIndex = new ArrayList<>();
                String header = in.nextLine();
                String[] columns = header.split(delimiter);
                if (filter != null) {
                    for (int i = 0; i < columns.length; i++) {
                        if (!filter.contains(columns[i])) {
                            skipIndex.add(i);
                        }
                    }
                }
                StringBuilder str = new StringBuilder();
                str.append(filterLine(header, delimiter, skipIndex));
                while (in.hasNext()) {
                    str.append(filterLine(in.nextLine(), delimiter, skipIndex));
                }
                writeToFile(str.toString(), argsName.get("out"));
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    private static boolean chekValidateArgs(ArgsName argsName) {
        String inputPath = argsName.get("path");
        String delimiter = argsName.get("delimiter");
        String outputPath = argsName.get("out");
        if (inputPath == null || delimiter == null || outputPath == null) {
            throw new IllegalArgumentException("Not all arguments are specified."
                    + "Enter your arguments: -path -delimiter -out ");
        }
        if (new File(inputPath).isDirectory()) {
            throw new IllegalArgumentException("First argument must be a directory");
        }
        return true;
    }

    private static void writeToFile(String text, String filePath) {
        try (PrintWriter out = new PrintWriter(
                new FileWriter(filePath, StandardCharsets.UTF_8, true))
        ) {
            out.write(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String filterLine(String line, String delimiter, List<Integer> skipIndex) {
        String[] lineParts = line.split(delimiter);
        String filteredLine = IntStream.range(0, lineParts.length)
                .filter(i -> !skipIndex.contains(i))
                .mapToObj(i -> lineParts[i])
                .collect(Collectors.joining(delimiter));
        return filteredLine + System.lineSeparator();
    }

    public static void main(String[] args) throws Exception {
        ArgsName argsName = ArgsName.of(args);
        CSVReader.handle(argsName);
    }
}