package com.sntzrr.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity(name = "Student")
@Table(name = "\"Students\"", schema = "public")
@PrimaryKeyJoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_student_person"))
@Getter
@Setter
public class Student extends Person implements Serializable {
    @Column(name = "schoolarship", columnDefinition = "boolean DEFAULT 'false'")
    private Boolean schoolarship = false;

    @Column(name = "state", columnDefinition = "integer DEFAULT '1'")
    private Integer state = 1;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "\"StudentCourse\"",
            joinColumns = @JoinColumn(
                    name = "student_id",
                    referencedColumnName = "id",
                    foreignKey = @ForeignKey(
                            name = "fk_student_course",
                            foreignKeyDefinition = "FOREIGN KEY (student_id)\r\n" +
                                    " REFERENCES public.\"Students\" (id) MATCH SIMPLE\r\n" +
                                    " ON UPDATE CASCADE\r\n" +
                                    " ON DELETE CASCADE",
                            value = ConstraintMode.CONSTRAINT
                    )
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "course_key",
                    referencedColumnName = "key",
                    foreignKey = @ForeignKey(
                            name = "fk_course_student",
                            foreignKeyDefinition = "FOREIGN KEY (course_key)\r\n" +
                                    " REFERENCES public.\"Courses\" (key) MATCH SIMPLE\r\n" +
                                    " ON UPDATE CASCADE\r\n" +
                                    " ON DELETE CASCADE",
                            value = ConstraintMode.CONSTRAINT
                    )
            )
    )
    private List<Course> enrolled_courses;
}
