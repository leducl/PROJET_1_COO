package canards;

public class CanardEau extends Canard{


    public CanardEau(String nom, double PV, double PA) {
        super(nom, TypeCanard.EAU, PV, PA);
    }

    @Override
    public void activerCapaciteSpeciale() {
        this.PV += 20;
    }
}
