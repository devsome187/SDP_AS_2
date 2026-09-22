package abstractfactory;

public class AbstractFactoryDemo {
    public static void main(String[] args) {
        String selectedWorld = args.length > 0 ? args[0].toLowerCase() : "desert";
        WorldFactory factory = switch (selectedWorld) {
            case "forest" -> new ForestWorldFactory();
            case "ice" -> new IceWorldFactory();
            case "desert" -> new DesertWorldFactory();
            default -> throw new IllegalArgumentException(
                    "Unknown world: " + selectedWorld + ". Use forest, ice or desert."
            );
        };
        WorldGame game = new WorldGame(factory);
        game.startWorld();
    }
}
