package com.nikita.lessons.dao.impl;

import com.nikita.lessons.dao.PersonDao;
import com.nikita.lessons.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PersonDaoImpl implements PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Lok"));
        people.add(new Person(++PEOPLE_COUNT, "Joe"));
        people.add(new Person(++PEOPLE_COUNT, "Snickers"));
        people.add(new Person(++PEOPLE_COUNT, "Jake"));
    }

    public List<Person> getPeople() {
        return people;
    }

    public Person getPerson(int id) {
        return people.stream().filter(person -> person.getId()==id).findAny().orElse(null);
    }

    public void savePerson(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void changePerson(int id, Person person) {
        Person changeablePerson = getPerson(id);
        changeablePerson.setName(person.getName());
    }

    public void deletePerson(int id) {
        people.removeIf(p -> p.getId()!=id);
    }
}
