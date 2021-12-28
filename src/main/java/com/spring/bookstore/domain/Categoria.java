package com.spring.bookstore.domain;

import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class Categoria implements Serializable {

	private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "Campo nome está em branco")
	@NotEmpty(message = "Insira o nome do livro")
	@Length(min = 2,max = 100, message = "Inserir de 2 a 100 caracteres")
	private String nome;

	@NotBlank(message = "Campo descrição está em branco")
	@NotEmpty(message = "Insira uma descrição")
	@Length(min = 2,max = 200, message = "Inserir de 2 a 200 caracteres")
	private String descricao;
	
   @OneToMany(mappedBy = "categoria")
	private List<Livro> livros = new ArrayList<>();


	public Categoria() {
		super();
	}

	public Categoria(Long id, String nome, String descricao) {
		super();
;		this.id = id;
		this.nome = nome;
		this.descricao = descricao;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
