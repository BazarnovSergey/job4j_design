package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorTest {
    @Test
    @Ignore
    public void whenGenerationIsSuccessful() {
        Generator generator = new TemplateEngine();
        String template = ("I am a ${name}, Who are ${subject}!");
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        map.put("subject", "you");
        String expected = "I am a Petr Arsentev, Who are you?";
        assertEquals(expected, generator.produce(template, map));
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenKeyIsMissing() {
        Generator generator = new TemplateEngine();
        String template = ("I am a ${name}, Who are ${subject}!");
        Map<String, String> map = new HashMap<>();
        map.put("name", "Petr Arsentev");
        generator.produce(template, map);
    }

    @Test(expected = IllegalArgumentException.class)
    @Ignore
    public void whenExtraKey() {
        Generator generator = new TemplateEngine();
        String template = ("I am a ${name}, Who are ${subject}!");
        Map<String, String> map = new HashMap<>();
        map.put("one", "Petr Arsentev");
        map.put("subject", "you");
        generator.produce(template, map);
    }
}