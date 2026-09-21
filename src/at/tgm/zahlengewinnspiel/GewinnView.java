package at.tgm.zahlengewinnspiel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GewinnView extends JFrame {

    private final GewinnController controller;

    private JLabel lblRundenErgebnis;
    private JLabel lblGesamtPunkte;

    private JTextField txtSpielerZahl;
    private JTextField txtComputerZahl;

    private JButton btnNochmal;

    public GewinnView(GewinnController controller) {

        this.controller = controller;

        setTitle("Zahlen-Gewinnspiel (v1.0)");
        setSize(600, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel hauptPanel = new JPanel(new BorderLayout(5, 5));
        hauptPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // OBERER BEREICH
        JPanel oben = new JPanel(new GridLayout(3, 2, 5, 5));

        oben.add(new JLabel("Rundenergebnis:", SwingConstants.CENTER));
        oben.add(new JLabel("Gesamtpunkte:", SwingConstants.CENTER));

        lblRundenErgebnis =
                new JLabel("Tippe eine Zahl von 1 bis 9", SwingConstants.CENTER);

        lblGesamtPunkte =
                new JLabel("30", SwingConstants.CENTER);

        lblRundenErgebnis.setOpaque(true);
        lblRundenErgebnis.setBackground(Color.WHITE);

        lblGesamtPunkte.setOpaque(true);
        lblGesamtPunkte.setBackground(Color.WHITE);

        oben.add(lblRundenErgebnis);
        oben.add(lblGesamtPunkte);

        oben.add(new JLabel("Deine Zahl:", SwingConstants.CENTER));
        oben.add(new JLabel("Computer:", SwingConstants.CENTER));

        hauptPanel.add(oben, BorderLayout.NORTH);

        // EINGABEFELDER
        JPanel mitte = new JPanel(new GridLayout(1, 2, 10, 0));

        txtSpielerZahl = new JTextField();
        txtComputerZahl = new JTextField();

        txtSpielerZahl.setHorizontalAlignment(JTextField.CENTER);
        txtComputerZahl.setHorizontalAlignment(JTextField.CENTER);

        txtSpielerZahl.setFont(new Font("Arial", Font.BOLD, 28));
        txtComputerZahl.setFont(new Font("Arial", Font.BOLD, 28));

        txtComputerZahl.setEditable(false);

        mitte.add(txtSpielerZahl);
        mitte.add(txtComputerZahl);

        hauptPanel.add(mitte, BorderLayout.CENTER);

        // BUTTON
        JPanel unten = new JPanel(new FlowLayout(FlowLayout.CENTER));

        btnNochmal = new JButton("Noch einmal!");

        unten.add(btnNochmal);

        hauptPanel.add(unten, BorderLayout.SOUTH);

        add(hauptPanel);

        // ENTER drücken
        txtSpielerZahl.addActionListener(e -> spieleRunde());
        btnNochmal.addActionListener(e -> neueRunde());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void spieleRunde() {

        boolean gueltig =
                controller.spieleRunde(txtSpielerZahl.getText());

        if (!gueltig) {
            JOptionPane.showMessageDialog(
                    this,
                    "Bitte eine Zahl von 1 bis 9 eingeben."
            );
            return;
        }

        txtComputerZahl.setText(
                String.valueOf(controller.getComputerZahl())
        );

        int ergebnis = controller.getRundenErgebnis();

        if (controller.hatGewonnen()) {
            lblRundenErgebnis.setText("Gewonnen");
        } else if (controller.hatVerloren()) {
            lblRundenErgebnis.setText("Verloren");
        } else if (ergebnis > 0) {
            lblRundenErgebnis.setText("+" + ergebnis);
        } else {
            lblRundenErgebnis.setText(String.valueOf(ergebnis));
        }

        lblGesamtPunkte.setText(
                String.valueOf(controller.getGesamtPunkte())
        );
    }
    private void neueRunde() {
        txtSpielerZahl.setText("");
        txtComputerZahl.setText("");
        lblRundenErgebnis.setText("Tippe eine Zahl von 1 bis 9");

        txtSpielerZahl.requestFocus();
    }
}