import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class HotelController {
    private List<Room> rooms;
    private List<Reservation> reservations;

    public HotelController() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        // Initialize rooms
        for (int i = 1; i <= 10; i++) {
            rooms.add(new Room(i));
        }
    }

    public Room getAvailableRoom() {
        for (Room room : rooms) {
            if (!room.isReserved()) {
                return room;
            }
        }
        return null; // No available room
    }

    public void makeReservation(String guestName, String paymentMethod, int numberOfDays) {
        Room availableRoom = getAvailableRoom();
        if (availableRoom != null) {
            Guest guest = new Guest(guestName, paymentMethod);
            Reservation reservation = new Reservation(guest, availableRoom, numberOfDays);
            availableRoom.setReserved(true);
            reservations.add(reservation);

            // Display success message using JOptionPane
            JOptionPane.showMessageDialog(null, "Reservation successful! Room number: " + availableRoom.getRoomNumber());

        } else {
            // Display error message using JOptionPane
            JOptionPane.showMessageDialog(null, "Sorry, no available rooms.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void cancelReservation(int roomNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoom().getRoomNumber() == roomNumber) {
                reservation.getRoom().setReserved(false);
                reservations.remove(reservation);

                // Display cancellation message using JOptionPane
                JOptionPane.showMessageDialog(null, "Reservation for room number " + roomNumber + " has been canceled.");
                return;
            }
        }

        // Display error message using JOptionPane
        JOptionPane.showMessageDialog(null, "No reservation found for room number " + roomNumber, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public void displayAvailableRooms() {
        StringBuilder availableRooms = new StringBuilder("Available Rooms:\n");
        for (Room room : rooms) {
            if (!room.isReserved()) {
                availableRooms.append("Room Number: ").append(room.getRoomNumber()).append("\n");
            }
        }

        // Display available rooms using JOptionPane
        JOptionPane.showMessageDialog(null, availableRooms.toString(), "Available Rooms", JOptionPane.INFORMATION_MESSAGE);
    }

    public void displayAllReservations() {
        StringBuilder allReservations = new StringBuilder("All Reservations:\n");
        for (Reservation reservation : reservations) {
            allReservations.append("Room Number: ").append(reservation.getRoom().getRoomNumber())
                    .append(", Guest: ").append(reservation.getGuest().getName())
                    .append(", Number of Days: ").append(reservation.getNumberOfDays())
                    .append(", Total Cost: ").append(reservation.getTotalCost())
                    .append(", Payment Method: ").append(reservation.getGuest().getPaymentMethod()).append("\n");
        }

        // Display all reservations using JOptionPane
        JOptionPane.showMessageDialog(null, allReservations.toString(), "All Reservations", JOptionPane.INFORMATION_MESSAGE);
    }
}
