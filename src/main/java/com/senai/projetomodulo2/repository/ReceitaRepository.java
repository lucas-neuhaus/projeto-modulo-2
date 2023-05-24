package com.senai.projetomodulo2.repository;

import com.senai.projetomodulo2.model.Categoria;
import com.senai.projetomodulo2.model.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    List<Receita> findByCategoria(Categoria categoria);

    @Query("SELECT r FROM Receita r WHERE r.restricoes = true")
    List<Receita> findByRestricoes();

    @Query("SELECT r FROM Receita r WHERE r.restricoes = false")
    List<Receita> findBySemRestricoes();

}
