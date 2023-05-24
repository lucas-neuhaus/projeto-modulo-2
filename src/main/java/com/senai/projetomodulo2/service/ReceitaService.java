package com.senai.projetomodulo2.service;


import com.senai.projetomodulo2.model.Categoria;
import com.senai.projetomodulo2.model.Receita;
import com.senai.projetomodulo2.repository.ReceitaRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class ReceitaService {

    @Autowired
    private ReceitaRepository receitaRepository;

    public Receita salvarReceita(Receita receita) {
        return receitaRepository.save(receita);
    }


    public Receita atualizarReceita(Long id, Receita receita){
        receita.setId(id);
        return receitaRepository.save(receita);
    }

    public List<Receita> listarReceitas(){
        return receitaRepository.findAll();
    }

    public void excluirReceita(Long id){
        if(!receitaRepository.existsById(id)){
            throw new IllegalArgumentException("Receita não encontrada!");
        }
        receitaRepository.deleteById(id);
    }
    public List<Receita> listarReceitasPorCategoria(Long categoriaId){
        Categoria categoria = new Categoria();
        categoria.setId(categoriaId);
        return receitaRepository.findByCategoria(categoria);
    }

    public List<Receita> listarReceitasComRestricoes(){
        return receitaRepository.findByRestricoes();
    }

    public List<Receita> listarReceitasSemRestricoes(){
        return receitaRepository.findBySemRestricoes();
    }
}
