package snake.game_component;

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
        for (SnakeLink link : snakeLinks) {
            link.step(deltaX, deltaY);
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
