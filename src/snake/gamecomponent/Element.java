package snake.gamecomponent;

import snake.C;
import snake.SnakePanel;

import java.awt.*;

public class Element extends Component {

    private int y;
    private int x;
    private int width;
    private int height;
    private Color color;

    public Element(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    public void draw(Graphics g, Component component) {
        g.setColor(color);
        g.fillRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET, width, height);
    }

    public void addComponent(SnakePanel snakePanel) {
        snakePanel.add(this);
    }

    protected void step(int deltaX, int deltaY) {
        x += deltaX;
        y += deltaY;
    }

    protected void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
