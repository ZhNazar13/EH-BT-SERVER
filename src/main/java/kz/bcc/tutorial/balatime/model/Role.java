package kz.bcc.tutorial.balatime.model;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Table(name = "role", schema = "public")
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Setter
@Getter
public class Role implements GrantedAuthority {
    @Id
    @SequenceGenerator(name = "role_id_seq",
            sequenceName = "role_id_seq",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "role_id_seq")
    @Column(name = "id")
    private Integer id;
    @Column(name = "code", unique = true)
    private String code;
    @Column(name = "name")
    private String name;

    @Override
    public String getAuthority() {
        return code;
    }
}
