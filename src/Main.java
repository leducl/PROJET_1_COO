import canards.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Canard> canards = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static int index; //index gérant les erreurs de choix d'utilisateur

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nBienvenue dans Canard Fighter Simulator !");
            System.out.println("1. Créer un canard");
            System.out.println("2. Lancer une bataille");
            System.out.println("3. Quitter");
            System.out.print("Choisissez une option : ");

            int choix = scanner.nextInt();
            scanner.nextLine(); // Consommer le retour à la ligne

            switch (choix) {
                case 1:
                    creerCanard();
                    break;
                case 2:
                    lancerBataille();
                    break;
                case 3:
                    System.out.println("À bientôt !");
                    scanner.close();
                    return;
                default:
                    System.out.println("Option invalide, veuillez réessayer.");
            }
        }
    }

    private static void creerCanard() {
        System.out.print("Entrez le nom du canard : ");
        String nom = scanner.nextLine();

        index = -1;
        while (index < 1 || index > TypeCanard.COUNT.ordinal()) {

            System.out.println("Choisissez un type de canard :");
            for (TypeCanard type : TypeCanard.values()) {
                if (type == TypeCanard.COUNT) break;
                System.out.println(type.ordinal() + 1 + ". " + type);
            }

            index = scanner.nextInt();
            scanner.nextLine();

            if ((index < 1) || (index > TypeCanard.COUNT.ordinal())) {
                System.out.println("\nType invalide ! Réessayer !");
            }
        }
        TypeCanard type = TypeCanard.values()[index - 1];
        Canard canard = null;

        switch (type) {
            case EAU:
                canard = new CanardEau(nom, 100, 10);
                break;
            case FEU:
                canard = new CanardFeu(nom, 100, 10);
                break;
            case GLACE:
                canard = new CanardGlace(nom, 100, 10);
                break;
            case VENT:
                canard = new CanardVent(nom, 100, 10);
                break;
        }

        if (canard != null) {
            canards.add(canard);
            System.out.println("Canard créé : " + canard.getNom() + " de type " + canard.getType());
        }
    }

    private static void lancerBataille() {
        if (canards.size() < 2) {
            System.out.println("Il faut au moins 2 canards pour lancer une bataille !");
            return;
        }

        System.out.println("Choisissez les deux canards pour la bataille :");
        for (int i = 0; i < canards.size(); i++) {
            System.out.println((i + 1) + ". " + canards.get(i).getNom() + " (" + canards.get(i).getType() + ")");
        }

        System.out.print("Choix du premier canard : ");
        int index1 = scanner.nextInt() - 1;
        System.out.print("Choix du second canard : ");
        int index2 = scanner.nextInt() - 1;
        scanner.nextLine();

        if (index1 == index2 || index1 < 0 || index2 < 0 || index1 >= canards.size() || index2 >= canards.size()) {
            System.out.println("Sélection invalide ! Retour au lobby !");
            return;
        }

        Canard canard1 = canards.get(index1);
        Canard canard2 = canards.get(index2);

        System.out.println("\nDébut du combat entre " + canard1.getNom() + " et " + canard2.getNom() + " !");

        //Combat des canards
        while (!canard1.estKO() && !canard2.estKO()) {

            choixAttaque(canard1);
            choixAttaque(canard2);
        }

        System.out.println("Le combat est terminé !");
        if (canard1.estKO()) {
            System.out.println(canard2.getNom() + " a gagné !");
        } else {
            System.out.println(canard1.getNom() + " a gagné !");
        }
    }

    private static int choixAttaque(Canard canard) {
        int index = -1;
        while (index != 1 && index != 2) { // Tant que l'entrée n'est pas 1 ou 2 on redemande
            System.out.println("\n" + canard.getNom() + " choisi ton attaque :\n1. Attaque normale !\n2. Attaque spéciale !");
            index = scanner.nextInt();
            if (index != 1 && index != 2) System.out.println("\nErreur ! Seulement le choix 1 et 2 sont possible. Réessayer !");
        }
        return index;
    }
}