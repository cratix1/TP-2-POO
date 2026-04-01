import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
        // 1. Demander à l'utilisateur de saisir une phrase.
        Scanner scanner = new Scanner(System.in);
        System.out.println("====== EXERCICE 2 : Analyse de phrase ======");
        System.out.println("Veuillez saisir une phrase : ");
        String phrase = scanner.nextLine();
        
        // 2. Convertir la phrase en minuscules (et enlever les espaces inutiles aux extrémités).
        phrase = phrase.trim().toLowerCase();
        
        // Sécurité si on a juste tapé "Entrée" ou des espaces :
        if (phrase.isBlank()) {
            System.out.println("La phrase est vide ou ne contient que des espaces !");
            scanner.close();
            return;
        }

        // 3. Découper la phrase en mots (le regex "\\s+" permet de gérer plusieurs espaces consécutifs).
        String[] mots = phrase.split("\\s+");
        
        // 4. Stocker les occurrences dans une Map<String, Integer>.
        Map<String, Integer> occurrences = new HashMap<>();
        
        for (String mot : mots) {
            occurrences.put(mot, occurrences.getOrDefault(mot, 0) + 1);
        }
        
        // 5. Afficher chaque mot avec son nombre d'occurrences.
        System.out.println("\n--- Résultat de l'analyse ---");
        System.out.printf("%-15s %s\n", "Mot", "Occurrences");
        System.out.println("-----------------------------");
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%-15s %d\n", entry.getKey(), entry.getValue());
        }
        
        // 6. Afficher : le nombre total de mots et le nombre de mots distincts.
        System.out.println("\n--- Statistiques ---");
        System.out.println("Nombre total de mots     : " + mots.length);
        System.out.println("Nombre de mots distincts : " + occurrences.size());
        
        // 7. Déterminer et afficher le mot le plus fréquent.
        String motPlusFrequent = null;
        int maxOccurrences = 0;
        
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > maxOccurrences) {
                maxOccurrences = entry.getValue();
                motPlusFrequent = entry.getKey();
            }
        }
        System.out.println("\n--- Mot le plus fréquent ---");
        System.out.println("Le mot le plus présent est '" + motPlusFrequent + "' (apparu " + maxOccurrences + " fois).");
        
        // 8. Afficher les mots triés par ordre alphabétique.
        System.out.println("\n--- Mots triés par ordre alphabétique ---");
        List<String> motsTries = new ArrayList<>(occurrences.keySet());
        Collections.sort(motsTries);
        
        for (String mot : motsTries) {
            System.out.println("- " + mot);
        }
        
        scanner.close();
    }
}
