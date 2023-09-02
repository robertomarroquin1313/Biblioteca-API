package com.ITProyect41.Biblioteca.Controller;

import com.ITProyect41.Biblioteca.Persistence.Libro;
import com.ITProyect41.Biblioteca.Service.Intercafe.LibroService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {
    private final LibroService libroService;

    @Autowired
    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @GetMapping("/guardar")
    public List<Libro> obtenerTodosLosLibros() {
        return libroService.obtenerTodosLosLibros();
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id);
    }

    @PostMapping("/crear")
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.guardarLibro(libro);
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(@PathVariable Long id, @RequestBody Libro libro) {
        // Verifica si el libro con el ID especificado existe antes de actualizarlo
        if (libroService.obtenerLibroPorId(id) == null) {
            libro.setIdBook(id);
            return libroService.guardarLibro(libro);
        } else {
            throw new ResourceNotFoundException("Libro no encontrado con ID: " + id);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}
