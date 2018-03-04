package snake;

import javax.swing.*;

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
