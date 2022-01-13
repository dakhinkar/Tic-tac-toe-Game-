package com.ticTacToe.GUI;

import com.ticTacToe.Pattern.Cal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MyWindow extends JWindow implements ActionListener {
    String player1, player2;
    JPanel panel;
    JButton buttons[] ;
    ImageIcon cross, zero;
    boolean turn = true;
    Cal cal ;
    public MyWindow(String p1, String p2, JFrame frame){
            cal = new Cal();

            cross = new ImageIcon("C:\\Users\\prani\\Desktop\\ACCIO\\DSA Project\\" +
                    "Tic Tac Toe\\src\\com\\ticTacToe\\GUI\\x.png");
            zero = new ImageIcon("C:\\Users\\prani\\Desktop\\ACCIO\\DSA Project\\" +
                    "\\Tic Tac Toe\\src\\com\\ticTacToe\\GUI\\o.png");

            player1 = p1;
            player2 = p2;
            panel = new JPanel();
            panel.setBounds(0,0,360,360);
            panel.setLayout(new GridLayout(3,3,5,5));
            panel.setBackground(Color.BLACK); // set Default Back Ground color
            setButtons(); // Initialize all button
            this.add(panel); // Add Button to the Window
            this.setSize(360,360); // set window width and size

            this.setLayout(null); // set Default layout
            this.setVisible(true);
    }

    public void setButtons(){
        buttons = new JButton[9];
        for(int i=0; i<9; i++){
            buttons[i] = new JButton();
            buttons[i].addActionListener(this); // add Action Perform
            panel.add(buttons[i]); // panel added to panel

        }
        int k =0; // to check all 9 moves are over or not
        for(int j =0; j<3; j++) {
            for (int i = 0; i < 3; i++) {
                buttons[k].setFont(new Font("Calibri", Font.PLAIN, 1)); // to set i, j position in button but .. invisible to user
                buttons[k++].setText("" + j + "," + i);
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
       JButton button = (JButton) e.getSource();
          if(button.getIcon() == null){ // If already moves is taken then it cannot be changed
              int i = button.getText().charAt(0)-'0';
              int j = button.getText().charAt(2) -'0';
              if(turn){ // turn by turn rotation
                  button.setIcon(cross);
              }else{
                  button.setIcon(zero);
              }
              int response = cal.fun(i,j,turn);  // Cal class to check who is winner
              // -1 means match is still running
              if(response != -1){ // of response is not -ve means one of the player will win the match or non is win
                  result(response); // Display who is winner
              }
              turn = !turn;
          }
    }


    public void result(int response){
        if(response == 1){ // player 1 win
            JOptionPane.showMessageDialog(null,
                    "Congratulation " + player1 + " you win the game","", JOptionPane.INFORMATION_MESSAGE);
        }else if(response == 2){ // player 2 win
            JOptionPane.showMessageDialog(null,
                    "Congratulation " + player2 + " you win the game","", JOptionPane.INFORMATION_MESSAGE);
        }else { // Draw
            JOptionPane.showMessageDialog(null,
                    "Match Tie","", JOptionPane.INFORMATION_MESSAGE);
        }
    }


}
