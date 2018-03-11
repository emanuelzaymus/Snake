package snake.gamecomponent;

import snake.C;
import snake.Direction;

import java.awt.*;

public class SnakeHead extends SnakeLink {

    private Direction direct;
    private final int eyeDiameter = 7;

    public SnakeHead(int x, int y, int width, int height, Direction direct) {
        super(x, y, width, height);
        this.direct = direct;
    }

    public void setDirection(Direction direct) {
        this.direct = direct;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x * C.RESOLUTION + C.OFFSET - 1, y * C.RESOLUTION + C.OFFSET - 1, width + 1, height + 1);
//        g.fillRoundRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET, width, height, 32, 32);

        switch (direct) {
            case RIGHT:
                g.fillRoundRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET, width / 2, height, linkArc, linkArc);
                g.setColor(Color.black);
                g.fillOval(getX() * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 3, getY() * C.RESOLUTION + C.OFFSET + 5, eyeDiameter, eyeDiameter);
                g.fillOval(getX() * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 3, getY() * C.RESOLUTION + C.OFFSET + 23, eyeDiameter, eyeDiameter);
                break;
            case LEFT:
                g.fillRoundRect(x * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 2, y * C.RESOLUTION + C.OFFSET, width / 2, height, linkArc, linkArc);
                g.setColor(Color.black);
                g.fillOval(getX() * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 3, getY() * C.RESOLUTION + C.OFFSET + 5, eyeDiameter, eyeDiameter);
                g.fillOval(getX() * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 3, getY() * C.RESOLUTION + C.OFFSET + 23, eyeDiameter, eyeDiameter);
                break;
            case DOWN:
                g.fillRoundRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET, width, height / 2, linkArc, linkArc);
                g.setColor(Color.black);
                g.fillOval(getX() * C.RESOLUTION + C.OFFSET + 5, getY() * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 3, eyeDiameter, eyeDiameter);
                g.fillOval(getX() * C.RESOLUTION + C.OFFSET + 23, getY() * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 3, eyeDiameter, eyeDiameter);
                break;
            case UP:
                g.fillRoundRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 2, width, height / 2, linkArc, linkArc);
                g.setColor(Color.black);
                g.fillOval(getX() * C.RESOLUTION + C.OFFSET + 5, getY() * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 3, eyeDiameter, eyeDiameter);
                g.fillOval(getX() * C.RESOLUTION + C.OFFSET + 23, getY() * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 3, eyeDiameter, eyeDiameter);
                break;
        }
    }

}
