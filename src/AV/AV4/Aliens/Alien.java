package AV.AV4.Aliens;

public abstract class Alien {

    private int health;
    private String name;

    public Alien(String name) {
        this.name = name;
        this.health = 100;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract int getDamage();


}
