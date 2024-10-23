package AV.AV4.Aliens;

public class OgreAlien extends Alien{
    public OgreAlien(String name) {
        super(name);
    }

    @Override
    public int getDamage() {
        return 6;
    }
}
