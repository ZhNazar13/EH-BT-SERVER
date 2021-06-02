package kz.bcc.tutorial.balatime.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;

@Table(name = "teacher", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Teacher {
    @Id
    @SequenceGenerator(name = "teacher_id_seq",
            sequenceName = "teacher_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "teacher_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "workload")
    private Integer workload;
    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

}
