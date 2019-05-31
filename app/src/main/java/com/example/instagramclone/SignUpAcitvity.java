package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpAcitvity extends AppCompatActivity {
    EditText edtUserName,edtPassword;
    Button btnSignUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_acitvity);
        setTitle("Sign Up");

        //assign the Views
        edtUserName=(EditText)findViewById(R.id.edtUserNameSignUp);
        edtPassword=(EditText)findViewById(R.id.edtPasswordSignUp);



        //sign the user up on click
        btnSignUp=(Button)findViewById(R.id.btnSignUp);


        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user=new ParseUser();
                user.setUsername(edtUserName.getText().toString());
                user.setPassword(edtPassword.getText().toString());
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            Toast.makeText(SignUpAcitvity.this,"Done",Toast.LENGTH_LONG).show();
                            Intent intent=new Intent(SignUpAcitvity.this,WelcomeActivity.class);
                            startActivity(intent);
                            finish();
                        }
                        else{
                            Toast.makeText(SignUpAcitvity.this,e.getMessage(),Toast.LENGTH_LONG).show();

                        }
                    }
                });
            }
        });
    }
}
