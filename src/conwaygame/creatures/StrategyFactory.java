package conwaygame.creatures;


public class StrategyFactory {

    public Strategy getDeadStrategy() {
        return new DeadStrategy();
    }

    public Strategy getDefaultStrategy() {
        return new DefaultStrategy();
    }

    public Strategy getExplosiveStrategy() {
        return new ExplosiveStrategy();
    }

    public Strategy getScarcityStrategy() {
        return new ScarcityStrategy();
    }

    public Strategy getStrategy(CreatureType type){
        return switch (type) {
            case DEFAULT -> getDefaultStrategy();
            case EXPLOSIVE -> getExplosiveStrategy();
            case SCARCITY -> getScarcityStrategy();
            default -> getDeadStrategy();
        };
    }

}
