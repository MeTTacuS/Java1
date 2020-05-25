package lt.vu.services;

import org.apache.deltaspike.core.api.future.Futureable;

import javax.ejb.AsyncResult;
import javax.enterprise.context.ApplicationScoped;
import java.io.Serializable;
import java.util.concurrent.Future;
import java.util.Random;

@ApplicationScoped
public class DuplicateFinder implements Serializable {

    @Futureable
    public Future<Integer> FindPossibleDuplicate(Integer modelId) {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Duplicate Finder finished");
        }
        Integer possibleDuplicateId = new Random(modelId).nextInt(100);
        return new AsyncResult<>(possibleDuplicateId);
    }

}
