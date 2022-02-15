package com.aaronnazareth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SpringBootApplication
@RestController
public class HelloSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloSpringBootApplication.class, args);
	}

	// localhost:8080
	@GetMapping
	String greet() {
		return "Hello Aaron";
	}

	@GetMapping(params = "name")
	String greetName(@RequestParam("name") String name) {
		return "Hello " + name + ", how are you?";
	}

	// localhost:8080/ping
	@GetMapping(path = "ping")
	String ping() {
		return "pong";
	}

	@GetMapping(path = "people")
	List<Person> getPerson() {
		return List.of(	// List.of returns an immutable list that cannot have elements added
				new Person("Aaron", 23),
				new Person("Random", 25)
				);
	}

	@PostMapping(path = "people")
	void addPerson(@RequestBody Person person) {
		System.out.println(person);
	}

	static class Person {
		private String name;
		private Integer age;

		public Person(String name, Integer age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}

		@Override
		public String toString() {
			return "Person{" +
					"name='" + name + '\'' +
					", age=" + age +
					'}';
		}

		@Override
		public boolean equals(Object o) {
			if (this == o) return true;
			if (o == null || getClass() != o.getClass()) return false;
			Person person = (Person) o;
			return Objects.equals(name, person.name) && Objects.equals(age, person.age);
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, age);
		}
	}

}
