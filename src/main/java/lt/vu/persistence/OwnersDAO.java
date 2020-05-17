package lt.vu.persistence;

import lt.vu.entities.Owner;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class OwnersDAO {
    @Inject
    private EntityManager em;

    public List<Owner> findAll() {
        return em.createNamedQuery("Owner.findAll", Owner.class).getResultList();
    }

    public void persist(Owner owner){
        this.em.persist(owner);
    }

    public Owner findOne(Integer id){ return em.find(Owner.class, id); }

    public Owner update(Owner owner){
        return em.merge(owner);
    }
}