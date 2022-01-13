package com.ticTacToe.Pattern;

public class Cal {
    // if row[i] == 3 || col[j] == 3 || c1 == 3 || c2 == 3 ... player 1 win
    // if row[i] == -3 || col[j] == -3  || c1 == -3 || c2 == -3 ..... Player 2 win



     int[] row;  // to store row freq
    int[] col; // to store column freq
    int c1 , c2; // diagonal
    int count; // moves from 1-9 only
    public Cal(){
        row = new int[3];
        col = new int[3];
        c1 = 0;
        c2 = 0;
        count = 0;

    }

    public int fun(int i , int j, boolean turn){
        if(turn){
            row[i]++;
            col[j]++;
            if(j == i){
                c1++;
            }else if(i +j == 2){
                c2++;
            }

        }else{
            row[i]--;
            col[j]--;
            if(j == i){
                c1--;
            }else if(i +j == 2){
                c2--;
            }
        }
        count++;
        if(row[i] == 3 || col[j]==3 || c1 == 3 || c2 == 3){ // Checking for wining state of player 1
            return 1;
        }else if(row[i] == -3 || col[j]==-3 || c1 == -3 || c2 == -3){ // check wining state of player 2
            return 2;
        }else if(count == 9){ // Match draw
            return 0;
        }else{ // Match not over
            return -1;
        }
    }






}
