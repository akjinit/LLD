package ParkingLotSystem;

public class TruckParkingSpot extends ParkingSpot {
    public TruckParkingSpot(int spotNumber) {
        super(VehicleType.TRUCK, spotNumber);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return VehicleType.TRUCK == (vehicle.getVehicleType());
    }
}
