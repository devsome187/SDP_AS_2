package factorymethod;

public class Skeleton implements Enemy {
    @Override
    public String getName() {
        return "Skeleton";
    }

    @Override
    public void attack() {
        System.out.println("Skeleton fires an arrow from a distance.");
    }
}
