package AV.AV4.Aliens;

public class SnakeAlien extends Alien{
    public SnakeAlien(String name) {
        super(name);
    }

    @Override
    public int getDamage() {
        return 10;
    }
}
