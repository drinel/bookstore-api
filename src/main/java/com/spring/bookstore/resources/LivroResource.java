package com.spring.bookstore.resources;

import com.spring.bookstore.domain.Livro;
import com.spring.bookstore.dtos.LivroDTO;
import com.spring.bookstore.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

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
    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value= "categoria", defaultValue = "0")Long id_cat){
         List<Livro> list = service.findAll(id_cat);
         List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList());
         return ResponseEntity.ok().body(listDTO);
                 //localhost:8080/livros?categoria=1
    }


}
