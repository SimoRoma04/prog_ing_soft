package model;

public class MainTest {
	public static void main(String[] args) {
		DefaultCourse cdc = new DefaultCourse();
		System.out.println(cdc.getDefaultCourse().getQuizList().get(0).getQuestion());
	}
}
