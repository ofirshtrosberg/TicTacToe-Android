package com.example.tictactoenew;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TicTacToeGameActivity extends AppCompatActivity {
    int turn = 0; // 0 = X play, 1 = O play
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
        ImageView[] imageViews = {game_img_row1_col1, game_img_row1_col2, game_img_row1_col3, game_img_row2_col1,game_img_row2_col2, game_img_row2_col3, game_img_row3_col1, game_img_row3_col2, game_img_row3_col3};
        ImageView game_who_play_or_win_img = findViewById(R.id.game_who_play_or_win_img);
        game_who_play_or_win_img.setImageResource(R.drawable.xplay);
        for(ImageView img: imageViews){
            img.setOnClickListener(view -> {
                if(turn==0){
                    img.setImageResource(R.drawable.x);
                    game_who_play_or_win_img.setImageResource(R.drawable.oplay);
                    turn=1;
                }
                else{
                    img.setImageResource(R.drawable.o);
                    game_who_play_or_win_img.setImageResource(R.drawable.xplay);
                    turn = 0;
                }
            });
        }
    }
}