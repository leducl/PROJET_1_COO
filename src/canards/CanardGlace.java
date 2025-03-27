package canards;

public class CanardGlace extends Canard{


    public CanardGlace(String nom, double PV, double PA) {
        super(nom, TypeCanard.GLACE, PV, PA);
    }

    @Override
    public void activerCapaciteSpeciale() {

    }
}
