package com.example.tris;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Gioco extends AppCompatActivity {
    ImageView IMGTURN;
    TextView LBL1, LBL2, LBL3, LBL4;
    Button resetGame, resetStats;
    //righe colonne
    int[][] matrix = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
    ImageView[][] imgMatrix = new ImageView[3][3];
    boolean check = false;
    int mosse = 0;
    int vittorieCe = 0;
    int vittorieCr = 0;
    int pareggi = 0;
    boolean fine = false;
    boolean pareggio = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gioco);
        imgMatrix[0][0] = findViewById(R.id.imageView);
        imgMatrix[0][1] = findViewById(R.id.imageView2);
        imgMatrix[0][2] = findViewById(R.id.imageView3);
        imgMatrix[1][0] = findViewById(R.id.imageView4);
        imgMatrix[1][1] = findViewById(R.id.imageView5);
        imgMatrix[1][2] = findViewById(R.id.imageView6);
        imgMatrix[2][0] = findViewById(R.id.imageView7);
        imgMatrix[2][1] = findViewById(R.id.imageView8);
        imgMatrix[2][2] = findViewById(R.id.imageView9);
        IMGTURN = findViewById(R.id.imageView10);
        LBL1 = findViewById(R.id.textView);
        LBL2 = findViewById(R.id.textView2);
        LBL3 = findViewById(R.id.textView3);
        LBL4 = findViewById(R.id.textView7);
        resetGame = findViewById(R.id.button);
        resetStats = findViewById(R.id.button2);
        imgMatrix[0][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(0, 0, imgMatrix[0][0]);
            }
        });
        imgMatrix[0][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(0, 1, imgMatrix[0][1]);
            }
        });
        imgMatrix[0][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(0, 2, imgMatrix[0][2]);
            }
        });
        imgMatrix[1][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(1, 0, imgMatrix[1][0]);
            }
        });
        imgMatrix[1][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(1, 1, imgMatrix[1][1]);
            }
        });
        imgMatrix[1][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(1, 2, imgMatrix[1][2]);
            }
        });
        imgMatrix[2][0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(2, 0, imgMatrix[2][0]);
            }
        });
        imgMatrix[2][1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(2, 1, imgMatrix[2][1]);
            }
        });
        imgMatrix[2][2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Changer(2, 2, imgMatrix[2][2]);
            }
        });
        resetGame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                puliscimelo();
            }
        });
        resetStats.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                vittorieCe = vittorieCr = pareggi = 0;
                LBL1.setText("0");
                LBL2.setText("0");
                LBL3.setText("0");
            }
        });
        try
        {
            this.getSupportActionBar().hide();
        }
        catch (NullPointerException e){}
        IMGTURN.setBackgroundResource(R.drawable.croce);
    }

    public void Changer(int Y, int X, ImageView IMG){
        if(matrix[Y][X] == 0 && !fine){
            if(!check){
                matrix[Y][X] = 1;
                IMGTURN.setBackgroundResource(R.drawable.cerchio);
                IMG.setBackgroundResource(R.drawable.croce);
                check = true;
            }else{
                matrix[Y][X] = 2;
                IMGTURN.setBackgroundResource(R.drawable.croce);
                IMG.setBackgroundResource(R.drawable.cerchio);
                check = false;
            }
            mosse++;
        }
        checker();
    }
    public void checker(){
        boolean checking = false;
        if(!fine){
            for(int i = 0; i < 3; i++){
                if(matrix[i][0] == 1 && matrix[i][1] == 1 && matrix[i][2] == 1) {
                    checking = true;
                    imgMatrix[i][0].setBackgroundResource(R.drawable.croceverde);
                    imgMatrix[i][1].setBackgroundResource(R.drawable.croceverde);
                    imgMatrix[i][2].setBackgroundResource(R.drawable.croceverde);
                    Vcroce();
                }
                if(matrix[i][0] == 2 && matrix[i][1] == 2 && matrix[i][2] == 2){
                    checking = true;
                    imgMatrix[i][0].setBackgroundResource(R.drawable.cerchioverde);
                    imgMatrix[i][1].setBackgroundResource(R.drawable.cerchioverde);
                    imgMatrix[i][2].setBackgroundResource(R.drawable.cerchioverde);
                    Vcerchio();
                }
            }
            for(int i = 0; i < 3; i++){
                if(matrix[0][i] == 1 && matrix[1][i] == 1 && matrix[2][i] == 1) {
                    checking = true;
                    imgMatrix[0][i].setBackgroundResource(R.drawable.croceverde);
                    imgMatrix[1][i].setBackgroundResource(R.drawable.croceverde);
                    imgMatrix[2][i].setBackgroundResource(R.drawable.croceverde);
                    Vcroce();
                }
                if(matrix[0][i] == 2 && matrix[1][i] == 2 && matrix[2][i] == 2){
                    checking = true;
                    imgMatrix[0][i].setBackgroundResource(R.drawable.cerchioverde);
                    imgMatrix[1][i].setBackgroundResource(R.drawable.cerchioverde);
                    imgMatrix[2][i].setBackgroundResource(R.drawable.cerchioverde);
                    Vcerchio();
                }
            }
            if(matrix[0][0] == 1 && matrix[1][1] == 1 && matrix[2][2] == 1){
                checking = true;
                imgMatrix[0][0].setBackgroundResource(R.drawable.croceverde);
                imgMatrix[1][1].setBackgroundResource(R.drawable.croceverde);
                imgMatrix[2][2].setBackgroundResource(R.drawable.croceverde);
                Vcroce();
            }
            if(matrix[0][0] == 2 && matrix[1][1] == 2 && matrix[2][2] == 2){
                checking = true;
                imgMatrix[0][0].setBackgroundResource(R.drawable.cerchioverde);
                imgMatrix[1][1].setBackgroundResource(R.drawable.cerchioverde);
                imgMatrix[2][2].setBackgroundResource(R.drawable.cerchioverde);
                Vcerchio();
            }
            if(matrix[0][2] == 1 && matrix[1][1] == 1 && matrix[2][0] == 1){
                checking = true;
                imgMatrix[0][2].setBackgroundResource(R.drawable.croceverde);
                imgMatrix[1][1].setBackgroundResource(R.drawable.croceverde);
                imgMatrix[2][0].setBackgroundResource(R.drawable.croceverde);
                Vcroce();
            }
            if(matrix[0][2] == 2 && matrix[1][1] == 2 && matrix[2][0] == 2){
                checking = true;
                imgMatrix[0][2].setBackgroundResource(R.drawable.cerchioverde);
                imgMatrix[1][1].setBackgroundResource(R.drawable.cerchioverde);
                imgMatrix[2][0].setBackgroundResource(R.drawable.cerchioverde);
                Vcerchio();
            }
            if(mosse == 9 && !checking){
                pareggi++;
                fine = true;
                LBL2.setText(String.valueOf(pareggi));
                IMGTURN.setBackgroundColor(Color.TRANSPARENT);
                LBL4.setText("Avete pareggiato!");
                pareggio = true;
            }
        }
    }

    public void Vcerchio(){
        fine = true;
        vittorieCe++;
        LBL3.setText(String.valueOf(vittorieCe));
        IMGTURN.setBackgroundColor(Color.TRANSPARENT);
        LBL4.setText("Ha vinto il cerchio!");
    }

    public void Vcroce(){
        fine = true;
        vittorieCr++;
        LBL1.setText(String.valueOf(vittorieCr));
        IMGTURN.setBackgroundColor(Color.TRANSPARENT);
        LBL4.setText("Ha vinto la croce!");
    }

    public void message(String text){
        AlertDialog.Builder builder = new AlertDialog.Builder(Gioco.this);
        builder.setMessage(text);
        builder.setTitle("Messaggio");
        builder.setCancelable(false);
        builder.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                puliscimelo();
                dialog.cancel();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
    //il tavolo con l'alcool
    public void puliscimelo(){
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                matrix[i][j] = 0;
            }
        }
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                imgMatrix[i][j].setBackgroundColor(Color.TRANSPARENT);
            }
        }
        if(pareggio){
            if(check){
                check = true;
                IMGTURN.setBackgroundResource(R.drawable.cerchio);
            }else{
                check = false;
                IMGTURN.setBackgroundResource(R.drawable.croce);
            }
        }else{
            if(check){
                check = false;
                IMGTURN.setBackgroundResource(R.drawable.croce);
            }else{
                check = true;
                IMGTURN.setBackgroundResource(R.drawable.cerchio);
            }
        }
        fine = false;
        pareggio = false;
        mosse = 0;
        LBL4.setText("");
    }
}