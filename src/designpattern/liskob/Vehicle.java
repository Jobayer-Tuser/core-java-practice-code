package designpattern.liskobsagregation;

public interface Vehicle {
    default int getNumberOfWheels(){
        return 2;
    }
}
