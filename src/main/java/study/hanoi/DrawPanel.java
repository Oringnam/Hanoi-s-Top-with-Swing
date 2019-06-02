package study.hanoi;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * @author oringnam
 * @since 02/06/2019
 * blog : http://box0830.tistory.com/
 */
public class DrawPanel extends JPanel {
    private Dimension dsize;
    private JLabel lblStatus, lblA, lblB, lblC;
    private JPanel bottom;
    private Graphics page;
    private ArrayList<HanoiData> tmpA;


    public DrawPanel(Dimension displaySize) {
        this.setBackground(Color.white);
        this.setBounds(0, displaySize.height / 8, displaySize.width, displaySize.height * 3 / 4);
        this.setLayout(null);

        dsize = new Dimension(displaySize.width, displaySize.height * 3 / 4);
        lblStatus = new JLabel();
        lblStatus.setBounds(displaySize.width * 7 / 8, 0, 100, 50);
        lblStatus.setText("");
        lblStatus.setForeground(Color.black);
        lblStatus.setFont(new Font("Monofour", Font.ITALIC, 25));
        this.add(lblStatus);

        tmpA = new ArrayList<HanoiData>();
        bottom = new JPanel();
        bottom.setBounds(0, dsize.height - 50, dsize.width, 50);
        bottom.setBackground(Color.gray);
        bottom.setLayout(null);
        this.add(bottom);

        Font fnt = new Font("Monofour", Font.ITALIC, 20);
        lblA = new JLabel("A");
        lblA.setBounds(135, 0, 50, 50);
        lblA.setFont(fnt);
        lblA.setForeground(Color.white);
        bottom.add(lblA);

        lblB = new JLabel("B");
        lblB.setBounds(375, 0, 50, 50);
        lblB.setFont(fnt);
        lblB.setForeground(Color.white);
        bottom.add(lblB);

        lblC = new JLabel("C");
        lblC.setBounds(615, 0, 50, 50);
        lblC.setFont(fnt);
        lblC.setForeground(Color.white);
        bottom.add(lblC);
    }

    public void drawTops() {
        for (HanoiData data : tmpA) {
            page.setColor(data.getColor());
            page.fillRect(data.getPtOne().x, data.getPtOne().y, data.getWidth(), data.getHeight());
        }
    }


    public void pillar() {
        page.fillRect(120, dsize.height / 4, 40, dsize.height * 3 / 4 - 50);
        page.fillRect(360, dsize.height / 4, 40, dsize.height * 3 / 4 - 50);
        page.fillRect(600, dsize.height / 4, 40, dsize.height * 3 / 4 - 50);
    }

    public void paintComponent(Graphics p) {
        super.paintComponent(p);
        page = p;
        this.pillar();
        this.drawTops();
    }

    public void setDataList(ArrayList<HanoiData> nowList, int x) {
        for (HanoiData data : nowList) {
            tmpA.add(new HanoiData(data, x));
        }
    }

    public void setBoard(int num, int goal) { lblStatus.setText(num + " / " + goal); }

}