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
        @NamedQuery(name = "Owner.findAll", query = "select o from Owner as o")
})
@Table(name = "OWNER")
@Getter @Setter
@EqualsAndHashCode
public class Owner {
    public Owner(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max = 50)
    private String name;

    @ManyToMany(mappedBy = "owners")
    private List<Model> models = new ArrayList<>();
}
