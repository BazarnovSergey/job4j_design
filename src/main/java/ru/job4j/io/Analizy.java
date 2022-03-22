package ru.job4j.io;

import java.io.*;

public class Analizy {
    public void unavailable(String source, String target) {
        try (BufferedReader in = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target));) {
            String log = "";
            boolean statusServer = true;
            for (String line = in.readLine(); line != null; line = in.readLine()) {
                String[] words = line.split(" ");
                if (statusServer && ("400".equals(words[0]) || "500".equals(words[0]))) {
                    log = words[1] + ";";
                    statusServer = false;
                }
                if (!statusServer && ("200".equals(words[0]) || "300".equals(words[0]))) {
                    log += words[1] + ";";
                    out.println(log);
                    statusServer = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analizy analyze = new Analizy();
        analyze.unavailable("./data/server.log", "./data/target.log");
    }
}
