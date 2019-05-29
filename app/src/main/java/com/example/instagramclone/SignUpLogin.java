package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class SignUpLogin extends AppCompatActivity implements View.OnClickListener {

    private EditText userNameSignUp,passwordSignUp,userNameSignIn,passwordSignIn;
    private Button btnSignUp,btnSignIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_login);


        //assign the UI components
        userNameSignUp=(EditText)findViewById(R.id.edtUserNameSignUp);
        passwordSignUp=(EditText)findViewById(R.id.edtPasswordSignUp);
        userNameSignIn=(EditText)findViewById(R.id.edtUserNameSignIn);
        passwordSignIn=(EditText)findViewById(R.id.edtPasswordSignIn);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);
        btnSignIn=(Button)findViewById(R.id.btnSignIn);



        //attach the listeners
        btnSignUp.setOnClickListener(SignUpLogin.this);
        btnSignIn.setOnClickListener(SignUpLogin.this);
    }

    @Override
    public void onClick(View v) {
         switch (v.getId()){
             case R.id.btnSignUp:

                     ParseUser user=new ParseUser();
                     user.setUsername(userNameSignUp.getText().toString());
                     user.setPassword(passwordSignUp.getText().toString());
                     user.signUpInBackground(new SignUpCallback() {
                         @Override
                         public void done(ParseException e) {
                             if (e==null){
                                 Toast.makeText(SignUpLogin.this,"done",Toast.LENGTH_LONG).show();
                             }
                             else{
                                 Toast.makeText(SignUpLogin.this,"not done",Toast.LENGTH_LONG).show();

                             }
                         }
                     });


                 break;

             case R.id.btnSignIn:
                 ParseUser.logInInBackground(userNameSignIn.getText().toString(),
                         passwordSignIn.getText().toString(), new LogInCallback() {
                             @Override
                             public void done(ParseUser user, ParseException e) {
                                 if (user!=null && e==null){
                                     Toast.makeText(SignUpLogin.this,"done",Toast.LENGTH_LONG).show();
                                 }
                             }
                         });


         }


    }
}
