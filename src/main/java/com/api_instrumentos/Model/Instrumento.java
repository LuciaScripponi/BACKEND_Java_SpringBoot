package com.api_instrumentos.Model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import javax.persistence.*;

    @Setter
    @Getter
    @NoArgsConstructor
    @Entity
    public class Instrumento {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        @Column
        private String instrumento;
        private String marca;
        private String modelo;
        private String imagen;
        private double precio;
        private String costoEnvio;
        private int cantidadVendida;
        @Column(columnDefinition = "longtext")
        private String descripcion;
    }
