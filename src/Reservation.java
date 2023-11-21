import java.io.Serializable;

public class Reservation implements Serializable {
    private Guest guest;
    private Room room;
    private int numberOfDays;
    private double totalCost;

    public Reservation(Guest guest, Room room, int numberOfDays) {
        this.guest = guest;
        this.room = room;
        this.numberOfDays = numberOfDays;
        this.totalCost = numberOfDays * 2000;
    }

    public Guest getGuest() {
        return guest;
    }

    public Room getRoom() {
        return room;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public double getTotalCost() {
        return totalCost;
    }

    @Override
    public String toString() {
        return "Room Number: " + room.getRoomNumber() +
                ", " + guest +
                ", Number of Days: " + numberOfDays +
                ", Total Cost: " + totalCost;
    }
}
