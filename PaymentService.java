package service;

import entity.Payment;
import exception.PaymentDeclinedException;
import repository.PaymentRepository;

public class PaymentService {

    private final PaymentRepository paymentRepo = new PaymentRepository();

    public void processPayment(int reservationId, double amount, String method) {
        // minimal simulation: decline if amount <= 0
        if (amount <= 0) throw new PaymentDeclinedException();

        paymentRepo.save(new Payment(reservationId, amount, method, "PAID"));
    }
}
