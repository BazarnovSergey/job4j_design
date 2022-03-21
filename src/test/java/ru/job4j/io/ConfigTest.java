package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/whenPairWithoutComment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
        assertThat(config.value("surname"), is(Matchers.nullValue()));
    }

    @Test
    public void whenPairWithComment() {
        String path = "./data/whenPairWithComment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr"));
        assertThat(config.value("surname"), is("Arsentev"));
    }

    @Test
    public void whenFileWithEmptyLine() {
        String path = "./data/whenFileWithEmptyLine.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr"));
        assertThat(config.value("surname"), is("Arsentev"));
    }

    @Test
    public void whenPairContainsComment() {
        String path = "./data/whenPairContainsComment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr"));
    }

    @Test
    public void whenPairDoubleSymbolAssignment() {
        String path = "./data/whenPairDoubleSymbolAssignment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("key"), is("dialect=2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenFileWriteWithErrorPattern() {
        String path = "./data/whenFileWriteWithErrorPattern.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairNotKey() {
        String path = "./data/whenPairNotKey.properties";
        Config config = new Config(path);
        config.load();
    }
}