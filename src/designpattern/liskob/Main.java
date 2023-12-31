package designpattern.liskobsagregation;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new MotorCycle());
        vehicleList.add(new Car());
        vehicleList.add(new ByCycle());

        for (Vehicle vehicle: vehicleList){
            System.out.println(vehicle.getNumberOfWheels());
        }

    }
}
