package abstractfactory;

public class IceSoundtrack implements Soundtrack {
    @Override
    public void play() {
        System.out.println("Soundtrack: cold wind, ice cracks and slow ambient music.");
    }
}
