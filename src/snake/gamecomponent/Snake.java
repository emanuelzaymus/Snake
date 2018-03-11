package snake.gamecomponent;

import snake.Direction;
import snake.SnakePanel;
import snake.C;
import sun.security.util.Length;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Snake {

    //    ArrayList<SnakeLink> snakeLinks;
    LinkedList<SnakeLink> snakeLinks;

    public Snake(int x, int y, int length, Direction direct) {
//        snakeLinks = new ArrayList<>();
        snakeLinks = new LinkedList<>();
        snakeLinks.add(new SnakeHead(x, y, C.ELEMENT_SIZE, C.ELEMENT_SIZE, direct));
        for (int i = 1; i < length - 1; i++) {
            snakeLinks.add(new SnakeLink(x - i, y, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
        }
        snakeLinks.add(new SnakeTail(x - length + 1, y, C.ELEMENT_SIZE, C.ELEMENT_SIZE, direct));
    }

    //    public ArrayList<SnakeLink> getSnakeLinks() {
    public LinkedList<SnakeLink> getSnakeLinks() {
        return snakeLinks;
    }

    public boolean move(Direction direct, Food food) {
        boolean isAline = true;
        int deltaX = direct.getX();
        int deltaY = direct.getY();
//        SnakeLink snakeLink0 = snakeLinks.get(0);
        SnakeLink snakeLink0 = snakeLinks.getFirst();
        int newX = snakeLink0.getX();
        int newY = snakeLink0.getY();
        ((SnakeHead) snakeLink0).setDirection(direct);

        if (newX + deltaX < 0) {
            deltaX += C.MAX_X;
        } else if (newX + deltaX >= C.MAX_X) {
            deltaX -= C.MAX_X;
        } else if (newY + deltaY < 0) {
            deltaY += C.MAX_Y;
        } else if (newY + deltaY >= C.MAX_Y) {
            deltaY -= C.MAX_Y;
        }
        snakeLink0.step(deltaX, deltaY);
        int link0x = snakeLink0.getX();
        int link0y = snakeLink0.getY();

        int oldX;
        int oldY;

//        for (int i = 1; i < snakeLinks.size(); i++) {
//            oldX = snakeLinks.get(i).getX();
//            oldY = snakeLinks.get(i).getY();
//            snakeLinks.get(i).setPosition(newX, newY);
//            if (newX == link0x && newY == link0y) {
//                isAline = false;
//                System.out.println("lost"); //todo
//            }
//            newX = oldX;
//            newY = oldY;
//        }

        Iterator<SnakeLink> iterator = snakeLinks.iterator();
        iterator.next();
        while (iterator.hasNext()) {
            SnakeLink link = iterator.next();

            oldX = link.getX();
            oldY = link.getY();
            if (link instanceof SnakeTail) {
                if (food.getX() == link0x && food.getY() == link0y) {
//            snakeLinks.add(new SnakeLink(newX, newY, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
                    snakeLinks.add(snakeLinks.size() - 1, new SnakeLink(newX, newY, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
                    food.reset(snakeLinks);
                    break;
                }
            }
            link.setPosition(newX, newY);
            if (newX == link0x && newY == link0y) {
                isAline = false;
                System.out.println("lost"); //todo
            }
            newX = oldX;
            newY = oldY;
        }

//        if (food.getX() == link0x && food.getY() == link0y) {
////            snakeLinks.add(new SnakeLink(newX, newY, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
//            snakeLinks.add(snakeLinks.size() - 1, new SnakeLink(newX, newY, C.ELEMENT_SIZE, C.ELEMENT_SIZE));
//            food.reset(snakeLinks);
//        }
        return isAline;
    }

    public void draw(Graphics g) {
        for (SnakeLink link : snakeLinks) {
            link.draw(g);
        }
        snakeLinks.get(0).draw(g);
    }

    public void addComponent(SnakePanel snakePanel) {
        for (SnakeLink link : snakeLinks) {
            snakePanel.add(link);
        }
    }

}
