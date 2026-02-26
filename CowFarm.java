package interview;

public class CowFarm {

    private final Cow rootCow;
    private final CowRepository cowRepository;

    public CowFarm(String rootCowId, String rootCowNickName) {
        rootCow = Cow.createNew(rootCowId, rootCowNickName);
        this.cowRepository = new CowRepository(rootCow);
    }

    public Cow giveBirth (String parentCowId, String childCowId, String childNickName) {
        Cow parentCow = cowRepository.findById(parentCowId);
        Cow childCow = Cow.createNew(childCowId, childNickName);

        cowRepository.save(childCow);
        cowRepository.save(parentCow.withChild(childCow));

        return childCow;
    }

    public void endLifeSpan(String cowId) {
        cowRepository.remove(cowId);
    }

    public void printFarmData() {
        //TODO - print farm data starting with this.rootCow
    }
}
