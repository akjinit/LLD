package ParkingLotSystem;

public class CarParkingSpot extends ParkingSpot {
    public CarParkingSpot(int spotNumber) {
        super(VehicleType.CAR, spotNumber);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return VehicleType.CAR == (vehicle.getVehicleType());
    }
}


