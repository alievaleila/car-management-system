package org.example;

public class GasCar extends Car implements Refuelable, AutopilotCapable, Drivable {

    private double fuelLiters;
    private double tankCapacityLiters;
    private double fuelConsumptionPer100Km;

    public GasCar(String brand, String model, int year, SensorSuite sensors) {
        super(brand, model, year, sensors);
    }

    @Override
    protected boolean hasEnoughEnergyFor(double km) {
        return fuelLiters >= (km / 100) * fuelConsumptionPer100Km;
    }

    @Override
    protected void consumeFor(double km) {
        fuelLiters -= (km / 100) * fuelConsumptionPer100Km;
        System.out.println(fuelLiters);
    }

    public double getFuelConsumptionPer100Km() {
        return fuelConsumptionPer100Km;
    }

    public void setFuelConsumptionPer100Km(double fuelConsumptionPer100Km) {
        this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
    }

    public double getFuelLiters() {
        return fuelLiters;
    }

    public void setFuelLiters(double fuelLiters) {
        this.fuelLiters = fuelLiters;
    }

    public double getTankCapacityLiters() {
        return tankCapacityLiters;
    }

    public void setTankCapacityLiters(double tankCapacityLiters) {
        this.tankCapacityLiters = tankCapacityLiters;
    }

    @Override
    public void refuel(double liters) {
        if (liters < 0) {
            throw new IllegalOperationException("Invalid operation: liter can't be negative.");
        }

        if (fuelLiters + liters >= tankCapacityLiters) {
            fuelLiters = tankCapacityLiters;
            System.out.println("Tank is full.Excess fuel is not added.");
        } else {
            fuelLiters += liters;
        }
        System.out.println("Current fuel level: " + fuelLiters + " litres");
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

    @Override
    public void start() {
        if (isRunning()) {
            System.out.println(getBrand() + " " + getModel() + " has already started");
        }

        if (fuelLiters <= 0) {
            throw new InsufficientEnergyException("Fuel is insufficient");
        }

        setRunning(true);
        System.out.println(getBrand() + " " + getModel() + " has started.");
    }


    @Override
    public void stop() {

    }
}
