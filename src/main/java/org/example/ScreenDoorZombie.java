package org.example;

public class ScreenDoorZombie extends Zombies{
    public ScreenDoorZombie(double Speed) {
        super(10, Speed);
    }

    @Override
    void move() {
    }

    @Override
    boolean isDead() {
        return HP<=0;
    }
}
