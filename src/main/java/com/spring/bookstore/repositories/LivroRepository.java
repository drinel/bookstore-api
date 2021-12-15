package com.spring.bookstore.repositories;

import com.spring.bookstore.domain.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
}
