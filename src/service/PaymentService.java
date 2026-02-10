package service;

import domain.Room;
import Exceptions.PaymentDeclinedException;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;

public class PaymentService {

    public double calculateTotal(Room room,
                                 LocalDate checkIn,
                                 LocalDate checkOut) {

        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);

        return nights * room.getPricePerNight();
    }

    // Payment simulation with exception
    public void processPayment(double amount) throws PaymentDeclinedException {

        Random random = new Random();

        // 30% chance payment fails
        if (random.nextInt(10) < 3) {
            throw new PaymentDeclinedException("Payment was declined by the bank!");
        }

        System.out.println("Payment successful! Amount paid: " + amount + " KZT");
    }
}
