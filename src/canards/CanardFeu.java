package canards;

/**
 * Représente un canard de type Feu.
 * Ce canard possède une capacité spéciale qui double sa puissance d'attaque pour une attaque.
 */
public class CanardFeu extends Canard {

    /**
     * Crée un CanardFeu avec les statistiques spécifiées.
     *
     * @param nom Nom du canard
     * @param PV Points de vie du canard
     * @param PA Points d'attaque du canard
     * @param VA Vitesse d'attaque du canard
     */
    public CanardFeu(String nom, double PV, double PA, double VA) {
        super(nom, TypeCanard.FEU, PV, PA, VA);
    }

    /**
     * Active la capacité spéciale du Canard Feu.
     * Cette capacité double temporairement sa puissance d'attaque pour une attaque.
     *
     * @param autreCanard Le canard cible de l'attaque spéciale
     */
    @Override
    public void activerCapaciteSpeciale(Canard autreCanard) {
        PA *= 2;
        attaquer(autreCanard);
        PA /= 2;
    }

    /**
     * Applique un effet spécial sur l'adversaire après une attaque.
     * Le canard cible est brûlé, ce qui lui inflige des dégâts supplémentaires à chaque tour.
     *
     * @param autreCanard Le canard qui subit l'effet de brûlure
     */
    @Override
    public void appliquerEffect(Canard autreCanard) {
        autreCanard.assignerStatut(StatutCanard.BRULE, 99);
    }
}
