import canards.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Canard> canards = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        //Creation de 4 canards par défaut
        canards = new ArrayList<>(List.of(
                new CanardGlace("Glaçon", 95, 12, 1),
                new CanardFeu("Chaudière", 120, 15, 0.5),
                new CanardVent("Ventilo", 80, 10, 1.5),
                new CanardEau("Mouillé", 110, 12, 1)
        ));

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

        //index gérant les erreurs de choix d'utilisateur
        int index = -1;
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
        Canard canard = switch (type) {
            case EAU -> new CanardEau(nom, 100, 10, 2);
            case FEU -> new CanardFeu(nom, 100, 10, 2);
            case GLACE -> new CanardGlace(nom, 100, 10, 2);
            case VENT -> new CanardVent(nom, 100, 10, 2);
            default -> null;
        };

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
        int roundCounter = 0;
        //Combat des canards
        while (!canard1.estKO() && !canard2.estKO()) {
            roundCounter++;
            System.out.println("\nDébut du " + roundCounter + " rounds !\nRécapitulatif des PV");
            System.out.println(canard1.getNom() + " (" + canard1.getPointsDeVie() + "PV)");
            System.out.println(canard2.getNom() + " (" + canard2.getPointsDeVie() + "PV)");

            //Attente de 2s
            delay(2000);

            //Choix de l'action à faire pour les canards
            gererActionCanard(canard1);
            delay(1000);
            gererActionCanard(canard2);

            //Attente de 2s
            delay(2000);

            //Calcul du combats
            combat(canard1, canard2);

            //Attente de 2s
            delay(2000);
        }

        System.out.println("Le combat est terminé ! (" + roundCounter + " rounds)");
        if (canard1.estKO()) {
            System.out.println(canard2.getNom() + " a gagné !");
        } else {
            System.out.println(canard1.getNom() + " a gagné !");
        }
        //Reset des PV, Statut et Actions des canards
        canard1.resetValues();
        canard2.resetValues();

        //Attente de 2s
        delay(3000);
    }

    private static void gererActionCanard(Canard canard) {
        if (canard.getAction() == 0) {
            choixAction(canard);
        } else {
            System.out.println("\n" + canard.getNom() + " : capacité spéciale déjà activée dans le combat.\nAttaque normale sélectionnée !\n");
        }
    }

    private static void choixAction(Canard canard) {
        int index = -1;
        while (index != 1 && index != 2) { // Tant que l'entrée n'est pas 1 ou 2 on redemande
            System.out.println("\n" + canard.getNom() + " choisi ton attaque :\n1. Attaque normale !\n2. Capacité spéciale !");
            index = scanner.nextInt();
            if (index != 1 && index != 2) System.out.println("\nErreur ! Seulement le choix 1 et 2 sont possible. Réessayer !");
        }
        canard.SetAction(index - 1);
    }

    public static void combat(Canard canard1, Canard canard2) {
        Canard premierAttaquant, secondAttaquant;

        // Déterminer qui attaque en premier
        if (canard1.getVitesseAttaque() >= canard2.getVitesseAttaque()) {
            premierAttaquant = canard1;
            secondAttaquant = canard2;
        } else {
            premierAttaquant = canard2;
            secondAttaquant = canard1;
        }

        //Vérification des statuts
        if (verifierStatut(premierAttaquant)) {
            action(premierAttaquant, secondAttaquant);
        }

        //Attente de 2s
        delay(2000);

        // Vérifier si le deuxième canard peut attaquer
        if (!secondAttaquant.estKO()) {
            // Le deuxième canard joue
            //Vérification des statuts
            if (verifierStatut(secondAttaquant)) {
                action(secondAttaquant, premierAttaquant);
            }
        }
    }

    private static void action(Canard attaquant, Canard cible) {
        if (attaquant.getAction() == 1){
            System.out.println(attaquant.getNom() + " utilise sa capacité spéciale !");
            attaquant.activerCapaciteSpeciale(cible);
            afficherEtat(cible);
            attaquant.SetAction(2); //Permet de dire que la capacité spéciale a déja était utilisé
        } else {
            System.out.println(attaquant.getNom() + " attaque !");
            attaquant.attaquer(cible);
            afficherEtat(cible);
        }
    }

    // Méthode pour afficher l'état des PV du canard
    private static void afficherEtat(Canard canard) {
        System.out.println(canard.getNom() + " a " + canard.getPointsDeVie() + " PV.");
        if (canard.estKO()) {
            System.out.println(canard.getNom() + " est KO !");
        }
        if (canard.getStatut() != StatutCanard.HEUREUX) {
            System.out.println(canard.getNom() + " est " + canard.getStatut());
        }
        System.out.println(); // Ajoute une ligne vide pour la lisibilité
    }

    private static boolean verifierStatut(Canard canard) {
        switch (canard.getStatut()) {
            case BRULE:
                System.out.println(canard.getNom() + " est brûlé et subit 5 dégâts !");
                canard.subirDegats(5);
                break;

            case GELE:
                System.out.println(canard.getNom() + " est gelé, il ne peut pas attaquer !");
                canard.decrementerStatut();
                return false; // Il ne peut pas attaquer

            case ETOURDI:
                if (Math.random() < 0.5) {
                    System.out.println(canard.getNom() + " est étourdi et rate son attaque !");
                    canard.decrementerStatut();
                    return false;
                } else {
                    System.out.println(canard.getNom() + " est étourdi mais réussi son attaque !");
                }
                break;

            case MOUILLE:
                System.out.println(canard.getNom() + " est mouillé, sa vitesse d'attaque est toujours réduite !");
                canard.decrementerStatut();
                break;

            case HEUREUX:
            default:
                break;
        }
        return true; // Peut attaquer
    }


    private static void delay(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}