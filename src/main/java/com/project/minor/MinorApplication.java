package com.project.minor;

import com.project.minor.model.Author;
import com.project.minor.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class MinorApplication implements CommandLineRunner {
	@Autowired
	AuthorRepository authorRepository;

	public static void main(String[] args) {
		SpringApplication.run(MinorApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Author> authorList = authorRepository.findByAgeGreaterThanEqualAndCountryAndNameStartingWith(20, "India", "La");
		authorList.forEach(a -> System.out.println(a.getName()));
	}
}
