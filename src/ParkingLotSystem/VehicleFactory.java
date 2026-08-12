package ParkingLotSystem;

public class VehicleFactory {
    public static Vehicle createVehicle(VehicleType vehicleType,String licencePlate,ParkingFeeStrategy parkingFeeStrategy){
        return switch (vehicleType){
            case CAR -> new Car(parkingFeeStrategy,licencePlate);
            case BIKE -> new Bike(parkingFeeStrategy,licencePlate);
            case TRUCK -> new Truck(parkingFeeStrategy,licencePlate);
        };
    }
}
