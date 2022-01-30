package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class QuizEnd {
	
	public QuizEnd() {
//CAMBIARE JFRAME CON JPANEL
	JFrame frame = new JFrame();
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(800, 600);
	frame.setLayout(new BorderLayout(10,10));
	frame.setVisible(true);
	
	ArrayList<JPanel> panel = new ArrayList<JPanel>();
	
	for(int i=0; i<5; i++) {
		panel.add(new JPanel());
	}
	
	/*
	panel.get(0).setBackground(Color.red);
	panel.get(1).setBackground(Color.green);
	panel.get(2).setBackground(Color.yellow);
	panel.get(3).setBackground(Color.magenta);
	panel.get(4).setBackground(Color.blue);
	*/
	
	panel.get(4).setLayout(new BorderLayout());
			
	panel.get(0).setPreferredSize(new Dimension(100,150));
	panel.get(1).setPreferredSize(new Dimension(100,250));
	panel.get(2).setPreferredSize(new Dimension(100,100));
	panel.get(3).setPreferredSize(new Dimension(100,200));
	panel.get(4).setPreferredSize(new Dimension(100,100));
	
	//------------- sub panels --------------------
	
	JPanel sup = new JPanel();
	JPanel inf = new JPanel();
	sup.setPreferredSize(new Dimension(100, 100));
	inf.setPreferredSize(new Dimension(100, 100));
	//sup.setBackground(Color.orange);
	//inf.setBackground(Color.pink);
	
	//lavoro sul pannello sup in cui inserirò la progress bar
	JProgressBar progress = new JProgressBar(0, 100);
	
//SOSTITUIRE A 60 IL VALORE PERCENTUALE OTTENUTO	
	progress.setValue(60); // inserire il punteggio (percentuale) ottenuto
	progress.setStringPainted(true);
	//UIManager.put("ProgressBar.background", Color.BLACK);
    UIManager.put("ProgressBar.foreground", Color.GREEN);
    UIManager.put("ProgressBar.selectionBackground", Color.YELLOW);
    UIManager.put("ProgressBar.selectionForeground", Color.BLUE);
    
    progress.setPreferredSize(new Dimension(550, 40));
    
    progress.setFont(new Font("Roboto", 5, 25));
	sup.add(progress);
	
	panel.get(4).setLayout(new BorderLayout());
	
	//lavoro sul pannello inf in cui scrivo quante risposte corrette sono state date
//SOSTITUIRE AI VALORI LE FUNZIONI PER IL PUNTEGGIO
	JLabel testoRisposte = new JLabel("<html>Hai risposto correttamente a " + 10 + " domande su " + 12);
	testoRisposte.setPreferredSize(new Dimension(550, 75));
	testoRisposte.setFont(new Font("Arial", 5 , 24));
	inf.add(testoRisposte);

	
	panel.get(4).add(inf, BorderLayout.SOUTH);
	panel.get(4).add(sup, BorderLayout.NORTH);
	
	//lavoro sul pannello principale in alto
//SOSTITUIRE A capitolo N IL CAPITOLO EFFETTIVO	
	JLabel testoFineCapitolo = new JLabel("QUIZ SUL " + "capitolo N" + " COMPLETATO!");
	testoFineCapitolo.setPreferredSize(new Dimension(700, 100));
	testoFineCapitolo.setFont(new Font("Arial", 5 , 40));
	panel.get(0).add(testoFineCapitolo);
	
	//lavoro sul pannello principale in basso
	JButton homeButton = new JButton("TORNA ALLA HOME");
	
//AGGINUGERE FUNZIONALITA' AL BOTTONE
	homeButton.addActionListener(e -> System.out.println("torno alla home"));
	homeButton.setPreferredSize(new Dimension(300, 75));
	panel.get(3).add(homeButton);
	
	
	//------------- sub panels --------------------

	frame.add(panel.get(0),BorderLayout.NORTH);
	frame.add(panel.get(1),BorderLayout.WEST);
	frame.add(panel.get(2),BorderLayout.EAST);
	frame.add(panel.get(3),BorderLayout.SOUTH);
	frame.add(panel.get(4),BorderLayout.CENTER);
	
	//comando per refreshare
	SwingUtilities.updateComponentTreeUI(frame);
	}
}