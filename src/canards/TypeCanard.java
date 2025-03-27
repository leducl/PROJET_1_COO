package canards;

public enum TypeCanard {
    EAU, FEU, GLACE, VENT, COUNT;

    public static double getMultiplicateur(TypeCanard attaquant, TypeCanard cible) {
        if (attaquant == cible) {
            return 1.0; // Même type = dégâts normaux
        }

        switch (attaquant) { //Série de comparaisons des différents types
            case EAU:
                return (cible == FEU) ? 2.0 : (cible == VENT ? 0.5 : 1.0);
            case FEU:
                return (cible == GLACE) ? 2.0 : (cible == EAU ? 0.5 : 1.0);
            case GLACE:
                return (cible == VENT) ? 2.0 : (cible == FEU ? 0.5 : 1.0);
            case VENT:
                return (cible == EAU) ? 2.0 : (cible == GLACE ? 0.5 : 1.0);
            default:
                return 1.0;
        }
    }
}
