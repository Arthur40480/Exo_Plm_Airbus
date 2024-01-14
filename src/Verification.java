import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Verification {
	
		// Méthode qui retourne le choix (pour les menus) de l'utilisateur une fois qu'il a été vérifié :
		public static int verificationMenu(Scanner scanner, String[] listChoicesMenu) {
			
			int userChoice;
			
			while(true) {
				if(scanner.hasNextInt()) {
					
					userChoice = scanner.nextInt();
					
					if(userChoice < 1 || userChoice > listChoicesMenu.length) {
						System.out.println("Désolé, votre saisie n'est pas valide. Veuillez réessayer en entrant un choix correct (1 - " + listChoicesMenu.length + ") :");
					}else {
						break;
					}
				}else {
					System.out.println("Désolé, votre saisie n'est pas valide. Veuillez réessayer en entrant un choix correct (1 - " + listChoicesMenu.length + ") :");
					scanner.next();
				}
			}
			return userChoice;
		}
		// Méthode qui retourne le choix (pour les avions) de l'utilisateur une fois qu'il a été vérifié :
		public static int verificationAirplane(Scanner scanner, ArrayList<HashMap<String, Object >> airplaneList) {
			
			int userChoice;
			
			while(true) {
				if(scanner.hasNextInt()) {
					
					userChoice = scanner.nextInt();
					
					if(userChoice < 1 || userChoice > airplaneList.size()) {
						System.out.println("Désolé, votre saisie n'est pas valide. Veuillez réessayer en entrant un choix correct (1 - " + airplaneList.size() + ") :");
					}else {
						break;
					}
				}else {
					System.out.println("Désolé, votre saisie n'est pas valide. Veuillez réessayer en entrant un choix correct (1 - " + airplaneList.size() + ") :");
					scanner.next();
				}
			}
			return userChoice;
		}
		// Méthode qui retourne le choix (pour les pièces) de l'utilisateur une fois qu'il a été vérifié :
		public static int verificationPiece(Scanner scanner, String[][] pieceList) {
			
			int userChoice;
			
			while(true) {
				if(scanner.hasNextInt()) {
					
					userChoice = scanner.nextInt();
					
					if(userChoice < 1 || userChoice > pieceList.length) {
						System.out.println("Désolé, votre saisie n'est pas valide. Veuillez réessayer en entrant un choix correct (1 - " + pieceList.length + ") :");
					}else {
						break;
					}
				}else {
					System.out.println("Désolé, votre saisie n'est pas valide. Veuillez réessayer en entrant un choix correct (1 - " + pieceList.length + ") :");
					scanner.next();
				}
			}
			return userChoice;
		}
		// Méthode qui retourne le choix (pour les pièces de l'avion séléctionner) de l'utilisateur une fois qu'il a été vérifié :
		public static int verificationAirplanePieceList(Scanner scanner, ArrayList<String[]> listAirplanePieceSelected) {
			
			int userChoice;
			
			while(true) {
				if(scanner.hasNextInt()) {
					
					userChoice = scanner.nextInt();
					
					if(userChoice < 1 || userChoice > listAirplanePieceSelected.size()) {
						System.out.println("Désolé, votre saisie n'est pas valide. Veuillez réessayer en entrant un choix correct (1 - " + listAirplanePieceSelected.size() + ") :");
					}else {
						break;
					}
				}else {
					System.out.println("Désolé, votre saisie n'est pas valide. Veuillez réessayer en entrant un choix correct (1 - " + listAirplanePieceSelected.size() + ") :");
					scanner.next();
				}
			}
			return userChoice;
		}
}
