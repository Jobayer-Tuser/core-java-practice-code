package designpattern.liskobsagregation;

public class Car implements EngineVehicle{
    @Override
    public boolean hasEngine(){
        return true;
    }

    @Override
    public int getNumberOfWheels(){
        return 4;
    }
}
