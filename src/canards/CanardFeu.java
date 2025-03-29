package canards;

public class CanardFeu extends Canard{

    public CanardFeu(String nom, double PV, double PA, double VA) {
        super(nom, TypeCanard.FEU, PV, PA, VA);
    }

    @Override
    public void activerCapaciteSpeciale(Canard autreCanard) {
        this.PA *= 2;
    }

    @Override
    public void appliquerEffect(Canard autreCanard) {
        autreCanard.SetStatut(StatutCanard.BRULE);
    }
}
