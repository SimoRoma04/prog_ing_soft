package controller;

import java.awt.Color;
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
	
	public void loadQuestions() {
		ArrayList<QuestionData> temp = new ArrayList<QuestionData>();
		
		// Problema: non funziona se la lista è vuota
		// Carica le opzioni per la domanda corrente
		for(Option o: m_course.getQuizList().get(m_currentQuestion).getOptions()) {
			temp.add(new QuestionData(o, Color.GRAY));
		}
		
		// Carica titolo e immagine
		m_questionText = m_course.getQuizList().get(m_currentQuestion).getText();
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
				q.m_color = Color.GREEN;
			else
				q.m_color = Color.RED;
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
	
	
	public ArrayList<QuestionData> getQuestionData() {
		return m_questionData;
	}
	
	public String getQuestionText() {
		return m_questionText;
	}
	
	public int getScore() {
		return m_gameScore;
	}
	
	public Image getImage() {
		return m_image;
	}
	
	// Invocato dalla view per ottenere le domande
	public ArrayList<QuestionData> getAnswer() {
		return m_questionData;
	}
	

}
