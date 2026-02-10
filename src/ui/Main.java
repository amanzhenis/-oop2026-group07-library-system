package ui;

import domain.*;
import Exceptions.*;
import persistence.RoomRepository;
import service.PaymentService;
import service.ReservationService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        RoomRepository roomRepo = new RoomRepository();
        ReservationService reservationService = new ReservationService();
        PaymentService paymentService = new PaymentService();

        Guest guest = new Guest(1, "Zhenis", "87001234567");

        while (true) {

            System.out.println("\n=== HOTEL BOOKING SYSTEM ===");
            System.out.println("1. View available rooms");
            System.out.println("2. Book a room");
            System.out.println("3. Calculate total price");
            System.out.println("0. Exit");

            System.out.print("Choose option: ");
            int choice = sc.nextInt();

            try {

                if (choice == 1) {
                    List<Room> rooms = roomRepo.getAvailableRooms();
                    for (Room r : rooms) {
                        System.out.println("Room ID: " + r.getId()
                                + " Type: " + r.getType()
                                + " Price: " + r.getPricePerNight());
                    }
                }

                else if (choice == 2) {

                    Room room = new StandardRoom(1, true);

                    reservationService.bookRoom(
                            guest,
                            room,
                            LocalDate.of(2026, 2, 10),
                            LocalDate.of(2026, 2, 12)
                    );
                }


                else if (choice == 3) {

                    Room room = new SuiteRoom(1, true);

                    double total = paymentService.calculateTotal(
                            room,
                            LocalDate.of(2026, 2, 10),
                            LocalDate.of(2026, 2, 12)
                    );

                    System.out.println("Total price = " + total + " KZT");
                }

                else if (choice == 0) {
                    break;
                }

            } catch (Exception e) {
                System.out.println("ERROR: " + e.getMessage());
            }
        }
    }
}
