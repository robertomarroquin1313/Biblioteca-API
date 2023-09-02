package com.ITProyect41.Biblioteca.Persistence;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idAuthor")
@Data
@Entity
@Table(name = "Autor")
public class Autor {
    @Id
    @Column(name = "autor_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAuthor;

    @Column(name = "nombre", nullable = false)
    private String name;

    @Column(name = "fecha_nacimiento")
    private Date date;

    @Column(name = "pais")
    private String country;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;
}
