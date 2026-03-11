package creatures;

public class ScarcityCreature extends AbstractCreature {

    public int getMinimumNeighbours() {
        return 1;
    }

    public int getMaxNeighbors() {
        return 2;
    }

    public int getResurrectionNeighbourCount() {
        return 1;
    }

}