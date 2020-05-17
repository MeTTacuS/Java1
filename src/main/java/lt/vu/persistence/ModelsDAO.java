package lt.vu.persistence;

import lt.vu.entities.Model;
import lt.vu.usecases.Models;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ModelsDAO {
    @Inject
    private EntityManager em;

    public List<Model> findAll(Integer id){
        return em.createNamedQuery("Model.findAll", Model.class).setParameter("factoryId", id).getResultList();
    }

    public void persist(Model model){
        this.em.persist(model);
    }

    public Model findOne(Integer id){
        return em.find(Model.class, id);
    }

    public Model update(Model model){
        return em.merge(model);
    }
}