package canards;

public abstract class Canard {
    private String nom;
    private TypeCanard typeCanard;
    private int PV;
    private int PA;

    public TypeCanard getType() {
        return typeCanard;
    }

    public int getPointsDeVie() {
        return PV;
    }

    public int getPointsAttaque() {
        return PA;
    }

    public String getNom(){
        return nom;
    }



    public void attaquer(Canard autreCanard){

    }
    public void subirDegats(int degats){
        PV -= degats;
    }

    public boolean estKO(){
        return PV <= 0;
    }


    public abstract void activerCapaciteSpeciale();
}
