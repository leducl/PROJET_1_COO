package canards;

/**
 * Représente un canard de type Vent.
 * Ce canard possède une capacité spéciale qui double temporairement sa vitesse d'attaque.
 */
public class CanardVent extends Canard {

    /**
     * Crée un CanardVent avec les statistiques spécifiées.
     *
     * @param nom Nom du canard
     * @param PV Points de vie du canard
     * @param PA Points d'attaque du canard
     * @param VA Vitesse d'attaque du canard
     */
    public CanardVent(String nom, double PV, double PA, double VA) {
        super(nom, TypeCanard.VENT, PV, PA, VA);
    }

    /**
     * Active la capacité spéciale du Canard Vent.
     * Cette capacité double temporairement sa vitesse d'attaque.
     *
     * @param autreCanard Le canard cible de la capacité spéciale
     */
    @Override
    public void activerCapaciteSpeciale(Canard autreCanard) {
        this.VA *= 2;
    }

    /**
     * Applique un effet spécial sur l'adversaire après une attaque.
     * Le canard cible est étourdi, ce qui peut l'empêcher d'attaquer correctement.
     *
     * @param autreCanard Le canard qui subit l'effet d'étourdissement
     */
    @Override
    public void appliquerEffect(Canard autreCanard) {
        autreCanard.SetStatut(StatutCanard.ETOURDI);
    }
}
