package com.example.demo.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;


@Entity
@Table(name = "users")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class User extends BaseEntity {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    @Getter @Setter
    @JoinColumn(name = "role_id")
    private Role role;

    @Getter @Setter
    @Column(name="nombre")
    private String nombre;

    @Getter @Setter
    @Column(name="apellido")
    private String apellido;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @Getter @Setter
    @Column(name="password")
    private String password;

    @Getter @Setter
    @Column(name="email")
    private String email;

    @Getter @Setter
    @Column(name="telefono")
    private String telefono;

    @Getter @Setter
    @Column(name="fecha_nacimiento")
    private Date fechaNacimiento;

    public User(String nombre, String apellido, String email, String telefono, Date fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
    }
}
