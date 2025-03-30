Canard Fighter Simulator

Description du projet

Canard Fighter Simulator est un jeu de combat où des canards dotés de différents types (Eau, Feu, Glace, Vent, etc.) s'affrontent en utilisant des attaques et des capacités spéciales. Ce projet vise à illustrer les concepts de la programmation orientée objet (POO) tels que l'héritage, le polymorphisme et la modularité.

Diagramme UML des classes

(Insérez ici une image du diagramme UML généré)

Le modèle suit une approche orientée objet avec une classe de base Canard et des sous-classes représentant différents types de canards. L'interaction entre les types est gérée via un enum TypeCanard, et chaque canard possède des attaques et une capacité spéciale propre.

Choix techniques

Langage : Java

Modularité : Utilisation de classes et héritage pour séparer la logique métier.

Polymorphisme : Implémentation des attaques et capacités spéciales via des méthodes redéfinies dans les sous-classes.

Gestion des forces/faiblesses : L'enum TypeCanard définit les multiplicateurs d'attaque.

Interface utilisateur : Un menu en ligne de commande permet de créer des canards et de les faire combattre.

Tests unitaires : Vérification des interactions entre les types et du comportement des méthodes principales.
