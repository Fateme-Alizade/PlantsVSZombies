package org.example;

abstract class BombPlants extends Plants {
    public BombPlants(int HP, double RechargeTime, int SunPrice) {
        super(HP, RechargeTime, SunPrice);
    }
    abstract void explosion();
}
