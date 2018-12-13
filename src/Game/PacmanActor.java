package Game;

import GameInfrastructure.Actor;

public class PacmanActor extends Actor<PacmanGame>{

	public PacmanActor(PacmanGame game) {
		super(game);
	}

	@Override
	public void update() {
		switch (game.getState()) {
		case INITIALIZING: updateInitializing(); break;
		case GAMESTART: updateReady(); break;
		case READY2: updateReady2(); break;
		case PLAYING: updatePlaying(); break;
		case PACMAN_DIED: updatePacmanDied(); break;
		case GHOST_CATCHED: updateGhostCatched(); break;
		case LEVEL_CLEARED: updateLevelCleared(); break;
		//case GAME_OVER: updateGameOver(); break;
		}
	}

	public void updateInitializing() {
	}


	public void updateReady() {
	}

	public void updateReady2() {
	}

	public void updatePlaying() {
	}

	public void updatePacmanDied() {
	}

	public void updateGhostCatched() {
	}

	public void updateLevelCleared() {
	}

	public void updateGameOver() {
	}

	// broadcast messages

	public void stateChanged() {
	}

}
