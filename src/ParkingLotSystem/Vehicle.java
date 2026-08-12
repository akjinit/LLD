package ParkingLotSystem;

public abstract class Vehicle {
    private String licensePlate;
    private VehicleType vehicleType;
    private ParkingFeeStrategy parkingFeeStrategy;

    public Vehicle(ParkingFeeStrategy parkingFeeStrategy, VehicleType vehicleType, String licensePlate) {
        this.parkingFeeStrategy = parkingFeeStrategy;
        this.vehicleType = vehicleType;
        this.licensePlate = licensePlate;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double calculateFee(int duration) {
        return parkingFeeStrategy.calculateFare(this.vehicleType, duration);
    }

    public ParkingFeeStrategy getParkingFeeStrategy() {
        return parkingFeeStrategy;
    }
}
