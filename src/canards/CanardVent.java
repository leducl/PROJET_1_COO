package canards;

public class CanardVent extends Canard{


    public CanardVent(String nom, double PV, double PA) {
        super(nom, TypeCanard.VENT, PV, PA);
    }

    @Override
    public void activerCapaciteSpeciale() {

    }
}
