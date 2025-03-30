/**
 * Enumération représentant les différents statuts qu'un canard peut avoir.
 * Chaque statut a une durée définie et peut affecter les capacités du canard.
 */
package canards;

public enum StatutCanard {
    /**
     * Canard heureux, sans effet négatif
     */
    HEUREUX,

    /**
     * Canard brûlé : subit des dégâts à chaque tour
     */
    BRULE,

    /**
     * Canard gelé : ne peut pas attaquer
     */
    GELE,

    /**
     * Canard étourdi : à 50% de chance de rater son attaque
     */
    ETOURDI,

    /**
     * Canard mouillé : réduction de 50% de sa vitesse d'attaque (VA)
     */
    MOUILLE;

}
