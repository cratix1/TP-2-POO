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

        Graph<String, DefaultEdge> graphe = new SimpleGraph<>(DefaultEdge.class);

        graphe.addVertex("Alger");
        graphe.addVertex("Blida");
        graphe.addVertex("Tipaza");
        graphe.addVertex("Boumerdes");
        graphe.addVertex("Medea");

        graphe.addEdge("Alger", "Blida");
        graphe.addEdge("Alger", "Tipaza");
        graphe.addEdge("Alger", "Boumerdes");
        graphe.addEdge("Blida", "Medea");

        System.out.println("Sommets du graphe : " + graphe.vertexSet());
        System.out.println("Arêtes du graphe  : " + graphe.edgeSet());

        System.out.println("Parcours BFS depuis Alger :");
        BreadthFirstIterator<String, DefaultEdge> bfs1 = new BreadthFirstIterator<>(graphe, "Alger");
        while (bfs1.hasNext()) {
            System.out.print(bfs1.next() + " ");
        }
        System.out.println();

        graphe.addVertex("Oran");
        
        System.out.println("Parcours BFS après ajout de Oran (non reliée) :");
        BreadthFirstIterator<String, DefaultEdge> bfs2 = new BreadthFirstIterator<>(graphe, "Alger");
        while (bfs2.hasNext()) {
            System.out.print(bfs2.next() + " ");
        }

        graphe.addEdge("Tipaza", "Medea");
        BreadthFirstIterator<String, DefaultEdge> bfs3 = new BreadthFirstIterator<>(graphe, "Alger");
        while (bfs3.hasNext()) {
            System.out.print(bfs3.next() + " ");
        }

        Graph<String, DefaultWeightedEdge> graphePondere = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);

        String[] villes = {"Alger", "Blida", "Tipaza", "Boumerdes", "Medea"};
        for (String v : villes) {
            graphePondere.addVertex(v);
        }

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

        DijkstraShortestPath<String, DefaultWeightedEdge> dijkstra = new DijkstraShortestPath<>(graphePondere);

        System.out.println("\nPlus court chemin entre Alger et Medea :");
        GraphPath<String, DefaultWeightedEdge> path1 = dijkstra.getPath("Alger", "Medea");
        System.out.println("Chemin : " + path1.getVertexList());
        System.out.println("Coût total : " + path1.getWeight());

        System.out.println("\nPlus court chemin entre Boumerdes et Blida :");
        GraphPath<String, DefaultWeightedEdge> path2 = dijkstra.getPath("Boumerdes", "Blida");
        System.out.println("Chemin : " + path2.getVertexList());
        System.out.println("Coût total : " + path2.getWeight());
    }
}
