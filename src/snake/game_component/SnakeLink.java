package snake.game_component;

import java.awt.*;

public class SnakeLink extends Element {

    public SnakeLink(int x, int y, int width, int height) {
        super(x, y, width, height, Color.GREEN);
    }

    @Override
    protected void step(int deltaX, int deltaY) {
        super.step(deltaX, deltaY);
    }
}
