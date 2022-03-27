package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private String key;
    private String value;

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException("Key not found");
        }
        return values.get(key);
    }

    private void checkValidateArguments(String argument) {
        if (argument.charAt(0) != '-') {
            throw new IllegalArgumentException("The parameter must start with the symbol \"-\"");
        }
        String str = argument.substring(1);
        if (str.indexOf('=') == -1) {
            throw new IllegalArgumentException("The parameter is passed in the format: -key=value");
        }
        String[] words = argument.replaceFirst("-", "")
                .split("=", 2);
        if (words[0].equals("")) {
            throw new IllegalArgumentException("You didn't enter the key."
                    + "The parameter is passed in the format: -key=value");
        }
        if (words[1].equals("")) {
            throw new IllegalArgumentException("You didn't enter the value."
                    + "The parameter is passed in the format: -key=value");
        }
        key = words[0];
        value = words[1];
    }

    private void parse(String[] args) {

        if (args.length == 0) {
            throw new IllegalArgumentException("The argument is not specified."
                    + " The parameter is passed in the format: -key=value");
        }

        for (String argument : args) {
            checkValidateArguments(argument);
            values.put(key, value);
        }

    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}