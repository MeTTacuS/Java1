package lt.vu.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQueries({
        @NamedQuery(name = "Factory.findAll", query = "select f from Factory as f")
})
@Table(name = "FACTORY")
@Getter @Setter
@EqualsAndHashCode
public class Factory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "factory")
    private List<Model> models = new ArrayList<>();
}