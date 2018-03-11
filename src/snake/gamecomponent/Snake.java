package snake.gamecomponent;

import snake.Direction;
import snake.SnakePanel;
import snake.C;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

public class Snake {

    LinkedList<SnakeLink> snakeLinks;
    private boolean isVisible = true;
    private boolean isAlive = true;
    private int blinkCount = 0;

    public Snake(int x, int y, int length, Direction direct) {
        snakeLinks = new LinkedList<>();
        snakeLinks.add(new SnakeHead(x, y, C.ELEMENT_SIZE, C.ELEMENT_SIZE, direct));
        for (int i = 1; i < length - 1; i++) {
            snakeLinks.add(new SnakeLink(x - i, y, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
        }
        snakeLinks.add(new SnakeTail(x - length + 1, y, C.ELEMENT_SIZE, C.ELEMENT_SIZE, direct));
    }

    public LinkedList<SnakeLink> getSnakeLinks() {
        return snakeLinks;
    }

    public boolean move(Direction direct, Food food) {
        int deltaX = direct.getX();
        int deltaY = direct.getY();
        SnakeLink head = snakeLinks.getFirst();
        int newX = head.getX();
        int newY = head.getY();
        ((SnakeHead) head).setDirection(direct);

        if (newX + deltaX < 0) {
            deltaX += C.MAX_X;
        } else if (newX + deltaX >= C.MAX_X) {
            deltaX -= C.MAX_X;
        } else if (newY + deltaY < 0) {
            deltaY += C.MAX_Y;
        } else if (newY + deltaY >= C.MAX_Y) {
            deltaY -= C.MAX_Y;
        }
        head.step(deltaX, deltaY);
        int head0x = head.getX();
        int head0y = head.getY();

        int oldX;
        int oldY;

        Iterator<SnakeLink> iterator = snakeLinks.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            SnakeLink link = iterator.next();

            oldX = link.getX();
            oldY = link.getY();
            if (link instanceof SnakeTail) {
                if (food.getX() == head0x && food.getY() == head0y) {
                    snakeLinks.add(snakeLinks.size() - 1, new SnakeLink(newX, newY, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
                    food.reset(snakeLinks);
                    break;
                } else {
                    SnakeLink lastButOne = snakeLinks.get(snakeLinks.size() - 2);
                    ((SnakeTail) link).setDirect(lastButOne.getX(), lastButOne.getY());
                }
            }
            link.setPosition(newX, newY);
            if (newX == head0x && newY == head0y) {
                isAlive = false;
                head.setColor(Color.RED);
                System.out.println("lost"); //todo
            }
            newX = oldX;
            newY = oldY;
        }
        return isAlive;
    }

    public void draw(Graphics g) {
        if (isVisible) {
            for (SnakeLink link : snakeLinks) {
                link.draw(g);
            }
            snakeLinks.get(0).draw(g);
        }
        if (!isAlive && blinkCount != 6) {
            isVisible = !isVisible;
            blinkCount++;
        }
    }

    public void addComponent(SnakePanel snakePanel) {
        for (SnakeLink link : snakeLinks) {
            snakePanel.add(link);
        }
    }

}
