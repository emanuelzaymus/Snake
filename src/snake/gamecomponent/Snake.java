package snake.gamecomponent;

import snake.SnakePanel;
import snake.C;

import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {

    ArrayList<SnakeLink> snakeLinks;

    public Snake(int x, int y, int length) {
        snakeLinks = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            snakeLinks.add(new SnakeLink(x - i, y, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
        }
    }

    public ArrayList<SnakeLink> getSnakeLinks() {
        return snakeLinks;
    }

    public boolean move(int deltaX, int deltaY, Food food) {
        boolean isAline = true;
        int newX = snakeLinks.get(0).getX();
        int newY = snakeLinks.get(0).getY();

        if (newX + deltaX < 0) {
            deltaX += C.MAX_X;
        } else if (newX + deltaX >= C.MAX_X) {
            deltaX -= C.MAX_X;
        } else if (newY + deltaY < 0) {
            deltaY += C.MAX_Y;
        } else if (newY + deltaY >= C.MAX_Y) {
            deltaY -= C.MAX_Y;
        }
        snakeLinks.get(0).step(deltaX, deltaY);
        int link0x = snakeLinks.get(0).getX();
        int link0y = snakeLinks.get(0).getY();

        int oldX;
        int oldY;

        for (int i = 1; i < snakeLinks.size(); i++) {
            oldX = snakeLinks.get(i).getX();
            oldY = snakeLinks.get(i).getY();
            snakeLinks.get(i).setPosition(newX, newY);
            if (newX == link0x && newY == link0y) {
                isAline = false;
                System.out.println("lost"); //todo
            }
            newX = oldX;
            newY = oldY;
        }
        if (food.getX() == link0x && food.getY() == link0y) {
            snakeLinks.add(new SnakeLink(newX, newY, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
            food.reset(snakeLinks);
        }
        return isAline;
    }

    public void draw(Graphics g) {
        for (SnakeLink link : snakeLinks) {
            link.draw(g);
        }
    }

    public void addComponent(SnakePanel snakePanel) {
        for (SnakeLink link : snakeLinks) {
            snakePanel.add(link);
        }
    }

}
