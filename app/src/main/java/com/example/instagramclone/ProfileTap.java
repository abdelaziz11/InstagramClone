package com.example.instagramclone;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SaveCallback;


public class ProfileTap extends Fragment {
    private EditText nameEdt,bioEdt,professionEdt,hobbiesEdt,favoriteSportsEdt;
    private Button updateInfoBtn;
    AnimationDrawable anim;
    AssetManager am;


    public ProfileTap() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile_tap, container, false);
        am = getActivity().getAssets();
        LinearLayout layout = (LinearLayout)view.findViewById(R.id.forAnim);
        anim = (AnimationDrawable) layout.getBackground();
        anim.setEnterFadeDuration(100);
        anim.setExitFadeDuration(1000);

        nameEdt=(EditText)view.findViewById(R.id.edtProfileName);
        bioEdt=(EditText)view.findViewById(R.id.edtProfileBio);
        professionEdt=(EditText)view.findViewById(R.id.edtProfileProfession);
        hobbiesEdt=(EditText)view.findViewById(R.id.edtProfileHobbies);
        favoriteSportsEdt=(EditText)view.findViewById(R.id.edtProfileFavoriteSports);
        updateInfoBtn=(Button)view.findViewById(R.id.btnUpdateInfo);
        updateInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ParseUser user=ParseUser.getCurrentUser();
                user.put("profileName",nameEdt.getText().toString());
                user.put("profileBio",bioEdt.getText().toString());
                user.put("profileProfession",professionEdt.getText().toString());
                user.put("profileHobbies",hobbiesEdt.getText().toString());
                user.put("ProfilefavoriteSports",favoriteSportsEdt.getText().toString());
                user.saveInBackground(new SaveCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e==null){
                            Toast.makeText(getContext(),"Updated",Toast.LENGTH_LONG).show();

                        }
                    }
                });


            }
        });
          return view;
    }

}
