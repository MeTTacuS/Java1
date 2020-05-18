package lt.vu.persistence;

import lt.vu.entities.Factory;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class FactoriesDAO {
    @Inject
    private EntityManager em;

    public List<Factory> findAll() {
        return em.createNamedQuery("Factory.findAll", Factory.class).getResultList();
    }

    public void persist(Factory factory){
        this.em.persist(factory);
    }

    public Factory findOne(Integer id) {
        return em.find(Factory.class, id);
    }
}