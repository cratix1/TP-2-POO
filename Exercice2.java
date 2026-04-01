import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Exercice2 {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Veuillez saisir une phrase : ");
        String phrase = scanner.nextLine();
        
        
        phrase = phrase.trim().toLowerCase();
        
        if (phrase.isBlank()) {
            System.out.println("La phrase est vide ou ne contient que des espaces !");
            scanner.close();
            return;
        }

        String[] mots = phrase.split("\\s+");
        
        Map<String, Integer> occurrences = new HashMap<>();
        
        for (String mot : mots) {
            occurrences.put(mot, occurrences.getOrDefault(mot, 0) + 1);
        }
        
        System.out.printf("%-15s %s\n", "Mot", "Occurrences");
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            System.out.printf("%-15s %d\n", entry.getKey(), entry.getValue());
        }
        
        System.out.println("Nombre total de mots     : " + mots.length);
        System.out.println("Nombre de mots distincts : " + occurrences.size());
        
        String motPlusFrequent = null;
        int maxOccurrences = 0;
        
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            if (entry.getValue() > maxOccurrences) {
                maxOccurrences = entry.getValue();
                motPlusFrequent = entry.getKey();
            }
        }
        System.out.println("Le mot le plus présent est '" + motPlusFrequent + "' (apparu " + maxOccurrences + " fois).");
        
        List<String> motsTries = new ArrayList<>(occurrences.keySet());
        Collections.sort(motsTries);
        
        for (String mot : motsTries) {
            System.out.println("- " + mot);
        }
        
        scanner.close();
    }
}
