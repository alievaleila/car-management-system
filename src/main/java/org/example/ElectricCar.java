package org.example;

public class ElectricCar extends Car implements Rechargeable,Drivable,AutopilotCapable{

    private double batteryKWh;
    private double batteryCapacityKWh;
    private double consumptionKWhPer100Km;
    private int regenPercent;

    public ElectricCar(String brand, String model, int year, SensorSuite sensors) {
        super(brand, model, year, sensors);
    }

    @Override
    protected boolean hasEnoughEnergyFor(double km) {
        return false;
    }

    @Override
    protected void consumeFor(double km) {

    }

    public double getBatteryCapacityKWh() {
        return batteryCapacityKWh;
    }

    public void setBatteryCapacityKWh(double batteryCapacityKWh) {
        this.batteryCapacityKWh = batteryCapacityKWh;
    }

    public double getBatteryKWh() {
        return batteryKWh;
    }

    public void setBatteryKWh(double batteryKWh) {
        this.batteryKWh = batteryKWh;
    }

    public double getConsumptionKWhPer100Km() {
        return consumptionKWhPer100Km;
    }

    public void setConsumptionKWhPer100Km(double consumptionKWhPer100Km) {
        this.consumptionKWhPer100Km = consumptionKWhPer100Km;
    }

    public int getRegenPercent() {
        return regenPercent;
    }

    public void setRegenPercent(int regenPercent) {
        this.regenPercent = regenPercent;
    }

    @Override
    public void recharge(double khw) {

    }

    @Override
    public void drive(double km) {

    }

    @Override
    public void enableAutopilot() {

    }

    @Override
    public void disableAutopilot() {

    }
}
