# SAE - Attractivité des Communes Bretonnes

![Logo](https://www.iutvannes.fr/wp-content/uploads/2020/11/IUT_VANNES_LOGO-sansfondblanc-e1669819263791.png)

## Authors

- @IsmaëlGuillouet
- @NathanLefèvre
- [@BaptisteHba](https://github.com/BaptisteHba)
- @MartinHuetChapuis
- [@AlexandreLacour](https://github.com/AidenRoman04)

## Objectif

Ce projet a pour objectif le développement d'une application permettant d'analyser et de visualiser l'attractivité des communes bretonnes. L'application utilise JavaFX avec FXML et Scene Builder pour l'interface graphique, Python pour la génération de graphes, ainsi que Java et la programmation orientée objet (POO) pour la gestion des données via des DAO (Data Access Objects).

## Description du Projet

L'application offre une interface utilisateur intuitive pour explorer divers indicateurs de l'attractivité des communes bretonnes. Elle intègre plusieurs technologies et méthodologies pour atteindre cet objectif :

### JavaFX et FXML

L'interface graphique de l'application est développée avec JavaFX et FXML. JavaFX est une bibliothèque pour créer des applications graphiques en Java. FXML est un langage basé sur XML utilisé pour définir l'interface utilisateur de manière déclarative(samblable à html). Scene Builder est utilisé pour faciliter la création des fichiers FXML grâce à une interface de conception visuelle.

### Python pour les Graphiques

Pour la visualisation des données, nous avons intégré des graphes générés avec Python. Ces graphiques offrent des repésentations visuels sur l'attractivité des communes, rendant les données plus compréhensibles pour l'utilisateur.

### Modèle-Vue-Contrôleur (MVC)

Le projet suit le modèle architectural MVC (Modèle-Vue-Contrôleur) :

- **Modèle** : Représente les données de l'application et la logique métier. Il est implémenté en Java avec des classes qui définissent les structures de données et les opérations associées.
- **Vue** : La partie de l'application qui gère l'affichage des données. Elle est construite avec JavaFX et FXML, offrant une interface utilisateur interactive et réactive.
- **Contrôleur** : Gère les interactions entre la vue et le modèle. Il capture les événements de l'utilisateur (comme les clics de souris ou les entrées clavier) et met à jour le modèle et/ou la vue en conséquence.

### Java et POO

Le cœur de l'application est développé en Java, en utilisant les principes de la programmation orientée objet (POO). Cela permet une structure de code modulaire et maintenable. Les DAO (Data Access Objects) sont utilisés pour interagir avec la base de données, assurant une séparation claire entre la logique de l'application et l'accès aux données.

### Base de Données

L'application nécessite une base de données contenant les données sur l'attractivité des communes bretonnes. Assurez-vous d'avoir une base de données prête avec les tables nécessaires avant de lancer l'application.

## Prérequis

Pour exécuter ce projet, vous aurez besoin des éléments suivants :

- Java Development Kit (JDK) 8 ou supérieur
- JavaFX SDK
- Scene Builder
- Python 3 avec les bibliothèques Matplotlib
- Une base de données avec les données sur l'attractivité des communes bretonnes

## Installation

1. Clonez le dépôt du projet :
   ```bash
   git clone https://github.com/AidenRoman04/Commune-Bretonne.git
   ```
2. Importez le projet dans votre IDE préféré (par exemple, IntelliJ IDEA, Eclipse).
3. Configurez le projet pour utiliser le JDK et JavaFX.
4. Assurez-vous que votre base de données est configurée et accessible.
5. Exécutez le projet. Cf. [Utilisation](#Utilisation)

## Utilisation

Lancez l'application depuis votre IDE ou en utilisant les ligne de commande depuis le fichier ws Situé dans le dossier IHM.

Compilation :

    javac --module-path "..\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -d ..\class ..\src\view\*.java ..\src\model\dao\*.java ..\src\model\data\*.java ..\src\model\*.java ..\src\controller\*.java

    xcopy /s /e /y "..\src\ressource" "..\class\ressource"

    xcopy /s /e /y "..\javafx-sdk-22.0.1" "..\class\javafx-sdk-22.0.1"

    xcopy /s /e /y "..\mysql-connector-j-8.4.0" "..\class\mysql-connector-j-8.4.0"

Execution :

    java --module-path "..\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp "..\class" view.MainApp

Enfin, vous pouvez naviguez à travers l'interface pour explorer les différentes fonctionnalités et visualisations offertes.

## Arborescence Principale

#### Commune Bretonne :

    📁 /Dev Orienté Obj
    📁 /IHM
    📁 /Partie SQL
    📄 README.md

#### IHM :

    📁 /class
    📁 /javadoc
    📁 /javafx-sdk-22.0.1
    📁 /mysql-connector-j-8.4.0
    📁 /ws
    📁 /src
        - 📁 controller
        - 📁 model
        - 📁 ressource
        - 📁 view

## Contributions

Les contributions sont les bienvenues ! Veuillez soumettre des demandes de tirage (pull requests) et signaler les problèmes (issues) via le dépôt Git.

---

Merci d'utiliser notre application pour explorer l'attractivité des communes bretonnes !

## Screenshots

![App Screenshot](https://via.placeholder.com/468x300?text=App+Screenshot+Here)
