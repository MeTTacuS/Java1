package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Factory;
import lt.vu.entities.Model;
import lt.vu.persistence.FactoriesDAO;
import lt.vu.persistence.ModelsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@javax.enterprise.inject.Model
public class Models {

    @Inject
    private FactoriesDAO factoriesDAO;

    @Inject
    private ModelsDAO modelsDAO;

    @Getter @Setter
    private Factory factory = new Factory();

    @Getter @Setter
    private Model modelToCreate = new Model();

    @Getter
    private List<Model> modelList;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer factoryId = Integer.parseInt(requestParameters.get("factoryId"));
        this.factory = factoriesDAO.findOne(factoryId);
        loadModelsOwners(factoryId);
    }

    private void loadModelsOwners(Integer factoryId) { modelList = modelsDAO.findAll(factoryId); }

    @Transactional
    public String createModel(){
        modelToCreate.setFactory(this.factory);
        modelsDAO.persist(modelToCreate);
        return "factoryModels?faces-redirect=true&factoryId=" + this.factory.getId();
    }
}