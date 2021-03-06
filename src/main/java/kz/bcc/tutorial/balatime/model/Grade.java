package kz.bcc.tutorial.balatime.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "grade", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Grade {
    @Id
    @SequenceGenerator(name = "grade_id_seq",
            sequenceName = "grade_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "grade_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
}
