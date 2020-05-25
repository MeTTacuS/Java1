package lt.vu.processors;

import lt.vu.entities.Model;

import javax.enterprise.inject.Alternative;

@Alternative
public class ModelNameWithFactoryProcessor implements ModelNameProcessor {

    @Override
    public void process(Model model) {
        String newName = "[" + model.getFactory().getName() + "]" + model.getName();
        model.setName(newName);
    }
}