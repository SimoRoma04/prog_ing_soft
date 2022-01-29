package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;
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

public class AnswerQuestion implements ViewInterface{

	TestController m_controller;
	ArrayList<JButton> m_buttons;
	
	public AnswerQuestion(TestController controller) {

		// Layout Manager = Defines the natural layout for components within a container
		
		// 3 common managers
		
		// BorderLayout = 	A BorderLayout places components in five areas: NORTH,SOUTH,WEST,EAST,CENTER. 
		//					All extra space is placed in the center area.
		
		m_controller = controller;

		// Creazione della label per inserimento immagine in pannello blu (4)
		JLabel label = new JLabel();
		ImageIcon image2 = new ImageIcon("Effect_Aard.png");
		label.setIcon(image2);

		JFrame frame = new JFrame();
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
		
		//------------- sub panels --------------------
		/*
		ArrayList<JPanel> subPanel = new ArrayList<JPanel>();
		
			for(int i=0; i<5; i++) {
				subPanel.add(new JPanel());
			}
		
		
		subPanel.get(0).setBackground(Color.black);
		subPanel.get(1).setBackground(Color.darkGray);
		subPanel.get(2).setBackground(Color.gray);
		subPanel.get(3).setBackground(Color.lightGray);
		subPanel.get(4).setBackground(Color.white);
		
		panel.get(4).setLayout(new BorderLayout());
		
		for(int i=0; i<5; i++) {
			subPanel.get(i).setPreferredSize(new Dimension(50,50));
		}
		
		
		
		panel.get(3).add(subPanel.get(0),BorderLayout.NORTH);
		panel.get(3).add(subPanel.get(1),BorderLayout.SOUTH);
		panel.get(3).add(subPanel.get(2),BorderLayout.WEST);
		panel.get(3).add(subPanel.get(3),BorderLayout.EAST);
		panel.get(3).add(subPanel.get(4),BorderLayout.CENTER);
		*/
		//------------- sub panels --------------------
		
		// Inizializzazione dell'ArrayList dei bottoni
		m_buttons = new ArrayList<JButton>();
		
		// Creazione di un bottone per ogni domanda
		for (String s: m_controller.getAnswer()) {
			JButton temp = new JButton(s);
			temp.addActionListener(e -> System.out.println("prova pulsante" + s));  //al posto della stringa bisogna inserire il metodo che viene invocato
			m_buttons.add(temp);
		}
		
		
		// SUCCESSIVAMENTE: introdurre modo per disabilitare i bottoni
		
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

	@Override
	public JPanel refresh() {
		// TODO Auto-generated method stub
		return null;
	}
}