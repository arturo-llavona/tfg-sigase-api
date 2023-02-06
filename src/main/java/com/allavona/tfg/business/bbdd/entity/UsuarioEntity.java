package com.allavona.tfg.business.bbdd.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "usuario", schema = "public", catalog = "tfg")
@NoArgsConstructor
@Data
public class UsuarioEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_usuario")
    private int idUsuario;
    @Basic
    @Column(name = "nombre")
    private String nombre;
    @Basic
    @Column(name = "apellido_1")
    private String apellido1;
    @Basic
    @Column(name = "apellido_2")
    private String apellido2;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "extension")
    private String extension;
    @Basic
    @Column(name = "tipo_usuario")
    private Integer tipoUsuario;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "password")
    private String password;
    @Basic
    @Column(name = "habilitado")
    private Boolean habilitado;
}
