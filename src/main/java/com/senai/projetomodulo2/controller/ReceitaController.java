package com.senai.projetomodulo2.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senai.projetomodulo2.model.Receita;
import com.senai.projetomodulo2.service.ReceitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/receita")
public class ReceitaController {

    @Autowired
    private ReceitaService receitaService;

    @PostMapping
    public ResponseEntity<Receita> cadastrarReceita(@RequestBody Receita receita) {
        Receita novaReceita = receitaService.salvarReceita(receita);
        return new ResponseEntity<Receita>(novaReceita, HttpStatus.CREATED);
    }

    @JsonIgnore
    @PutMapping(value = "atualizar/{id}")
    public ResponseEntity<Receita> atualizarReceita(@PathVariable Long id, @RequestBody Receita receita) {
        Receita receitaAtualizada = receitaService.atualizarReceita(id, receita);
        return new ResponseEntity<>(receitaAtualizada, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirReceita(@PathVariable Long id) {
        receitaService.excluirReceita(id);
        String mensagem = "Categoria de ID " + id + " foi excluída com sucesso!";
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

    @JsonIgnore
    @GetMapping(value = "/por-categoria/{categoriaId}")
    public ResponseEntity<List<Receita>> listarReceitasPorCategoria(@PathVariable Long categoriaId) {
        List<Receita> receitas = receitaService.listarReceitasPorCategoria(categoriaId);
        return new ResponseEntity<>(receitas, HttpStatus.OK);
    }

    @GetMapping(value = "/com-restricoes")
    public ResponseEntity<List<Receita>> listarReceitasComRestricoes() {
        return new ResponseEntity<List<Receita>>(receitaService.listarReceitasComRestricoes(), HttpStatus.OK);
    }

    @GetMapping(value = "/sem-restricoes")
    public ResponseEntity<List<Receita>> listarReceitasSemRestricoes() {
        return new ResponseEntity<List<Receita>>(receitaService.listarReceitasSemRestricoes(), HttpStatus.OK);
    }
}
