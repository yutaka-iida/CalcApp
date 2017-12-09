package com.example.iiday.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        double answer = 0;
        Intent intent = getIntent();
        double value1 = intent.getDoubleExtra("VALUE1", 0);
        double value2 = intent.getDoubleExtra("VALUE2", 0);
        int enzan = intent.getIntExtra("ENZAN", 0);

        switch(enzan){
            case 0:
                answer = value1 + value2;
                break;
            case 1:
                answer = value1 - value2;
                break;
            case 2:
                answer = value1 * value2;
                break;
            case 3:
                if(value2 == 0){
                    answer = 0;
                }
                else{
                    answer = value1 / value2;
                }
                break;
            default:
                break;
        }

        TextView textView = (TextView)findViewById(R.id.textview);
        textView.setText(String.valueOf(answer));
    }
}
