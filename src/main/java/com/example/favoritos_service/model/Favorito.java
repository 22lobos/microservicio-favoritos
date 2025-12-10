package com.example.favoritos_service.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "favoritos")
public class Favorito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // viene de tu usuarios-service
    private Long idUsuario;

    // viene de tu reportes-mascotas-service
    private Long idReporte;

    private LocalDateTime fechaAgregado;

    @Column(length = 500) // comentario opcional del usuario
    private String nota;

    public Favorito() {
    }

    // ===== GETTERS & SETTERS =====

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getIdUsuario() { return idUsuario; }
    public void setIdUsuario(Long idUsuario) { this.idUsuario = idUsuario; }

    public Long getIdReporte() { return idReporte; }
    public void setIdReporte(Long idReporte) { this.idReporte = idReporte; }

    public LocalDateTime getFechaAgregado() { return fechaAgregado; }
    public void setFechaAgregado(LocalDateTime fechaAgregado) { this.fechaAgregado = fechaAgregado; }

    public String getNota() { return nota; }
    public void setNota(String nota) { this.nota = nota; }
}
