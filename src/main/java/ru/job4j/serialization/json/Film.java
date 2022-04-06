package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "film")
public class Film {

    @XmlAttribute
    private String movieName;

    public Film() {

    }

    public Film(String movieName) {
        this.movieName = movieName;
    }

    @Override
    public String toString() {
        return "Film{"
                + "Movie name='" + movieName + '\''
                + '}';
    }
}