package abstractfactory;

public class ForestSoundtrack implements Soundtrack {
    @Override
    public void play() {
        System.out.println("Soundtrack: birds, wind and calm forest music.");
    }
}
