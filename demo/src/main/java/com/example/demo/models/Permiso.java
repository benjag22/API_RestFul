package com.example.demo.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permisos")
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Permiso extends BaseEntity{

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    /**Role
     * Esto es solo para que nos traiga el id de un role y no el obejeto completo
     */
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId=true)
    @JsonProperty("role_id")
    @ManyToOne(fetch = FetchType.LAZY)
    @Getter @Setter
    @JoinColumn(name = "role_id")
    private Role role;

}
