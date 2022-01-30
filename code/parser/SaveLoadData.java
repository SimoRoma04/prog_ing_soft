package parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.StringTokenizer;


public class SaveLoadData {
	
	public static LinkedHashMap<String, SavedDataFormat> loadData(String path) {
			
			File f = new File(path);
			return loadData(f);
	}
	
	public static LinkedHashMap<String, SavedDataFormat> loadData(File f) {
		
		LinkedHashMap<String, SavedDataFormat> ll = new LinkedHashMap<String, SavedDataFormat>();
		
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			
			String line;
			
			while((line = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line, "\t");
				String chapterName = st.nextToken();
				ArrayList<Integer> scores = new ArrayList<Integer>();
				
				while(st.hasMoreTokens())
					scores.add(Integer.parseInt(st.nextToken()));
					
				ll.put(chapterName, new SavedDataFormat(chapterName, scores));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ll;
	}
}
