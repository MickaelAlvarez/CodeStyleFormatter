#CodeStyleFormatter

Étants utilisateurs de l’IDE (Integrated Development Environment) Eclipse nous savions qu’il est possible de formater un code facilement grâce à des raccourcis ou à des outils intégrés sous cet IDE. De même on peut générer ou injecter des patterns de formatage de code (appelés profiles). C’est pourquoi sachant que les sources d’Eclipse sont disponibles en open-source nous avons décidé de les utiliser pour se fabriquer un outil en ligne de commande qui nous permettrai de formater un projet Java dans un style défini par un profil donné.

Les sources d’Eclipse étant des jar, l’outil de refactoring a été fait en java, il a été construit de sorte à pouvoir être exécuté en ligne de commande en prenant en paramètre un fichier de profile et la racine d’un projet java. Un jar exécutable a donc été généré et intégré au projet. 

Pour parser les document xml de profil de formatage, nous utilisons la librairie xStream 1.4.9, elle nous permet de facilement transformer les éléments xml en un objet Java.


Pour utiliser cet outil il suffit d'exécuter :
  java -jar refactor.jar profile.xml racine
  
profil.xml: le profil de formatage voulu
racine: le chemin du projet à formater

On peut générer facilement un fichier de profile à partir d’Eclipse, il suffit d’aller dans windows/préférences/Java/Code Style/Formatter de créer un nouveau profil et de l’exporter.
