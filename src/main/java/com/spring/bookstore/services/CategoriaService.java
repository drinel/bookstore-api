package com.spring.bookstore.services;

import com.spring.bookstore.domain.Categoria;
import com.spring.bookstore.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria findById(Long id){
        Optional<Categoria> obj = repo.findById(id);
         return obj.orElse(null);
    }
}
