import dao.*;
import model.Person;

import java.util.*;

public class Demo {
    public static void main(String[] args) {
        //tranzijentan
        Person teodora = new Person("1333", "Teodora", "Marković", 23);
        Person semra = new Person("13336", "Semra", "Minic", 14);
        Person bilal = new Person("13354", "Bilal", "Sporisevic", 57);
        Person bilki1 = new Person("55", "Bilal", "Hujdurevic", 24);
        Person nedim = new Person("5555", "Nedim", "Cimic", 23);
        List<Person> personList = List.of(teodora,semra,bilki1,bilal,nedim);

//test upisivanja person liste u persons.txt
       // Dao<Person> personDao = new PersonFileDao();
        //personDao.writeElements(personList);

       /* List<Person> procitanePersone = personDao.readElements();
        for(Person procitanaPersona:procitanePersone){
            System.out.println(procitanaPersona);
        }

        */
        //test upisivanja person liste u persons.dat
      // Dao<Person> personDao = new PersonDaoSeriaziable();
      //  personDao.writeElements(personList);




        //Čitanje podataka iz persons.dat

       /*List<Person> procitaneDatPersone =personDao.readElements();
       for(Person person:procitaneDatPersone){
           System.out.println(person);

        }

        */
// Test upisivanja person list u persons.xml
      /*  Dao<Person> personDao = new PersonXMLDao();
        personDao.writeElements(new ArrayList<>(personList));

       */
// test čitanja person list iz XML

    /*    List<Person> xmlList = personDao.readElements();
        xmlList.forEach(System.out::println);


        Map<String,Person> personMap = new LinkedHashMap<>();
        personMap.put("Bilalovkljuc", new Person());

     */

        Dao<Person> personDao = new PersonJSONDao();
        //personDao.writeElements(personList);
        List<Person> jsonLista = personDao.readElements();
        for(Person person:jsonLista){
            System.out.println(person);
        }
    }
}

