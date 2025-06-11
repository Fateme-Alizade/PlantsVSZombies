package org.example;

public abstract class Plants {
    protected static int HP;
    protected static double RechargeTime;
    protected static int SunPrice;

    public Plants(int HP, double RechargeTime, int SunPrice) {
        Plants.HP = HP;
        Plants.RechargeTime = RechargeTime;
        Plants.SunPrice = SunPrice;
    }
    public int getHP() {
        return HP;
    }
    public double getRechargeTime() {
        return RechargeTime;
    }
    public int getSunPrice() {
        return SunPrice;
    }
}
