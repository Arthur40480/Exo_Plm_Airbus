import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Piece {
	
	// Méthode permettant d'ajouter une pièce à un certain avion :
	public static void addPiece(Scanner scanner, String[][] pieceList, ArrayList<HashMap<String, Object >> airplaneList) {
		System.out.println();
		System.out.print("Saisissez l'id de l'avion concerné : ");
		int idAirplaneSelected = (Verification.verificationAirplane(scanner, airplaneList)) - 1;
		boolean addPieceAgain = true;
		
		while(addPieceAgain == true) {
			// On crée une référence à la HashMap sélectionnée :
			HashMap<String, Object> airplaneSelected = airplaneList.get(idAirplaneSelected);
			@SuppressWarnings("unchecked")
			
			// On crée une référence à la liste de pièce de la HashMap sélectionnée :
			ArrayList<String[]> listAirplanePieceSelected = (ArrayList<String[]>) airplaneSelected.get("piece");
			
			System.out.println("----------------------------------------------------------");
			System.out.println( 
								airplaneList.get(idAirplaneSelected).get("id") + " - " + 
								airplaneList.get(idAirplaneSelected).get("program") + " - " + 
								airplaneList.get(idAirplaneSelected).get("type") + " - " + 
								airplaneList.get(idAirplaneSelected).get("currentPhase") + " - Pièces: "
								);
			// On boucle sur la liste de pièce pour afficher le nom des pièces présente :
			for(String[] piece : listAirplanePieceSelected) {
				System.out.print(piece[0] + " " );
			}
			System.out.println();
			System.out.println("----------------------------------------------------------");
			
			System.out.print("Saisissez l'id de la pièce à ajouter : ");
			int idPieceSelected = Verification.verificationPiece(scanner, pieceList);
			String[] pieceAndInformationToAdd = pieceList[idPieceSelected - 1];
			
			// On ajoute la pièce à la liste de pièces de l'avion sélectionné :
			listAirplanePieceSelected.add(pieceAndInformationToAdd);
			System.out.println("Vous avez ajouté la pièce : " + pieceList[idPieceSelected - 1][0]);
			System.out.println("----------------------------------------------------------");
			System.out.println("Voulez - vous ajouter une autre pièce pour cet avion ? (Oui/Non) :");
			String userResponse = scanner.next();
			if(!userResponse.equals("Oui")) {
				addPieceAgain = false;
			}
			
		}
		// On appelle la méthode pour afficher le menu des pièces :
		Menu.displayPieceMenu(scanner, airplaneList, pieceList);	
	}
	
	// Méthode permettant de supprimer une pièce d'un certain avion :
	public static void removePiece(Scanner scanner, String[][] pieceList, ArrayList<HashMap<String, Object >> airplaneList) {
		System.out.println();
		System.out.print("Saisissez l'id de l'avion concerné : ");
		int idAirplaneSelected = (Verification.verificationAirplane(scanner, airplaneList)) -1;
		boolean removePieceAgain = true;
		
		while(removePieceAgain == true) {
			int indicePiece = 1;
			// On crée une référence à la HashMap sélectionnée :
			HashMap<String, Object> airplaneSelected = airplaneList.get(idAirplaneSelected);
			@SuppressWarnings("unchecked")
			
			// On crée une référence à la liste de pièce de la HashMap sélectionnée :
			ArrayList<String[]> listAirplanePieceSelected = (ArrayList<String[]>) airplaneSelected.get("piece");
			
			System.out.println("----------------------------------------------------------");
			System.out.println( 
								airplaneList.get(idAirplaneSelected).get("id") + " - " + 
								airplaneList.get(idAirplaneSelected).get("program") + " - " + 
								airplaneList.get(idAirplaneSelected).get("type") + " - " + 
								airplaneList.get(idAirplaneSelected).get("currentPhase") + " - Pièces: "
								);
			if(listAirplanePieceSelected.size() == 0) {
				System.out.println();
				System.out.println("La liste de pièce pour cet avion est vide pour le moment !");
				Menu.displayPieceMenu(scanner, airplaneList, pieceList);
			}
			System.out.println();
			// On boucle sur la liste de pièce pour afficher le nom des pièces présente ainsi que leurs id :
			for(String[] piece : listAirplanePieceSelected) {
				System.out.println("id: " + indicePiece + " -> " + piece[0]);
				indicePiece = indicePiece + 1;
			}
			
			System.out.println();
			System.out.print("Saisissez l'id de la pièce à supprimer: ");
			int idPieceSelected = Verification.verificationAirplanePieceList(scanner, listAirplanePieceSelected);
			listAirplanePieceSelected.remove(idPieceSelected - 1);
			System.out.println("----------------------------------------------------------");
			System.out.println("Voulez - vous supprimer une autre pièce pour cet avion ? (Oui/Non) :");
			String userResponse = scanner.next();
			if(!userResponse.equals("Oui")) {
				removePieceAgain = false;
			}
		}
		// On appelle la méthode pour afficher le menu des pièces :
		Menu.displayPieceMenu(scanner, airplaneList, pieceList);	
		System.out.println();
		System.out.println("----------------------------------------------------------");
	}
}
