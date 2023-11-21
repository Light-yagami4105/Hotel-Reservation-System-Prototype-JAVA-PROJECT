import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HotelView {
    private HotelController controller;

    public HotelView(HotelController controller) {
        this.controller = controller;
    }

    public void startReservationProcess() {
        // Create a JFrame (window)
        JFrame frame = new JFrame("Hotel Reservation System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(null);

        // Create JTextField for guest name
        JTextField nameField = new JTextField();
        nameField.setBounds(150, 20, 200, 25);
        frame.add(nameField);

        // Create JTextField for payment method
        JTextField paymentField = new JTextField();
        paymentField.setBounds(150, 60, 200, 25);
        frame.add(paymentField);

        // Create JTextField for number of days
        JTextField daysField = new JTextField();
        daysField.setBounds(150, 100, 200, 25);
        frame.add(daysField);

        // Create JButton for making a reservation
        JButton reservationButton = new JButton("Make Reservation");
        reservationButton.setBounds(150, 140, 200, 25);
        frame.add(reservationButton);

        // Add ActionListener for the reservationButton
        reservationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input from JTextFields
                String guestName = nameField.getText();
                String paymentMethod = paymentField.getText();
                int numberOfDays = Integer.parseInt(daysField.getText());

                // Call the controller method
                controller.makeReservation(guestName, paymentMethod, numberOfDays);

                // Close the JFrame after making a reservation
                frame.dispose();
            }
        });

        // Make the JFrame visible
        frame.setVisible(true);
    }
}
