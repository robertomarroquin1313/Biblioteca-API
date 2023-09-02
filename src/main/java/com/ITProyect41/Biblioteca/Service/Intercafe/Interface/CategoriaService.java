package com.ITProyect41.Biblioteca.Service.Intercafe.Interface;

import com.ITProyect41.Biblioteca.Persistence.Categoria;
import com.ITProyect41.Biblioteca.Repository.CategoriaRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CategoriaService {
    List<Categoria> obtenerTodasLasCategorias();
    Categoria obtenerCategoriaPorId(long id);
    Categoria guardarCategoria(Categoria categoria);
    void eliminarCategoria(long id);
}
