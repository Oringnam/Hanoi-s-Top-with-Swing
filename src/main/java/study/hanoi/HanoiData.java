package study.hanoi;

import java.awt.*;

/**
 * @author oringnam
 * @since 02/06/2019
 * blog : http://box0830.tistory.com/
 */
public class HanoiData {
    private Point ptOne;
    private int position, width, height;
    private Color blockColor;
    private int vertic;
    private int stdx, total, stdPosit;
    private char location;

    public HanoiData(int num, int tot) {
        ptOne = new Point();
        location = 'A';
        total = tot;
        position = num;
        stdPosit = total - position;
        vertic = 550;
        height = 40;
        int r, g, b;
        r = (int) (Math.random() * 256);
        g = (int) (Math.random() * 256);
        b = (int) (Math.random() * 256);
        blockColor = new Color(r, g, b);
        this.setDatas();
    }

    public HanoiData(HanoiData data, int x) {
        ptOne = data.getPtOne();
        location = data.getLocation();
        total = data.getTotal();
        position = data.getPosition();
        stdPosit = data.getStdPosit();
        vertic = 550;
        height = 40;
        width = data.getWidth();
        blockColor = data.getColor();
        this.setDatas();
    }

    public void changeData(char change, int bar) {
        location = change;
        stdPosit = bar;
    }

    public void setDatas() {
        int locStd;
        if (location == 'A') {
            locStd = 140;
        } else if (location == 'B') {
            locStd = 380;
        } else {
            locStd = 620;
        }
        stdx = 90 / total;
        ptOne.y = vertic - height * stdPosit;
        ptOne.x = locStd - stdx * (position + 1);
        width = (locStd - ptOne.x) * 2;
    }

    public Point getPtOne() { return ptOne; }

    public int getPosition() { return position; }

    public int getTotal() { return total; }

    public char getLocation() { return location; }

    public int getWidth() { return width; }

    public int getHeight() { return height; }

    public Color getColor() { return blockColor; }

    public int getStdPosit() { return stdPosit; }

}
