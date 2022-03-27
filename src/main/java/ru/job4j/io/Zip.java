package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(source.toFile()))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void checkValidateArguments(Path start, String exclude) {
        if (!start.toFile().isDirectory()) {
            throw new IllegalArgumentException("Path is not directory");
        }
        if (!exclude.startsWith(".")) {
            throw new IllegalArgumentException("Exclude must start with character \".\"");
        }
    }

    public static void main(String[] args) {
        if (args.length != 3) {
            throw new IllegalArgumentException("Enter all arguments. Use pattern:"
                    + "-d=c:\\project\\job4j\\ -e=.class -o=project.zip\n"
                    + "-d - directory - which we want to archive.\n"
                    + "-e - exclude - exclude files with the extension class.\n"
                    + "-o - output - what we archive into");
        }
        ArgsName argsName = ArgsName.of(args);
        Path start = Paths.get(argsName.get("d"));
        String exclude = argsName.get("e");
        File output = new File(argsName.get("o"));
        checkValidateArguments(start, exclude);
        List<Path> filesWithoutExcluded = new ArrayList<>();
        try {
            filesWithoutExcluded = Search.search(start, p -> !p.toFile().getName().endsWith(exclude));
        } catch (IOException e) {
            e.printStackTrace();
        }
        packFiles(filesWithoutExcluded, output);
    }
}