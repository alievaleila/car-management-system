package org.example;

public class GasCar extends Car implements Refuelable, Drivable {

    private double fuelLiters;
    private double tankCapacityLiters;
    private double fuelConsumptionPer100Km;

    public GasCar(String brand, String model, int year, SensorSuite sensors, double fuelConsumptionPer100Km,
                  double fuelLiters, double tankCapacityLiters) {
        super(brand, model, year, sensors);
        this.fuelConsumptionPer100Km = fuelConsumptionPer100Km;
        this.fuelLiters = fuelLiters;
        this.tankCapacityLiters = tankCapacityLiters;
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
        if (hasEnoughEnergyFor(km)) {
            consumeFor(km);
            System.out.println(getBrand() + " " + getModel() + " is driving");
        } else {
            throw new InsufficientEnergyException("Fuel is insufficient.");
        }
    }

    @Override
    public void enableAutopilot() {
        if (isRunning() && getSensors().allOk() && fuelLiters >= 5) {
            setAutopilotOn(true);
            System.out.println(getBrand() + " " + getModel() + " has enabled autopilot.");
        } else {
            System.out.println("Autopilot is inaccessible.");
        }
    }

    @Override
    public void disableAutopilot() {
        if (isAutopilotOn()) {
            setAutopilotOn(false);
            System.out.println(getBrand() + " " + getModel() + " has disabled autopilot");
        } else {
            System.out.println("Autopilot is already disabled.");
        }
    }

    @Override
    public void start() {

        if (fuelLiters <= 0) {
            throw new InsufficientEnergyException("Fuel is insufficient.");
        }


        if (isRunning()) {
            System.out.println(getBrand() + " " + getModel() + " has already started.");
        }
        setRunning(true);
        System.out.println(getBrand() + " " + getModel() + " has started.");
    }


    @Override
    public void stop() {
        if (isRunning()) {
            setRunning(false);
            System.out.println(getBrand() + " " + getModel() + " has stopped.");
        } else {
            System.out.println(getBrand() + " " + getModel() + " has already stopped.");
        }
    }
}
