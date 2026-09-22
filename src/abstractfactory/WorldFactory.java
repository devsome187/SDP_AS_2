package abstractfactory;

public interface WorldFactory {
    Enemy createEnemy();
    Terrain createTerrain();
    Soundtrack createSoundtrack();
}
