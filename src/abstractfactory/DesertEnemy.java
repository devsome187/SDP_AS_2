package abstractfactory;

public class DesertEnemy implements Enemy {
    @Override
    public void appear() {
        System.out.println("A Desert Scorpion crawls out from under the sand.");

    }

    @Override
    public void attack() {
        System.out.println("Desert Scorpion attacks with its poisonous tail.");
    }
}
