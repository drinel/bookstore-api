package com.spring.bookstore.services;

import com.spring.bookstore.domain.Categoria;
import com.spring.bookstore.repositories.CategoriaRepository;
import com.spring.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repo;

    public Categoria findById(Long id){
        Optional<Categoria> obj = repo.findById(id);
         return obj.orElseThrow(() -> new ObjectNotFoundException(
                 "Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }
}
