package dao;

import model.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PersonDaoSeriaziable implements Dao<Person> {
    static final String FILE_NAME = "persons.dat";

    @Override
    public List<Person> readElements() {

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
          List<Person>  personList = (List<Person>) ois.readObject();
          return  personList;

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public void writeElements(List<Person> persons) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            ous.writeObject(persons);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
