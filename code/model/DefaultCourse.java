package model;

public class DefaultCourse {

	private Course c = new Course("Ingegneria del Software"); //inizializzo il nome del corso di default
	private Parser p = new Parser(); //parso il json
	//private ImageHandler ih = new ImageHandler(); //crea la lista di immagini
	
	public DefaultCourse(){
		//1° passo metto i quiz parsati dal parser nella lista del corso
		p.addParsedQuizToList(c.getQuizList());
		
		
		//2° passo metto le immagini nei rispettivi quiz della lista del corso
		//ih.addImageToQuiz(c.getQuizList());
	}
	
	public Course getDefaultCourse() {
		return c;
	}
	
	
	
}
