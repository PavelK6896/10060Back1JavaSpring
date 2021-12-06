package app.web.pavelk.chat2.back1.info.db.mysql.schema;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

import static javax.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@ToString
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(schema = "chat2", name = "book_my_sql")
public class BookMySql {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "number")
    private Long number;

    @Column(name = "name")
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        BookMySql bookMySql = (BookMySql) o;
        return id != null && Objects.equals(id, bookMySql.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
