import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                HotelController hotelController = new HotelController();
                HotelView hotelView = new HotelView(hotelController);

                JFrame frame = new JFrame("Hotel Reservation System");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(400, 300);
                frame.setLayout(null);

                JButton reservationButton = new JButton("Make a Reservation");
                reservationButton.setBounds(50, 50, 300, 30);
                frame.add(reservationButton);

                JButton cancelReservationButton = new JButton("Cancel a Reservation");
                cancelReservationButton.setBounds(50, 100, 300, 30);
                frame.add(cancelReservationButton);

                JButton displayRoomsButton = new JButton("Display Available Rooms");
                displayRoomsButton.setBounds(50, 150, 300, 30);
                frame.add(displayRoomsButton);

                JButton displayReservationsButton = new JButton("Display All Reservations");
                displayReservationsButton.setBounds(50, 200, 300, 30);
                frame.add(displayReservationsButton);

                reservationButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hotelView.startReservationProcess();
                    }
                });

                cancelReservationButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String roomNumberInput = JOptionPane.showInputDialog(frame, "Enter room number to cancel reservation:");
                        if (roomNumberInput != null && !roomNumberInput.isEmpty()) {
                            int roomNumber = Integer.parseInt(roomNumberInput);
                            hotelController.cancelReservation(roomNumber);
                        }
                    }
                });

                displayRoomsButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hotelController.displayAvailableRooms();
                    }
                });

                displayReservationsButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        hotelController.displayAllReservations();
                    }
                });

                frame.setVisible(true);
            }
        });
    }
}
