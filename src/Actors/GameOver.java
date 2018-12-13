package Actors;

import Game.PacmanActor;
import Game.PacmanGame;
import Game.PacmanGame.State;

public class GameOver extends PacmanActor{

	public GameOver(PacmanGame game) {
		super(game);
	}

	@Override
	public void init() {
		x = 77;
		y = 160;
		loadFrames("/res/gameover.png");
		System.out.println("Hello GAMEOVER");
		
		//updateGameOver();
	}


	@Override
	public void updateGameOver() {

		game.returnToREADY();

	}

	// broadcast messages

	@Override
	public void stateChanged() {
		visible = false;
		if (game.state == State.GAME_OVER) {
			visible = true;
		}
	}
}
