import java.util.ArrayList;
import java.util.Scanner;

public class HotelBookingSystem {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Room> rooms = new ArrayList<>();

    public static void main(String[] args) {

        initializeRooms();
        int choice;

        do {
            System.out.println("\n===== HOTEL BOOKING MANAGEMENT SYSTEM =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Book a Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. View All Rooms");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1 -> viewAvailableRooms();
                case 2 -> bookRoom();
                case 3 -> cancelBooking();
                case 4 -> viewAllRooms();
                case 5 -> System.out.println("Thank you for using the system!");
                default -> System.out.println("Invalid choice! Please try again.");
            }

        } while (choice != 5);
    }

    // Initialize rooms with price
    static void initializeRooms() {
        rooms.add(new Room(101, "Single", 1500));
        rooms.add(new Room(102, "Double", 2500));
        rooms.add(new Room(103, "Deluxe", 4000));
        rooms.add(new Room(104, "Single", 1500));
    }

    // View only available rooms
    static void viewAvailableRooms() {
        boolean found = false;
        System.out.println("\nAvailable Rooms:");
        for (Room r : rooms) {
            if (!r.isBooked) {
                System.out.println("Room " + r.roomNumber +
                        " | Type: " + r.roomType +
                        " | Price: ₹" + r.price);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No rooms available!");
        }
    }

    // Book a room
    static void bookRoom() {
        System.out.print("Enter room number: ");
        int roomNo = sc.nextInt();
        sc.nextLine(); // clear buffer

        for (Room r : rooms) {
            if (r.roomNumber == roomNo) {
                if (!r.isBooked) {
                    System.out.print("Enter customer name: ");
                    r.customerName = sc.nextLine();
                    r.isBooked = true;
                    System.out.println("Room booked successfully!");
                    System.out.println("Total price: ₹" + r.price);
                } else {
                    System.out.println("Room already booked!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }

    // Cancel booking
    static void cancelBooking() {
        System.out.print("Enter room number to cancel booking: ");
        int roomNo = sc.nextInt();

        for (Room r : rooms) {
            if (r.roomNumber == roomNo) {
                if (r.isBooked) {
                    r.isBooked = false;
                    r.customerName = "";
                    System.out.println("Booking cancelled successfully!");
                } else {
                    System.out.println("Room is not booked!");
                }
                return;
            }
        }
        System.out.println("Room not found!");
    }

    // View all rooms
    static void viewAllRooms() {
        System.out.println("\nAll Rooms:");
        for (Room r : rooms) {
            System.out.println(
                    "Room " + r.roomNumber +
                            " | " + r.roomType +
                            " | ₹" + r.price +
                            " | " + (r.isBooked ? "Booked by " + r.customerName : "Available")
            );
        }
    }
}
