package abstractfactory;

public class DesertTerrain implements Terrain {
    @Override
    public void load() {
        System.out.println("Terrain: hot desert with dunes, rocks and an oasis.");

    }
}
