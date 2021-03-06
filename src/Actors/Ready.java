package Actors;

import Game.PacmanActor;
import Game.PacmanGame;
import Game.PacmanGame.State;

public class Ready extends PacmanActor{
	 public Ready(PacmanGame game) {
	        super(game);
	    }

	    @Override
	    public void init() {
	        x = 11 * 8;
	        y = 20 * 8;
	        loadFrames("/res/ready.png");
	    }

	    @Override
	    public void updateStart() {

	    	yield:
	        while (true) {
	                    game.setState(State.READY);
	                    break yield;            
	        }
	    }
	    
	    @Override
	    public void updateReady() {
	        yield:
	        while (true) {
	            switch (instructionPointer) {
	                case 0:
	                    game.broadcastMessage("showAll");
	                    waitTime = System.currentTimeMillis();
	                    instructionPointer = 1;
	                case 1:
	                    if (System.currentTimeMillis() - waitTime < 2000) { // || game.sounds.get("start").isPlaying()) {
	                        break yield;
	                    }
	                    game.setState(State.PLAYING);
	                    break yield;
	            }
	        }
	    }

	    // broadcast messages

	    @Override
	    public void stateChanged() {
	        visible = false;
	        if (game.getState() == PacmanGame.State.GAMESTART 
	                || game.getState() == PacmanGame.State.READY) {
	            
	            visible = true;
	            instructionPointer = 0;
	        }
	    }
}
