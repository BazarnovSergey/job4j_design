package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final Map<FileProperty, List<Path>> filePropertyHashMap = new HashMap<>();
    private final List<Path> pathList = new ArrayList<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        List<Path> list = new ArrayList<>();
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.toFile().getName());
        if (!filePropertyHashMap.containsKey(fileProperty)) {
            list.add(file.toAbsolutePath());
            filePropertyHashMap.put(fileProperty, list);
        } else {
            filePropertyHashMap.get(fileProperty).add(file.toAbsolutePath());
        }
        return super.visitFile(file, attrs);
    }

    public List<Path> getDuplicates() {
        for (FileProperty fp : filePropertyHashMap.keySet()) {
            if (filePropertyHashMap.get(fp).size() > 1) {
                pathList.addAll(filePropertyHashMap.get(fp));
            }
        }
        return pathList;
    }
}