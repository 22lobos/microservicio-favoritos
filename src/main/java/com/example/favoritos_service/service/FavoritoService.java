package com.example.favoritos_service.service;

import com.example.favoritos_service.model.Favorito;
import com.example.favoritos_service.repository.FavoritoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class FavoritoService {

    private final FavoritoRepository repository;

    public FavoritoService(FavoritoRepository repository) {
        this.repository = repository;
    }

    // LISTAR FAVORITOS DE UN USUARIO
    public List<Favorito> listarPorUsuario(Long idUsuario) {
        return repository.findByIdUsuarioOrderByFechaAgregadoDesc(idUsuario);
    }

    // AGREGAR (CREATE)
    public Favorito agregar(Favorito favorito) {

        // Regla simple: no permitir duplicados del mismo reporte para el mismo usuario
        if (repository.existsByIdUsuarioAndIdReporte(
                favorito.getIdUsuario(),
                favorito.getIdReporte()
        )) {
            throw new RuntimeException("Este reporte ya está en favoritos");
        }

        favorito.setFechaAgregado(LocalDateTime.now());
        return repository.save(favorito);
    }

    // MODIFICAR (UPDATE) – aquí actualizamos solo la nota
    public Favorito modificar(Long id, Favorito datos) {
        Favorito existente = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Favorito no encontrado"));

        existente.setNota(datos.getNota());

        return repository.save(existente);
    }

    // ELIMINAR (DELETE)
    public void eliminar(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("No existe el favorito con id " + id);
        }
        repository.deleteById(id);
    }
}
