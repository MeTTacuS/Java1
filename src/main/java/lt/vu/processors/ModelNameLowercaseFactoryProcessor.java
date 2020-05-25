package lt.vu.processors;

import lt.vu.entities.Model;

import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Specializes;

@Specializes
@Alternative
public class ModelNameLowercaseFactoryProcessor extends ModelNameWithFactoryProcessor {

    protected String getFactoryName(Model model) {
        String factoryName = model.getFactory().getName();
        return factoryName.toLowerCase();
    }
}