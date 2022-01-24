package parser;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import model.Option;
import model.Quiz;

public class CsvParser {
	
	static ArrayList<Quiz> parseCsv(File f) {
		
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			while((line = br.readLine()) != null) {
				String chapter, question, image, rightOption;
				Boolean hasImage;
				ArrayList<Option> options = new ArrayList<Option>();
				
				StringTokenizer st = new StringTokenizer(line, ";");
				
				// Capitolo
				String current = st.nextToken();
				if(current.equals(""))
					chapter = "Capitolo non specificato";
				else
					chapter = current;
				
				// Testo della domanda
				current = st.nextToken();
				if(current.equals(""))
					question = "Domanda mancante";
				else
					question = current;
				
				// Path dell'immagine (se c'è);
				current = st.nextToken();
				if(current.equals("")) {
					hasImage = false;
					image = "";
				}
				else {
					hasImage = true;
					image = current;
				}
				
				// Opzione corretta
				current = st.nextToken();
				options.add(new Option(current, true));
				
				// Aggiunta delle altre risposte
				while(st.hasMoreTokens()) {
					current = st.nextToken();
					if(current.equals(""))
						break;
					options.add(new Option(current, false));
				}
				
				quizzes.add(new Quiz(chapter, question, hasImage, image, options));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return quizzes; 
		
	}
}
