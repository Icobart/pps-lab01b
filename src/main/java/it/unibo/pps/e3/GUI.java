package it.unibo.pps.e3;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import javax.swing.event.MouseInputListener;

import java.util.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

public class GUI extends JFrame {
    
    private static final long serialVersionUID = -6218820567019985015L;
    private final Map<JButton,Pair<Integer,Integer>> buttons = new HashMap<>();
    private final Logics logics;
    
    public GUI(int size, int minesCount) {
        this.logics = new LogicsImpl(size, minesCount);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(100*size, 100*size);
        
        JPanel panel = new JPanel(new GridLayout(size,size));
        this.getContentPane().add(BorderLayout.CENTER,panel);
        
        ActionListener onClick = (e)->{
            if (this.logics.isLost() || this.logics.isWon()) return;
            final JButton bt = (JButton)e.getSource();
            final Pair<Integer,Integer> pos = buttons.get(bt);
            this.logics.hit(pos);
            boolean aMineWasFound = this.logics.isLost();
            if (aMineWasFound) {
                quitGame();
                JOptionPane.showMessageDialog(this, "You lost!!");
            } else {
                drawBoard();            	
            }
            boolean isThereVictory = this.logics.isWon();
            if (isThereVictory){
                quitGame();
                JOptionPane.showMessageDialog(this, "You won!!");
                System.exit(0);
            }
        };

        MouseInputListener onRightClick = new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (logics.isLost() || logics.isWon()) return;
                if (SwingUtilities.isRightMouseButton(e)) {
                    final JButton bt = (JButton)e.getSource();
                    if (bt.isEnabled()){
                        final Pair<Integer,Integer> pos = buttons.get(bt);
                        logics.toggleFlag(pos);
                    }
                    drawBoard();
                }
            }
        };
                
        for (int i=0; i<size; i++){
            for (int j=0; j<size; j++){
                final JButton jb = new JButton(" ");
                jb.addActionListener(onClick);
                jb.addMouseListener(onRightClick);
                this.buttons.put(jb,new Pair<>(i,j));
                panel.add(jb);
            }
        }
        this.drawBoard();
        this.setVisible(true);
    }
    
    private void quitGame() {
        this.drawBoard();
    	for (var entry: this.buttons.entrySet()) {
            Pair<Integer, Integer> pos = entry.getValue();
            JButton bt = entry.getKey();
            if (this.logics.hasMine(pos)) {
                bt.setText("*");
            }
            bt.setEnabled(false);
    	}
    }

    private void drawBoard() {
        for (var entry: this.buttons.entrySet()) {
            Pair<Integer, Integer> pos = entry.getValue();
            JButton bt = entry.getKey();
            if (this.logics.isRevealed(pos)) {
                bt.setEnabled(false);
                int count = this.logics.getAdjacentMinesCount(pos);
                if (count > 0) {
                    bt.setText(String.valueOf(count));
                } else {
                    bt.setText("");
                }
            } else if (this.logics.isFlagged(pos)) {
                bt.setText("F");
            } else {
                bt.setText(" ");
                if (!this.logics.isLost() && !this.logics.isWon()) {
                    bt.setEnabled(true);
                }
            }
    	}
    }
    
}
