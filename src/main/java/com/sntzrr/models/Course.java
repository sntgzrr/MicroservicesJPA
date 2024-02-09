package com.sntzrr.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

@Entity(name = "Course")
@Table(name = "\"Courses\"", schema = "public")
@Getter
@Setter
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "key")
    private Long key;

    @ManyToOne
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "id",
            foreignKey = @ForeignKey(
                    name = "fk_course_teacher",
                    foreignKeyDefinition = " FOREIGN KEY (teacher_id)\r\n" +
                            " REFERENCES public.\"Teachers\" (id) MATCH SIMPLE\r\n" +
                            " ON UPDATE CASCADE\r\n" +
                            " ON DELETE CASCADE",
                    value = ConstraintMode.CONSTRAINT
            )
    )
    private Teacher teacher;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "start_date", nullable = false, columnDefinition = "date DEFAULT 'now()'")
    private LocalDate start_date = ZonedDateTime.now(ZoneId.of("America/Bogota")).toLocalDate();

    @Column(name = "ending_date", nullable = false)
    private LocalDate ending_date;

    @ManyToMany(mappedBy = "enrolled_courses", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Student> enrolled_students;
}
