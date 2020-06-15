package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.style.UpdateLayout;
import android.util.Log;
import android.view.View;
//import android.widget.GridLayout;
import androidx.gridlayout.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activeplayer = 0;

    boolean gameactive= true;

    int[] arr = {2,2,2,2,2,2,2,2,2};
    int[][] winningposition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void dropin(View view) {
        ImageView counter = (ImageView) view;
        int tappedplace = Integer.parseInt(counter.getTag().toString());
        if (arr[tappedplace] == 2 && gameactive) {
            counter.setTranslationY(-1000f);
            arr[tappedplace]=activeplayer;
            if (activeplayer == 0) {
                counter.setImageResource(R.drawable.cross);
                activeplayer = 1;
            } else if (activeplayer == 1) {
                counter.setImageResource(R.drawable.blue);
                activeplayer = 0;
            }
            counter.animate().translationYBy(1000f).setDuration(300);

            for(int[] winningposition : winningposition)
            {
                if(arr[winningposition[0]]==arr[winningposition[1]]&&arr[winningposition[1]]==arr[winningposition[2]]&&arr[winningposition[0]]!=2)
                {
                    gameactive=false;
                    String won = "circle";
                    if(arr[winningposition[0]]==0)
                    {
                        won = "cross";
                    }
                    TextView winner = findViewById(R.id.winner);
                    winner.setText(won+" won");
                    LinearLayout layout = findViewById(R.id.playAgainLayout);
                    layout.setVisibility(View.VISIBLE);
                }
                else
                {
                    boolean gameover=true;
                    for(int state: arr)
                    {
                        if(state == 2)
                        {
                            gameover=false;
                        }
                    }
                    if(gameover)
                    {
                        TextView winner = findViewById(R.id.winner);
                        winner.setText("It's a draw");
                        LinearLayout layout = findViewById(R.id.playAgainLayout);
                        layout.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
    }

    public void playAgain(View view)
    {
        System.out.println("play Again tapped for the 1 time");
        gameactive=true;
        System.out.println("play Again tapped for the 2 time");
        LinearLayout layout = findViewById(R.id.playAgainLayout);
        System.out.println("play Again tapped for the 3 time");
        layout.setVisibility(View.INVISIBLE);
        System.out.println("play Again tapped for the 4 time");
        activeplayer = 0;
        System.out.println("play Again tapped for the 5 time");

        for(int i=0;i<arr.length;i++)
        {
            arr[i]=2;
        }
        System.out.println("play Again tapped for the 6 time");
        GridLayout gridLayout = findViewById(R.id.grid);
        System.out.println("play Again tapped for the 7 time");
        for(int j=0; j<gridLayout.getChildCount() ; j++)
        {
            ((ImageView) gridLayout.getChildAt(j)).setImageResource(0);
        }
        System.out.println("play Again tapped for the 8 time");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
