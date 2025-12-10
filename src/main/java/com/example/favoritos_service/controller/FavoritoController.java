package com.example.favoritos_service.controller;

import com.example.favoritos_service.model.Favorito;

import com.example.favoritos_service.service.FavoritoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/favoritos")
@CrossOrigin(origins = "*")
public class FavoritoController {

    private final FavoritoService service;

    public FavoritoController(FavoritoService service) {
        this.service = service;
    }

    // LISTAR FAVORITOS DE UN USUARIO
    @GetMapping("/usuario/{idUsuario}")
    public List<Favorito> listarPorUsuario(@PathVariable Long idUsuario) {
        return service.listarPorUsuario(idUsuario);
    }

    // AGREGAR FAVORITO
    @PostMapping
    public ResponseEntity<Favorito> agregar(@RequestBody  Favorito favorito) {
        Favorito creado = service.agregar(favorito);
        return new ResponseEntity<>(creado, HttpStatus.CREATED);
    }

    // MODIFICAR NOTA DEL FAVORITO
    @PutMapping("/{id}")
    public Favorito modificar(
            @PathVariable Long id,
            @RequestBody Favorito favorito
    ) {
        return service.modificar(id, favorito);
    }

    // ELIMINAR FAVORITO
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        service.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
