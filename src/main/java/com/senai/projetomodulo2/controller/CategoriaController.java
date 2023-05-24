package com.senai.projetomodulo2.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.senai.projetomodulo2.model.Categoria;
import com.senai.projetomodulo2.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> cadastrarCategoria(@RequestBody Categoria categoria){
        Categoria novaCategoria = categoriaService.salvarCategoria(categoria);
        return new ResponseEntity<Categoria>(novaCategoria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listarCategorias(){
        List<Categoria> categorias = categoriaService.listarCategorias();
        if (categorias.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<String> excluirCategoria(@PathVariable("id") Long id) {
        categoriaService.excluirCategoria(id);
        String mensagem = "Categoria de ID " + id + " foi excluída com sucesso!";
        return new ResponseEntity<>(mensagem, HttpStatus.OK);
    }

}
