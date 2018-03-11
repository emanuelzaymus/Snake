package snake.gamecomponent;

import snake.C;
import snake.SnakePanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

public abstract class Element extends Component {

    protected int y;
    protected int x;
    protected int width;
    protected int height;

    public Element(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public int getX() {
        return x;
    }

    public abstract void draw(Graphics g);

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
