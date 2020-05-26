package lt.vu.decorators;

import lombok.experimental.Delegate;
import lt.vu.entities.Model;

import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.enterprise.inject.Default;
import java.util.List;

@Default
public class IdenticalComparitor implements ModelNamesComparitor{
    @Override
    public Integer find(Model model, List<Model> models) {
        Integer id = null;

        for (Model m : models) {
            if (m.getName().equals(model.getName()) && !m.getId().equals(model.getId())) {
                id = m.getId();
            }
        }

        return id;
    }
}
