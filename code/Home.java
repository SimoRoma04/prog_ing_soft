import java.util.ArrayList;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.*;

public class Home {

	TestController m_controller;
	
	public Home(TestController controller) {
		m_controller = controller;
		
		JLabel label = new JLabel();
		ImageIcon image2 =new ImageIcon("Effect_Aard.png");
		label.setIcon(image2);
		
		int larghezza = 800;
		int altezza = 600;
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(larghezza, altezza);
		frame.setResizable(false);
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
		
		
		//lavoro sul pannello 3 per l'aggiunta dei tasti di inizio
		JButton startButton = new JButton("START QUIZ");
		startButton.setFont(new Font("Arial", Font.BOLD, 18));
		
		JButton settings = new JButton("SETTINGS");
		
		
		panel.get(3).setLayout(new GridLayout(3, 2, 10, 10));

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		frame.add(panel.get(0),BorderLayout.NORTH);
		frame.add(panel.get(1),BorderLayout.WEST);
		frame.add(panel.get(2),BorderLayout.EAST);
		frame.add(panel.get(3),BorderLayout.SOUTH);
		frame.add(panel.get(4),BorderLayout.CENTER);
		
		SwingUtilities.updateComponentTreeUI(frame);
	}
	
}
