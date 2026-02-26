package interview;

public class CowCollection {
    private CowEntry firstCowEntry;

    public static class CowEntry {
        private Cow cow;
        private CowEntry nextSibling;
        private CowCollection children;

        public Cow getCow() {
            return cow;
        }

        public CowEntry getNextSibling() {
            return nextSibling;
        }

        public CowCollection getChildren() {
            return children;
        }
    }

    public Cow get(String cowId) {
        CowEntry parentCowEntry = firstCowEntry;
        Cow current = parentCowEntry.cow;

        if (cowId.equals(current.cowId())) {
            return current;
        }

        //search children
        while (parentCowEntry.getChildren() != null) {
            //
            CowCollection children = parentCowEntry.getChildren();
            CowEntry firstChildEntry = children.getFirstCowEntry();
            if (cowId.equals(firstChildEntry.getCow().cowId())) {
                return firstChildEntry.getCow()
            }
        }

        // got to next sibling


        return null;
        //search children
//        return find(parentCowEntry.getChildren(), cowId);

    }

    private Cow find(CowCollection children, String cowId) {
        CowEntry firstChildEntry = children.getFirstCowEntry();
        Cow cow = firstChildEntry.getCow();
        if (cowId.equals(cow.cowId())) {
            return cow;
        }

        Cow current = find(firstChildEntry.getChildren(), cowId);
        if (current != null) {
            return current;
        }

        CowEntry nextSibling = firstChildEntry.getNextSibling();
        Cow nextSiblingCow = nextSibling.getCow();
        if (cowId.equals(nextSiblingCow.cowId())) {
            return nextSiblingCow;
        }

        Cow next = find()

        return null;
    }

    public void add(Cow cow) {
        //TODO
    }

    public void remove(Cow cow) {
        //TODO
    }

    public CowCollection(CowEntry firstCowEntry) {
        this.firstCowEntry = firstCowEntry;
    }

    public CowEntry getFirstCowEntry() {
        return firstCowEntry;
    }
}
