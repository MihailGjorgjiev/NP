package AV.AV4.Aliens;

import java.util.ArrayList;
import java.util.List;

public class AlienPack {
    private List<Alien> aliens;

    public AlienPack() {
        aliens = new ArrayList<>();
    }

    public void addAlien(Alien alien) {
        aliens.add(alien);
    }

    public List<Alien> getAliens() {
        return aliens;
    }

    public int calculateDamage() {
        int damage = 0;
        for(Alien alien:aliens){
            damage+=alien.getDamage();
        }
        return damage;
    }

    public static void main(String[] args) {
        AlienPack alienPack=new AlienPack();
        alienPack.addAlien(new SnakeAlien("Alan"));
        alienPack.addAlien(new MarshMallowMan("Bill"));
        alienPack.addAlien(new MarshMallowMan("Jerome"));
        alienPack.addAlien(new OgreAlien("Steven"));
        alienPack.addAlien(new SnakeAlien("Maria"));

        System.out.println("Alien Pack total damage: "+alienPack.calculateDamage());
    }
}
