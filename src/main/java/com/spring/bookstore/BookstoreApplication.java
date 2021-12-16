package com.spring.bookstore;

import com.spring.bookstore.domain.Categoria;
import com.spring.bookstore.domain.Livro;
import com.spring.bookstore.repositories.CategoriaRepository;
import com.spring.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BookstoreApplication {



	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}


}
