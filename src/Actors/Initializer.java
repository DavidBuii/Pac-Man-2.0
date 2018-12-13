package Actors;

import Game.PacmanActor;
import Game.PacmanGame;
import Game.PacmanGame.State;

public class Initializer extends PacmanActor{

	public Initializer(PacmanGame game) {
		super(game);
	}

	@Override
	public void updateInitializing() {
		yield:
			while (true) {
				game.setState(State.GAMESTART);
				break yield;
			}
	}
}
