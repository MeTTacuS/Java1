package lt.vu.processors;

import lt.vu.entities.Model;

import java.io.Serializable;

public interface ModelNameProcessor extends Serializable {
    void process(Model model);
}