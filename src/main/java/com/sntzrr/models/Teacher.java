package com.sntzrr.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.List;

@Entity(name = "Teacher")
@Table(name = "\"Teachers\"", schema = "public")
@OnDelete(action = OnDeleteAction.CASCADE)
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_teacher_person"))
@Getter
@Setter
public class Teacher extends Person implements Serializable {
    @Column(name = "degree", nullable = false)
    private String degree;

    @Column(name = "salary", nullable = false)
    private Double salary;

    @JsonIdentityInfo( //Ref.Bidireccional, logra crear un solo identificador.
            generator = ObjectIdGenerators.PropertyGenerator.class, //Genera una clase.
            property = "key" //Valor que me taerá de Course.
    )
    @JsonIdentityReference(alwaysAsId = true) //Para todos los objetos.
    @OneToMany(mappedBy = "teacher", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true) // Cascade permite eliminar los cursos que tengan relación con el profesor si son eliminados.
    private List<Course> courses;
}
