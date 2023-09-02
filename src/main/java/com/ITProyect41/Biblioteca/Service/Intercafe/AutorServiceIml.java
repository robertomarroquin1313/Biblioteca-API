package com.ITProyect41.Biblioteca.Service.Intercafe;

import com.ITProyect41.Biblioteca.Persistence.Autor;
import com.ITProyect41.Biblioteca.Repository.AutorRepository;
import com.ITProyect41.Biblioteca.Service.Intercafe.Interface.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceIml implements AutorService {
    private final AutorRepository autorRepository;

    @Autowired
    public AutorServiceIml(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public List<Autor> obtenerTodosLosAutores() {
        return autorRepository.findAll();
    }

    @Override
    public Autor obtenerAutorPorId(long id) {
        return autorRepository.findById(id).orElse(null);
    }

    @Override
    public Autor guardarAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    @Override
    public void eliminarAutor(long id) {
        autorRepository.deleteById(id);
    }
}
