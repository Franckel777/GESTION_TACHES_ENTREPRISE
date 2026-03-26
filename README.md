#### GESTION DES PROJETS D'ENTREPRISE ########

## A PROPOS ℹ️
>**GESTION_TACHES_ENTREPRISE** est une application de gestion des tâches développée en **Java** utilisant **JDBC** pour la connexion à une base de données **MySQL**.           L'application a pour objectif de faciliter l’organisation et le suivi des tâches au sein d’une entreprise en permettant aux utilisateurs de créer, consulter, modifier et gérer différentes tâches selon leur statut.

>L’application repose sur une architecture simple séparant les différentes responsabilités du système (modèles, accès aux données et logique applicative).

>L’application permet notamment de :
>* consulter la liste des tâches
>* filtrer les tâches selon leur statut (par exemple : **À faire**, **En cours**, **Terminée**)
>* interagir avec une base de données pour stocker et récupérer les informations  
Ce projet constitue une base solide pour le développement futur d’un système de gestion des tâches plus complet intégrant par exemple une interface graphique ou une interface web.

    
## Pre-recquis
a. Un serveur locale   
b. Une IDE java   
c. Git Bash

## Comment ça marche ⚙️?

1. Ouvrez votre IDE java (*je vous recommende eclipse*). Allez dans l'onglet **fichier** ou **files** en anglais, puis cliquez sur **nouveau projet Java** ou **new Java project**.

2. Installez git bash. Puis allez dans votre dossier ou se trouve le projet, faites un clique droit et cliquez sur "Ouvrir git bash ici"  
➡️ https://git-scm.com/download/win

3. Copier le lien d'acces au repo sur l'icone "code". Executez la commande sur git bash "git clone " suivi du lien copié puis synchronisez le.

4. Installez et demmarez votre serveur locale (xampp, wampp, mariaDB,etc...). Si vous voulez installez xampp allez sur:  
➡️ https://www.apachefriends.org/download.html

5. Dans le dossier sql, importez le fichier gestion_projet.sql qui s'y trouve depuis votre systeme de gestion de base de donnees (pHpMyAdmin, MariaDB...).

6. Dans le dossier lib, copiez le pilote "mysqlconnector" qui s'y trouve. Puis dans votre librairie locale sur votre IDE, installez le pilote copié.

7. Si le pilote ne marche pas ou est endommagé, installez le sur:
➡️ https://dev.mysql.com/downloads/connector/j/ 

8. Dans le package co.kozao.app, ouvrez le menu "main.java" et executer le.

9. Vous pouvez desormais profiter de notre programme😁.

## LICENSE 📖
Ceci est un programme entierement gratuit mais si jamais vous pouvez l'ameliorer, ne vous prions de le faire et de le contribuer a notre repo github. Cordialement.

©Franckel_2026
