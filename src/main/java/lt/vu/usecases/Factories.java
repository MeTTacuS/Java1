package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Factory;
import lt.vu.entities.Model;
import lt.vu.persistence.FactoriesDAO;
import lt.vu.persistence.ModelsDAO;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@javax.enterprise.inject.Model
public class Factories {

    @Inject
    private FactoriesDAO factoriesDAO;

    @Inject
    private ModelsDAO modelsDAO;

    @Getter @Setter
    private Factory factoryToCreate = new Factory();

    @Getter
    private List<Factory> allFactories;

    @Getter
    private List<Model> modelList;

    @PostConstruct
    public void init(){ loadAllFactories(); }

    @Transactional
    private void loadAllFactories() { allFactories = factoriesDAO.findAll(); }

    public Integer loadAmountOfModels(Integer modelId) {
        modelList = modelsDAO.findAll(modelId);
        return modelList.size();
    }

    @Transactional
    public String createFactory(){
        factoriesDAO.persist(factoryToCreate);
        return "index?faces-redirect=true";
    }
}