package at.tgm.zahlengewinnspiel;

public class GewinnController {
    private final GewinnModel model;

    public GewinnController(GewinnModel model) {
        this.model = model;
    }

    public boolean spieleRunde(String eingabe) {
        try {
            int spielerZahl = Integer.parseInt(eingabe);

            if (spielerZahl < 1 || spielerZahl > 9) {
                return false;
            }

            model.berechneRunde(spielerZahl);
            return true;

        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int getGesamtPunkte() {
        return model.getGesamtPunkte();
    }

    public int getComputerZahl() {
        return model.getComputerZahl();
    }

    public int getRundenErgebnis() {
        return model.getRundenErgebnis();
    }

    public boolean hatGewonnen() {
        return model.hatGewonnen();
    }

    public boolean hatVerloren() {
        return model.hatVerloren();
    }
}
