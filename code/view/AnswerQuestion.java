package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.text.JTextComponent;

import controller.Controller;
import controller.QuestionData;

public class AnswerQuestion extends ViewAbs{

	Controller m_controller;
	ArrayList<JButton> m_buttons;
	JFrame frame;
	
	public AnswerQuestion(Controller controller) {

		
		m_controller = controller;

		// Creazione della label per inserimento immagine in pannello blu (4)
		JLabel label = new JLabel();
		ImageIcon image2 = new ImageIcon("Effect_Aard.png");
		label.setIcon(image2);

		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout(10,10));
		frame.setVisible(true);
		frame.setResizable(false);
		
		// Creazione di tutti i pannelli insieme
		ArrayList<JPanel> panel = new ArrayList<JPanel>();
		
		for(int i=0; i<5; i++) {
			panel.add(new JPanel());
		}
		
		// DEBUGGING DA ELIMINARE
		panel.get(0).setBackground(Color.red);
		panel.get(1).setBackground(Color.green);
		panel.get(2).setBackground(Color.yellow);
		panel.get(3).setBackground(Color.magenta);
		panel.get(4).setBackground(Color.blue);
		
				
		panel.get(0).setPreferredSize(new Dimension(100,100));
		panel.get(1).setPreferredSize(new Dimension(150,100));
		panel.get(2).setPreferredSize(new Dimension(150,100));
		panel.get(3).setPreferredSize(new Dimension(100,200));
		panel.get(4).setPreferredSize(new Dimension(100,100));
		
		// Inserimento dell'immagine
		//ImageIcon pic = new ImageIcon("prova_img.png");
	    
	    //label.setIcon(pic);
		panel.get(4).add(label); //panel per immagine
		
		//inserimento del testo della domanda dal riferimento del controller
		panel.get(0).add(new JLabel(m_controller.getName()));
		
		// Inizializzazione dell'ArrayList dei bottoni
		m_buttons = new ArrayList<JButton>();
		addButtons();
		
		// Comandi per sistemare il layout dei pannelli: struttura a griglia
		panel.get(3).setLayout(new GridLayout(2, 2, 10, 10));
		
		// Aggiunta automatica dei bottoni alla pagina
		for (JButton b: m_buttons) {
			panel.get(3).add(b);
		}
		
		
		frame.add(panel.get(0),BorderLayout.NORTH);
		frame.add(panel.get(1),BorderLayout.WEST);
		frame.add(panel.get(2),BorderLayout.EAST);
		frame.add(panel.get(3),BorderLayout.SOUTH);
		frame.add(panel.get(4),BorderLayout.CENTER);
		
		// Comando per refreshare il contenuto del frame
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
	// Creazione di un bottone per ogni domanda
	public void addButtons() {
		for (QuestionData q: m_controller.getAnswer()) {
			JButton temp = new JButton(q.getOption().getText());
			temp.setBackground(q.getColor());
			temp.setOpaque(true);
			temp.setBorderPainted(false);
			temp.addActionListener(new ButtonListener(m_controller.getAnswer().indexOf(q)));  
			m_buttons.add(temp);
		}
	}
	
	// Disattivazione bottoni
	public void deactivateButtons() {
		for(JButton b: m_buttons) {
			b.setEnabled(false);
		}
	}
	
	// Cancellazione di tutti i bottoni delle risposte
	public void emptyButtons() {
		m_buttons.clear();
	}
	
	// Refresh dell'interfaccia
	public void refreshUI() {
		m_buttons.clear();
		addButtons();
	}
	 
	// ActionListener per i tasti
	public class ButtonListener implements ActionListener {
			
			private int m_number;
			
			public ButtonListener(int number) {
				m_number = number;
			}
	
			@Override
			public void actionPerformed(ActionEvent e) {
				m_controller.isRight(m_number);
				refreshUI();
				m_controller.loadQuestions();
				refreshUI();
			}
			
		}
	
	
	
}