package snake.gamecomponent;

import snake.C;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

public class Food extends Element {

    private final Random random;

    public Food(int x, int y, int width, int height) {
        super(x, y, width, height);
        random = new Random();
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED);
        g.fillOval(super.x * C.RESOLUTION + C.OFFSET, super.y * C.RESOLUTION + C.OFFSET, super.width, super.height);
    }

//    public void reset(ArrayList<SnakeLink> snakeLinks) {
    public void reset(LinkedList<SnakeLink> snakeLinks) {
        int newX;
        int newY;
        boolean equal;
        do {
            equal = false;
            newX = random.nextInt(C.MAX_X);
            newY = random.nextInt(C.MAX_Y);

            for (SnakeLink link : snakeLinks) {
                if (link.getX() == newX && link.getY() == newY) {
                    equal = true;
                    break;
                }
            }
        } while (equal);

        super.setPosition(newX, newY);
    }

}
