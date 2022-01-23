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

public class AnswerQuestion extends ViewAbs{

	TestController m_controller;
	
	public AnswerQuestion(TestController controller) {

		// Layout Manager = Defines the natural layout for components within a container
		
		// 3 common managers
		
		// BorderLayout = 	A BorderLayout places components in five areas: NORTH,SOUTH,WEST,EAST,CENTER. 
		//					All extra space is placed in the center area.
		
		m_controller = controller;


		JLabel label = new JLabel();
		ImageIcon image2 =new ImageIcon("Effect_Aard.png");
		label.setIcon(image2);

		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800, 600);
		frame.setLayout(new BorderLayout(10,10));
		frame.setVisible(true);
		
		ArrayList<JPanel> panel = new ArrayList<JPanel>();
		
		for(int i=0; i<5; i++) {
			panel.add(new JPanel());
		}
		
		//DEBUGGING DA ELIMINARE
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
		
		//inserimento dell'immagine
		//ImageIcon pic = new ImageIcon("prova_img.png");
	    
	    //label.setIcon(pic);
		panel.get(4).add(label);
		
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
		
		//creazione e aggiunta bottoni con i rispettivi Action Listener
		JButton ris1 = new JButton(m_controller.getAnswer().get(0)); //tra parantesi ci vuole il testo della domanda
		ris1.addActionListener(e -> System.out.println("prova pulsante 1"));
		JButton ris2 = new JButton(m_controller.getAnswer().get(1));
		ris2.addActionListener(e -> System.out.println("prova pulsante 2")); //al posto della stringa bisogna inserire il metodo che viene invocato
		JButton ris3 = new JButton(m_controller.getAnswer().get(2));
		ris3.addActionListener(e -> System.out.println("prova pulsante 3"));
		JButton ris4 = new JButton(m_controller.getAnswer().get(3));
		ris4.addActionListener(e -> System.out.println("prova pulsante 4"));
		
		//SUCCESSIVAMENTE: introdurre modo per disabilitare i bottoni
		
		//comandi per sistemare il layout dei pannelli
		panel.get(3).setLayout(new GridLayout(2, 2, 10, 10));
		
		panel.get(3).add(ris1);
		panel.get(3).add(ris2);
		panel.get(3).add(ris3);
		panel.get(3).add(ris4);
		
		frame.add(panel.get(0),BorderLayout.NORTH);
		frame.add(panel.get(1),BorderLayout.WEST);
		frame.add(panel.get(2),BorderLayout.EAST);
		frame.add(panel.get(3),BorderLayout.SOUTH);
		frame.add(panel.get(4),BorderLayout.CENTER);
		
		SwingUtilities.updateComponentTreeUI(frame);
	}
}