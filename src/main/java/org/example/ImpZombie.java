package org.example;

public class ImpZombie extends Zombies {
    public ImpZombie(double Speed) {
        super(3, Speed);
    }

    @Override
    void move() {

    }

    @Override
    boolean isDead() {
        return HP<=0;
    }
}
