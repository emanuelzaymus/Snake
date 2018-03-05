package snake.gamecomponent;

import java.awt.Color;

public class SnakeLink extends Element {

    public SnakeLink(int x, int y, int width, int height) {
        super(x, y, width, height, Color.GREEN);
    }

    @Override
    protected void step(int deltaX, int deltaY) {
        super.step(deltaX, deltaY);
    }

    @Override
    protected void setPosition(int x, int y) {
        super.setPosition(x, y);
    }

}
