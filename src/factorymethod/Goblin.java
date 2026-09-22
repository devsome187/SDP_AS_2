package factorymethod;

public class Goblin implements Enemy {
    @Override
    public String getName() {
        return "Goblin";
    }

    @Override
    public void attack() {
        System.out.println("Goblin attacks quickly with a rusty dagger.");
    }
}
