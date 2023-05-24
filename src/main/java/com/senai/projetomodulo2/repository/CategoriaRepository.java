package com.senai.projetomodulo2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.senai.projetomodulo2.model.Categoria;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long>{
        Optional<Categoria> findByNome(String nome);
}
