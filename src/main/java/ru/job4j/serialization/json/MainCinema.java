package ru.job4j.serialization.json;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.StringReader;
import java.io.StringWriter;

public class MainCinema {
    public static void main(String[] args) throws Exception {
        Cinema cinema = new Cinema("Stan Lee", true,
                new Film("Spider-Man"), 90,
                new double[]{16.45, 18.00, 20.30});
        JAXBContext context = JAXBContext.newInstance(Cinema.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(cinema, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Cinema result = (Cinema) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
