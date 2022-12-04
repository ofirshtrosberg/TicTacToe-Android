package com.example.tictactoenew;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Arrays;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class TicTacToeGameActivity extends AppCompatActivity {
    int turn = 0; // 0 = X play, 1 = O play
    int flag = 0;
    int[] statusGame = {2, 2, 2, 2, 2, 2, 2, 2, 2};
    boolean noWin = false;
    int[][] winCombinations = {{0, 1, 2}, {0, 3, 6}, {0, 4, 8}, {2, 5, 8}, {2, 4, 6}, {6, 7, 8}, {3, 4, 5}, {1, 4, 7}};

    int checkWin() {
        for (int[] winCombination : winCombinations) {
            if (statusGame[winCombination[0]] == statusGame[winCombination[1]] &&
                    statusGame[winCombination[1]] == statusGame[winCombination[2]] &&
                    statusGame[winCombination[0]] != 2) {
                flag = 1; // means someone win
            }
        }
        return flag;
    }

    // in case no wining
    boolean noOneWin() {
        if (Arrays.stream(statusGame).allMatch(x -> x != 2)) {
            noWin = true;
        }
        return noWin;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tic_tac_toe_game);
        ImageView game_img_row1_col1 = findViewById(R.id.game_img_row1_col1);
        ImageView game_img_row1_col2 = findViewById(R.id.game_img_row1_col2);
        ImageView game_img_row1_col3 = findViewById(R.id.game_img_row1_col3);
        ImageView game_img_row2_col1 = findViewById(R.id.game_img_row2_col1);
        ImageView game_img_row2_col2 = findViewById(R.id.game_img_row2_col2);
        ImageView game_img_row2_col3 = findViewById(R.id.game_img_row2_col3);
        ImageView game_img_row3_col1 = findViewById(R.id.game_img_row3_col1);
        ImageView game_img_row3_col2 = findViewById(R.id.game_img_row3_col2);
        ImageView game_img_row3_col3 = findViewById(R.id.game_img_row3_col3);
        ImageView[] imageViews = {game_img_row1_col1,
                game_img_row1_col2, game_img_row1_col3, game_img_row2_col1, game_img_row2_col2, game_img_row2_col3, game_img_row3_col1, game_img_row3_col2, game_img_row3_col3};
        ImageView game_who_play_or_win_img = findViewById(R.id.game_who_play_or_win_img);


        for (ImageView img : imageViews) {
            img.setOnClickListener(view -> {
                if (turn == 0) {
                    img.setImageResource(R.drawable.x);
                    int getArrayIndex = Arrays.asList(imageViews).indexOf(img);
                    statusGame[getArrayIndex] = 0;
                    checkWin();
                    if (flag == 1) {
                        game_who_play_or_win_img.setImageResource(R.drawable.xwin);
                    } else {
                        noOneWin();
                        if(noWin==true)
                            game_who_play_or_win_img.setImageResource(R.drawable.nowin);
                       else {
                            game_who_play_or_win_img.setImageResource(R.drawable.oplay);
                            img.setClickable(false);
                            turn = 1;
                        }
                    }
                } else {
                    img.setImageResource(R.drawable.o);
                    int getArrayIndex = Arrays.asList(imageViews).indexOf(img);
                    statusGame[getArrayIndex] = 1;
                    checkWin();
                    if (flag == 1) {
                        game_who_play_or_win_img.setImageResource(R.drawable.owin);
                    } else {
                        game_who_play_or_win_img.setImageResource(R.drawable.xplay);
                        img.setClickable(false);
                        turn = 0;
                    }
                }
            });
        }


        Button game_new_game_btn = findViewById(R.id.game_new_game_btn);
        game_new_game_btn.setOnClickListener(view -> {
            for (ImageView img : imageViews) {
                img.setClickable(true);
                img.setImageResource(R.drawable.empty);
            }
            Arrays.fill(statusGame, 2);
            flag = 0;
            game_who_play_or_win_img.setImageResource(R.drawable.xplay);
            turn = 0;
            noWin = false;
        });
    }
}


