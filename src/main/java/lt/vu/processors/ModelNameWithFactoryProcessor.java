package lt.vu.processors;

import lt.vu.entities.Model;

import javax.enterprise.inject.Alternative;

@Alternative
public class ModelNameWithFactoryProcessor implements ModelNameProcessor {

    protected String getFactoryName(Model model) {
        return model.getFactory().getName();
    }

    @Override
    public void process(Model model) {
        String newName = "[" + getFactoryName(model) + "]" + model.getName();
        model.setName(newName);
    }
}