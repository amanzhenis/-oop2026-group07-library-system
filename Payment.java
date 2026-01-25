package entity;

public class Payment {
    private int reservationId;
    private double amount;
    private String method;
    private String status;

    public Payment(int reservationId, double amount, String method, String status) {
        this.reservationId = reservationId;
        this.amount = amount;
        this.method = method;
        this.status = status;
    }

    public int getReservationId() { return reservationId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }
    public String getStatus() { return status; }
}
