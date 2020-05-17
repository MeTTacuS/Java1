package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Model;
import lt.vu.mybatis.dao.ModelOwnersMapper;
import lt.vu.mybatis.dao.OwnerMapper;
import lt.vu.mybatis.model.ModelOwners;
import lt.vu.mybatis.model.Owner;
import lt.vu.persistence.ModelsDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@javax.enterprise.inject.Model
@RequestScoped
public class ModelDetails {

    @Inject
    private ModelsDAO modelsDAO;

    @Getter @Setter
    private Model model = new Model();

    @Inject
    private OwnerMapper ownerMapper;

    @Inject
    private ModelOwnersMapper modelOwnersMapper;

    @Getter @Setter
    private ModelOwners modelOwners = new ModelOwners();

    @Getter @Setter
    private Owner owner = new Owner();

    @Getter
    private List<Owner> ownerList;

    @Getter
    private List<Owner> ownerListFree;

    @PostConstruct
    public void init(){
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer modelId = Integer.parseInt(requestParameters.get("modelId"));
        this.model = modelsDAO.findOne(modelId);
        loadModel(modelId);
        loadModelOwners(modelId);
        loadModelOwnersFree(modelId);
    }

    private void loadModel(Integer modelId) { this.model = modelsDAO.findOne(modelId); }

    private void loadModelOwners(Integer modelId){
        this.ownerList = ownerMapper.selectOwnersByModel(modelId);
    }

    private void loadModelOwnersFree(Integer modelId) { this.ownerListFree = ownerMapper.selectOwnersByModelFree(modelId); }

    @Transactional
    public String addOwner(){
        modelOwners.setModelsId(this.model.getId());
        modelOwners.setOwnersId(this.owner.getId());
        modelOwnersMapper.insert(modelOwners);
        return "modelDetails?faces-redirect=true&modelId=" + this.model.getId();
    }
}