package lt.vu.services;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Capitalizer {
    public String capitalize(String input) {
        return input.toUpperCase();
    }
}
