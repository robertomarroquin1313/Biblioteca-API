package com.ITProyect41.Biblioteca.Repository;

import com.ITProyect41.Biblioteca.Persistence.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    ///consultas personalizadas
}
