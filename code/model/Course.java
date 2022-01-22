package model;
import java.util.ArrayList;

public class Course {
	private String name;
	private ArrayList<Quiz> quizList;
	 
	public Course(String name){
		this.name=name;
		quizList = new ArrayList<Quiz>();
	}
	
	//methods
	public ArrayList<Quiz> getQuizList(){
		return quizList;
	}
	
	public String getName(){
		return name;
	}
	
	 public void addQuiz(Quiz q){
		 quizList.add(q);
	 }
	 
	 public void removeQuiz(Quiz q){
		 quizList.remove(q);
	 }
	 
}
