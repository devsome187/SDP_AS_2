package factorymethod;

public class FactoryMethodDemo {
    public static void main(String[] args) {
        EnemySpawner goblinSpawner = new GoblinSpawner();
        goblinSpawner.startEncounter();

        EnemySpawner skeletonSpawner = new SkeletonSpawner();
        skeletonSpawner.startEncounter();

        EnemySpawner slimeSpawner = new SlimeSpawner();
        slimeSpawner.startEncounter();
    }
}