package com.Haythem.tictac;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void BuClick(View view) {
        Button buSelected = (Button) view;

        int CellID=0;
        switch((buSelected.getId())){
            case R.id.bu1:
                CellID=1;
                break;
            case R.id.bu2:
                CellID=2;
                break;
            case R.id.bu3:
                CellID=3;
                break;
            case R.id.bu4:
                CellID=4;
                break;
            case R.id.bu5:
                CellID=5;
                break;
            case R.id.bu6:
                CellID=6;
                break;
            case R.id.bu7:
                CellID=7;
                break;
            case R.id.bu8:
                CellID=8;
                break;
            case R.id.bu9:
                CellID=9;
                break;
        }
        PlayGame( CellID , buSelected);
    }
    int ActivePlayer = 1 ;
    ArrayList<Integer> Player1 = new ArrayList<Integer>();
    ArrayList<Integer> Player2 = new ArrayList<Integer>();
    void PlayGame(int CellID, Button buSelected){

        Log.d("Player",String.valueOf(CellID));
        if(ActivePlayer==1){
            buSelected.setText("X");
            buSelected.setBackgroundColor(Color.RED);
            Player1.add(CellID);
            ActivePlayer=2;

        }
        else if (ActivePlayer==2){
            buSelected.setText("O");
            buSelected.setBackgroundColor(Color.GREEN);
            Player2.add(CellID);
            ActivePlayer=1;

        }
        buSelected.setEnabled(false);
        CheckWiner();


    }
    void CheckWiner(){
        int Winer = -1 ;
        //row 1
        if(Player1.contains(1) && Player1.contains(2) && Player1.contains(3)){
            Winer=1;
        }
        if(Player2.contains(1) && Player2.contains(2) && Player2.contains(3)){
            Winer=2;
        }
        //row 2
        if(Player1.contains(4) && Player1.contains(5) && Player1.contains(6)){
            Winer=1;
        }
        if(Player2.contains(4) && Player2.contains(5) && Player2.contains(6)){
            Winer=2;
        }

        //row 3
        if(Player1.contains(7) && Player1.contains(8) && Player1.contains(9)){
            Winer=1;
        }
        if(Player2.contains(7) && Player2.contains(8) && Player2.contains(9)){
            Winer=2;
        }

        //col 1
        if(Player1.contains(1) && Player1.contains(4) && Player1.contains(7)){
            Winer=1;
        }
        if(Player2.contains(1) && Player2.contains(4) && Player2.contains(7)){
            Winer=2;
        }
        //col 2

        if(Player1.contains(2) && Player1.contains(5) && Player1.contains(8)){
            Winer=1;
        }
        if(Player2.contains(2) && Player2.contains(5) && Player2.contains(8)){
            Winer=2;
        }
        //col 3
        if(Player1.contains(3) && Player1.contains(6) && Player1.contains(9)){
            Winer=1;
        }
        if(Player2.contains(3) && Player2.contains(6) && Player2.contains(9)){
            Winer=2;
        }

        // col x
        if(Player1.contains(1) && Player1.contains(5) && Player1.contains(9)){
            Winer=1;
        }
        if(Player2.contains(1) && Player2.contains(5) && Player2.contains(9)){
            Winer=2;
        }
        //col x 2
        if(Player1.contains(3) && Player1.contains(5) && Player1.contains(7)){
            Winer=1;
        }
        if(Player2.contains(3) && Player2.contains(5) && Player2.contains(7)){
            Winer=2;
        }

        if(Winer != -1){
            if(Winer == 1){
                Toast.makeText(this, "Player 1 is Winner", Toast.LENGTH_SHORT).show();
            }
            if(Winer == 2){
                Toast.makeText(this, "Player 2 is Winner", Toast.LENGTH_SHORT).show();
            }

        }

    }
}