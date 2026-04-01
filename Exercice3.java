package com.exercice;

import org.jgrapht.Graph;
import org.jgrapht.GraphPath;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.graph.SimpleWeightedGraph;
import org.jgrapht.traverse.BreadthFirstIterator;

public class Exercice3 {

    public static void main(String[] args) {
        System.out.println("====== EXERCICE 3 : GRAPHES ======");

        // --- PARTIE C : Création du graphe ---
        System.out.println("\n--- PARTIE C ---");
        Graph<String, DefaultEdge> graphe = new SimpleGraph<>(DefaultEdge.class);

        // 2. Ajouter tous les sommets
        graphe.addVertex("Alger");
        graphe.addVertex("Blida");
        graphe.addVertex("Tipaza");
        graphe.addVertex("Boumerdes");
        graphe.addVertex("Medea");

        // 3. Ajouter toutes les relations
        graphe.addEdge("Alger", "Blida");
        graphe.addEdge("Alger", "Tipaza");
        graphe.addEdge("Alger", "Boumerdes");
        graphe.addEdge("Blida", "Medea");

        // 4 & 5. Afficher sommets et arêtes
        System.out.println("Sommets du graphe : " + graphe.vertexSet());
        System.out.println("Arêtes du graphe  : " + graphe.edgeSet());

        // 6 & 7. BFS à partir d'Alger
        System.out.println("Parcours BFS depuis Alger :");
        BreadthFirstIterator<String, DefaultEdge> bfs1 = new BreadthFirstIterator<>(graphe, "Alger");
        while (bfs1.hasNext()) {
            System.out.print(bfs1.next() + " ");
        }
        System.out.println();

        // --- PARTIE D : Modifications ---
        System.out.println("\n--- PARTIE D ---");
        // 1. Ajouter Oran (sans le relier)
        graphe.addVertex("Oran");
        
        // 2. Relancer le BFS
        System.out.println("Parcours BFS après ajout de Oran (non reliée) :");
        BreadthFirstIterator<String, DefaultEdge> bfs2 = new BreadthFirstIterator<>(graphe, "Alger");
        while (bfs2.hasNext()) {
            System.out.print(bfs2.next() + " ");
        }
        // 3. Observer si Oran apparait
        System.out.println("\n(Observation : Oran n'apparait pas car elle n'est pas connectée dans le parcours d'Alger)");

        // 4. Ajouter Tipaza - Medea
        graphe.addEdge("Tipaza", "Medea");
        // 5. Relancer BFS et comparer
        System.out.println("Parcours BFS après ajout de l'arête Tipaza-Medea :");
        BreadthFirstIterator<String, DefaultEdge> bfs3 = new BreadthFirstIterator<>(graphe, "Alger");
        while (bfs3.hasNext()) {
            System.out.print(bfs3.next() + " ");
        }
        System.out.println("\n(Observation : L'ordre a pu changer et Medea est désormais accessible également par Tipaza)");

        // --- PARTIE E : Graphe pondéré ---
        System.out.println("\n--- PARTIE E : Graphe Pondéré et Plus Court Chemin ---");
        // 1. Créer un graphe pondéré
        Graph<String, DefaultWeightedEdge> graphePondere = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        // 2. Ajouter les sommets
        String[] villes = {"Alger", "Blida", "Tipaza", "Boumerdes", "Medea"};
        for (String v : villes) {
            graphePondere.addVertex(v);
        }

        // 3. Ajouter les arêtes avec leurs poids
        DefaultWeightedEdge e1 = graphePondere.addEdge("Alger", "Blida");
        graphePondere.setEdgeWeight(e1, 50.0);

        DefaultWeightedEdge e2 = graphePondere.addEdge("Alger", "Tipaza");
        graphePondere.setEdgeWeight(e2, 70.0);

        DefaultWeightedEdge e3 = graphePondere.addEdge("Alger", "Boumerdes");
        graphePondere.setEdgeWeight(e3, 45.0);

        DefaultWeightedEdge e4 = graphePondere.addEdge("Blida", "Medea");
        graphePondere.setEdgeWeight(e4, 90.0);

        DefaultWeightedEdge e5 = graphePondere.addEdge("Boumerdes", "Tipaza");
        graphePondere.setEdgeWeight(e5, 80.0);

        DefaultWeightedEdge e6 = graphePondere.addEdge("Tipaza", "Medea");
        graphePondere.setEdgeWeight(e6, 60.0);

        // 4. Calculer le plus court chemin
        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graphePondere);

        // Alger et Medea
        System.out.println("\nPlus court chemin entre Alger et Medea :");
        GraphPath<String, DefaultWeightedEdge> path1 = dijkstra.getPath("Alger", "Medea");
        System.out.println("Chemin : " + path1.getVertexList());
        System.out.println("Coût total : " + path1.getWeight());

        // Boumerdes et Blida
        System.out.println("\nPlus court chemin entre Boumerdes et Blida :");
        GraphPath<String, DefaultWeightedEdge> path2 = dijkstra.getPath("Boumerdes", "Blida");
        System.out.println("Chemin : " + path2.getVertexList());
        System.out.println("Coût total : " + path2.getWeight());
    }
}
