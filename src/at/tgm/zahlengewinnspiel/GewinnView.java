package at.tgm.zahlengewinnspiel;

import javax.swing.*;
import java.awt.*;

public class GewinnView extends JFrame {

    private JLabel lblRundenErgebnis;
    private JLabel lblGesamtPunkte;

    private JTextField txtSpielerZahl;
    private JTextField txtComputerZahl;

    private JButton btnNochmal;

    public GewinnView() {

        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 5, 5));

        add(new JLabel("Rundenergebnis:", SwingConstants.CENTER));
        add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));

        lblRundenErgebnis =
                new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);

        lblGesamtPunkte =
                new JLabel("Gesamtpunkte: 30", SwingConstants.CENTER);

        add(lblRundenErgebnis);
        add(lblGesamtPunkte);

        add(new JLabel("Deine Zahl:", SwingConstants.CENTER));
        add(new JLabel("Computer:", SwingConstants.CENTER));

        txtSpielerZahl = new JTextField();
        txtComputerZahl = new JTextField();

        txtComputerZahl.setEditable(false);

        add(txtSpielerZahl);
        add(txtComputerZahl);

        btnNochmal = new JButton("Noch einmal!");

        add(new JLabel(""));
        add(btnNochmal);

        setLocationRelativeTo(null);
        setVisible(true);
    }
}
