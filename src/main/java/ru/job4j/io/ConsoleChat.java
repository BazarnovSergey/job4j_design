package ru.job4j.io;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> botAnswers = readPhrases();
        List<String> logs = new ArrayList<>();
        boolean appRun = true;
        boolean botRun = true;
        Random random = new Random();
        System.out.println("Введите \"закончить\" что бы завершить работу программы.\n"
                + "Введите \"стоп\" что бы приостановить работу бота.\n"
                + "Введите \"продолжить\" что бы продолжить работу бота.\n");
        System.out.println("Задавайте глупые вопросы, получайте умные ответы! :");
        Scanner in = new Scanner(System.in);
        while (appRun) {
            String question = in.nextLine();
            logs.add(question);
            switch (question) {
                case (OUT):
                    System.out.println("До встречи!");
                    logs.add(question);
                    appRun = false;
                    break;
                case (STOP):
                    System.out.println("Хорошо, я подожду.");
                    logs.add(question);
                    botRun = false;
                    break;
                case (CONTINUE):
                    System.out.println("Продолжим!");
                    botRun = true;
                    break;
                default:
                    if (botRun) {
                        String answer = botAnswers.get(random.nextInt(botAnswers.size()));
                        logs.add(answer);
                        System.out.println("Бот: " + answer);
                    }
            }
        }
        saveLog(logs);
    }

    private List<String> readPhrases() {
        List<String> answers = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(botAnswers))) {
            in.lines().forEach(answers::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return answers;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path,
                Charset.forName("WINDOWS-1251"), true))) {
            log.forEach(pw::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("./data/ChatLog.log",
                "./data/botAnswers.txt");
        cc.run();
    }
}
