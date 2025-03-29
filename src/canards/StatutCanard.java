package canards;

public enum StatutCanard {
    HEUREUX(0), // Pas d'effet négatif
    BRULE(99), // Inflige des dégâts à chaque tour (99 = permanent jusqu'à guérison)
    GELE(2), // Ne peut pas attaquer pendant 2 tours
    ETOURDI(1), // A 50% de rater son attaque
    MOUILLE(1); // Réduction de 50% de la VA

    private int duree;

    StatutCanard(int duree) {
        this.duree = duree;
    }

    public int getDuree() {
        return duree;
    }

    public void reduireDuree() {
        if (this.duree > 0) {
            this.duree--;
        }
    }

    public boolean estExpire() {
        return this.duree == 0;
    }
}
