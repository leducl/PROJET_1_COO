/**
 * Classe abstraite représentant un canard dans le jeu.
 * Un canard possède des points de vie, des dégâts, une vitesse d'attaque, un type et un statut.
 */
package canards;

public abstract class Canard {
    private final String nom;
    private final TypeCanard typeCanard;
    protected double PV; // Points de vie
    protected double PA; // Points d'attaque
    protected double VA; // Vitesse d'attaque
    private int action; // 0 : attaque, 1 : capacité spéciale, 2 : capacité spéciale utilisée
    protected StatutCanard statut;
    private int statutDuree = 0; // Nombre de tours restants pour le statut actuel

    // Constantes
    final double CHANCE_CRITIQUE = 0.10;
    final double CHANCE_APPLIQUER_EFFET = 0.05;

    /**
     * Constructeur de la classe Canard.
     * @param nom Nom du canard
     * @param typeCanard Type du canard
     * @param PV Points de vie du canard
     * @param PA Points d'attaque du canard
     * @param VA Vitesse d'attaque du canard
     */
    public Canard(String nom, TypeCanard typeCanard, double PV, double PA, double VA) {
        this.nom = nom;
        this.typeCanard = typeCanard;
        this.PV = PV;
        this.PA = PA;
        this.VA = VA;
        this.statut = StatutCanard.HEUREUX;
    }

    // GETTERS

    /**
     * @return Le type du canard
     */
    public TypeCanard getType() { return typeCanard; }

    /**
     * @return Les points de vie du canard
     */
    public double getPointsDeVie() { return PV; }

    /**
     * @return Les points d'attaque du canard
     */
    public double getPointsAttaque() { return PA; }

    /**
     * @return La vitesse d'attaque du canard
     */
    public double getVitesseAttaque() { return VA; }

    /**
     * @return Le nom du canard
     */
    public String getNom() { return nom; }

    /**
     * @return L'action en cours du canard
     */
    public int getAction() { return action; }

    /**
     * @return Le statut actuel du canard
     */
    public StatutCanard getStatut() { return statut; }

    // SETTERS

    /**
     * Définit l'action du canard.
     * @param action Nouvelle action du canard
     */
    public void SetAction(int action) { this.action = action; }

    /**
     * Définit le statut du canard.
     * @param statut Nouveau statut du canard
     */
    public void SetStatut(StatutCanard statut) { this.statut = statut; }

    /**
     * Définit la vitesse d'attaque du canard.
     * @param VA Nouvelle vitesse d'attaque
     */
    public void SetVA(double VA) { this.VA = VA; }

    /**
     * Le canard attaque un autre canard.
     * @param autreCanard Le canard ciblé par l'attaque
     */
    public void attaquer(Canard autreCanard){
        final boolean coupCritique = Math.random() < CHANCE_CRITIQUE;
        double multiplicateur = TypeCanard.getMultiplicateur(this.typeCanard, autreCanard.getType());
        double degats = PA * multiplicateur * (coupCritique ? 2 : 1);
        autreCanard.subirDegats(degats);

        if (coupCritique){
            System.out.println("Ouch, Coup critique !");
        }

        if (Math.random() < CHANCE_APPLIQUER_EFFET && autreCanard.getStatut() == StatutCanard.HEUREUX) {
            appliquerEffect(autreCanard);
        }
    }

    /**
     * Le canard subit des dégâts.
     * @param degats Montant des dégâts subis
     */
    public void subirDegats(double degats){
        PV -= degats;
    }

    /**
     * Vérifie si le canard est KO (n'a plus de PV).
     * @return true si le canard est KO, sinon false
     */
    public boolean estKO(){
        return PV <= 0;
    }

    /**
     * Réinitialise les valeurs du canard.
     */
    public void resetValues(){
        PV = 100;
        action = 0;
        statut = StatutCanard.HEUREUX;
    }

    /**
     * Décrémente la durée du statut du canard et restaure l'état normal si nécessaire.
     */
    public void decrementerStatut() {
        if (statut != StatutCanard.HEUREUX) {
            statutDuree--;
            if (statutDuree <= 0) {
                if (statut == StatutCanard.MOUILLE) {
                    VA *= 2;
                }
                statut = StatutCanard.HEUREUX;
            }
        }
    }

    /**
     * Applique un effet spécifique à un autre canard.
     * @param autreCanard Le canard cible de l'effet
     */
    protected abstract void appliquerEffect(Canard autreCanard);

    /**
     * Active la capacité spéciale du canard.
     * @param autreCanard Le canard cible de la capacité spéciale
     */
    public abstract void activerCapaciteSpeciale(Canard autreCanard);
}
