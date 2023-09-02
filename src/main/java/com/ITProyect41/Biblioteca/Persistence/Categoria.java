package com.ITProyect41.Biblioteca.Persistence;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;

import javax.naming.Name;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idCategory")
@Data
@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @Column(name = "categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategory;

    @Column(name = "nombre")
    private String name;

    @Column(name = "archivo")
    private String archive;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Libro> libros;

}
