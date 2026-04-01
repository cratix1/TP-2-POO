//exercise1

 Dans cet exercice, j'ai implémenté la gestion d'une collection d'étudiants en utilisant les interfaces list et set. Le programme est découpé en deux parties:

-La classe Etudiant: Elle contient les attributs basiques (id, nom, prénom). 
J'ai redéfini les méthodes equals() et hashCode() en me basant uniquement sur l'ID. C'est ce qui permet aux collections de comprendre que deux instances différentes
 en mémoire sont en réalité le même étudiant si elles ont le même identifiant. J'y ai également implémenté l'interface comparable pour permettre un tri naturel.

-Le programme principal (main) : J'y démontre l'utilisation d'une ArrayList (qui accepte l'ajout de mes doublons logiques)
 et sa conversion facile vers un HashSet. Le HashSet se sert de mon hashCode et de mon equals pour effacer les doublons automatiquement.
 j'utilise ensuite Collections.sort() pour trier la liste sans doublons de deux manières différentes,
 d'abord via l'ordre naturel défini (par ID croissant), puis via un comparator créé à la volée pour trier par ordre alphabétique des noms.



//exercise2

Dans cet exercice, j'ai implémenté un analyseur de phrases qui compte la fréquence de chaque mot en utilisant la structure map. Il se fait en êtapes suivants:

1-Entrée et nettoyage: Le programme lit la phrase, la nettoie avec trim() et la passe en minuscules grâce à toLowerCase() pour assurer l'insensibilité à la casse.
2-Découpage: J'utilise split("\\s+"). L'expression régulière permet de découper les mots même s'il y a plusieurs espaces consécutifs entre eux.
3-Comptage via HashMap: Je parcours mon tableau de mots. Si le mot n'existe pas en clé dans ma map, la méthode getOrDefault(mot, 0) retourne 0,
 auquel j'ajoute 1; S'il existe déjà elle renvoie la valeur actuelle qui est alors incrémentée.
4-Recherche du mot le plus fréquent: J'itère une seule fois sur entrySet() pour trouver l'association Clé-Valeur avec la plus grande fréquence 
plutôt que de reparcourir.
5-Tri du résultat: j'extrais les clés de la Map (qui sont uniques) dans une nouvelle ArrayList et j'y applique Collections.sort() 
pour avoir mon classement final par ordre alphabétique.


//exercise3

Dans cet exercise, le but était de modéliser un réseau routier entre des villes à l'aide de la bibliothèque externe JGraphT. Voici comment j'ai structuré mon code :

-L'intégration Maven: j'ai mis en place un projet Maven avec un fichier pom.xml pour importer la dépendance jgrapht-core
-Partie C & D: J'ai d'abord instancié un SimpleGraph, J'y ai ajouté les villes en utilisant addVertex() et les routes via addEdge().
J'ai ensuite utilisé BreadthFirstIterator pour parcourir en largeur en partant d'Alger.
lorsqu'on ajoute la ville d'Oran sans créer de route, le BFS l'ignore complètement;
-Partie E: J'ai créé un deuxième graphe SimpleWeightedGraph, qui permet d'associer la distance en kilomètres à chaque route via setEdgeWeight().
J'ai ensuite utilisé la classe DijkstraShortestPath qui implémente l' algorithme de Dijkstra.
Cela m'a permis de calculer le chemin le plus court, et son coût total, sans avoir à analyser l'arbre du graphe manuellement.
