package canards;

/**
 * Représente un canard de type Eau dans le jeu Canard Fighter Simulator.
 * Ce canard possède une capacité spéciale qui lui permet de se soigner
 * et applique l'effet "Mouillé" à ses adversaires.
 */
public class CanardEau extends Canard {

    /**
     * Constructeur de la classe CanardEau.
     *
     * @param nom Nom du canard.
     * @param PV  Points de vie initiaux.
     * @param PA  Points d'attaque.
     * @param VA  Vitesse d'attaque.
     */
    public CanardEau(String nom, double PV, double PA, double VA) {
        super(nom, TypeCanard.EAU, PV, PA, VA);
    }

    /**
     * Active la capacité spéciale du Canard Eau.
     * Cette capacité permet au canard de récupérer 20 points de vie.
     *
     * @param autreCanard Le canard adverse (non affecté par cette capacité).
     */
    @Override
    public void activerCapaciteSpeciale(Canard autreCanard) {
        this.PV += 20;
    }

    /**
     * Applique l'effet "Mouillé" à l'adversaire.
     * Cet effet peut potentiellement réduire la vitesse d'attaque de l'adversaire.
     *
     * @param autreCanard Le canard adverse qui subit l'effet.
     */
    @Override
    public void appliquerEffect(Canard autreCanard) {
        autreCanard.assignerStatut(StatutCanard.MOUILLE, 3);
        double newVA = autreCanard.getVitesseAttaque() / 2;
        autreCanard.SetVA(newVA);
    }
}
