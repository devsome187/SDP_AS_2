package factorymethod;

public class SlimeSpawner extends EnemySpawner {
    @Override
    protected Enemy createEnemy() {
        return new Slime();
    }
}
