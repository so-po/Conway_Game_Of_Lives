package conwaygame.creatures;

import java.awt.Color;
import java.util.List;

public class Creature {
    Strategy strategy;
    StrategyFactory strategyFactory = new StrategyFactory();
    boolean alive = false;

    public void setStateBasedOnNeighbors(List<Creature> neighbors) {
        //Kill or resurrect the cell given its number of neighbours

        int aliveNeighborCount = countAliveCreatures(neighbors);
        if (isAlive() && (imTooLonely(aliveNeighborCount) || imOverCrowded(aliveNeighborCount))) {
            this.kill();
        } else if (iHaveEnoughNeighborsToRevive(aliveNeighborCount)) {
            //revive & choose what type to revive on
            CreatureType newStrategyType = this.strategy.chooseNewStrategy(neighbors);
            if (this.strategy.getType() != newStrategyType) {
                this.strategy = strategyFactory.getStrategy(newStrategyType);
            }
            makeAlive();
        }

    }

    private boolean iHaveEnoughNeighborsToRevive(int aliveNeighborCount) {
        return (aliveNeighborCount == this.strategy.getResurrectionNeighbourCount());
    }

    private boolean imTooLonely(int aliveNeighborCount) {
        return aliveNeighborCount < this.strategy.getMinimumNeighbours();
    }

    private boolean imOverCrowded(int aliveNeighborCount) {
        return aliveNeighborCount > this.strategy.getMaxNeighbours();
    }

    private int countAliveCreatures(List<Creature> creatures) {
        int aliveCreatureCount = 0;
        for (Creature creature : creatures) {
            if (creature.isAlive()) {
                aliveCreatureCount++;
            }
        }
        return aliveCreatureCount;
    }

    public Creature(Strategy strategy) {
        this.strategy = strategy;
    }

    public Creature() {
        this.strategy = strategyFactory.getDefaultStrategy();
    }

    public void makeAlive() {
        this.alive = true;
    }

    public void kill() {
        this.alive = false;
    }

    public void reviveWithStrategy(Strategy strategy) {
        this.makeAlive();
        this.strategy = strategy;
    }

    public boolean isDefault(){ return strategy.isDefault(); }
    public boolean isExplosive(){ return strategy.isExplosive(); }
    public boolean isScarcity(){ return strategy.isScarcity(); }
    public boolean isDead(){ return !this.alive; }
    public boolean isAlive() {return this.alive; }

    public Color getColor() {
        if (this.isAlive()) {
            return strategy.getAliveColor();
        } else {
            return strategy.getDeadColor();
        }
    }

    public CreatureType getType() { return strategy.getType();}

}