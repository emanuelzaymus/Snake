package snake.gamecomponent;

import snake.SnakePanel;
import snake.C;

import java.awt.*;
import java.util.ArrayList;

public class Snake {

    ArrayList<SnakeLink> snakeLinks;

    public Snake(int x, int y, int length) {
        snakeLinks = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            snakeLinks.add(new SnakeLink(x + i, y, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
        }
    }

    public void move(int deltaX, int deltaY) {
        int newX = snakeLinks.get(0).getX();
        int newY = snakeLinks.get(0).getY();

        snakeLinks.get(0).step(deltaX, deltaY);

        int oldX;
        int oldY;

        for (int i = 1; i < snakeLinks.size(); i++) {
            oldX = snakeLinks.get(i).getX();
            oldY = snakeLinks.get(i).getY();
            snakeLinks.get(i).setPosition(newX, newY);
            newX = oldX;
            newY = oldY;
        }
    }

    public void draw(Graphics g, Component component) {
        for (SnakeLink link : snakeLinks) {
            link.draw(g, component);
        }
    }

    public void addComponent(SnakePanel snakePanel) {
        for (SnakeLink link : snakeLinks) {
            snakePanel.add(link);
        }
    }

}
