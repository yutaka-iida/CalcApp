package com.example.iiday.calcapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText m_edittext1;
    EditText m_edittext2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button_tasu = (Button)findViewById(R.id.button_tasu);
        Button button_hiku = (Button)findViewById(R.id.button_hiku);
        Button button_kake = (Button)findViewById(R.id.button_kakeru);
        Button button_waru = (Button)findViewById(R.id.button_waru);
        m_edittext1 = (EditText)findViewById(R.id.edit_value1);
        m_edittext1.setInputType(InputType.TYPE_CLASS_NUMBER);
        m_edittext2 = (EditText)findViewById(R.id.edit_value2);
        m_edittext2.setInputType(InputType.TYPE_CLASS_NUMBER);

        button_tasu.setOnClickListener(this);
        button_hiku.setOnClickListener(this);
        button_kake.setOnClickListener(this);
        button_waru.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        int enzan = 0;
        Intent intent = new Intent(this, AnswerActivity.class);

        if(v.getId() == R.id.button_tasu){
            enzan = 0;
        }
        else if(v.getId() == R.id.button_hiku){
            enzan = 1;
        }
        else if(v.getId() == R.id.button_kakeru){
            enzan = 2;
        }
        else if(v.getId() == R.id.button_waru){
            enzan = 3;
        }
        intent.putExtra("ENZAN", enzan);

        if(m_edittext1.getText().toString().length() == 0){
            intent.putExtra("VALUE1", 0);
        }
        else{
            intent.putExtra("VALUE1", Double.valueOf(m_edittext1.getText().toString()));
        }
        if(m_edittext2.getText().toString().length() == 0){
            intent.putExtra("VALUE2", 0);
        }
        else{
            intent.putExtra("VALUE2", Double.valueOf(m_edittext2.getText().toString()));
        }
        startActivity(intent);
    }

}
