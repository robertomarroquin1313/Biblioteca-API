package com.ITProyect41.Biblioteca.Service.Intercafe;

import com.ITProyect41.Biblioteca.Persistence.Libro;
import com.ITProyect41.Biblioteca.Repository.LibroRepository;
import com.ITProyect41.Biblioteca.Service.Intercafe.Interface.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroServiceIml implements LibroService {
    private final LibroRepository libroRepository;

    @Autowired
    public LibroServiceIml(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public List<Libro> obtenerTodosLosLibros() {
        return libroRepository.findAll();
    }

    @Override
    public Libro obtenerLibroPorId(long id) {
        return libroRepository.findById(id).orElse(null);
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void eliminarLibro(long id) {
        libroRepository.deleteById(id);
    }
}
