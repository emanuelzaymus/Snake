package snake;

import javax.swing.JFrame;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame(C.TITLE);

        SnakePanel panel = new SnakePanel();
        frame.getContentPane().add(panel);

        frame.setSize(C.FRAME_WIDTH, C.FRAME_HEIGHT);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

}

/*
* TODO LIST:
* - bug (2 arrows at the same time)
*
* - levels/types of the game = wall element
* - increasing speed
* - head of the snake
* - design of snakes link
* - collection points
* - counter of pints
* - more food (good or bad)
* - icone
*
*
* */