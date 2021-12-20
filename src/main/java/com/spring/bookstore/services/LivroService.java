package com.spring.bookstore.services;

import com.spring.bookstore.domain.Livro;
import com.spring.bookstore.repositories.LivroRepository;
import com.spring.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository repo;

    public Livro findById(Long id){
     Optional<Livro> obj = repo.findById(id);
     return obj.orElseThrow(() -> new ObjectNotFoundException(
             "Livro não econtrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }
}
