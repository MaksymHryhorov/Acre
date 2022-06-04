package org.hryhorov.dao;

import org.hryhorov.models.Person;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/catalog?serverTimezone=UTC";
    private static final String login = "root";
    private static final String password = "root";

    private static Connection connection = null;

    public List<Person> peopleList() {
        List<Person> people = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            connection = DriverManager.getConnection(URL,login,password);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            Statement statement = connection.createStatement();

            String SQL = "SELECT * FROM person";

            ResultSet resultSet = statement.executeQuery(SQL);

            while (resultSet.next()) {
                Person person = new Person();

                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setEmail(resultSet.getString("email"));
                person.setAge(resultSet.getInt("age"));

                people.add(person);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return people;
    }

    public Person showPerson(int id) {
     //   return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
        return null;
    }

    public void save(Person person) {
     //   person.setId(++PEOPLE_COUNT);
   //     people.add(person);

        try {
            Statement statement = connection.createStatement();
            String SQL = "INSERT INTO Person VALUES(" + 1 + ",'" + person.getName() +
                    "'," + person.getAge() + ",'" + person.getEmail() + "')";

            statement.executeUpdate(SQL);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void update(int id, Person updatedPerson) {
    //    Person personUpdating = showPerson(id);

      //  personUpdating.setName(updatedPerson.getName());
        //personUpdating.setAge(updatedPerson.getAge());
        //personUpdating.setEmail(updatedPerson.getEmail());
    }

    public void delete(int id) {
     //   people.removeIf(person -> person.getId() == id);
    }
}