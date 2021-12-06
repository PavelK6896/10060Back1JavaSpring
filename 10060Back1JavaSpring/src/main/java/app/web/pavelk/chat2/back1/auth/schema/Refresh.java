package app.web.pavelk.chat2.back1.auth.schema;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.GenerationType.IDENTITY;

@Builder
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"id"})
@Table(catalog = "client", name = "refresh")
public class Refresh {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "token")
    private String token;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "connected")
    private LocalDateTime connected;

    @Column(name = "remote_address")
    private String remoteAddress;

    @Column(name = "user_id")
    private Long userId;

    @ManyToOne
    @JoinColumn(name = "user_id", updatable = false, insertable = false)
    @ToString.Exclude
    private User user;

}
