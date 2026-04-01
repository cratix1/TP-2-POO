import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Exercice1 {

    public static void main(String[] args) {
        System.out.println("====== EXERCICE 1 ======");

        // 4. Créer une List<Etudiant>
        List<Etudiant> listeEtudiants = new ArrayList<>();
        
        // Ajouter plusieurs étudiants
        listeEtudiants.add(new Etudiant(3, "Martin", "Paul"));
        listeEtudiants.add(new Etudiant(1, "Dupont", "Jean"));
        listeEtudiants.add(new Etudiant(2, "Bernard", "Alice"));
        
        // Ajouter volontairement au moins deux doublons logiques (même ID qu'un existant)
        listeEtudiants.add(new Etudiant(1, "Dupont", "Jean")); // Doublon de l'ID 1
        listeEtudiants.add(new Etudiant(3, "Martin", "Paul")); // Doublon de l'ID 3
        
        // Afficher la liste complète
        System.out.println("--- 4. Liste complète (avec doublons) ---");
        for (Etudiant e : listeEtudiants) {
            System.out.println(e);
        }
        
        // 5. Recherche par ID
        System.out.println("\n--- 5. Recherche d'un étudiant par ID ---");
        int idRecherche = 2;
        Etudiant trouve = rechercherParId(listeEtudiants, idRecherche);
        if (trouve != null) {
            System.out.println("Étudiant trouvé (ID " + idRecherche + ") : " + trouve);
        } else {
            System.out.println("Aucun étudiant ne possède l'ID " + idRecherche);
        }
        
        // 6. Convertir en Set pour éliminer les doublons
        System.out.println("\n--- 6. Conversion en Set (élimination des doublons) ---");
        Set<Etudiant> setEtudiants = new HashSet<>(listeEtudiants);
        for (Etudiant e : setEtudiants) {
            System.out.println(e);
        }
        
        // 7. Comparaison des tailles
        System.out.println("\n--- 7. Comparaison des tailles ---");
        System.out.println("Taille de la List (avec doublons) : " + listeEtudiants.size());
        System.out.println("Taille du Set (sans doublons)   : " + setEtudiants.size());
        
        // 8. Trier la liste
        List<Etudiant> listeUniqueTest = new ArrayList<>(setEtudiants);
        
        System.out.println("\n--- 8a. Tri par ID croissant ---");
        Collections.sort(listeUniqueTest);
        for (Etudiant e : listeUniqueTest) {
            System.out.println(e);
        }
        
        System.out.println("\n--- 8b. Tri par nom alphabétique ---");
        Collections.sort(listeUniqueTest, new Comparator<Etudiant>() {
            @Override
            public int compare(Etudiant e1, Etudiant e2) {
                return e1.getNom().compareToIgnoreCase(e2.getNom());
            }
        });
        
        for (Etudiant e : listeUniqueTest) {
            System.out.println(e);
        }
    }
    
    // Méthode de recherche par ID demandée à la question 5
    public static Etudiant rechercherParId(List<Etudiant> list, int id) {
        for (Etudiant e : list) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null; // Retourne null si non trouvé
    }
}

// Classe Etudiant (non publique pour pouvoir résider dans le même fichier)
class Etudiant implements Comparable<Etudiant> {
    private int id;
    private String nom;
    private String prenom;

    public Etudiant() {
    }

    public Etudiant(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Accesseurs (Getters et Setters)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }

    @Override
    public String toString() {
        return "Etudiant{id=" + id + ", nom='" + nom + "', prenom='" + prenom + "'}";
    }

    // Redéfinition de equals basée sur l'id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return id == etudiant.id;
    }

    // Redéfinition de hashCode basée sur l'id
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    // Implémentation optionnelle mais pratique pour le tri par défaut par id croissant
    @Override
    public int compareTo(Etudiant o) {
        return Integer.compare(this.id, o.id);
    }
}
