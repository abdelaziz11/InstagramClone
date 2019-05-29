package com.example.instagramclone;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import androidx.appcompat.app.AppCompatActivity;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.pressIt);
        textView.setOnClickListener(SignUp.this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pressIt:
                Intent intent=new Intent(SignUp.this,SignUpLogin.class);
                startActivity(intent);

                break;

        }


    }
}
