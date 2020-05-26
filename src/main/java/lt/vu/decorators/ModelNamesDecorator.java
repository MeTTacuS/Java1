package lt.vu.decorators;

import lt.vu.entities.Model;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import java.util.List;

@Decorator
public class ModelNamesDecorator implements ModelNamesComparitor {

    @Inject
    @Delegate
    @Any
    ModelNamesComparitor modelNamesComparitor;

    @Override
    public Integer find(Model model, List<Model> models) {
        System.out.println("You can do additional stuff here");
        return modelNamesComparitor.find(model, models);
    }
}