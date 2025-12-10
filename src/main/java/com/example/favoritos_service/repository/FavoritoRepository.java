package com.example.favoritos_service.repository;

import com.example.favoritos_service.model.Favorito;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavoritoRepository extends JpaRepository<Favorito, Long> {

    // Para listar favoritos de un usuario
    List<Favorito> findByIdUsuarioOrderByFechaAgregadoDesc(Long idUsuario);

    // Para evitar duplicados (mismo usuario marcando el mismo reporte muchas veces)
    boolean existsByIdUsuarioAndIdReporte(Long idUsuario, Long idReporte);
}
