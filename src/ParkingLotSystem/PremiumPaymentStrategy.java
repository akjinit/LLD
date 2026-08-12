package ParkingLotSystem;

public class PremiumPaymentStrategy implements ParkingFeeStrategy {
    @Override
    public double calculateFare(VehicleType vehicleType, int duration) {
        return switch (vehicleType) {
            case VehicleType.CAR -> duration * 15;
            case VehicleType.BIKE -> duration * 10;
            case VehicleType.TRUCK -> duration * 25;
            default -> 0;
        };
    }
}
