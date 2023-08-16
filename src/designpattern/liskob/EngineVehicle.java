package designpattern.liskobsagregation;

public interface EngineVehicle extends Vehicle{
    default boolean hasEngine(){
        return false;
    }
}
