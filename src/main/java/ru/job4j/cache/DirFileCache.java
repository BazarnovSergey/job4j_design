package ru.job4j.cache;

import java.io.*;

public class DirFileCache extends AbstractCache<String, String> {
    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileInputStream fileInputStream = new FileInputStream("./" + cachingDir + "/" + key)) {
            int i = -1;
            while ((i = fileInputStream.read()) != -1) {
                stringBuilder.append((char) i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
