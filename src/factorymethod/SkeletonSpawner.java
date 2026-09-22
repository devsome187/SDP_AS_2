package factorymethod;

public class SkeletonSpawner extends EnemySpawner {
    @Override
    protected Enemy createEnemy() {
        return new Skeleton();
    }
}
