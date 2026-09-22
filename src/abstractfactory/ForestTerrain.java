package abstractfactory;

public class ForestTerrain implements Terrain {
    @Override
    public void load() {
        System.out.println("Terrain: green forest with trees, moss and a river.");
    }
}
