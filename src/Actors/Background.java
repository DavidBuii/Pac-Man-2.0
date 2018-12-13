package Actors;

import java.awt.Color;
import java.awt.Graphics2D;

import Game.PacmanActor;
import Game.PacmanGame;
import Game.PacmanGame.State;


public class Background extends PacmanActor{

	public Background(PacmanGame game) {
		super(game);
	}

	@Override
	public void init() {
		loadFrames("/res/background_0.png", "/res/background_1.png");
	}

	@Override
	public void updateLevelCleared() {
		yield:
			while (true) {
					visible = true;
					game.nextLevel();
					break yield;
				}
			}


	//Shows Background

	@Override
	public void stateChanged() {
		if (game.getState() == State.GAMESTART) {
			visible = true;
		}
	}

	public void hideAll() {
		visible = false;
	}

}
