package ParkingLotSystem;

public class HourlyPaymentStrategy implements ParkingFeeStrategy {
    @Override
    public double calculateFare(VehicleType vehicleType, int duration) {
        return switch (vehicleType) {
            case VehicleType.CAR -> duration * 10;
            case VehicleType.BIKE -> duration * 5;
            case VehicleType.TRUCK -> duration * 20;
            default -> 0;
        };
    }
}
