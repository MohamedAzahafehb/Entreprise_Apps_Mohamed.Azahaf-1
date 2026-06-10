# Enterprise Apps Mohamed Azahaf
## Inhoudsopgave
- [Enterprise Apps Mohamed Azahaf](#enterprise-apps-mohamed-azahaf)
  - [Inhoudsopgave](#inhoudsopgave)
  - [Project Uitvoeren](#project-uitvoeren)
    - [1. Vereisten](#1-vereisten)
    - [2. Database Aanmaken](#2-database-aanmaken)
    - [3. Database Configuratie](#3-database-configuratie)
    - [4. Mailserver configuratie](#4-mailserver-configuratie)
    - [5. Applicatie Starten](#5-applicatie-starten)
  - [Gebruikte Technologieën \& Frameworks](#gebruikte-technologieën--frameworks)
  - [Hulpmiddelen](#hulpmiddelen)
    - [Cursus](#cursus)
    - [Externe bronnen](#externe-bronnen)
    - [Gebruik van AI](#gebruik-van-ai)
      - [Antigravity AI Assistent](#antigravity-ai-assistent)
      - [ChatGPT](#chatgpt)

---
## Project Uitvoeren

### 1. Vereisten
- **Spring 4.0.6**
- **Java 25**
- **MySQL**
- **Maven 4.0**
- **IDE** (bv. Spring Tool Suite 4 of IntelliJ)
  
### 2. Database Aanmaken
Zorg ervoor dat MySQL actief is en maak een database aan genaamd `ngo_anderlecht`:
```sql
CREATE DATABASE ngo_anderlecht;
```

### 3. Database Configuratie
In `src/main/resources/application.properties` staan de properties klaar, vul uw database gegevens correct aan. Zo moet het er ongeveer eruit zien:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ngo_anderlecht
spring.datasource.username=root
spring.datasource.password=root
```
*Pas zo nodig de gebruikersnaam en het wachtwoord aan aan uw lokale MySQL-installatie.*

*En als u een andere naam of poort heeft gekozen voor uw Database, vul die in in plaats van 3306/ngo_anderlecht*

### 4. Mailserver configuratie
Om e-mails daadwerkelijk te versturen naar je Mailtrap inbox, voeg je jouw mail-gegevens toe in `src/main/resources/application.properties`:
Ik maak gebruik van Outlook, als u een andere wenst te gebruiken moet u hiervoor de correcte in te vullen gegevens opzoeken
```properties
spring.mail.host=smtp-mail.outlook.com
spring.mail.port=587
spring.mail.username=voornaam.achternaam@ehb.be
spring.mail.password=wachtwoord123!
```
*Uiteraard vult u uw eigen mailadres en wachtwoord in*

*Ik maak gebruik van Environment Variables zodat mijn gegevens niet in deze repository komen vij het pushen*


### 5. Applicatie Starten
Rechtermuisklik op het project en run as a Spring Boot App

De applicatie start op op: *`http://localhost:8080`*.

---
## Gebruikte Technologieën & Frameworks
Deze informatie is te vinden in de pom.xml
Belangrijke Technologieën en Frameworks zijn:
- Spring 4.0.6
- Java 25
- Maven

Spring Starters:
- Thymeleaf
- JDBC API
- Spring Data JPA
- MYSQL Driver (mijn eigen keuze omdat ik er beter in vertrouwd ben)
- Spring Web
- Spring Mail

---

## Hulpmiddelen
### Cursus
Ik heb de mappenstructuur overgenomen van onze lector en mijn hele Rest API hierop gebaseerd [ehb-enterprise-applications-verloren-gevonden](https://github.com/WeAreAllAmazingPeople/ehb-enterprise-applications-verloren-gevonden/tree/feature/database)
### Externe bronnen
- **Het gebruik maken van PathVariables voor de ID in de url voor zowel GET, PUT als DELETE**: [Spring Documentation](https://spring.io/guides/tutorials/rest)
- **Foreign key in de models dmv annotations**: [@ManyToOne](https://jakarta.ee/specifications/persistence/4.0/apidocs/jakarta.persistence/jakarta/persistence/manytoone) [@JoinColumn](https://jakarta.ee/specifications/persistence/4.0/apidocs/jakarta.persistence/jakarta/persistence/joincolumn)
- **Views displayen via Controllers**: [Spring MVC - 5. Controllers](https://www.youtube.com/watch?v=9VmmSOCA2F4&list=PL82C6-O4XrHejlASdecIsroNEbZFYo_X1&index=5)
- **Gebruik van mapping**: [Spring Documentation](https://spring.io/guides/gs/handling-form-submission)
- **Mailtrap gebruiken**: [Send Email in Spring Boot using Gmail SMTP - Tutorial by Mailtrap](https://www.youtube.com/watch?v=_tb2d7RCsmM)
- **Gebruik van environment variables om privacy van wachtwoorden te garanderen**: [Spring Boot Environment Variables Explained](https://www.youtube.com/watch?v=rQV76dufxz4)

### Gebruik van AI
#### Antigravity AI Assistent
- Form validation op Niew Evenement, zelfde werkwijze hergebruikt voor Nieuwe Locatie
- De hele frontend, Alle Views
- De structuur van deze ReadMe (Gebruik van titels en codeblokken, inhoudstafel)

#### ChatGPT
- In de Service-laag het gebruik maken van de orElseThrow() methode
- env var gebruiken in de code (EmailService.java)