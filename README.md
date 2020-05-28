
[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/bloodysysy73/J-P-Website_Front_End">
    <img src="https://github.com/bloodysysy73/J-P-Website_Front_End/blob/master/public/images/logojp.jpg" alt="Logo" width="auto" height="80">
  </a>

  <h3 align="center">Simulation site web de l'Association Jumeaux & plus 73 : Front end</h3>

  <p align="center">
    Ce repo contient le code de la partie backend de mon application web "jumeau et plus 73". Cette application web est un site hybride administrateur/forum qui pourrait permettre (si il était déployé) à l'association jumeaux et plus 73 de gérer leurs adhérents, de les informer des évènements passés et à venir et de créer une communauté d'entraide en mettants les membres en relation direct.
   <br />
    <br />
    <a href="https://github.com/bloodysysy73/J-P-Website_Front_End"><strong>Arborescence des fichiers</strong></a>
    <br />
  
  <br />
  La partie frontend à été réalisée en javascript avec le framework React JS, la partie backend en JAVA avec le framework spring. Les données sont persistées dans une base de donnée relationelle MySql avec l'ORM hibernate.<br /><br />
    <a href="https://github.com/bloodysysy73/J-P-Website_Front_End/"><strong>Cliquez ici pour accéder au front-end de l'application</strong></a>
    <br />
</p>



<!-- TABLE OF CONTENTS -->
## Sommaire

* [Principe de l'application](#principe-de-lapplication)
  * [Built With](#built-with)
* [Getting Started](#getting-started)
  * [Prerequisites](#prerequisites)
  * [Installation](#installation)
* [Usage](#usage)
* [Contact](#contact)



<!-- ABOUT THE PROJECT -->
## Principe de l'application

ce projet spring boot est le backend d'un projet React en référence ci-avant. Il permet de gérer le site internet d'une association.

Les utlisateurs peuvent se créer un compte ou se connecter avec google. Dans les 2 cas le backend créer un compte dans la base de donnée mySql et les identifiants seront utilisés pour la création du token qui permet d'obtenir l'accès au service proposés.

la base de donnée contient les données relatifs au 6 classes du projet spring : les utilisateurs, les rôles, les questions posées par les utlisateurs et les réponses associées, les publications et les évènements postés sur le site internet par l'asscoiation. 

### Built With

* []() Framework Spring (JAVA 8) pour la partie backend (projet spring boot)
* []() Spring security pour la gestion des tokens et l'accès au service du backend
* []() maven 4.0 pour la gestion des dépendences 
* []() hibernate pour la persistance des données

<!-- GETTING STARTED -->
## Getting Started

Pour obtenir un copie locale de cette application veuillez suivre ces étapes. 

### Prerequisites

* lampp (ici avec ubuntu)
```sh
sudo apt install apache2 php libapache2-mod-php mysql-server php-mysql
```
* java 8

### Installation

Pour la base de donnée : 

1. lancer lampp

```sh
sudo lampp start
```

Pour la partie back : 

1. Cloner le repo du back dans un autre dossier
```sh
git clone https://github.com/bloodysysy73/J-P-Website_Back_End
```
2. Ouvrir le projet spring boot avec votre IDE (idéalement eclipse avec l'extension spring tools 3.9.12 et l'addon 4.3.9)
```sh
cliquez droit sur votre projet : run as spring boot App
```


<!-- USAGE EXAMPLES -->
## Usage

L'API REST est utilisé pour communiquer avec ce backend. Les url possibles sont données dans le package "controller". 


<!-- CONTACT -->
## Contact

Sylvain GUEHRIA   - sylvain.guehria@gmail.com - 06 64 39 70 53

[![LinkedIn][linkedin-shield]][linkedin-url]



<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
[linkedin-shield]: https://img.shields.io/badge/-LinkedIn-black.svg?style=flat-square&logo=linkedin&colorB=555
[linkedin-url]: https://www.linkedin.com/in/sylvain-guehria-ab9737134/
[product-screenshot]: public/images/capture1.png
[capture-question]: public/images/capture2.png
[capture-question-2]: public/images/Capture3.png
[capture-profile]: public/images/Capture5.png
[capture-admin]: public/images/capture7.png

