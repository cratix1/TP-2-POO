import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Exercice1 {

    public static void main(String[] args) {
    

       
        List<Etudiant> listeEtudiants = new ArrayList<>();
        
        
        listeEtudiants.add(new Etudiant(3, "hiba", "meghni"));
        listeEtudiants.add(new Etudiant(1, "meriem", "meghni"));
        listeEtudiants.add(new Etudiant(2, "amira", "meghni"));
        
        
        listeEtudiants.add(new Etudiant(1, "meriem", "meghni")); 
        listeEtudiants.add(new Etudiant(3, "hiba", "meghni")); 
        
      
        for (Etudiant e : listeEtudiants) {
            System.out.println(e);
        }
        
       
       
        int idRecherche = 2;
        Etudiant trouve = rechercherParId(listeEtudiants, idRecherche);
        if (trouve != null) {
            System.out.println("Étudiant trouvé (ID " + idRecherche + ") : " + trouve);
        } else {
            System.out.println("Aucun étudiant ne possède l'ID " + idRecherche);
        }
        
       
        Set<Etudiant> setEtudiants = new HashSet<>(listeEtudiants);
        for (Etudiant e : setEtudiants) {
            System.out.println(e);
        }
        
       
        System.out.println("Taille de la List (avec doublons) : " + listeEtudiants.size());
        System.out.println("Taille du Set (sans doublons)   : " + setEtudiants.size());
        
        
        List<Etudiant> listeUniqueTest = new ArrayList<>(setEtudiants);
        
        
        Collections.sort(listeUniqueTest);
        for (Etudiant e : listeUniqueTest) {
            System.out.println(e);
        }
        
       
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
    
    
    public static Etudiant rechercherParId(List<Etudiant> list, int id) {
        for (Etudiant e : list) {
            if (e.getId() == id) {
                return e;
            }
        }
        return null; 
    }
}


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

 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Etudiant etudiant = (Etudiant) o;
        return id == etudiant.id;
    }

    
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
    
    
    @Override
    public int compareTo(Etudiant o) {
        return Integer.compare(this.id, o.id);
    }
}
