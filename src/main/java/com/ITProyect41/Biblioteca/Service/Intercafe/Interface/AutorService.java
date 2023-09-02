package com.ITProyect41.Biblioteca.Service.Intercafe.Interface;

import com.ITProyect41.Biblioteca.Persistence.Autor;
import com.ITProyect41.Biblioteca.Repository.AutorRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AutorService {
    List<Autor> obtenerTodosLosAutores();
    Autor obtenerAutorPorId(long id);
    Autor guardarAutor(Autor autor);
    void eliminarAutor(long id);
}
