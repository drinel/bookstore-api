package com.spring.bookstore.resources;

import com.spring.bookstore.domain.Livro;
import com.spring.bookstore.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
public class LivroResource {

    @Autowired
    private LivroService service;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findBydId(@PathVariable Long id){
        Livro obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
