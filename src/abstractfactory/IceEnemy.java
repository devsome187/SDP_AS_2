package abstractfactory;

public class IceEnemy implements Enemy {
    @Override
    public void appear() {
        System.out.println("An Ice Golem rises from the frozen ground.");
    }

    @Override
    public void attack() {
        System.out.println("Ice Golem throws a freezing crystal.");
    }
}
