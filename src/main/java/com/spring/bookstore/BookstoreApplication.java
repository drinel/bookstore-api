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
public class BookstoreApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repoCategory;

	@Autowired
	private LivroRepository repoLivro;

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1= new Categoria(null,"Informática","Livro de TI");

		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum",cat1);


		cat1.getLivros().addAll(Arrays.asList(l1));

		this.repoCategory.saveAll(Arrays.asList(cat1));
		this.repoLivro.saveAll(Arrays.asList(l1));

	}
}
