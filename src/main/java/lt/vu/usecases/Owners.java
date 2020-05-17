package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Owner;
import lt.vu.persistence.OwnersDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Owners {

    @Inject
    private OwnersDAO ownersDAO;

    @Getter @Setter
    private Owner ownerToCreate = new Owner();

    @Getter
    private List<Owner> allOwners;

    @PostConstruct
    public void init() {
        loadAllOwners();
    }

    private void loadAllOwners() { this.allOwners = ownersDAO.findAll(); }

    @Transactional
    public String createOwners(){
        ownersDAO.persist(ownerToCreate);
        return "index?faces-redirect=true";
    }
}