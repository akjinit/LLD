package ParkingLotSystem;

public class Truck extends Vehicle{
    public Truck(ParkingFeeStrategy parkingFeeStrategy, String licensePlate) {
        super(parkingFeeStrategy, VehicleType.TRUCK, licensePlate);
    }
}
