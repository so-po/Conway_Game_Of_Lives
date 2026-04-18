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

    public Strategy getStrategy(String type){
        switch (type){
            case "DEFAULT": return getDefaultStrategy();
            case "EXPLOSIVE": return getExplosiveStrategy();
            case "SCARCITY": return getScarcityStrategy();
            default: return getDeadStrategy();
        }
    }

}
