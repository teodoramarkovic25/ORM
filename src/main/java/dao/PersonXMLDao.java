package dao;

import model.Person;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class PersonXMLDao implements Dao<Person> {

 static final String FILE_NAME = "person.xml";
    @Override
    public List<Person> readElements() {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream(FILE_NAME))) {
            List<Person> personList = (List<Person>) xmlDecoder.readObject();
            return  personList;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return Collections.emptyList();
    }

    @Override
    public void writeElements(List<Person> elements) {
        if (elements == null || elements.isEmpty()) {

            return;
        }
        try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream(FILE_NAME))) {
            xmlEncoder.writeObject(elements);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
