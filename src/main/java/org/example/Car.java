package org.example;

public abstract class Car implements Drivable, AutopilotCapable{
    private String brand;
    private String model;
    private int year;
    private SensorSuite sensors;
    private double odometerKm;
    private boolean isRunning;
    private boolean autopilotOn;

    public Car(String brand, String model, int year, SensorSuite sensors) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.sensors= sensors;
    }

    public boolean isAutopilotOn() {
        return autopilotOn;
    }

    public void setAutopilotOn(boolean autopilotOn) {
        this.autopilotOn = autopilotOn;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean running) {
        isRunning = running;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getOdometerKm() {
        return odometerKm;
    }

    public void setOdometerKm(double odometerKm) {
        this.odometerKm = odometerKm;
    }

    public SensorSuite getSensors() {
        return sensors;
    }

    public void setSensors(SensorSuite sensors) {
        this.sensors = sensors;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {
    }

    protected abstract boolean hasEnoughEnergyFor(double km);
    protected abstract void consumeFor(double km);

    @Override
    public String toString() {
        return "Car{" +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", odometerKm=" + odometerKm +
                '}';
    }
}
