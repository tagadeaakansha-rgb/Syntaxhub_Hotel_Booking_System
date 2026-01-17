public class Room {

    int roomNumber;
    String roomType;
    double price;          // Extra feature
    boolean isBooked;
    String customerName;

    // Constructor
    public Room(int roomNumber, String roomType, double price) {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.price = price;
        this.isBooked = false;
        this.customerName = "";
    }
}
