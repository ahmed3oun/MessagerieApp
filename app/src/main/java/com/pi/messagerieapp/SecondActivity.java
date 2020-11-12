package com.pi.messagerieapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    private TextView box=null;
    private Button btnsend=null;
    private EditText message=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        message=findViewById(R.id.message2);
        btnsend=findViewById(R.id.send);
        box=findViewById(R.id.box_message2);
        //Recieve data

        try {
            String RecievedMessage=getIntent().getStringExtra("msg");
            box.setText(RecievedMessage);
            Log.d("msg ",RecievedMessage);
                    }catch (Exception e){

        }


        //return
        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msgTosend=message.getText().toString();
                Log.d("test :",msgTosend);
                Intent intent1=new Intent();
                intent1.putExtra("msg",msgTosend);
                SecondActivity.this.setResult(RESULT_OK,intent1);
                //startActivity(intent1);
                finish();

            }
        });


    }
}