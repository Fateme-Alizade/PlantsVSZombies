package org.example;

public abstract class Zombies {
    protected int HP;
    protected double Speed;
    protected int row;
    protected int col;
    public Zombies(int HP, double Speed) {
        this.HP=HP;
        this.Speed=Speed;
    }
    abstract void move();
    abstract boolean isDead();
}
