package canards;

public class CanardFeu extends Canard{

    public CanardFeu(String nom, double PV, double PA) {
        super(nom, TypeCanard.FEU, PV, PA);
    }

    @Override
    public void activerCapaciteSpeciale() {
        this.PA *= 2;
    }
}
