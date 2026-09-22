package factorymethod;

public class Slime implements Enemy {
    @Override
    public String getName() {
        return "Slime";
    }

    @Override
    public void attack() {
        System.out.println("Slime jumps forward and deals acid damage.");
    }
}
