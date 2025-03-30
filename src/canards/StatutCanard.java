/**
 * Enumération représentant les différents statuts qu'un canard peut avoir.
 * Chaque statut a une durée définie et peut affecter les capacités du canard.
 */
package canards;

public enum StatutCanard {
    /**
     * Canard heureux, sans effet négatif.
     */
    HEUREUX(0),

    /**
     * Canard brûlé : subit des dégâts à chaque tour (99 = permanent jusqu'à guérison).
     */
    BRULE(99),

    /**
     * Canard gelé : ne peut pas attaquer pendant 2 tours.
     */
    GELE(2),

    /**
     * Canard étourdi : a 50% de chance de rater son attaque.
     */
    ETOURDI(1),

    /**
     * Canard mouillé : réduction de 50% de sa vitesse d'attaque (VA) pendant 1 tour.
     */
    MOUILLE(1);

    private int duree;

    /**
     * Constructeur du statut du canard.
     * @param duree Nombre de tours pendant lesquels le statut est actif.
     */
    StatutCanard(int duree) {
        this.duree = duree;
    }
}
