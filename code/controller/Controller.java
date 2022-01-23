package controller;

import java.util.ArrayList;

import model.Course;
import model.Image;
import model.Option;

public class Controller extends ControllerAbs {
	
	// Campi globali
	private Course m_course;
	private int m_currentQuestion;
	private int m_gameScore;
	
	// Campi per la domanda corrente
	private ArrayList<QuestionData> m_questionData;
	private String m_questionText;
	private Image m_image;
	
	public Controller(String name, Course course) {
		super(name);
		m_currentQuestion = 0;
		
		m_course = course;
		
		loadQuestions();
	}
	
	private void loadQuestions() {
		ArrayList<QuestionData> temp = new ArrayList<QuestionData>();
		
		// Problema: non funziona se la lista è vuota
		// Carica le opzioni per la domanda corrente
		for(Option o: m_course.getQuizList().get(m_currentQuestion).getOptions()) {
			temp.add(new QuestionData(o, "grey"));
		}
		
		// Carica titolo e immagine
		m_questionText = m_course.getQuizList().get(m_currentQuestion).getName();
		if(m_course.getQuizList().get(m_currentQuestion).getHasImage())
			m_image = m_course.getQuizList().get(m_currentQuestion).getImage();
		else
			m_image = null;
		
		
		m_questionData = temp;
	}
	
	// Invocata alla pressione dei tasti risposta
	public void isRight(int numTasto) {
		
		// Controlla se il bottone schiacciato corrisponde alla risposta corretta
		// (se sì, aggiungi punti)
		if(m_questionData.get(numTasto).getOption().getIsRight())
			m_gameScore++;
		
		// Cambia colore a tutti i tasti, in base alla correttezza del contenuto
		for(QuestionData q: m_questionData) {
			if(q.getOption().getIsRight())
				q.color = "green";
			else
				q.color = "red";
		}
		
		// Avanza il cursore della domanda corrente
		m_currentQuestion++;
		
		// Carica la domanda successiva dopo 5 secondi
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		loadQuestions();
	}
	
	
}
