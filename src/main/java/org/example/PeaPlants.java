package org.example;

abstract class PeaPlants extends Plants {

    public PeaPlants(int HP, double RechargeTime, int SunPrice) {
        super(HP, RechargeTime, SunPrice);
    }
    abstract void shooting();
}
