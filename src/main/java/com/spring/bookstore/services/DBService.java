package com.spring.bookstore.services;

import com.spring.bookstore.domain.Categoria;
import com.spring.bookstore.domain.Livro;
import com.spring.bookstore.repositories.CategoriaRepository;
import com.spring.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository repoCategory;

    @Autowired
    private LivroRepository repoLivro;

    public void instanciarBanco(){

        Categoria cat1= new Categoria(null,"Informática","Livro de TI");
        Categoria cat2 = new Categoria(null, "Ficção Cientifíca", "Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografía", "Livros de Biografia");


        Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem ipsum",cat1);
        Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum",cat1);
        Livro l3 = new Livro(null, "The Time Machine", "H.G Wells", "Lorem ipsum",cat2);
        Livro l4 = new Livro(null, "The War of the Worlds", "H.G Wells", "Lorem ipsum",cat2);
        Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Lorem ipsum",cat2);

        cat1.getLivros().addAll(Arrays.asList(l1,l2));
        cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));

        this.repoCategory.saveAll(Arrays.asList(cat1,cat2,cat3));
        this.repoLivro.saveAll(Arrays.asList(l1,l2,l3,l4,l5));

    }
}
