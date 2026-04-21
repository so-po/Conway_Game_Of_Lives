package conwaygame.creatures;


public class StrategyFactory {

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
            case EXPLOSIVE -> getExplosiveStrategy();
            case SCARCITY -> getScarcityStrategy();
            default -> getDefaultStrategy();
        };
    }

}
