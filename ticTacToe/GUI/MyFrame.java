package com.ticTacToe.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {
    JLabel player1;
    JLabel player2;
    JTextField p1_Name, p2_Name;
    String n1 , n2;
    JButton play, quit, playAgain;
    MyWindow window;
    public MyFrame(){
            n1 = "Player1";
            n2 = "Player2";// Default Name
            player1 = new JLabel("First Player     :- ");
            player2 = new JLabel("Second Player :- ");
            p1_Name = new JTextField("");
            p2_Name = new JTextField("");

            // Set Font
            player1.setFont(new Font("Calibri" ,Font.BOLD,20));
            player2.setFont(new Font("Calibri" ,Font.BOLD,20));

            // Configure Button
            play = new JButton("Play");
            quit = new JButton("Quit");
            playAgain = new JButton("Play Again");


            // set Location
            player1.setBounds(30,20,150,25);
            p1_Name.setBounds(170,20, 150,25);

            player2.setBounds(30,60,150,25);
            p2_Name.setBounds(170,60, 150,25);

            // set Button Location
            play.setBounds(20, 120,80,50);
            playAgain.setBounds(120,120,100,50);
            quit.setBounds(240,120,80,50);


        // Add Action Listener
            play.addActionListener(this);
            quit.addActionListener(this);
            playAgain.addActionListener(this);

            // Add Component
            this.add(player1);
            this.add(p1_Name);
            this.add(player2);
            this.add(p2_Name);
            this.add(play);

            this.add(quit);
            this.add(playAgain);
            this.setTitle("Tic Tac Toe Game");
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setResizable(false);
            this.setLayout(null);
            this.setSize(360,300);
            this.setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e){
        play.setEnabled(false);
        if(e.getSource() == play){
            if(p1_Name.getText().length() >0){
                n1 = p1_Name.getText();
            }

            if(p2_Name.getText().length() > 0){
                n2 = p2_Name.getText();
            }
            System.out.println(n1 + " " + n2);

            window  = new MyWindow(n1, n2, this);
            window.setLocation(360,0);
            window.setVisible(true);



        }else if(e.getSource() == quit){
            int response = JOptionPane.showConfirmDialog(null,"Do you want to exit ?", "",JOptionPane.YES_NO_OPTION);
            if(response == 0)
                System.exit(0);

        }else{
            window  = new MyWindow(n1, n2, this);
            window.setLocation(360,0);
            window.setVisible(true);
        }
    }



}
