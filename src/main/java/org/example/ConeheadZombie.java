package org.example;

public class ConeheadZombie extends Zombies {
    public ConeheadZombie(double Speed) {
        super(7, Speed);
    }

    @Override
    void move() {
    }

    @Override
    boolean isDead() {
        return HP<=0;
    }
}
