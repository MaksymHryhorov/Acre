package org.hryhorov.dao;

import org.hryhorov.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT = 0;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT,"Tom", 30,"tom@email.com" ));
        people.add(new Person(++PEOPLE_COUNT,"Cat",31,"cat@email.com"));
        people.add(new Person(++PEOPLE_COUNT,"Jerry", 32, "jerry@email.com"));
        people.add(new Person(++PEOPLE_COUNT,"Mouse", 33, "mouse@email.com"));
    }

    public List<Person> peopleList() {
        return people;
    }

    public Person showPerson(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatedPerson) {
        Person personUpdating = showPerson(id);

        personUpdating.setName(updatedPerson.getName());
        personUpdating.setAge(updatedPerson.getAge());
        personUpdating.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
