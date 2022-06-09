package com.api_instrumentos.Model;

import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;
import javax.persistence.*;

    @Setter   //Anotacion de lombok para metodos Setters
    @Getter   //Anotacion de lombok para metodos Getters
    @NoArgsConstructor  //Anotacion de lombok para contructor sin parámetros
    @Entity
    public class Instrumento {
        @Id  //Defino que el atributo ID sera el PK de la tabla Instrumento
        @GeneratedValue(strategy = GenerationType.IDENTITY)  //Defino el ID autoincremental
        private int id;
        @Column
        private String instrumento;
        private String marca;
        private String modelo;
        private String imagen;
        private double precio;
        private String costoEnvio;
        private int cantidadVendida;
        @Column(columnDefinition = "longtext")  //Anotacion para definir la descripcion como un string largo
        private String descripcion;
    }
