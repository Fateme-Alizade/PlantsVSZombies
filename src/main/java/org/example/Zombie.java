package org.example;

public class Zombie extends Zombies {
    public Zombie(int Speed) {
        super(5, Speed);
    }

    @Override
    void move() {

    }

    @Override
    boolean isDead() {
        return HP <= 0;
    }

}
