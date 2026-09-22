package factorymethod;

public abstract class EnemySpawner {
    protected abstract Enemy createEnemy();
    public void startEncounter() {
        Enemy enemy = createEnemy();
        System.out.println(enemy.getName() + " has appeared!");
        enemy.attack();
    }
}
