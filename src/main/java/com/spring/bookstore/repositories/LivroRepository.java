package com.spring.bookstore.repositories;

import com.spring.bookstore.domain.Livro;
import com.spring.bookstore.dtos.LivroDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {
//
//    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :id_cat ORDER BY titulo")
//    List<Livro> findAllByCategory(@Param(value = "id_cat") Long id_cat);

    List<Livro> findAllByCategoriaIdOrderByTitulo(Long id_cat);

}
