package abstractfactory;

public class WorldGame {
    private final Enemy enemy;
    private final Terrain terrain;
    private final Soundtrack soundtrack;

    public WorldGame(WorldFactory factory) {
        this.enemy = factory.createEnemy();
        this.terrain = factory.createTerrain();
        this.soundtrack = factory.createSoundtrack();
    }

    public void startWorld() {
        System.out.println("=== Loading game world ===");
        terrain.load();
        soundtrack.play();
        enemy.appear();
        enemy.attack();
        System.out.println("=== World is ready ===");
    }
}
