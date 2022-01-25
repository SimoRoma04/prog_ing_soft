package model;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.Module;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.swing.ImageIcon;

public class Parser {
	ObjectMapper objectMapper = new ObjectMapper();	
	File file = new File("prova.json");
	ArrayList<Question> quizList;
	
	
	public Parser() {
		try {
			quizList = objectMapper.readValue(file, new TypeReference<ArrayList<Question>>(){});
		} catch (StreamReadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DatabindException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	
	public void addParsedQuizToList(ArrayList<Question> ql) {
		for(Question q : quizList) {
			ql.add(q);
		}
	}
}
