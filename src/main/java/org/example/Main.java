package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        SensorSuite sensors=new SensorSuite(true,true,true,true,true);

        ArrayList<Car> cars=new ArrayList<>();
        cars.add(new ElectricCar("Tesla", "Model S", 2025,sensors,100,80,
                20,5));
        cars.add(new GasCar("Toyota", "Corolla", 2022, sensors, 50, 10,
                6.5));

        Car selectedCar=null;

        while(true){
            printMenu();

            int choice=sc.nextInt();
            sc.nextLine();
            switch (choice){
                case 0:
                    System.out.println("Exiting..");
                    return;
                case 1:




            }

        }

    }

    private static void printMenu() {
        System.out.println("-----Car Management System-----");
        System.out.println(" 1. Choose a car.");
        System.out.println(" 2. Start.");
        System.out.println(" 3. Stop.");
        System.out.println(" 4. Drive.");
        System.out.println(" 5. Refuel.");
        System.out.println(" 6. Recharge.");
        System.out.println(" 7. Enable autopilot.");
        System.out.println(" 8. Disable autopilot.");
        System.out.println(" 9. Change sensors.");
        System.out.println(" 0. Exit.");

        System.out.println("Enter your choice, (1-10)");
    }


}