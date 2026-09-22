package abstractfactory;

public class DesertSoundtrack implements Soundtrack {
    @Override
    public void play() {
        System.out.println("Soundtrack: dry wind, distant drums and desert ambience.");
    }
}
