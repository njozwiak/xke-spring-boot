XKE spring-boot
===================

# Etape 1 : Créer une application spring boot du néant

## 1.1 Créer le fichier de build
Créer un fichier de configuration sur http://start.spring.io/ (gradde ou maven) et le copier à la racine du projet.
Sélectionner les starters
- Actuator
- Jpa
- Thymeleaf
- Web

>Cette étape n'est pas obligatoire, le fichier peut être créer manuellement,
>elle permet cependant de démarrer rapidement.

## 1.2 Classe com.xebia.xkboot.Application
Dans le package de base créer la classe principale Application
```
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
```

## 1.3 Classe com.xebia.xkboot.Configuration

- Déclarer la classe comme une **Configuration**
- Activer le **ComponentScan**
- Activer l'**AutoConfiguration**
- **Importer** cette classe dans la classe Application

## 1.4 Classe com.xebia.xkboot.controller.ClientController

- Déclarer cette classe en **RestController**

## 1.5 Démarrer l'application en utilisant les plugins:

graddle :
```
./gradlew bootRun
```
maven :
```
mvn spring:boot
```

Compiler et démarrer l'application en standalone
```
./gradlew build
java -jar build/libs/xke-spring-boot-0.1.0.jar
```

```
mvn package
java -jar target/xke-spring-boot-0.1.0.jar
```

Aller sur la page http://localhost:8080/, l'application spring-boot fonctionne

Tester la page inexistante http://localhost:8080/peek-a-boo

## 1.2 Modifier la classe ClientController.java

Utiliser le service ClientService


# Etape 2 : Data

## 2.1 Création du ClientRepository

- Ajouter la dépendance ```spring-boot-starter-data-jpa```
- Créer la classe ```ClientRepository``` qui étend ```JpaRepository<Client, String>```
- Par défaut, Spring boot fournit un hsqldb in memory
- Ajouter le repository dans la classe ```ClientService``` et modifier la méthode ```findAll()```
- Relancer l'application
- Spring boot scanne automatiquement les fichiers sql de répertoire resources et initialise les données

# Etape 3 : Gestion de la configuration

## 3.1 Changer le port du serveur en ligne de commande
- Utiliser la propriété ```server.port```
## 3.2 Définir un nouvel emplacement pour le fichier de configuration
- Utiliser la propriété ```spring.config.location```
## 3.3 Définir un nouvel emplacement pour le fichier de log
- [Surcharger](http://docs.spring.io/spring-boot/docs/current-SNAPSHOT/reference/htmlsingle/#boot-features-custom-log-configuration) le fichier logback.xml
## 3.4 Ajouter les ConfigurationProperties

- Créer le **Component** ```ClientProperties``` qui est un **ConfigurationProperties**
- Dans le fichier application.yml, ajouter la propriété suivante sous app :
 ```
    client :
       orderByName : true
 ```
- Dans la classe ```ClientProperties```, ajouter le prefix ```prefix = "app.client"```
- Ajouter l'attribut Boolean ```orderByName``` ainsi que le getter/setter
- Injecter la classe ```ClientProperties``` dans le ```ClientService```
- Ajouter une condition dans la méthode ```findAll()``` pour trier les clients par nom (ordre croissant) lorsque la propriété ```orderByName``` est true

# Etape 4 : Actuator

## 4.1 Examiner l'état de l'application
- Ajouter la dépendance ```spring-boot-starter-actuator```
- Afficher les variables surchargées
- Faire un thread dump de l'application
- Afficher les metrics
- Tracer les requêtes HTTP

# Etape 5 : Security