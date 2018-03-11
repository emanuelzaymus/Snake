package snake.gamecomponent;

import snake.C;
import snake.Direction;

import java.awt.*;

public class SnakeTail extends SnakeLink {

    private Direction direct;

    public SnakeTail(int x, int y, int width, int height, Direction direct) {
        super(x, y, width, height);
        this.direct = direct;
    }

    public void setDirect(Direction direct) {
        this.direct = direct;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x * C.RESOLUTION + C.OFFSET - 1, y * C.RESOLUTION + C.OFFSET - 1, width + 1, height + 1);

        switch (direct) {
            case RIGHT:
                g.fillRoundRect(x * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 2, y * C.RESOLUTION + C.OFFSET, width / 2, height, linkArc, linkArc);
                break;
            case LEFT:
                g.fillRoundRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET, width / 2, height, linkArc, linkArc);
                break;
            case DOWN:
                g.fillRoundRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET + C.ELEMENT_SIZE / 2, width, height / 2, linkArc, linkArc);
                break;
            case UP:
                g.fillRoundRect(x * C.RESOLUTION + C.OFFSET, y * C.RESOLUTION + C.OFFSET, width, height / 2, linkArc, linkArc);
                break;
        }
    }
}
