package study.hanoi;

import java.util.ArrayList;

/**
 * @author oringnam
 * @since 02/06/2019
 * blog : http://box0830.tistory.com/
 */
public class Logic {
    private int count;
    private ArrayList<HanoiData> nowList;
    private ArrayList<Sequence> sequence;
    private int aBar, bBar, cBar;

    public Logic(int num) {
        count = 0;
        aBar = num;
        bBar = cBar = 0;

        nowList = new ArrayList<HanoiData>();
        for (int i = 0; i < num; i++) {
            nowList.add(new HanoiData(i, num));
        }

        ArrayList<HanoiData> tmpList = new ArrayList<HanoiData>();
        sequence = new ArrayList<Sequence>();
        int i = 0;
        for (HanoiData data : nowList) {
            tmpList.add(new HanoiData(data, num - i));
            i++;
        }
        sequence.add(new Sequence(tmpList));

        this.calcHanoi(num, 'A', 'B', 'C');
    }

    public void calcHanoi(int num, char from, char other, char to) {
        if (num == 1) {
            ++count;
            this.moveBlock(num - 1, from, to);
        } else {
            ++count;
            this.calcHanoi(num - 1, from, to, other);
            this.moveBlock(num - 1, from, to);
            this.calcHanoi(num - 1, other, from, to);
        }
    }

    public void moveBlock(int position, char from, char to) {
        int tBar;
        if (from == 'A') {
            aBar--;
        } else if (from == 'B') {
            bBar--;
        } else {
            cBar--;
        }
        if (to == 'A') {
            aBar++;
            tBar = aBar;
        } else if (to == 'B') {
            bBar++;
            tBar = bBar;
        } else {
            cBar++;
            tBar = cBar;
        }
        for (HanoiData data : nowList) {
            if (data.getPosition() == position) {
                data.changeData(to, tBar);
                break;
            }
        }

        ArrayList tmpList = new ArrayList();
        for (int i = 0; i < nowList.size(); i++) {
            tmpList.add(new HanoiData(nowList.get(i), tBar - i));
        }
        sequence.add(new Sequence(tmpList));
    }

    public ArrayList getSequence() { return sequence; }
    public int getCount() { return count; }

}