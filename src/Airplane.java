import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Airplane {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] program = {"A320", "A400M", "A380", "A340", "A350XWB"};
		String[] currentPhase = {"ETUDE_DE_FAISABILITE", "CONCEPTION", "DEFINITION", "CONSTRUCTION", "EN_SERVICE", "CLOTURE"};
		String[] type = {"Fret", "Transport de passager", "Militaire", "Avions d'affaires", "Avion de Collection"};
		String[][] pieceList = {
				{"Compas", "Navigation", "5000"},
				{"GPS", "Navigation", "10000"},
				{"Indicateur de vitesse", "Pilotage", "3000"},
				{"Indicateur d'altitude", "Pilotage", "7000"},
				{"Altimètre", "Pilotage", "3600"},
				{"Radar météo", "Environement du vol", "9000"},
				{"Système anti-collision", "Environement du vol", "5500"}
		};
		
		// CREATION DE LA LISTE D'AVION / PIECES :
		ArrayList<HashMap<String, Object >> airplaneList = new ArrayList<>();
		
		// CREATION DES AVIONS :
		for(int i = 0; i < 5; i++) {
			HashMap<String, Object> airplane = new HashMap<>();
			ArrayList<String[]> airplanePiece = new ArrayList<>();

			airplane.put("id", String.valueOf(i + 1));
			airplane.put("program", program[i]);
			airplane.put("currentPhase", currentPhase[i]);
			airplane.put("type", type[i]);
			airplane.put("piece", airplanePiece);
			
			airplaneList.add(airplane);
		}
		
		// DEBUT DU PROGRAMME, APPEL DU MENU PRINCIPAL:
		Menu.displayMainMenu(scanner, airplaneList, pieceList);
		scanner.close();
	}
	
}
