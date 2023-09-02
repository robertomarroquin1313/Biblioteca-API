package com.ITProyect41.Biblioteca.Persistence;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idBook")
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
