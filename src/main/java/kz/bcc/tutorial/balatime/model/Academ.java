package kz.bcc.tutorial.balatime.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "academ", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Academ {
    @Id
    @SequenceGenerator(name = "academ_id_seq",
            sequenceName = "academ_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "academ_id_seq")
    @Column(name = "id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name="subject_id")
    private Subject subject;
    @Column(name = "theme")
    private String theme;
    @Column(name = "homework")
    private String homework;
    @Column(name="rank")
    private Integer rank;

}
