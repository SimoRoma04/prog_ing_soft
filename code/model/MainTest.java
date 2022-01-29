package model;

import java.io.File;
import java.util.ArrayList;

import parser.CsvParser;

public class MainTest {
	public static void main(String[] args) {
		//DefaultCourse cdc = new DefaultCourse();
		ArrayList<Option> optionList = new ArrayList<Option>();
		optionList.add(new Option("right", true));
		optionList.add(new Option("wrong", false));
		optionList.add(new Option("wrong", false));
		optionList.add(new Option("wrong", false));
		
		ArrayList<Question> questionList = CsvParser.parseCsv("./docs/domande.tsv");
		System.out.println(questionList.size());		
		
		Question w = questionList.get(0); 
		//System.out.println(cdc.getDefaultCourse().getQuizList().get(0).getText());
	}
}
