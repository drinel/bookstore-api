package com.spring.bookstore.services;

import com.spring.bookstore.domain.Categoria;
import com.spring.bookstore.dtos.CategoriaDTO;
import com.spring.bookstore.repositories.CategoriaRepository;
import com.spring.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Categoria> findAll(){
          return repo.findAll();
    }

    public Categoria create(Categoria obj){
        obj.setId(null);
        return repo.save(obj);

    }

    public Categoria update(Long id, CategoriaDTO objDTO) {
        Categoria obj = repo.getById(id);

        obj.setNome(objDTO.getNome());
        obj.setDescricao(objDTO.getDescricao());


        return repo.save(obj);
    }


    public void deleteById(Long id) {
        findById(id);
        try{
            repo.deleteById(id);
        }catch (DataIntegrityViolationException e){
                throw new com.spring.bookstore.services.exceptions.DataIntegrityViolationException(
                        "Categoria possui livros associados, não pode ser deletado");
        }
    }
}
