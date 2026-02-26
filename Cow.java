package interview;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public record Cow(String cowId, String nickName, boolean alive, List<Cow> children) {
    public static Cow createNew(String cowId, String nickName) {
        return new Cow(cowId, nickName, true, new ArrayList<>());
    }

    public Cow endLife() {
        return new Cow(this.cowId, this.nickName, false, this.children);
    }

    public Cow withChild(Cow cow) {
        List<Cow> newChildren = new ArrayList<>(this.children);
        newChildren.add(cow);
        return new Cow(this.cowId, this.nickName, this.alive, newChildren);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Cow cow = (Cow) o;
        return alive == cow.alive && cowId.equals(cow.cowId) && nickName.equals(cow.nickName) && Objects.equals(children, cow.children);
    }

    @Override
    public int hashCode() {
        int result = cowId.hashCode();
        result = 31 * result + nickName.hashCode();
        result = 31 * result + Boolean.hashCode(alive);
        result = 31 * result + Objects.hashCode(children);
        return result;
    }

    @Override
    public String toString() {
        return "Cow{" +
                "cowId='" + cowId + '\'' +
                ", nickName='" + nickName + '\'' +
                ", alive=" + alive +
                ", children=" + children +
                '}';
    }
}