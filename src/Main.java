import controller.GewinnController;
import model.GewinnModel;
import view.GewinnView;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {


            GewinnModel model = new GewinnModel();
            GewinnController controller = new GewinnController(model);

            new GewinnView(controller);
    }
}