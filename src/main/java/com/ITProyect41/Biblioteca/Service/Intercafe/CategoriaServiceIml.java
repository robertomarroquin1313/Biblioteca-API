package com.ITProyect41.Biblioteca.Service.Intercafe;

import com.ITProyect41.Biblioteca.Persistence.Categoria;
import com.ITProyect41.Biblioteca.Repository.CategoriaRepository;
import com.ITProyect41.Biblioteca.Service.Intercafe.Interface.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceIml implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceIml(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<Categoria> obtenerTodasLasCategorias() {
        return categoriaRepository.findAll();
    }

    @Override
    public Categoria obtenerCategoriaPorId(long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    @Override
    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    @Override
    public void eliminarCategoria(long id) {
        categoriaRepository.deleteById(id);
    }
}
