package factorymethod;

public class GoblinSpawner extends EnemySpawner {
    @Override
    protected Enemy createEnemy() {
        return new Goblin();
    }
}
