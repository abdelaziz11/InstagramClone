package com.example.instagramclone;


import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtUserName,edtPassword;
    Button btnLogin,btnToSignUp;
    AnimationDrawable anim;
    AssetManager am;


    Typeface typefaceLobster, typefaceArial;
    TextView lblHeader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        //instagram color animations
        am = this.getApplicationContext().getAssets();
        RelativeLayout container = (RelativeLayout) findViewById(R.id.container);
        anim = (AnimationDrawable) container.getBackground();
        anim.setEnterFadeDuration(100);
        anim.setExitFadeDuration(1000);




        setTitle("Login");
         if (ParseUser.getCurrentUser()!=null){
             goToWelcomeActivity();
             finish();
         }

        //assign the views
        edtUserName=(EditText) findViewById(R.id.edtUserNameSignIn);
        edtPassword=(EditText) findViewById(R.id.edtPasswordSignIn);
        btnLogin=(Button) findViewById(R.id.btnLogin);
        btnToSignUp=(Button)findViewById(R.id.btnToSignUp);



        //attach Listeners
        btnLogin.setOnClickListener(LoginActivity.this);
        btnToSignUp.setOnClickListener(LoginActivity.this);




    }


    @Override
    public void onClick(View v) {

           if (v.getId()==R.id.btnLogin){
               //on signIn Button Click open wellcome activity
               ParseUser.logInInBackground(edtUserName.getText().toString(),
                                           edtPassword.getText().toString(),
                                           new LogInCallback() {
                           @Override
                           public void done(ParseUser user, ParseException e) {
                               if (e==null && user!=null){
                                   goToWelcomeActivity();
                                   finish();
                               }
                               else{
                                   Toast.makeText(LoginActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();;
                               }


                           }
                       });


           }
           if (v.getId()==R.id.btnToSignUp){

               Intent intent=new Intent(LoginActivity.this,SignUpAcitvity.class);
               startActivity(intent);
               finish();
           }




        }



        //method to remove the keyboard on rootLayout press
        public void rootLayoutTapped (View view){


           try{
               InputMethodManager inputMethodManager=(InputMethodManager)getSystemService(INPUT_METHOD_SERVICE);
               inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

            }
           catch (Exception e){
               e.printStackTrace();
           }

        }

    @Override
    protected void onResume() {
        super.onResume();
        if (anim != null && !anim.isRunning())
            anim.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (anim != null && anim.isRunning())
            anim.stop();
    }
    public void goToWelcomeActivity(){
        Intent intent=new Intent(LoginActivity.this,WelcomeActivity.class);
        startActivity(intent);

    }
}

