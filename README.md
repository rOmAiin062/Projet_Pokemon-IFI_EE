## Projet_Pokemon-IFI_EE
-----------
### Utilisation

* Utiliser maven pour exécuter les différents projets dans l'ordre suivant : 
  * 1 - Notification-service
    * $ cd notification-service 
    * $ mvn package
    * $ java -jar target/tp-06-async-1.0.0.jar
   * 2 - Ifi-trainer-api
      * $ cd ifi-trainer-api
      * $ mvn package
      * $ java -jar target/tp-04-jpa-1.0.0.jar
   * 3 - Tpa-fight
      * $ cd tpa-fight
      * $ mvn package
      * $ java -jar target/tpa-fight-0.1.0.jar
   * 4 - Tp-05-gui
      * $ cd tp-05-gui
      * $ mvn package
      * $ java -jar target/05-tp-gui-0.1.0.jar

-----------
### Composition et description des projets : 

#### TP Notification
* Voir dossier [notification-service](https://github.com/rOmAiin062/Projet_Pokemon-IFI_EE/tree/master/notification-service)

#### TP Trainer API 
* Voir dossier [ifi-trainer-api](https://github.com/rOmAiin062/Projet_Pokemon-IFI_EE/tree/master/ifi-trainer-api)
* Ajout d'un inventaire et d'un porte monnaie (wallet)

#### TP GUI
* Voir dossier [tp-05-gui](https://github.com/rOmAiin062/Projet_Pokemon-IFI_EE/tree/master/tp-05-gui)
* Permet l'accès à l'API Trainer (ci-dessus) + (API Pokemon)[https://ifi-pokemon-api.herokuapp.com/pokemons] + PokéBoutique (cf ci-dessous) + Combat (cf ci-dessous)

#### TPA Pokeboutique
* Voir dossier [tp-05-gui](https://github.com/rOmAiin062/Projet_Pokemon-IFI_EE/tree/master/tp-05-gui)
* Permet l'achat d'item (Pokéball ou Potion) 

#### TPA Fight
* Voir dossier [tpa-fight](https://github.com/rOmAiin062/Projet_Pokemon-IFI_EE/tree/master/tpa-fight)
* Permet d'exécuter des combats entre desseurs de Pokémon. 

-------- 
### Liens utiles pour l'utilisation des différents projets : 

#### tp-05-giu

http://localhost:9500/ - Home    
http://localhost:9500/trainers - List of trainers     
http://localhost:9500/pokemons - List of pokemons    
http://localhost:9500/pokeboutique - Pokeboutique    

http://localhost:9500/trainers/NOM_DU_TRAINER - Show details of NOM_DU_TRAINER    
http://localhost:9500/trainers/NOM_DU_TRAINER/fights - Show fight of NOM_DU_TRAINER    
http://localhost:9500/trainers/NOM_DU_TRAINER/fights/ID_FIGHT - Show details of fights ID_FIGHT    
http://localhost:9500/trainers/NOM_DU_TRAINER/arena - Visit arena to start fight    
http://localhost:9500/trainers/NOM_DU_TRAINER/fight/NOM_TRAINER2 - Start fight between NOM_DU_TRAINER vs NOM_TRAINER2    



#### tpa-fight

http://localhost:8082/fight/ - All Fight    
http://localhost:8082/fight/NOM_DU_TRAINER - Fight for NOM_DU_TRAINER     
http://localhost:8082/fight/NOM_TRAINER1/NOM_TRAINER2 - runFight    

#### ifi-trainer-api

http://localhost:8081/trainers/ - All Trainers     
http://localhost:8081/trainers/NOM_DU_TRAINER - Trainer NOM_DU_TRAINER      
