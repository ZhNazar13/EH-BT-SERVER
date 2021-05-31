package kz.bcc.tutorial.balatime.model;

import lombok.*;

import javax.persistence.*;

@Table(name = "group", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Group {
    @Id
    @SequenceGenerator(name = "group_id_seq",
            sequenceName = "group_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "group_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "rank")
    private Integer rank;
    @Column(name = "workload")
    private Integer workload;
}
