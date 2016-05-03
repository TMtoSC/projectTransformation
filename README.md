# projectTransformation

Afin de pouvoir utiliser notre projet, il vous faut dans un premier temps installer le projet YAKINDU Statechart Tools
disponible a cette adresse : https://github.com/Yakindu/statecharts#yakindu-statechart-tools

Pour ce faire suivez le tutoriel qui y est disponible.

Voici comment procéder avec l'outil installeur Oomph qui installera une nouvelle version d'éclipse directement
configurée pour Yakindu. Il est possible d'utiliser le projet Yakindu sans réinstaller une version d'eclipse, néanmoins
par soucis de facilité de travail nous n'avons pas tenté cette solution.

Setting up the development environment using Oomph (recommended)

    Download the Oomph Eclipse Installer for your platform and install it.
    Start Oomph by executing eclipse-installer/eclipse-inst.
    On the initial page, select Advanced Mode in the menu at the top right.
    On the Product page, select Eclipse IDE for Eclipse Committers in the Eclipse.org folder, then click Next.
    On the Projects page, select Github Projects.
    Click on the green "plus" symbol. Copy the Link https://raw.githubusercontent.com/Yakindu/statecharts/master/StatechartTools.setup in to the text field.
    Click on OK. The project Statechart Tools is available as Github Projects//Statechart Tools.
    Double-click on the project Statechart Tools to add it to the catalog section at the bottom of the wizard page.
    On the Variables page, choose a meaningful name for the Installation folder name variable, then click Next.
    On the Confirmation page, check the settings, then click on Finish.
    The setup is executing its tasks now. Meanwhile: Drink a cup of coffee, and watch your Statechart Tools development environment being assembled.
    After the installation has been completed, Eclipse starts up with the YAKINDU Statechart Tools projects in your workspace.
    (Optional) Click on Finish in the Oomph window to close it.
    (Optional) While installing, clicking on the double-arrow (double arrow) allows you to see the further progression. Click on Finish to close the window when the installer is done.
    After having built the workspace, you will see a lot of errors in it. That's because the language artifacts haven't been generated yet. Oomph made a contribution to the toolbar. Click on the double-arrow symbol. The Confirmation window appears. Deselect everything except for the three "Launch …" tasks. (The other tasks have already been executed.) The selected tasks will generate the languages "Expressions", "SText", and "SGen".
    Click on Finish.
    Click Proceed three times in order to confirm the execution of each launch despite any existing errors.


Une fois ceci fait il vous faut importer notre projet via l'import GitHub ou via l'archive de notre projet.

Via GitHub :
Clique Droit sur le dossier sct-master contenant les projets Yakindu
Import > Maven > Checkout Maven Projet from SCM
Dans SCM URL sélectionez git puis collez : https://github.com/TMtoSC/projectTransformation.git
Cliquez sur Finish

Une fois notre projet ainsi que le projet Yakindu importés, il vous faut définir les dépendances de notre projet.
Pour cela Clique Droit sur notre projet importé > Properties > Java Build Path > Projects > Add > Selectionnez tous les projets maven de Yakindu (a savoir toute la liste) > Ok

Ce projet est maintenant pret à être utilisé.

Afin de générer des fichier XML resultants de tests vous allez devoir effectuer un clique droit sur le dossier
src/test/main > Run As > JUnit Test
Les fichiers correspondants aux transformations des 6 opérateurs lotos ainsi que du WXR et de certains opérateurs imbriqués avec eux même seront générés dans le dossier :
.\tests\
Ces fichiers seront nommés : nom_de_loperateur.sct
Et pourront être lus par Yakindu afin de présenter leur ordonancement hierarchique via l'explorateur de projets de Yakindu (partie gauche).

Afin de pouvoir ouvrir ces fichiers avec Yakindu : Ouvrez Yakindu > Choisisez n'importe quel Workspace > Créez un nouveau projet de type général grace a l'outil > Glissez/Déposez le fichier .sct depuis l'explorateur de votre machine dans le projet de Yakindu > Sélectionnez l'option Link File > Ok

Ceci va vous importer le statechart créé que vous pourrez explorer de dans cet explorateur de Projet.



Notes sur les Statecharts :a
L'algorithme ne permet pas certaines fonctionnalités nécessaires à la simulation du statecharts.

Voici les points qu'il faudra améliorer pour obtenir un algorithme valide et utilisable parfaitement. 

La visualisation : Nous avons réussi à définir la structure du modèle de tâches mais nous n'avons pas pu faire la modélisation. Celle-ci d'apres ce qu'on a compris ce fais à l'aide de déclaration de balise Diagram à la suite de notre xml que l'on génère. On a pensé qu'elle se faisait avec la gmf d'eclipse mais nous n'avons pas réussi à l'utiliser mais cela à été notre meilleure piste pour l'instant

Les états finaux : En effet certaines tâches doivent être considérer comme finale dans un modèle de tâches et récursivement cela devient compliquer à trouver celles qui le sont ou celles qui ne le sont pas. Pour ne pas trop s'attarder dessus nous avons décidé de mettre ceci de côté afin de créer la structure de données du statecharts

Les synchronisations des multiples concurrences : Un peu comme les états finaux une concurrence doit se synchroniser avec ses autres aprties concurrentes afin que toutes soient fini avant de passer à la suite si suite il y a. Le problème revient au même que les états finaux, c'est à dire, savoir quel état fini une partie de la concurrence pour pouvoir faire pointer vers l'état synchronisant.

Les transition sont crées de haut en bas mais nous n'avons pas reussi a les construire de bas en haut. C'est a dire que nous pouvons lors de l'imbrication de deux opérateurs passer a l'opérateur le plus bas, mais nous ne sommes pas parvenus à revenir sur l'opérateur principal.
De plus ces statecharts ne possèdent pas d'état final bien placé. C'est a dire que toutes les tâches qui peuvent finir la simulation et donc n'offrent pas la possibiliter que ce soit par un opérateur plus haut ou plus bas de continuer le modèle, ne possèdent pas de transition vers Final State qui est donc l'état dans lequel le modèle est terminé.
