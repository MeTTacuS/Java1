package lt.vu.services;

import lombok.Getter;
import lombok.Setter;
import org.apache.deltaspike.core.api.future.Futureable;

import lt.vu.decorators.ModelNamesComparitor;
import lt.vu.entities.Model;
import lt.vu.persistence.ModelsDAO;
import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.Future;
import java.util.Random;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class DuplicateFinder implements Serializable {

    @Inject
    private ModelNamesComparitor modelNamesComparitor;

    @Inject
    @Setter @Getter
    private ModelsDAO modelsDAO;

    @Futureable
    public Future<Integer> FindPossibleDuplicate(Integer modelId) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Duplicate Finder finished");
        }
        // Integer possibleDuplicateId = new Random(modelId).nextInt(100);

        Model model = modelsDAO.findOne(modelId);
        List<Model> models = modelsDAO.findAll(model.getFactory().getId());
        models.removeIf(m -> m.getId().equals(model.getId()));

        Integer possibleDuplicateId = modelNamesComparitor.find(model, models);

        return new AsyncResult<>(possibleDuplicateId);
    }

}
