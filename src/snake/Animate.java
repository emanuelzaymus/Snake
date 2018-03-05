package snake;

public class Animate implements Runnable {

    SnakePanel snakePanel;

    public Animate(SnakePanel snakePanel) {
        this.snakePanel = snakePanel;
    }

    @Override
    public void run() {
        while (true) {
            snakePanel.update();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
