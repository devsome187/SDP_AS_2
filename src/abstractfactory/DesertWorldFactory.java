package abstractfactory;

public class DesertWorldFactory implements WorldFactory {
    @Override
    public Enemy createEnemy() {
        return new DesertEnemy();

    }

    @Override
    public Terrain createTerrain() {
        return new DesertTerrain();

    }

    @Override
    public Soundtrack createSoundtrack() {
        return new DesertSoundtrack();
    }
}
