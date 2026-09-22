package abstractfactory;

public class ForestEnemy implements Enemy {
    @Override
    public void appear() {
        System.out.println("A Forest Goblin emerges from behind the trees.");
    }

    @Override
    public void attack() {
        System.out.println("Forest Goblin attacks with a wooden spear.");
    }
}
