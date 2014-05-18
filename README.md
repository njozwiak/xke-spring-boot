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
Dans le package de base créer la classe principale Application (public static void main)

## 1.3 Classe com.xebia.xkboot.Configuration

- Déclarer la classe comme une **Configuration**
- Activer le **ComponentScan**
- Activer l'**AutoConfiguration**

## 1.4 Classe com.xebia.xkboot.controller.ClientController

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

Utiliser le service


# Etape 2 : Gestion de la configuration

## 2.1 Changer le port du serveur en ligne de commande
