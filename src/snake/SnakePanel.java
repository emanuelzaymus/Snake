package snake;

import snake.gamecomponent.Food;
import snake.gamecomponent.Snake;

import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class SnakePanel extends JPanel implements KeyListener {

    private Animate animate = new Animate(this);
    private Thread thread = new Thread(animate);

    private Snake snake;
    private Food food;

    private int deltaX;
    private int deltaY;

    private boolean running = false;
    private boolean lost = false;

    public SnakePanel() {
        this.restart();
        thread.start();

        addKeyListener(this);
        setFocusable(true);
    }

    private void restart() {
        snake = new Snake(8, 5, 6);
        snake.addComponent(this);
        food = new Food(0, 0, C.ELEMENT_SIZE, C.ELEMENT_SIZE);
        food.reset(snake.getSnakeLinks());
        food.addComponent(this);

        deltaX = 1;
        deltaY = 0;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        food.draw(g);
        snake.draw(g);
    }

    public void update() {
        if (running) {
            running = snake.move(deltaX, deltaY, food);
            lost = !running;
            super.repaint();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (running) {                      //pause
                running = false;
            } else if (!running && lost) {      //new game
                this.restart();
                running = true;
                lost = false;
            } else if (!running && !lost) {     //play after pause
                running = true;
            }
        }
        if (!running) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && (deltaX != 0 && deltaY != 1)) {
            deltaX = 0;
            deltaY = -1;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && (deltaX != 0 && deltaY != -1)) {
            deltaX = 0;
            deltaY = 1;
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && (deltaX != -1 && deltaY != 0)) {
            deltaX = 1;
            deltaY = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && (deltaX != 1 && deltaY != 0)) {
            deltaX = -1;
            deltaY = 0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
