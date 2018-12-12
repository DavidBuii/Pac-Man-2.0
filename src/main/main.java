package main;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import Game.PacmanGame;
import GameInfrastructure.Display;
import GameInfrastructure.Game;

public class main {

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				Game game = new PacmanGame();
				Display view = new Display(game);
				JFrame frame = new JFrame();
				frame.setTitle("Pacman 2.0");
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.getContentPane().add(view);
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);
				view.requestFocus();
				view.start();
			}

		});

	}

}
