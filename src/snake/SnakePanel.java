package snake;

import snake.game_component.Food;
import snake.game_component.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakePanel extends JPanel implements KeyListener {

    Thread thread;
    Animate animate;

    Snake snake;
    Food food;

    public SnakePanel() {
        food = new Food(0, 0, C.ELEMENT_SIZE, C.ELEMENT_SIZE);
        food.addComponent(this);
        snake = new Snake(5, 5, 3);
        snake.addComponent(this);

        addKeyListener(this);
        setFocusable(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        food.draw(g, this);
        snake.draw(g, this);
    }

    public void update() {
        super.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            animate = new Animate(this);
            thread = new Thread(animate);
            thread.start();
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            snake.move(0, -1);
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            snake.move(0, 1);
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            snake.move(1, 0);
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            snake.move(-1,0);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
