package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Factory;
import lt.vu.persistence.FactoriesDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Model
@RequestScoped
public class Factories {

    @Inject
    private FactoriesDAO factoriesDAO;

    @Getter @Setter
    private Factory factoryToCreate = new Factory();

    @Getter
    private List<Factory> allFactories;

    @PostConstruct
    public void init(){ loadAllFactories(); }

    private void loadAllFactories() { allFactories = factoriesDAO.findAll(); }

    @Transactional
    public String createFactory(){
        factoriesDAO.persist(factoryToCreate);
        return "index?faces-redirect=true";
    }
}