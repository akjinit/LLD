package ParkingLotSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLotSystem {
    public static void main(String[] args) {
        List<ParkingSpot> parkingSpotList = new ArrayList<>();
        parkingSpotList.add(new BikeParkingSpot(1));
        parkingSpotList.add(new CarParkingSpot(2));
        parkingSpotList.add(new TruckParkingSpot(3));
        parkingSpotList.add(new BikeParkingSpot(4));

        ParkingLot parkingLot = new ParkingLot(parkingSpotList);

        ParkingFeeStrategy hourlyPaymentStrategy = new HourlyPaymentStrategy();
        ParkingFeeStrategy premiumPaymentStrategy = new PremiumPaymentStrategy();

        Vehicle car1 = new Car(hourlyPaymentStrategy, "JHOS");
        Vehicle car2 = new Car(hourlyPaymentStrategy, "JHDS");
        Vehicle bike1 = new Bike(hourlyPaymentStrategy, "JHJD");
        Vehicle bike2 = new Bike(hourlyPaymentStrategy, "JHJF");

        ParkingSpot carspot = parkingLot.parkVehicle(car1);
        ParkingSpot bikespot = parkingLot.parkVehicle(bike1);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select payment method for your vehicle:");
        System.out.println("1. Credit Card");
        System.out.println("2. Cash");
        int paymentMethod = scanner.nextInt();

        if (carspot != null) {
            double fee = car1.calculateFee(2);
            PaymentStrategy paymentStrategy = getPaymentStrategy(paymentMethod,fee);
            paymentStrategy.processPayment(fee);
        }if (bikespot != null) {
            double fee = bike1.calculateFee(2);
            PaymentStrategy paymentStrategy = getPaymentStrategy(paymentMethod,fee);
            paymentStrategy.processPayment(fee);
        }

        scanner.close();
    }


    private static PaymentStrategy getPaymentStrategy(int paymentMethod, double fee) {
        return switch (paymentMethod) {
            case 1 -> new CreditCardPayment(fee);
            case 2 -> new CashPayment(fee);
            default -> new CashPayment(fee);
        };
    }
}
