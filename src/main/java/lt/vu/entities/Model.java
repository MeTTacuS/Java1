package lt.vu.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name = "Model.findAll", query = "select m from Model as m where m.factory.id =: factoryId")
})
@Table(name = "MODEL")
@Getter @Setter
@EqualsAndHashCode
public class Model {
    public Model() {}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    private String name;

    @ManyToMany()
    @JoinTable(name = "MODEL_OWNERS")
    private List<Owner> owners = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "FACTORY_ID")
    private Factory factory;

    @Version
    @Column(name = "OPT_LOCK_VERSION")
    private Integer version;
}