package kz.bcc.tutorial.balatime.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "student", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Student {
    @Id
    @SequenceGenerator(name = "student_id_seq",
            sequenceName = "student_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "student_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "parent_name")
    private String parent_name;
    @Column(name = "parent_email")
    private String parent_email;
    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;

}
