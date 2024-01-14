import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;


public class Display {
	
	// Méthode permettant d'afficher l'ensemble des avions :
	public static void displayAllAirplanes(Scanner scanner, ArrayList<HashMap<String, Object >> airplaneList, String[][] pieceList) {
		System.out.println("--------------------------------------------------------");
		
		// Utilisation de la méthode stream();
		// Elle génère un flux de type "Stream<type>";
		// Elle offre des opérations de haut niveau pour manipuler/traiter les objets =>
		// Filtrage, transformation, réduction, tri, limitation etc ..
		airplaneList.stream().forEach(airplane -> {
			System.out.println(airplane.get("id") + " - " + airplane.get("program") + " - " + airplane.get("currentPhase") + " - " + airplane.get("type"));
		});
		
		System.out.println("--------------------------------------------------------");
		// On appelle la méthode pour afficher le menu principale :
		Menu.displayMainMenu(scanner, airplaneList, pieceList);
	}
	
	// Méthode permettant d'afficher un ou plusieurs avions en fonction d'un mot-clé saisi par l'utilisateur :
	public static void displayAirplaneKeyword(ArrayList<HashMap<String, Object >> airplaneList, Scanner scanner, String[][] pieceList) {
		System.out.println("--------------------------------------------------------");
		System.out.print("Veuillez saisir un mot clé, exemple A380 : ");

		String keyword = scanner.next();
		System.out.println();
		
		boolean anyResultFound = airplaneList.stream()
			// Expression Lambda :
			// Les lambdas sont des petites instruction que tu donne à JAVA pour faire quelque chose sur chaque élément de la liste :
			// C'est une façon concise et lisible d'écrire des actions sur des collections de données :
			.filter(map -> map.get("program").toString().contains(keyword))
			.peek(map -> {
				System.out.println(map.get("id") + " - " + map.get("program") + " - " + map.get("currentPhase") + " - " + map.get("type"));
			})
			// Cela compare le résultat du .count() avec zéro. Si le nombre d'éléments correspondants est supérieur à zéro, 
			// cela signifie qu'au moins un élément a été trouvé, et donc retournera true :
			.count() > 0;
		
		if(!anyResultFound) {
			System.out.println("Aucun résultat !");
		}
		
		System.out.println("--------------------------------------------------------");
		Menu.displayMainMenu(scanner, airplaneList, pieceList);
		
	}
	// Méthode permettant d'afficher les informations détaillées d'un avion :
	public static void displayInformationFromAirplane(Scanner scanner, ArrayList<HashMap<String, Object >> airplaneList) {
		System.out.print("Saisissez l'id de l'avion concerné : ");
		int userChoice = Verification.verificationAirplane(scanner, airplaneList);
		
		HashMap<String, Object> airplaneSelected = airplaneList.get(userChoice - 1);
		String idAirplaneSelected = (String) airplaneSelected.get("id");
		String nameAirplaneSelected = (String) airplaneSelected.get("program");
		String currentPhaseAirplaneSelected = (String) airplaneSelected.get("currentPhase");
		String typeAirplaneSelected = (String) airplaneSelected.get("type");
		@SuppressWarnings("unchecked")
		ArrayList<String[]> pieceListAirplaneSelected = (ArrayList<String[]>) airplaneSelected.get("piece");
		
		System.out.println("--------------------------------------------------------");
		System.out.println("ID: " + idAirplaneSelected + " - Program: " + nameAirplaneSelected);
		System.out.println("Current phase: " + currentPhaseAirplaneSelected + " - Type: " + typeAirplaneSelected);
		System.out.println();
		System.out.print("Pièce :");
		if(pieceListAirplaneSelected.size() == 0) {
			System.out.println(" -> La liste de pièce de cet avion est vide pour le moment !");
		} else {
			System.out.println();
			for(String[] piece : pieceListAirplaneSelected) {
				System.out.println("Name: " + piece[0] + " - Catégorie: " + piece[1] + " - Prix: " + piece[2]);
			}
		}
		System.out.println("--------------------------------------------------------");

	}
	
	// Méthode permettant d'afficher l'ensemble des pièces disponibles :
	public static void displayAllPieces(ArrayList<HashMap<String, Object >> airplaneList, Scanner scanner, String[][] pieceList) {
		System.out.println();
		System.out.println("-------------------- Pièce disponible --------------------");
		System.out.println();
		System.out.println("ID - [ NOM, CATEGORIE, PRIX ]");
		System.out.println();
		for(int i = 0; i < pieceList.length; i++) {
			System.out.println(i + 1 + " - " + Arrays.toString(pieceList[i]));
		}
		System.out.println();
		System.out.println("--------------------------------------------------------");
		// On appelle la méthode pour afficher le menu des pièces :
		Menu.displayPieceMenu(scanner, airplaneList, pieceList);

	}
}
