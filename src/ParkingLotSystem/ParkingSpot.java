package ParkingLotSystem;

public abstract class ParkingSpot {
    private VehicleType spotType;
    private boolean isOccupied;
    private Vehicle vehicle;
    private int spotNumber;

    public ParkingSpot(VehicleType spotType, int spotNumber) {
        this.spotType = spotType;
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }


    public boolean isOccupied() {
        return isOccupied;
    }

    // Abstract method to check if a vehicle can park in this spot
    public abstract boolean canParkVehicle(Vehicle vehicle);

    // Method to park a vehicle in the spot
    public void parkVehicle(Vehicle vehicle){
        if(isOccupied){
            System.out.println("Space occupied...");
            return;
        }

        if(!canParkVehicle(vehicle)){
            System.out.println("This spot is not suitable for this " + vehicle.getVehicleType());
            return;
        }

        this.vehicle = vehicle;
        this.isOccupied = true;
    }


    public void vacate() {
        // Check if the spot is already vacant
        if (!isOccupied) {
            System.out.println("Spot is already vacant.");
            return;
        }
        this.vehicle = null;
        this.isOccupied = false;
    }

    public VehicleType getSpotType() {
        return spotType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}


