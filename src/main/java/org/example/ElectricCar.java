package org.example;

public class ElectricCar extends Car implements Rechargeable {

    private double batteryKWh;
    private double batteryCapacityKWh;
    private double consumptionKWhPer100Km;
    private int regenPercent;

    public ElectricCar(String brand, String model, int year, SensorSuite sensors, double batteryCapacityKWh,
                       double batteryKWh, double consumptionKWhPer100Km, int regenPercent) {
        super(brand, model, year, sensors);
        this.batteryCapacityKWh = batteryCapacityKWh;
        this.batteryKWh = batteryKWh;
        this.consumptionKWhPer100Km = consumptionKWhPer100Km;
        this.regenPercent = regenPercent;
    }

    @Override
    protected boolean hasEnoughEnergyFor(double km) {
        if (batteryKWh < (km / 100) * consumptionKWhPer100Km) {
            throw new InsufficientEnergyException(getBrand() + " " + getModel() + " has insufficient energy.");
        } else {
            return true;
        }
    }

    @Override
    protected void consumeFor(double km) {
        if (!hasEnoughEnergyFor(km)) {
            throw new InsufficientEnergyException(getBrand() + " " + getModel() + " has insufficient energy.");
        }
        batteryKWh -= (km / 100) * consumptionKWhPer100Km;
        System.out.println("Remaining battery: " + batteryKWh + "KWh.");
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
        if (khw < 0) {
            throw new IllegalOperationException("khw can't be negative.");
        }

        if (batteryKWh + khw > batteryCapacityKWh) {
            System.out.println("Battery is full.Excess energy is not added.");
        } else {
            batteryKWh += khw;
        }
        System.out.println("Current battery level is " + batteryKWh + " khw.");
    }

    @Override
    public void drive(double km) {
        if (!isRunning()) {
            System.out.println(getBrand() + " " + getModel() + " is not driving.");
        }
        hasEnoughEnergyFor(km);
        consumeFor(km);

        System.out.println(getBrand() + " " + getModel() + " is driving" + km + " km");
    }

    @Override
    public void enableAutopilot() {
        if (isRunning() && isAutopilotOn() && getSensors().allOk() && batteryKWh >= 0.15 * batteryCapacityKWh) {
            setAutopilotOn(true);
        } else {
            System.out.println("Autopilot is inaccessible.");
        }
    }

    @Override
    public void disableAutopilot() {
        if (isAutopilotOn()) {
            setAutopilotOn(false);
        } else {
            System.out.println("Autopilot has already disabled.");
        }
    }
}
