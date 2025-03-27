package canards;

public class CanardEau extends Canard{


    public CanardEau(String nom, double PV, double PA, double VA) {
        super(nom, TypeCanard.EAU, PV, PA, VA);
    }

    @Override
    public void activerCapaciteSpeciale(Canard autreCanard) {
        this.PV += 20;
    }
}
