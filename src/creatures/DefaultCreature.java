package creatures;

public class DefaultCreature extends AbstractCreature {

    public int getMinimumNeighbours() {
        return 2;
    }

    public int getMaxNeighbors() {
        return 3;
    }

    public int getResurrectionNeighbourCount() {
        return 3;
    }

}