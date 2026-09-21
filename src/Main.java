import at.tgm.zahlengewinnspiel.GewinnController;
import at.tgm.zahlengewinnspiel.GewinnModel;
import at.tgm.zahlengewinnspiel.GewinnView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            GewinnModel model = new GewinnModel();
            GewinnController controller = new GewinnController(model);

            new GewinnView(controller);
        });
    }
}