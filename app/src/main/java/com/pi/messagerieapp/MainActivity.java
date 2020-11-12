package com.pi.messagerieapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView box = null;
    private Button btnsend = null;
    private EditText message = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        message = findViewById(R.id.message2);
        btnsend = findViewById(R.id.send);
        box = findViewById(R.id.box_message2);

        Intent intent = new Intent(getApplicationContext(), SecondActivity.class);
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgToSend = message.getText().toString();
                Log.d("test :", msgToSend);

                intent.putExtra("msg", msgToSend);
                startActivityForResult(intent, 1);
            }
        });


    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                String receivedMsg = data.getStringExtra("msg");

                box.setText(box.getText() + "\n" + receivedMsg + "\n");
            }
            if (resultCode == RESULT_CANCELED) {
                box.setText(box.getText() + "\n" + "unsent message" + "\n");
            }
        }
    }
}
    /*@Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent intent) {
        Log.d("info ", "onAcitvityResult");
        switch (requestCode){
            case RESULT_OK:
                Log.d("info ", "onAcitvityResult--RESULT_OK");
                super.onActivityResult(requestCode, resultCode, intent);
                intent=getIntent();
                String recievedMsg=intent.getStringExtra("msg");
                box.setText(recievedMsg);
                break;
            case RESULT_CANCELED:
                box.setText("Action cancel");
                break;
            default:
                break;
        }
    }*/

