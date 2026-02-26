package interview;

import java.util.Map;
import java.util.Optional;

public class CowRepository {
    private Map<String, Cow> cows;

    public CowRepository(Cow rootCow) {
        this.cows = Map.of(rootCow.cowId(), rootCow);
    }

    public Cow findById(String cowId) {
        return Optional.ofNullable(cows.get(cowId)).orElseThrow(() -> new RuntimeException("Cow with id [" + cowId + "] not found"));
    }

    public void save(Cow cow) {
        cows.put(cow.cowId(), cow);
    }

    public void remove(String cowId) {
        cows.remove(cowId);
    }
}
