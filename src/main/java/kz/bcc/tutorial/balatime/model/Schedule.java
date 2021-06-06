package kz.bcc.tutorial.balatime.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Time;
import java.time.DayOfWeek;

@Table(name = "schedule", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Schedule {
    @Id
    @SequenceGenerator(name = "schedule_id_seq",
            sequenceName = "schedule_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "schedule_id_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="academ_id")
    private Academ academ;
    @ManyToOne
    @JoinColumn(name="group_id")
    private Group group;
    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;
    @Column(name = "day")
    private DayOfWeek day;
    @Column(name = "quarter")
    private String quarter;
    @Column(name = "time")
    private Time time;

}
