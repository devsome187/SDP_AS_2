package abstractfactory;

public class IceTerrain implements Terrain {
    @Override
    public void load() {
        System.out.println("Terrain: frozen lake surrounded by snow-covered mountains.");
    }
}
