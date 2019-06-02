package study.hanoi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * @author oringnam
 * @since 02/06/2019
 * blog : http://box0830.tistory.com/
 */
public class Display extends JPanel {
    private Dimension displaySize;
    private JLabel lblTitle, lblAsking;
    private JPanel subOptions;
    private DrawPanel mainDisplay;
    private JButton btnNext, btnPrev, btnExe;
    private JTextField txtInput;
    private HanoiListener listener;
    private Logic logic;
    private int nInput, nSequence;
    private ArrayList<Sequence> sequence;

    public Display() {
        displaySize = new Dimension(800, 800);
        this.setPreferredSize(displaySize);
        this.setBackground(Color.black);
        this.setLayout(null);

        listener = new HanoiListener();
        nSequence = 1;

        lblTitle = new JLabel("Hanoi Top");
        lblTitle.setForeground(Color.white);
        lblTitle.setFont(new Font("Monofour", Font.ITALIC, 40));
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setBounds(0, 0, displaySize.width, displaySize.height / 8);
        this.add(lblTitle);

        mainDisplay = new DrawPanel(displaySize);
        this.add(mainDisplay);

        subOptions = new JPanel();
        subOptions.setBackground(Color.black);
        subOptions.setBounds(0, displaySize.height * 7 / 8, displaySize.width, displaySize.height * 1 / 8);
        subOptions.setLayout(null);
        this.add(subOptions);

        Font fnt = new Font("Monofour", Font.BOLD, 20);

        lblAsking = new JLabel("Tops");
        lblAsking.setBounds(50, 25, 100, 50);
        lblAsking.setForeground(Color.white);
        lblAsking.setHorizontalAlignment(SwingConstants.CENTER);
        lblAsking.setFont(fnt);
        subOptions.add(lblAsking);

        txtInput = new JTextField();
        txtInput.setBounds(150, 25, 100, 50);
        txtInput.setFont(fnt);
        txtInput.addActionListener(listener);
        subOptions.add(txtInput);

        btnExe = new JButton("Confirm");
        btnExe.setBounds(250, 25, 100, 50);
        btnExe.addActionListener(listener);
        subOptions.add(btnExe);

        btnPrev = new JButton("Prev");
        btnPrev.setBounds(500, 25, 100, 50);
        btnPrev.addActionListener(listener);
        btnPrev.setEnabled(false);
        subOptions.add(btnPrev);

        btnNext = new JButton("Next");
        btnNext.setBounds(600, 25, 100, 50);
        btnNext.addActionListener(listener);
        btnNext.setEnabled(false);
        subOptions.add(btnNext);
    }

    private class HanoiListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Object obj = e.getSource();
            if ((obj == txtInput) || (obj == btnExe)) {
                nInput = Integer.parseInt(txtInput.getText());
                logic = new Logic(nInput);
                btnNext.setEnabled(true);
                txtInput.setText("");
            } else if (obj == btnPrev) {
                nSequence--;
                btnNext.setEnabled(true);
                if (nSequence == 1) {
                    btnPrev.setEnabled(false);
                }
            } else if (obj == btnNext) {
                nSequence++;
                btnPrev.setEnabled(true);
                if (nSequence == logic.getCount() + 1) {
                    btnNext.setEnabled(false);
                }
            }
            sequence = logic.getSequence();
            mainDisplay.setBoard(nSequence - 1, logic.getCount());
            mainDisplay.setDataList(sequence.get(nSequence - 1)
                                            .getNowData(), nSequence - 1);
            mainDisplay.repaint();
        }
    }


}
