package parser;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;


import model.Option;
import model.Question;

public class CsvParser {
	
	public static ArrayList<Question> parseCsv(String path) {
		
		File f = new File(path);
		return parseCsv(f);
	}
	
	public static ArrayList<Question> parseCsv(File f) {
		
		ArrayList<Question> questions = new ArrayList<Question>();
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			int rowNumber = 0;
			while((line = br.readLine()) != null) {
				rowNumber++;
				String chapter, question, image;
				Boolean hasImage;
				ArrayList<Option> options = new ArrayList<Option>();
				String[] row = line.split("\t");
				
				if(row.length < 5) {
					System.out.println("Unexpected content found on line " + rowNumber + " of input file");
					continue;
				}
				
				// Capitolo
				String current = row[0];
				if(current.equals("")) continue;
				chapter = current;
				
				// Testo della domanda
				current = row[1];
				if(current.equals("")) continue;
				question = current;
				
				
				// Path dell'immagine (se c'è);
				current = row[2];
				hasImage = true;
				if(current.equals("")) {
					hasImage = false;
					image = "";
				}
				else 
				{
					hasImage = true;
					image = current;
				}
				
				
				// Opzione corretta
				current = row[3];
				if(current.equals("")) continue;
				options.add(new Option(current, true));
				
				
				// Opzione sbagliata 1 (obbligatoria)
				current = row[4];
				if(current.equals("")) continue;
				options.add(new Option(current, false));
				
				
				// Opzione sbagliata 2 (facoltativa)
				if(row.length > 5) {
					current = row[5];
					if(!current.equals("")) options.add(new Option(current, false));
				}
				
				// Opzione sbagliata 3 (facoltativa)
				if(row.length > 6) {
					current = row[6];
					if(!current.equals("")) options.add(new Option(current, false));
				}
				
				questions.add(new Question(chapter, question, hasImage, image, options));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return questions;
	}
}
