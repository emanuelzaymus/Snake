package snake.gamecomponent;

import snake.C;

import java.awt.Color;
import java.awt.Graphics;

public class SnakeLink extends Element {

    protected Color color = Color.green;
    protected final int linkArc = 10;

    public SnakeLink(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
//        g.fillRect(x  * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET, width, height);
        g.fillRoundRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET, width, height, linkArc, linkArc);
    }

    @Override
    protected void step(int deltaX, int deltaY) {
        super.step(deltaX, deltaY);
    }

    @Override
    protected void setPosition(int x, int y) {
        super.setPosition(x, y);
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
