package ParkingLotSystem;

import java.util.List;

public class ParkingLot {
    private List<ParkingSpot> parkingSpotList;

    public ParkingLot(List<ParkingSpot> parkingSpotList) {
        this.parkingSpotList = parkingSpotList;
    }

    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (!parkingSpot.isOccupied() && vehicle.getVehicleType() == parkingSpot.getSpotType()) {
                return parkingSpot;
            }
        }

        System.out.println(
                "No parking spots available for " + vehicle.getVehicleType() + "!");
        return null;
    }

    public ParkingSpot parkVehicle(Vehicle vehicle) {
        ParkingSpot parkingSpot = findAvailableSpot(vehicle);
        if (parkingSpot != null) {
            parkingSpot.parkVehicle(vehicle); // Mark the spot as occupied
            System.out.println(
                    "Vehicle parked successfully in spot: " + parkingSpot.getSpotNumber());
            return parkingSpot;
        }
        System.out.println(
                "No parking spots available for " + vehicle.getVehicleType() + "!");
        return null;
    }


    public void vacateSpot(ParkingSpot parkingSpot, Vehicle vehicle) {
        if (parkingSpot != null && parkingSpot.isOccupied()
                && parkingSpot.getVehicle().equals(vehicle)) {
            parkingSpot.vacate();
            System.out.println(vehicle.getVehicleType()
                    + " vacated the spot: " + parkingSpot.getSpotNumber());
        } else {
            System.out.println("Invalid operation! Either the spot is already vacant "
                    + "or the vehicle does not match.");
        }
    }

    public ParkingSpot getSpotByNumber(int spotNumber) {
        for (ParkingSpot parkingSpot : parkingSpotList) {
            if (parkingSpot.getSpotNumber() == spotNumber) {
                return parkingSpot;
            }
        }
        return null;
    }

    public List<ParkingSpot> getParkingSpotList() {
        return parkingSpotList;
    }
}
