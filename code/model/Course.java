package model;
import java.util.ArrayList;

public class Course {
	private String name;
	private ArrayList<Question> quizList;
	 
	public Course(String name){
		this.name=name;
		quizList = new ArrayList<Question>();
	}
	
	//methods
	public ArrayList<Question> getQuizList(){
		return quizList;
	}
	
	public String getName(){
		return name;
	}
	
	 public void addQuiz(Question q){
		 quizList.add(q);
	 }
	 
	 public void removeQuiz(Question q){
		 quizList.remove(q);
	 }
	 
}
