import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class Menu {
	
	//Méthode pour afficher le menu principale et récupérer la choix de l'utilisateur :
	public static void displayMainMenu(Scanner scanner, ArrayList<HashMap<String, Object >> airplaneList, String[][] pieceList) {
		System.out.println();
		System.out.println("******************** Menu Principale ********************");
		System.out.println();
		String [] mainMenu = {
				"1 - Afficher la liste des avions",
				"2 - Afficher la liste des avions suivant un mot-clé spécifié",
				"3 - Ajouter ou supprimer une pièce d'un avion choisi",
				"4 - Afficher un avion avec toutes ses infos détaillées",
				"5 - Quitter l'application"
		};		
		
		for(String option : mainMenu) {
			System.out.println(option);
		}
		System.out.println();
		System.out.println("**********************************************************");
		System.out.print("Veuillez saisir l'option de votre choix : ");

		int userChoice = Verification.verificationMenu(scanner, mainMenu); // On retourne le choix de l'utilisateur, une fois vérifié
		
		switch(userChoice) {
			case 1:
				Display.displayAllAirplanes(scanner, airplaneList, pieceList);
				break;
			case 2:
				Display.displayAirplaneKeyword(airplaneList, scanner, pieceList);
				break;
			case 3:
				Menu.displayPieceMenu(scanner, airplaneList, pieceList);
				break;
			case 4:
				Display.displayInformationFromAirplane(scanner, airplaneList);
				break;
			case 5:
				System.out.println();
				System.out.println("A bientôt !");
				System.exit(0);
		}
	}
	
	//Méthode pour afficher le menu des pièces et récupérer la choix de l'utilisateur :
	public static void displayPieceMenu(Scanner scanner, ArrayList<HashMap<String, Object >> airplaneList, String[][] pieceList) {
		System.out.println();
		System.out.println("*********************** Menu Pièce ***********************");
		System.out.println();
		String [] pieceMenu = {
				"1 - Afficher toutes les pièces disponible",
				"2 - Ajouter une pièce",
				"3 - Suprimer un pièce",
				"4 - Quitter la boutique de pièce"
		};
		
		for(String option : pieceMenu) {
			System.out.println(option);
		}
		System.out.println();
		System.out.println("**********************************************************");
		System.out.print("Veuillez saisir l'option de votre choix : ");

		int userChoice = Verification.verificationMenu(scanner, pieceMenu); // On retourne le choix de l'utilisateur, une fois vérifié
		
		switch(userChoice) {
		case 1:
			Display.displayAllPieces(airplaneList, scanner, pieceList);
			break;
		case 2:
			Piece.addPiece(scanner, pieceList, airplaneList);
			break;
		case 3:
			Piece.removePiece(scanner, pieceList, airplaneList);
			break;
		case 4:
			Menu.displayMainMenu(scanner, airplaneList, pieceList);
			break;
		}
	}
}
