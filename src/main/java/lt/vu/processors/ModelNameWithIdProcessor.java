package lt.vu.processors;

import lt.vu.entities.Model;

import javax.enterprise.inject.Alternative;

@Alternative
public class ModelNameWithIdProcessor implements ModelNameProcessor {
    @Override
    public void process(Model model) {
        String newName = "[ID: " + model.getId() + "]" + model.getName();
        model.setName(newName);
    }
}