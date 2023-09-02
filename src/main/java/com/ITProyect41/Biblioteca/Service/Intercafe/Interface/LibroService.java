package com.ITProyect41.Biblioteca.Service.Intercafe.Interface;

import com.ITProyect41.Biblioteca.Persistence.Libro;
import com.ITProyect41.Biblioteca.Repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LibroService {
    List<Libro> obtenerTodosLosLibros();
    Libro obtenerLibroPorId(long id);
    Libro guardarLibro(Libro libro);
    void eliminarLibro(long id);
}
