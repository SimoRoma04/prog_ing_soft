package model;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class ImageHandler {
	ArrayList<Image> imageList;
	//ArrayList<Quiz> quizList;
	
	public ImageHandler(){
		for(int i=0; i<20; i++){ //size della directory con le immagini, oppure hardcode perchè sai quante immagini ci sono
			String s = Integer.toString(i);
			ImageIcon ic = new ImageIcon(i+".png"); 
			Image img = new Image(s,ic);
			imageList.add(img);
		}	
	}
	
	
	public void addImageToQuiz(ArrayList<Quiz> ql) {
		for(Quiz q : ql) {
			if(q.getHasImage()) {  //se il flag image è true
				for(Image i : imageList) {
					if(q.getName() == i.getName()) {
						q.setImage(i);
					}
				}
			}
		}
	}
	
	
}
