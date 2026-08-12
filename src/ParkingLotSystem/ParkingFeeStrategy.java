package ParkingLotSystem;

public interface ParkingFeeStrategy {
//    @param vehicleType Type of vehicle being parked
//	  @param duration of parking (in hours)
    double calculateFare(VehicleType vehicleType,int duration);
}
