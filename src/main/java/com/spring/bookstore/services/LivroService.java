package com.spring.bookstore.services;

import com.spring.bookstore.domain.Livro;
import com.spring.bookstore.repositories.LivroRepository;
import com.spring.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;
    @Autowired
    private CategoriaService service;

    public Livro findById(Long id){
     Optional<Livro> obj = repo.findById(id);
     return obj.orElseThrow(() -> new ObjectNotFoundException(
             "Livro não econtrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Long id_cat) {
       service.findById(id_cat);
       return repo.findAllByCategory(id_cat);
    }
}
