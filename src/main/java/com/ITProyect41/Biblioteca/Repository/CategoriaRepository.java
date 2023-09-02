package com.ITProyect41.Biblioteca.Repository;

import com.ITProyect41.Biblioteca.Persistence.Categoria;
import com.ITProyect41.Biblioteca.Persistence.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
