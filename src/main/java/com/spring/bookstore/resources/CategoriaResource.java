package com.spring.bookstore.resources;

import com.spring.bookstore.domain.Categoria;
import com.spring.bookstore.dtos.CategoriaDTO;
import com.spring.bookstore.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin("*")
@RestController
@RequestMapping("/categorias")
public class CategoriaResource {

    @Autowired
    private CategoriaService service;


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> findById(@PathVariable Long id){
        Categoria obj = service.findById(id);
        return ResponseEntity.ok().body(obj);

    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll(){
      List<Categoria> list = service.findAll();
      List<CategoriaDTO> listDTO = list.stream().map(obj -> new CategoriaDTO(obj)).collect(Collectors.toList());
      return ResponseEntity.ok().body(listDTO);
    }

      @PostMapping
     public ResponseEntity<Categoria> create(@Valid @RequestBody Categoria obj){
          obj = service.create(obj);
          URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
          return ResponseEntity.created(uri).body(obj);
      }

      @PutMapping("/{id}")
      public ResponseEntity<CategoriaDTO> update(@PathVariable Long id, @Valid @RequestBody CategoriaDTO objDTO){
        Categoria newObj = service.update(id, objDTO);
        return ResponseEntity.ok().body(new CategoriaDTO(newObj));
      }

      @DeleteMapping("/{id}")
      public ResponseEntity<Void> deleteById(@PathVariable Long id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
      }
}
