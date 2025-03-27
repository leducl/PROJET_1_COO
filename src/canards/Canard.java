package canards;

public abstract class Canard {
    private String nom;
    private TypeCanard typeCanard;
    protected double PV;
    protected double PA;

    public Canard(String nom, TypeCanard typeCanard, double PV, double PA) {
        this.nom = nom;
        this.typeCanard = typeCanard;
        this.PV = PV;
        this.PA = PA;
    }

    public TypeCanard getType() {
        return typeCanard;
    }

    public double getPointsDeVie() {
        return PV;
    }

    public double getPointsAttaque() {
        return PA;
    }

    public String getNom() {
        return nom;
    }

    public void attaquer(Canard autreCanard){
        autreCanard.subirDegats(PA * TypeCanard.getMultiplicateur(this.typeCanard, autreCanard.getType()));
    }

    public void subirDegats(double degats){
        PV -= degats;
    }

    public boolean estKO(){
        return PV <= 0;
    }


    public abstract void activerCapaciteSpeciale();
}
