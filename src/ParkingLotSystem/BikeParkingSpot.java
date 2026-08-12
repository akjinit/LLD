package ParkingLotSystem;

public class BikeParkingSpot extends ParkingSpot {
    public BikeParkingSpot(int spotNumber) {
        super(VehicleType.BIKE, spotNumber);
    }

    @Override
    public boolean canParkVehicle(Vehicle vehicle) {
        return VehicleType.BIKE == (vehicle.getVehicleType());
    }
}
