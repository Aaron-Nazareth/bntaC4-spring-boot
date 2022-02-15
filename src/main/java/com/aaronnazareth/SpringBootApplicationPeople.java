package com.aaronnazareth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController // Add @RestController to you expose methods as REST services to clients
public class SpringBootApplicationPeople {  // All your code should be inside this one class
    static List<Person> people = new ArrayList<>(); // Create a static List of type person with few people inside
    public static void main(String[] args) {
        Person aaron = new Person(1, "Aaron", 23);
        Person p2 = new Person(2, "p2", 24);
        Person p3 = new Person(3, "p3", 25);
        people.add(aaron);
        people.add(p2);
        people.add(p3);
        SpringApplication.run(SpringBootApplicationPeople.class, args);
    }



    // Create a class called Person with following properties: id, name, age
    static class Person {
        private int id;
        private String name;
        private int age;

        public Person(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return id == person.id && age == person.age && Objects.equals(name, person.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, age);
        }
    }
    // Implement getPersonById
    @GetMapping("people/{id}")
        public Person getPersonById(@PathVariable("id") Integer id) {
            // filter list and return person that matches id otherwise return null
        for (Person person : people) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    // create another method that returns all people using @GetMapping("people")
    @GetMapping("people1")  // Named path as people1 since we already had people path in another class
    public List<Person> getAllPeople() {
        return people;
    }

    // test your api using chrome
}
