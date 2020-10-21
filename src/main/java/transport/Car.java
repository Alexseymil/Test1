package transport;

public abstract class Car extends Transport {

    public abstract int numberOfSpeeds();

    public abstract String brand();

    public abstract CarBody carBody();

    public abstract EngineType engineType();

    @Override
    public Type type() {
        return Type.ROAD;
    }
}
