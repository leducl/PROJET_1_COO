package canards;

public abstract class Canard {
    private final String nom;
    private final TypeCanard typeCanard;
    protected double PV; // Point de vie
    protected double PA; // Dégâts
    protected double VA; //Vitesse d'attaque
    private int action; // 0 : attaque, 1 : capacité spéciale, 2 : capacité spéciale utilisée
    protected StatutCanard statut;
    private int statutDuree = 0; // Nombre de tours restants pour le statut actuel

    //Constantes
    final double CHANCE_CRITIQUE = 0.10;
    final double CHANCE_APPLIQUER_EFFET = 0.9;

    public Canard(String nom, TypeCanard typeCanard, double PV, double PA, double VA) {
        this.nom = nom;
        this.typeCanard = typeCanard;
        this.PV = PV;
        this.PA = PA;
        this.VA = VA;
        this.statut = StatutCanard.HEUREUX;
    }
    //GETTERS, SETTERS
    public TypeCanard getType() {return typeCanard;}
    public double getPointsDeVie() {return PV;}
    public double getPointsAttaque() {return PA;}
    public double getVitesseAttaque() {return VA;}
    public String getNom() {return nom;}
    public int getAction() {return action;}
    public StatutCanard getStatut() {return statut;}
    public void SetAction(int action) {this.action = action;}
    public void SetStatut(StatutCanard statut) {this.statut = statut;}
    public void SetVA(double VA) {this.VA = VA;}

    public void attaquer(Canard autreCanard){
        final boolean coupCritique = Math.random() < CHANCE_CRITIQUE;

        double multiplicateur = TypeCanard.getMultiplicateur(this.typeCanard, autreCanard.getType());
        double degats = PA * multiplicateur * (coupCritique ? 2 : 1);
        autreCanard.subirDegats(degats);

        if (coupCritique){
            System.out.println("Ouch, Coût critique !");
        }

        //% de chance d'appliquer un effet en fonction du type.
        if (Math.random() < CHANCE_APPLIQUER_EFFET) {
            if (autreCanard.getStatut() == StatutCanard.HEUREUX) {
                appliquerEffect(autreCanard);
            }
        }
    }

    public void subirDegats(double degats){
        PV -= degats;
    }

    public boolean estKO(){
        return PV <= 0;
    }

    public void resetValues(){
        PV = 100;
        action = 0;
        statut = StatutCanard.HEUREUX;
    }

    public void decrementerStatut() {
        if (statut != StatutCanard.HEUREUX) {
            statutDuree--;
            if (statutDuree <= 0) {
                if (statut == StatutCanard.MOUILLE) {
                    VA *= 2;
                }
                statut = StatutCanard.HEUREUX; // Retour à l'état normal

            }
        }
    }

    protected abstract void appliquerEffect(Canard autreCanard);

    public abstract void activerCapaciteSpeciale(Canard autreCanard);
}
