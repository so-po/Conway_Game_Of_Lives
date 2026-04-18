package conwaygame.creatures;

import java.awt.Color;

public class Creature {
    Strategy strategy;
    StrategyFactory strategyFactory = new StrategyFactory();

    public int isAliveStateBasedOnNeighbours(int numberOfNeighbours) {
        return this.strategy.isAliveStateBasedOnNeighbours(numberOfNeighbours);
    }

    public Creature(Strategy strategy) {
        this.strategy = strategy;
    }

    public Creature() {
        this.setStrategy(strategyFactory.getDeadStrategy());
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void kill() {
        this.strategy = strategyFactory.getDeadStrategy();
    }

    public boolean isDefault(){ return strategy.isDefault(); }
    public boolean isExplosive(){ return strategy.isExplosive(); }
    public boolean isScarcity(){ return strategy.isScarcity(); }
    public boolean isDead(){ return strategy.isDead(); }

    public Color getColor() { return strategy.getColor();}

}