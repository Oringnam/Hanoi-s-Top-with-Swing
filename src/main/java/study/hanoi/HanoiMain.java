package study.hanoi;

import javax.swing.*;

/**
 * @author oringnam
 * @since 02/06/2019
 * blog : http://box0830.tistory.com/
 */
public class HanoiMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Display primary = new Display();
        frame.getContentPane()
             .add(primary);
        frame.pack();
        frame.setVisible(true);
    }

}
