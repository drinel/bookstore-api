package com.spring.bookstore.services;

import com.spring.bookstore.domain.Categoria;
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
    private CategoriaService serviceCategory;

    public Livro findById(Long id){
     Optional<Livro> obj = repo.findById(id);
     return obj.orElseThrow(() -> new ObjectNotFoundException(
             "Livro não econtrado! Id: " + id + ", Tipo: " + Livro.class.getName()));
    }

    public List<Livro> findAll(Long id_cat) {
       serviceCategory.findById(id_cat);
       return repo.findAllByCategoriaIdOrderByTitulo(id_cat);
    }

    public Livro update(Long id, Livro obj) {
        Livro newObj = repo.getById(id);
        updateData(newObj, obj);

        return repo.save(newObj);
    }

    private void updateData(Livro newObj, Livro obj) {

        newObj.setTitulo(obj.getTitulo());
        newObj.setNome_autor(obj.getNome_autor());
        newObj.setTexto(obj.getTexto());
    }

    public Livro create(Long id_cat, Livro obj) {
        obj.setId(null);
        Categoria cat = serviceCategory.findById(id_cat);
        obj.setCategoria(cat);
        return repo.save(obj);

    }

    public void delete(Long id) {
        Livro obj = findById(id);
        repo.delete(obj);
    }
}
