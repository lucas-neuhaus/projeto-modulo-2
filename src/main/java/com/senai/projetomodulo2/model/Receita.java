package com.senai.projetomodulo2.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "receita")
public class Receita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private Categoria categoria;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String ingredientes;

    @Column(nullable = false)
    private String preparo;

    @Column(nullable = false)
    private Boolean restricoes;

}
