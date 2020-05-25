package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;

import lt.vu.entities.Model;
import lt.vu.persistence.ModelsDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateModel implements Serializable {
    private Model model;

    @Inject
    private ModelsDAO modelsDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateModel init is called");
        Map<String, String> requestParameters = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer modelId = Integer.parseInt(requestParameters.get("modelId"));
        this.model = modelsDAO.findOne(modelId);
    }

    @Transactional
    public String updateModelName() {
        try {
            modelsDAO.update(this.model);
        } catch (OptimisticLockException e) {
            return "modelDetails?faces-redirect=true&modelId=" + this.model.getId() + "&error=optimistic-lock-exception";
        }
        return "modelDetails?faces-redirect=true&modelId=" + this.model.getId();
    }
}
