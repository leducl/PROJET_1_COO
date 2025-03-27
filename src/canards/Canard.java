package canards;

public abstract class Canard {
    private final String nom;
    private final TypeCanard typeCanard;
    protected double PV; // Point de vie
    protected double PA; // Dégâts
    protected double VA; //Vitesse d'attaque
    private int action; // 0 : attaque, 1 : capacité spéciale
    protected StatutCanard statut;

    public Canard(String nom, TypeCanard typeCanard, double PV, double PA, double VA) {
        this.nom = nom;
        this.typeCanard = typeCanard;
        this.PV = PV;
        this.PA = PA;
        this.VA = VA;
        this.statut = StatutCanard.HEUREUX;
    }
    //GETTERS
    public TypeCanard getType() {return typeCanard;}
    public double getPointsDeVie() {return PV;}
    public double getPointsAttaque() {return PA;}
    public double getVitesseAttaque() {return VA;}
    public String getNom() {return nom;}
    public int getAction() {return action;}
    public StatutCanard getStatut() {return statut;}
    public void SetAction(int action) {this.action = action;}
    public void SetStatut(StatutCanard statut) {this.statut = statut;}

    public void attaquer(Canard autreCanard){
        autreCanard.subirDegats(PA * TypeCanard.getMultiplicateur(this.typeCanard, autreCanard.getType()));
    }

    public void subirDegats(double degats){
        PV -= degats;
    }

    public boolean estKO(){
        return PV <= 0;
    }

    public abstract void activerCapaciteSpeciale(Canard autreCanard);
}
