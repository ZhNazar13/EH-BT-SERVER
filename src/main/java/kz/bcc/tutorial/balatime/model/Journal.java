package kz.bcc.tutorial.balatime.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "journal", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Journal {
    @Id
    @SequenceGenerator(name = "journal_id_seq",
            sequenceName = "journal_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "journal_id_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="schedule_id")
    private Schedule schedule;
    @ManyToOne
    @JoinColumn(name="student_id")
    private Student student;
    @Column(name = "attendance")
    private Integer attendance;
    @Column(name = "grade")
    private Integer grade;

}
