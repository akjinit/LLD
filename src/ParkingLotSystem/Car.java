package ParkingLotSystem;

public class Car extends Vehicle{
    public Car(ParkingFeeStrategy parkingFeeStrategy, String licensePlate) {
        super(parkingFeeStrategy, VehicleType.CAR, licensePlate);
    }
}
