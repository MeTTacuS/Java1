package lt.vu.decorators;

import lt.vu.entities.Model;

import java.util.List;

public interface ModelNamesComparitor {
    public Integer find(Model model, List<Model> models);
}