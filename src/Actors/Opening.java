package Actors;

import java.awt.Graphics2D;

import Game.PacmanGame.State;

public class Opening extends Game.PacmanActor{
	private String text = "Pacman 2.0";
    private int textIndex;

    public Opening(Game.PacmanGame game) {
        super(game);
    }

    @Override
    public void updateDBPresents() {
        yield:
        while (true) {
            switch (instructionPointer) {
                case 0:
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 1;
                case 1:
                    while (System.currentTimeMillis() - waitTime < 100) {
                        break yield;
                    }
                    textIndex++;
                    if (textIndex < text.length()) {
                        instructionPointer = 0;
                        break yield;
                    }
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 2;
                case 2:
                    while (System.currentTimeMillis() - waitTime < 3000) {
                        break yield;
                    }
                    visible = false;
                    waitTime = System.currentTimeMillis();
                    instructionPointer = 3;
                case 3:
                    while (System.currentTimeMillis() - waitTime < 1500) {
                        break yield;
                    }
                    game.setState(State.TITLE);
                    break yield;
            }
        }
    }

    @Override
    public void draw(Graphics2D g) {
        if (!visible) {
            return;
        }
        game.drawText(g, text.substring(0, textIndex), 60, 130);
    }

    
    // broadcast messages
    
    @Override
    public void stateChanged() {
        visible = false;
        if (game.state == State.DB_PRESENTS) {
            visible = true;
            textIndex = 0;
        }
    }
}
