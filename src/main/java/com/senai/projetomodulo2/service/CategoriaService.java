package com.senai.projetomodulo2.service;


import com.senai.projetomodulo2.model.Categoria;
import com.senai.projetomodulo2.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria salvarCategoria(Categoria categoria) {
        if (categoriaRepository.findByNome(categoria.getNome()).isPresent()) {
            throw new IllegalArgumentException("Categoria já cadastrada");
        }
        return categoriaRepository.save(categoria);
    }

    public List<Categoria> listarCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    public void excluirCategoria(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Categoria não encontrada"));
        if (categoriaTemReceitas(categoria)) {
            throw new IllegalStateException("Não é possível excluir uma categoria com receitas cadastradas");
        }
        categoriaRepository.delete(categoria);
    }

    private boolean categoriaTemReceitas(Categoria categoria) {
        return categoria.temReceitas();
    }


}
