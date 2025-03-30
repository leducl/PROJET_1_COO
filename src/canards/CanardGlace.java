package canards;

/**
 * Représente un canard de type Glace.
 * Ce canard possède une capacité spéciale qui gèle l'adversaire, l'empêchant d'attaquer pendant un certain temps.
 */
public class CanardGlace extends Canard {

    /**
     * Crée un CanardGlace avec les statistiques spécifiées.
     *
     * @param nom Nom du canard
     * @param PV Points de vie du canard
     * @param PA Points d'attaque du canard
     * @param VA Vitesse d'attaque du canard
     */
    public CanardGlace(String nom, double PV, double PA, double VA) {
        super(nom, TypeCanard.GLACE, PV, PA, VA);
    }

    /**
     * Active la capacité spéciale du Canard Glace.
     * Cette capacité gèle l'adversaire, l'empêchant d'attaquer pendant un certain temps.
     *
     * @param autreCanard Le canard cible de la capacité spéciale
     */
    @Override
    public void activerCapaciteSpeciale(Canard autreCanard) {
        autreCanard.SetStatut(StatutCanard.GELE);
    }

    /**
     * Applique un effet spécial sur l'adversaire après une attaque.
     * Le canard cible est gelé, ce qui l'empêche d'attaquer pendant un certain temps.
     *
     * @param autreCanard Le canard qui subit l'effet de gel
     */
    @Override
    public void appliquerEffect(Canard autreCanard) {
        autreCanard.SetStatut(StatutCanard.GELE);
    }
}
