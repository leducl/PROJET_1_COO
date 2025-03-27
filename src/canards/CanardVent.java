package canards;

public class CanardVent extends Canard{


    public CanardVent(String nom, double PV, double PA, double VA) {
        super(nom, TypeCanard.VENT, PV, PA, VA);
    }

    @Override
    public void activerCapaciteSpeciale(Canard autreCanard) {

    }
}
