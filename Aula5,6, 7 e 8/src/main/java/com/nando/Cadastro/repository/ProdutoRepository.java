package com.nando.Cadastro.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nando.Cadastro.model.Produto;
// Conectar com o banco e trazer metodos
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
