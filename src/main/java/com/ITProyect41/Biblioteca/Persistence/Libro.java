package com.ITProyect41.Biblioteca.Persistence;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Libro")
public class Libro {

    @Id
    @Column(name = "libro_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBook;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "autor_id")
    private long idAuthor;

    @Column(name = "categoria_id")
    private long idCategory;

    @Column(name = "precio")
    private double price;

    @Column(name = "estado")
    private  String estatus;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
}
