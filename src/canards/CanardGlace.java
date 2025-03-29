package canards;

public class CanardGlace extends Canard{


    public CanardGlace(String nom, double PV, double PA, double VA) {
        super(nom, TypeCanard.GLACE, PV, PA, VA);
    }

    @Override
    public void activerCapaciteSpeciale(Canard autreCanard) {
        autreCanard.SetStatut(StatutCanard.GELE);
    }

    @Override
    public void appliquerEffect(Canard autreCanard) {
        autreCanard.SetStatut(StatutCanard.GELE);
    }
}
