package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        char sex = 'm';
        byte children = 2;
        short id = 101;
        int age = 33;
        long numberPassport = 123456789012345L;
        float weight = 82.3f;
        double height = 188.5;
        boolean married = true;

        LOG.debug("User info sex : {}, children : {}, id : {}, age : {}, "
                        + "numberPassport : {}, weight : {}, height : {}, married : {}",
                sex, children, id, age, numberPassport, weight, height, married);
    }
}