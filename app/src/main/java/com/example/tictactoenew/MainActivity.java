package com.example.tictactoenew;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button playBtn = findViewById(R.id.main_play_btn);
        playBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this, TicTacToeGameActivity.class);
            startActivity(intent);
        });
    }
}